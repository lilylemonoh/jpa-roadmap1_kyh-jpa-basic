package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMainExample {
      public static void main(String[] args) {

          EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

          EntityManager em = emf.createEntityManager();

          // transaction
          EntityTransaction tx = em.getTransaction();
          tx.begin();

          try {
              Team team = new Team();
              team.setName("TeamA");
              // 역방향(주인이 아닌 방향)만 연관관계 설정
//            team.getMembers().add(member);
              em.persist(team);

              MemberExample member = new MemberExample();
              member.setUsername("member1");
//            member.setTeam(team);
              em.persist(member);

//            team.getMembers().add(member); // 연관관계 편의 메소드를 MemberExample 세터에 생성하였음.
              team.addMember(member);

              em.flush();
              em.clear();

              Team findTeam = em.find(Team.class, team.getId());
              List<MemberExample> members = findTeam.getMembers();

              for (MemberExample m : members) {
                  System.out.println("m = " + m.getUsername());
              }


              tx.commit();
          } catch (Exception e) {
              tx.rollback();
          } finally {
              em.close();
          }
          emf.close();
    }
}

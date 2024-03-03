package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
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
              team.setName("teamA");
              em.persist(team);

              Team teamB = new Team();
              teamB.setName("teamB");
              em.persist(teamB);

              MemberExample member1 = new MemberExample();
              member1.setUsername("member1");
              member1.setTeam(team);
              em.persist(member1);

              MemberExample member2 = new MemberExample();
              member2.setUsername("member2");
              member2.setTeam(teamB);
              em.persist(member2);

              em.flush();
              em.clear();

//              MemberExample m  = em.find(MemberExample.class, member1.getId());

              List<MemberExample> members = em.createQuery(
                      "select m from MemberExample m join fetch m.team",
                              MemberExample.class)
                      .getResultList();

              // SQL: select * from Member
              // SQL: select * from Team where TEAM_ID = xxx

              tx.commit();
          } catch (Exception e) {
              tx.rollback();
              e.printStackTrace();
          } finally {
              em.close();
          }
          emf.close();
    }


}

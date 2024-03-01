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

              MemberExample member = new MemberExample();
              member.setUsername("member1");

              em.persist(member);

              Team team = new Team();
              team.setName("teamA");
              //
              team.getMembers().add(member);

              em.persist(team);

              tx.commit();
          } catch (Exception e) {
              tx.rollback();
          } finally {
              em.close();
          }
          emf.close();
    }
}

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
              MemberExample member = new MemberExample();
              member.setUsername("Hello");
              member.setHomeAddress(new Address("city", "street", "zipcode"));
              member.setWorkPeriod(new Period());

              em.persist(member);
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

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
              Address address = new Address("city", "street", "zipcode");

              MemberExample member = new MemberExample();
              member.setUsername("member1");
              member.setHomeAddress(address);
              em.persist(member);

              Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
              member.setHomeAddress(newAddress);


              //
//               member.getHomeAddress().setCity("newCity");
               // 임베디드


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

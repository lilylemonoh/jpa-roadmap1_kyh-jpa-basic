package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
              member.setHomeAddress(new Address("city", "street", "zipcode"));

              member.getFavoriteFoods().add("치킨");
              member.getFavoriteFoods().add("족발");
              member.getFavoriteFoods().add("피자");

              member.getAddressHistory().add(new AddressEntity("old1", "street", "zipcode"));
              member.getAddressHistory().add(new AddressEntity("old2", "street", "zipcode"));

              em.persist(member);

              em.flush();
              em.clear();

              System.out.println("============START==============");
              MemberExample findMember = em.find(MemberExample.class, member.getId());

              // city -> newCity
              Address a = findMember.getHomeAddress();
              findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));

              // 치킨을 한식으로
              findMember.getFavoriteFoods().remove("치킨");
              findMember.getFavoriteFoods().add("한식");

              findMember.getAddressHistory().add(new AddressEntity("old1", "street", "zipcode"));
              findMember.getAddressHistory().add(new AddressEntity("newnewcity", "street", "zipcode"));




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

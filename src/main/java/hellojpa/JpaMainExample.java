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

              MemberExample member1 = new MemberExample();
              member1.setUsername("member1");
              em.persist(member1);

              em.flush();
              em.clear();

              MemberExample refMember = em.getReference(MemberExample.class, member1.getId());
              System.out.println("refMember = " + refMember.getClass()); // Proxy
//              refMember.getUsername(); // 강제 초기화

              Hibernate.initialize(refMember); // 강제 초기화
              // 참고 : JPA 표준은 강제 초기화 없음
              // 강제 호출: member.getName()

//              System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

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

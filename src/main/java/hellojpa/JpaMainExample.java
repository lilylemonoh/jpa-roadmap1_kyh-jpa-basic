package hellojpa;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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
              // 1. jpql
//              em.createQuery(
//                      "select m From MemberExample m where m.username like '%kim%'",
//                      MemberExample.class
//              ).getResultList();

//              // Criteria 사용 준비
//              CriteriaBuilder cb = em.getCriteriaBuilder();
//              CriteriaQuery<MemberExample> query = cb.createQuery(MemberExample.class);
//
//              Root<MemberExample> m = query.from(MemberExample.class);
//
//              CriteriaQuery<MemberExample> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//
//              // 동적쿼리
//              String username ="qwer";
//              if (username != null) {
//                  cq = cq.where(cb.equal(m.get("username"), "kim"));
//              }
//
//              List<MemberExample> resultList = em.createQuery(cq)
//                              .getResultList();

              MemberExample member = new MemberExample();
              member.setUsername("member1");
              em.persist(member);

              // flush -> commit, query

              em.flush();
              // 결과 0
              // dbconn.executeQuery("select * from member");

              em.createNativeQuery("SELECT MEMBER_ID, city, street, zipcode, USERNAME from MEMBEREXAMPLE")
                              .getResultList();

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

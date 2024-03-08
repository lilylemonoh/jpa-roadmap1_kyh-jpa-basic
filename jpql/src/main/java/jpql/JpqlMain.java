package jpql;

import jakarta.persistence.*;

import java.util.List;

public class JpqlMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            Member result = em.createQuery(
                            "select m from Member m" +
                                    " where m.username = :username", Member.class)
                    .setParameter("username", "member1")
                    .getSingleResult();

            System.out.println("result.getUsername() = " + result.getUsername());

//          타입 모를 때
//            Query query1 = em.createQuery("select m.username, m.age from Member m";

            // 결과가 여러개 -> 결과가 없으면 빈 리스트 반환
//            List<Member> resultList = query.getResultList();
//
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//
//            // 결과가 1개
//            Member result = query.getSingleResult();



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






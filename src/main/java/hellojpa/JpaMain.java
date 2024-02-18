package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //code - 회원 저장
            Member member = new Member();
            member.setId(1L);
            member.setName("helloA");
            em.persist(member);
            
            // code - 회원  수정
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA"); // 같은 트랜잭션 안에 있으면

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for (Member members : result) {
                System.out.println("member.name = " + member.getName());
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

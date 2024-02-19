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
//            //code - 회원 저장
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");
//            em.persist(member);
//
//            // code - 회원  수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA"); // 같은 트랜잭션 안에 있으면
//
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member members : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속
//            System.out.println("===Before===");
//            em.persist(member);
//            System.out.println("===After===");

//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember.getId = " +findMember.getId());
//            System.out.println("findMember.getName = " + findMember.getName());

            // 영속 엔티티의 동일성 보장
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println(findMember1 == findMember2);

            // 영속
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);

//            System.out.println("===================");
            Member member = em.find(Member.class, 101L);
            member.setName("ZZZZZZZZZZZZZ");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

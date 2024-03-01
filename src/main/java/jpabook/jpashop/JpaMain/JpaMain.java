package jpabook.jpashop.JpaMain;

import hellojpa.MemberExample;
import hellojpa.Team;
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

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);
            MemberExample member = new MemberExample();
            member.setUsername("member1");
//            member.setTeamId(team.getId());
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            MemberExample findMember = em.find(MemberExample.class, member.getId());
            List<MemberExample> members = findMember.getTeam().getMembers();

            for (MemberExample m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }

            //
            Team newTeam = em.find(Team.class, 100L);
            findMember.setTeam(newTeam);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

package hellojpa;

import jakarta.persistence.*;

@Entity
public class MemberExample {

    @Id @GeneratedValue
    @Column(name = "Member_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    // 이런 매핑은 공식적으로 존재하지 않음
    // 읽기 전용 필드를 사용해서 양방향처럼 사용하는 방법
    // 다대일 양방향을 사용하자
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

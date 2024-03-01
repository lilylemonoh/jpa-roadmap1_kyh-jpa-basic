//package hellojpa;
//
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
////@Table(uniqueConstraints = )
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
//public class Member {
//
//    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO) // Auto는 db 방언에 맞춰 자동으로 생성
////    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity는 생성을 데이터베이스에 위임
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
//    private Long id;
//
////    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default 'EMPTY'")
//    private String username;
//    public Member() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//}

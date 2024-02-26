package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
//@Table(uniqueConstraints = )
public class Member {

    @Id
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;
    private Integer age;

    @Enumerated(EnumType.STRING) // 주의! ORDINAL(default) 사용 x
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @Transient
    private int temp;

    public Member() {
    }
}

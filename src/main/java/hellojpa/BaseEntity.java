package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass // 매핑 정보만 받는 슈퍼 클래스
public abstract class BaseEntity {
    /**
     * 1. 상속관계 매핑 X
     * 2. 엔티티 X, 테이블과 매핑 X
     * 3. 부모 클래스를 상속받는 자식 클래스에 매핑 정보만 제공
     * 4. 조회, 검색 불가 (em.find(BaseEntity) 불가)
     * 5. 직접 생성해서 사용할 일이 없으므로 추상 클래스 권장
     */

    @Column(name = "INSERT_MEMBER")
    private String createdBy;

    @Column(name = "UPDATE_MEMBER")
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}

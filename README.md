# Introduce
자바 ORM 표준 JPA 프로그래밍 - 기본편 (김영한) 의 예제코드 저장소


**[Inflearn - 강의 링크](https://www.inflearn.com/course/ORM-JPA-Basic)**

학습 기간: 2024/2/19~2024/3/10
## JPA (Java Persistence API)

* 자바 ORM 표준인 JPA는 SQL 작성 없이도 객체를 데이터베이스에 직접 저장할 수 있게 함
* 객체와 관계형 데이터베이스의 차이도 중간에서 해결 가능
* JPA를 사용함으로써 SQL 중심의 개발에서 객체 중심으로 개발, 개발 생산성 향상, 유지보수 편의 등이 가능함

# Curriculum
### 섹션 0. 강좌 소개
* 강좌 소개

### 섹션 1. JPA 소개
* SQL 중심적인 개발의 문제점
* JPA 소개

### 섹션 2. JPA 시작하기

* Hello JPA - 프로젝트 생성
* Hello JPA - 애플리케이션 개발

### 섹션 3. 영속성 관리 - 내부 동작 방식

* 영속성 컨텍스트 1
* 영속성 컨텍스트 2
* 플러시
* 준영속 상태
* 정리

### 섹션 4. 엔티티 매핑

* 객체와 테이블 매핑
* 데이터베이스 스키마 자동 생성
* 필드와 컬럼 매핑
* 기본 키 매핑
* 실전 예제 1 - 요구사항 분석과 기본 매핑

### 섹션 5. 연관관계 매핑 기초

* 단방향 연관관계
* 양방향 연관관계와 연관관계의 주인 1- 기본
* 양방향 연관관계와 연관관계의 주인 2 - 주의점, 정리
* 실전 예제 2 - 연관관계 매핑 시작

### 섹션 6. 다양한 연관관계 매핑

* 다대일 [N:1]
* 일대다 [1:N]
* 일대일 [1:1]
* 다대다 [N:M]
* 실전 예제 3 - 다양한 연관관계 매핑

### 섹션 7. 고급 매핑

* 상속관계 매핑
* Mapped Superclass - 매핑 정보 상속
* 실전 예제 4 - 상속관계 매핑

### 섹션 8. 프록시와 연관관계 관리

* 프록시
* 즉시 로딩과 지연 로딩
* 영속성 전이(CASCADE)와 고아 객체
* 실전 예제 5 - 연관관계 관리

### 섹션 9. 값 타입

* 기본값 타입
* 임베디드 타입
* 값 타입과 불변 객체
* 값 타입의 비교
* 값 타입 컬렉션
* 실전 예제 6 - 값 타입 매핑

### 섹션 10. 객체지향 쿼리 언어1 - 기본 문법

* 소개
* 기본 문법과 쿼리 API
* 프로젝션(SELECT)
* 페이징
* 조인
* 서브 쿼리
* JPQL 타입 표현과 기타식
* 조건식(CASE 등등)
* JPQL 함수

### 섹션 11. 객체지향 쿼리 언어2 - 중급 문법

* 경로 표현식
* 페치 조인 1 - 기본
* 페치 조인 2 - 한계
* 다형성 쿼리
* 엔티티 직접 사용
* Named 쿼리
* 벌크 연산

# 참고사항
* 본 강의에서는 **개념 설명**과  **실전 예제**를 별개의 프로젝트로 작성했으나 이 저장소에서는 하나의 프로젝트에 패키지를 분리하여 작성하였습니다.
* 이때 클래스 이름이 중복되는 경우, **개념 설명**의 클래스 이름에 'Example'을 붙여 구분하였습니다.

* 섹션 10에서 진행되는 jpql은 강의에서는 별도의 프로젝트로 진행하였으나, 이 저장소에서는 프로젝트 내부에 모듈을 생성하여 작성하였습니다.

# Hibernate 6 변경 사항
(강의 내용에서 달라진 부분)
* FROM 절에 서브쿼리 가능 (섹션 10- 서브쿼리 관련)
* DISTINCT가 추가로 애플리케이션에서 중복 제거 시도 (섹션 11-페치조인 1- 기본 관련)

---
# 필기
## 값 타입
값 타입은 복잡한 객체 세상을 조금이라도 단순화하려고 만든 개념이다. 따라서 값 타입은 단순하고 안전하게 다룰 수 있어야 한다.
### 값 타입 공유 참조
* 임베디드 타입 같은 값 타입을 여러 엔티티에서 공유하면 위험함 (부작용 발생)
* 값 타입의 실제 인스턴스인 값을 공유하는 것은 위험 -> 대신 값(인스턴스)을 복사해서 사용
### 객체 타입의 한계
* 항상 값을 복사해서 사용하면 공유 참조로 인해 발생하는 부작용을 피할 수 있다.
* 문제는 임베디드 타입처럼 직접 정의한 값 타입은 자바의 기본(primitive) 타입이 아니라 객체 타입이라는 것
* 객체 타입은 참조값을 직접 대입하는 것을 막을 방법이 없다.
* **객체의 공유 참조는 피할 수 없다.**
### 불변 객체
* 객체 타입을 수정할 수 없게 만들면 부작용을 원천 차단
* 값 타입은 불변 객체(immutable object)로 설계해야 함
* 불변 객체 : 생성 시점 이후 절대 값을 변경할 수 없는 객체
* 생성자로만 값을 설정하고 수정자(setter)를 만들지 않으면 됨
* 참고 : Integer, String은 자바가 제공하는 대표적인 불변객체
* **결론 : 상황에 따라 setter를 제거하거나, setter를 private method로 만든다.**
---
## 값 타입의 비교
* 동일성(identity) : 인스턴스의 참조 값을 비교, == 사용
* 동등성(equivalence) : 인스턴스의 값을 비교, equals() 사용
* 값 타입은 a.equals(b)를 사용해서 동등성 비교를 해야 함
* 값 타입의 equals() 메소드를 적절하게 재정의(주로 모든 필드 사용)
---
## 값 타입 컬렉션
* 값 타입을 하나 이상 저장할 때 사용
* @ElementCollection, @CollectionTable 사용
* 데이터베이스는 컬렉션을 같은 테이블에 저장할 수 없다.
* 컬렉션을 저장하기 위한 별도의 테이블이 필요함

## 값 타입 컬렉션 사용
* 값 타입은 소속 엔티티와 생명주기를 같이한다.
* 값 타입 컬렉션은 영속성 전이(Cascade) + 고아 객체 제거 기능을 필수로 가진다고 볼 수 있다.
* 값 타입 컬렉션은 지연 로딩 전략을 사용한다.

## 값 타입 컬렉션의 제약사항
* 값 타입은 엔티티와 다르게 식별자 개념이 없다.
* 값은 변경하면 추적이 어렵다.
* 값 타입 컬렉션에 변경 사항이 발생하면, 주인 엔티티와 연관된 모든 데이터를 삭제하고, 값 타입 컬렉션에 있는 현재 값을 모두 다시 저장한다.
* 값 타입 컬렉션을 매핑하는 테이블은 모든 컬럼을 묶어서 기본키를 구성해야 함: 
* **null 입력 X, 중복 저장X**

## 값 타입 컬렉션 대안
* 실무에서는 상황에 따라 값 타입 컬렉션 대신에 일대다 관계를 고려
* 일대다 관계를 위한 엔티티를 만들고, 여기에서 값 타입을 사용
* 영속성 전이(Cascade) + 고아 객체 제거를 사용해서 값타입 컬렉션처럼 사용
* EX) AddressEntity

## 엔티티 타입의 특징
* 식별자 O
* 생명 주기 관리
* 공유

## 값 타입의 특징
* 식별자 X
* 생명 주기를 엔티티에 의존
* 공유하지 않는 것이 안전(복사해서 사용)
* 불변 객체로 만드는 것이 안전


* 값 타입은 정말 값 타입이라 판단될 때만 사용
* 엔티티와 값 타입을 혼동해서 엔티티를 값 타입으로 만들면 안 됨
* 식별자가 필요하고, 지속해서 값을 추적, 변경해야 한다면 그것은 값 타입이 아닌 엔티티
---
## JPQL 문법
* select m from Member as m where m.age > 18
* 엔티티와 속성은 대소문자 구분 O (Member, age)
* JPQL 키워드는 대소문자 구분 X (SELECT, FROM, where)
* 엔티티 이름 사용, 테이블 이름이 아님(Member)
* 별칭은 필수(m) (as는 생략가능)

## 결과 조회 API
* query.getResultList(): 결과가 하나 이상일 때, 리스트 반환
  * 결과가 없으면 빈 리스트 반환
* query.getSingleResult(): 결과가 정확히 하나, 단일 객체 반환
  * 결과가 없으면: javax.persistence.NoResultException
  * 둘 이상이면: javax.persistence.NonUniqueResultException

---
## 조인 대상 필터링
* 예) 회원과 팀을 조인하면서, 팀 이름이 A인 팀만 조인
* JPQL: SELECT m, t FROM Member m LEFT JOIN m.team t on t.name ='A'
* SQL: SELECT m.*, t.* FROM Member m LEFT JOIN Team t ON m.Team_ID=t.id and t.name='A'

## 연관관계 없는 엔티티 외부 조인
* 예) 회원의 이름과 팀의 이름이 같은 대상 외부 조인
* JPQL: SELECT m,t FROM Member m LEFT JOIN TEAM t on m.username = t.name
* SQL: SELECT m.*, t.* FROM member m LEFT JOIN Team t ON m.username = t.name
---

## JPA 서브 쿼리 한계
* FROM 절의 서브 쿼리는 현재 JPQL에서 불가능
* 조인으로 풀 수 있으면 풀어서 해결
---
## JPQL 타입 표현
* 문자: "HELLO", 'She''s'
* 숫자: 10L, 10D, 10F
* Boolean: TRUE, FALSE
* ENUM: jpql.MemberType.Admin (패키지명 포함)
* 엔티티 타입: TYPE(m) = Member (상속 관계에서 사용)
---
## 경로 표현식 용어 정리
* 상태 필드 : 단순히 값을 저장하기 위한 필드 (ex: m.username)
* 연관 필드 : 연관관계를 위한 필드
  * 단일 값 연관 필드 : ManyToOne, OneToOne, 대상이 엔티티(ex: m.team)
  * 컬렉션 값 연관 필드 : OneToMany, ManyToMany, 대상이 컬렉션(ex: m.orders)

## 경로 표현식 특징
* 상태 필드 : 경로 탐색의 끝, 탐색 X
* 단일 값 연관 경로: 묵시적 내부 조인 발생, 탐색 O
* 컬렉션 값 연관 경로: 묵시적 내부 조인 발생, 탐색 X
  * FROM 절에서 명시적 조인을 통해 별칭을 얻으면 별칭을 통해 탐색 가능

---
## 페치 조인의 특징과 한계
* 페치 조인 대상에는 별칭을 줄 수 없다.
  * 하이버네이트는 가능, 가급적 사용 X
* 둘 이상의 컬렉션은 페치 조인 할 수 없다.
* 컬렉션을 페치 조인하면 페이징 API(setFirstResult, setMaxResult)를 사용할 수 없다.
  * 일대일, 다대일 같은 단일 값 연관 필드들은 페치 조인해도 페이징 가능
  * 하이버네이트는 경고 로그를 남기고 메모리에서 페이징(매우 위험)

* 여러 테이블을 조인해서 엔티티가 가진 모양이 아닌 전혀 다른 결과를 내야 하면 일반 조인을 사용하고 DTO를 사용하는 것이 효과적

---
## 벌크 연산 주의
* 벌크 연산은 영속성 컨텍스트를 무시하고 데이터베이스에 직접 쿼리
  * 해결방법 (둘 중 하나 선택)
    * 벌크 연산을 먼저 실행
    * 벌크 연산 수행 후 영속성 컨텍스트 초기화
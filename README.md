# Library-kotlin
- library-app 패키지 구조
    - Controller(Spring Bean이고 다른 Bean에 대한 의존성이 있다)
    - Service(Spring Bean이고 다른 Bean에 대한 의존성이 있으며 많은 비즈니스 로직이 들어간다)
    - Entitiy(POJO이면서 JPA Entity이다) == domain Objects
    - Repository(Spring Bean이고 다른 Bean에 대한 의존성이 없다)
    - dto(요청, 응답에 사용되는 클래스 묶음이다)
- entity와 dto의 관계
    - user의 요청을 dto로 받아 service로직에서 필요한 entity로 변환하고 변환된 entity는 JPA를 통해 DB에 access(CRUD)된다 

package springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository; // DAO라고 불리는 DB Layer 접근자. JPA에서는 Repository라고 부르며 인터페이스로 생성.
import org.springframework.data.jpa.repository.Query;

import java.util.List;


// @Repository를 추가할 필요도 없음!
// 주의점: Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다.
public interface PostsRepository extends JpaRepository<Posts, Long>{ // 여기서 JpaRepository를 상속하면 기본 CRUD 메소드가 자동 생성.

    //쿼리 추가
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

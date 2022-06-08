package springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 롬복의 어노테이션 1 -> 코드를 단순화시켜주나 필수 어노테이션은 아님.
@NoArgsConstructor // 롬복 어노테이션 2
@Entity // JPA 어노테이션 -> 필수 어노테이션에 가까움. 따라서 @Entity를 가깝게 둔다. -> DB 테이블과 링크될 클래스임을 나타낸다. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭.
public class Posts {

    @Id // 해당 테이블의 PK 필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타냄. 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.
    private Long id;

    @Column(length = 500, nullable = false) // 테이블 컬럼을 나타내며 굳이 선언 안해도 해당 클래스의 필드는 모두 컬럼이 된다. 사용 이유? 기본값 외에 추가로 변경이 필요한 옵션이 있을 때 사용한다. 문자열의 경우, VARCHAR(255)가 기본값인데 만약 사이즈를 500으로 늘리고 싶거나
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 타입을 TEXT로 변경하고 싶거나 등의 경우에 사용된다.
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

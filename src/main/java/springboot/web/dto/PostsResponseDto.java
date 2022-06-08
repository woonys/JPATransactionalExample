package springboot.web.dto;

import lombok.Getter;
import springboot.domain.posts.Posts;
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) { // -> Entity 필드 중 일부만 사용한다. 그러니 생성자로 Entity를 받아 필드에 값을 넣는다. 굳이 모든 필드를 가진 생성자가 필요하진 않으므로 Dto는 Entity를 받아 처리한다.
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}

package springboot.web;
import springboot.web.dto.PostsSaveRequestDto;
import springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController // REST API 컨트롤
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto); // 등록 기능! -> web에서 post API로 관리.
    }
}

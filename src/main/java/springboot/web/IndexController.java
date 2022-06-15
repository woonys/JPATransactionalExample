package springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import springboot.service.posts.PostsService;
import springboot.web.dto.PostsResponseDto;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc()); // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장. 여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달한다.
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id); // 해당 id를 찾는다.
        model.addAttribute("post", dto);

        return "posts-update";
    }
}

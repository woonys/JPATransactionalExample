package springboot.web;

import org.springframework.web.bind.annotation.GetMapping; // 얘가 Get method!
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다. 예전에는 @ResponseBody를 각 메소드마다 선언했던 걸 한 번에 사용할 수 있게 해준다.
public class HelloController {
    @GetMapping("/hello") // HTTP method인 GET 요청 받는 API를 만들어준다. 예전에는 @RequestMapping으로 사용되었는데 이제는 /hello로 요청 오면 문자열 hello를 반환하는 기능!
    public String hello() {
        return "Hello";
    }
}

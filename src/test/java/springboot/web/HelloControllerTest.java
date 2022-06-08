package springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class) // JPA 기능 작동하지 않기 때문에 여기서는 얘를 추가한다.
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_test() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
            get("/hello/dto")
                .param("name", name) // param: API 테스트할 때 사용될 요청 파라미터를 설정. 단, 값은 String만 허용. 숫자/날짜 등 데이터 등록할 때는 문자열로 변경해야만 가능.
                .param("amount", String.valueOf(amount)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(name))) // json 응답값을 필드별로 검증할 수 있는 메소드.
            .andExpect(jsonPath("$.amount", is(amount)));
    }
}

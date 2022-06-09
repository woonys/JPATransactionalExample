package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication // 스프링 부트 자동 설정, 스프링 bean 읽기와 생성 모두 자동으로 설정! -> 애는 항상 프로젝트 최상단에 위치해야!
public class Application { // 프로젝트의 메인 클래스!
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
}

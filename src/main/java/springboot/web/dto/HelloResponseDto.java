package springboot.web.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성. final이 없는 필드는 생성자에 포함되지 X.
public class HelloResponseDto {

    private final String name; // 둘 다 final이 있으니 생성자에 포함되어서 자동으로 생성자가 만들어진다.
    private final int amount;

}

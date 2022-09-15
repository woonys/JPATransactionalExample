package springboot.domain.posts;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.domain.User;
import springboot.domain.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void userTest() {
        User user = new User();
        user.setName("woony");

        userRepository.save(user);

        User thisUser = userRepository.findById(1l).orElse(null);
        thisUser.setName("woonys");
        userRepository.save(thisUser);

        List<User> userList = userRepository.findAll();
        System.out.println("userList = " + userList.get(0).getName());

    }

}

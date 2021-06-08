package ac.kr.soundofwind;

import ac.kr.soundofwind.config.auth.PrincipalDetailService;
import ac.kr.soundofwind.controller.api.UserApiController;
import ac.kr.soundofwind.domain.User;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserApiController.class)
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrincipalDetailService principalDetailService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @DisplayName("회원가입 테스트")
    @org.junit.jupiter.api.Test
    public void join() throws Exception {
        String username = "ksb";
        String password = "1234";
        String email = "ksb@naver.com";

        String encPassword=encoder.encode(password);

        User user = User.builder().username(username).password(encPassword).email(email).build();
        Gson gson = new Gson();
        String json = gson.toJson(user);

        MvcResult result = this.mockMvc.perform(
                post("/auth/joinApi")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

    }

    @DisplayName("회원정보 수정 테스트")
    @org.junit.jupiter.api.Test
    public void update() throws Exception {
        String password = "1234";
        String email = "ksb@gmail.com";

        String encPassword=encoder.encode(password); //해싱한 password

        User user = User.builder().password(encPassword).email(email).build();
        Gson gson = new Gson();
        String json = gson.toJson(user);

        MvcResult result = this.mockMvc.perform(
                post("/auth/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();

    }


}

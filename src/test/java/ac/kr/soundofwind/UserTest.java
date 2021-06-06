package ac.kr.soundofwind;

import ac.kr.soundofwind.config.auth.PrincipalDetailService;
import ac.kr.soundofwind.controller.api.UserApiController;
import ac.kr.soundofwind.model.Board;
import ac.kr.soundofwind.model.User;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserApiController.class)
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrincipalDetailService principalDetailService;

    @DisplayName("회원가입 테스트")
    @org.junit.jupiter.api.Test
    public void join() throws Exception {
        String username = "ksb";
        String password = "1234";
        String email = "ksb@naver.com";

        User user = User.builder().username(username).password(password).email(email).build();
        Gson gson = new Gson();
        String json = gson.toJson(user);

        MvcResult result = this.mockMvc.perform(
                post("/auth/joinApi")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

    }

}
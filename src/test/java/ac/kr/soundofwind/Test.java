package ac.kr.soundofwind;

import ac.kr.soundofwind.controller.api.UserApiController;
import ac.kr.soundofwind.model.User;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class Test {

    private MockMvc mockMvc;
    @Before
    public void setup(){
        // 이곳에서 HomeController를 MockMvc 객체로 만듭니다.
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserApiController()).build();
    }

    @org.junit.Test
    public void insert() throws Exception {
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

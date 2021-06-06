package ac.kr.soundofwind;

import ac.kr.soundofwind.config.auth.PrincipalDetailService;
import ac.kr.soundofwind.controller.api.UserApiController;
import ac.kr.soundofwind.model.Board;
import ac.kr.soundofwind.model.User;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserApiController.class)
public class BoardTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrincipalDetailService principalDetailService;

    @DisplayName("게시판 생성 테스트")
    @org.junit.jupiter.api.Test
    public void boardInsert() throws Exception {
        String title = "title";
        String content = "content";

        Board board = Board.builder().title(title).content(content).build();
        Gson gson = new Gson();
        String json = gson.toJson(board);

        MvcResult result = this.mockMvc.perform(
                post("/api/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();

    }
}

package ac.kr.soundofwind;

import ac.kr.soundofwind.config.auth.PrincipalDetailService;
import ac.kr.soundofwind.controller.api.BoardApiController;
import ac.kr.soundofwind.controller.api.UserApiController;
import ac.kr.soundofwind.domain.Board;
import ac.kr.soundofwind.domain.Reply;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoardApiController.class)
public class BoardTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrincipalDetailService principalDetailService;

    @DisplayName("게시판 전체 보기 테스트")
    @org.junit.jupiter.api.Test
    public void boardView() throws Exception {
        this.mockMvc.perform(get("/board/details"))
                .andExpect(status().isOk());
    }

    @DisplayName("게시판 상세 보기 테스트")
    @org.junit.jupiter.api.Test
    public void boardDetail() throws Exception {
        Integer boardId = 1;
        this.mockMvc.perform(get("/board/" + boardId))
                .andExpect(status().isOk());
    }

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

    @DisplayName("게시판 수정 테스트")
    @org.junit.jupiter.api.Test
    public void boardUpdate() throws Exception {
        Integer boardId = 1;
        String title = "title";
        String content = "content";

        Board board = Board.builder().title(title).content(content).build();
        Gson gson = new Gson();
        String json = gson.toJson(board);

        MvcResult result = this.mockMvc.perform(
                put("/api/board/"+boardId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();
    }

    @DisplayName("게시판 삭제 테스트")
    @org.junit.jupiter.api.Test
    public void boardDelete() throws Exception {
        Integer boardId = 1;

        MvcResult result = this.mockMvc.perform(
                delete("/api/board/"+boardId))
                .andExpect(status().isOk())
                .andReturn();
    }


    @DisplayName("댓글 작성 테스트")
    @org.junit.jupiter.api.Test
    public void replyInsert() throws Exception {
        Integer boardId = 1;
        String content = "content";

        Reply reply = Reply.builder().content(content).build();
        Gson gson = new Gson();
        String json = gson.toJson(reply);

        MvcResult result = this.mockMvc.perform(
                post("/api/board/"+boardId+"/reply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();

    }

    @DisplayName("댓글 삭제 테스트")
    @org.junit.jupiter.api.Test
    public void replyDelete() throws Exception {
        Integer boardId = 1;
        Integer replyId = 1;

        MvcResult result = this.mockMvc.perform(
                delete("/api/board/"+boardId+"reply"+replyId))
                .andExpect(status().isOk())
                .andReturn();
    }

}

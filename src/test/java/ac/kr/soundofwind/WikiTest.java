package ac.kr.soundofwind;

import ac.kr.soundofwind.controller.api.UserApiController;
import ac.kr.soundofwind.controller.api.WikiApiController;
import ac.kr.soundofwind.domain.Board;
import ac.kr.soundofwind.domain.Wiki;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WikiApiController.class)
public class WikiTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("wiki 상세 보기 테스트")
    @org.junit.jupiter.api.Test
    public void wikiDetail() throws Exception {
        Integer wikiId = 1;
        this.mockMvc.perform(get("/wiki/details" + wikiId))
                .andExpect(status().isOk());
    }

    @DisplayName("wiki 생성 테스트")
    @org.junit.jupiter.api.Test
    public void boardInsert() throws Exception {
        String title = "title";
        String content = "content";

        Wiki wiki = Wiki.builder().title(title).content(content).build();
        Gson gson = new Gson();
        String json = gson.toJson(wiki);

        MvcResult result = this.mockMvc.perform(
                post("/api/manager/wiki")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();

    }

    @DisplayName("wiki 수정 테스트")
    @org.junit.jupiter.api.Test
    public void boardUpdate() throws Exception {
        Integer wikiId = 1;
        String title = "title";
        String content = "content";

        Wiki wiki = Wiki.builder().title(title).content(content).build();
        Gson gson = new Gson();
        String json = gson.toJson(wiki);

        MvcResult result = this.mockMvc.perform(
                put("/api/board/"+wikiId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();
    }
}

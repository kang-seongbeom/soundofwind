package ac.kr.soundofwind;

import ac.kr.soundofwind.controller.api.UserApiController;
import ac.kr.soundofwind.controller.api.WikiApiController;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WikiApiController.class)
public class WikiTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("게시판 상세 보기 테스트")
    @org.junit.jupiter.api.Test
    public void wikiDetail() throws Exception {
        Integer wikiId = 1;
        this.mockMvc.perform(get("/wiki/details" + wikiId))
                .andExpect(status().isOk());
    }
}

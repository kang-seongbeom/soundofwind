package ac.kr.soundofwind.controller.api;

import ac.kr.soundofwind.config.auth.PrincipalDetail;
import ac.kr.soundofwind.domain.Board;
import ac.kr.soundofwind.domain.Wiki;
import ac.kr.soundofwind.dto.ResponseDto;
import ac.kr.soundofwind.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WikiApiController {

    @Autowired
    private WikiService wikiService;

    //게시글 작성
    @PostMapping("/api/manager/wiki")
    public ResponseDto<Integer> wikiSave(@RequestBody Wiki wiki,
                                          @AuthenticationPrincipal PrincipalDetail principalDetail){

        wikiService.writeApi(wiki,principalDetail.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value());

    }
}

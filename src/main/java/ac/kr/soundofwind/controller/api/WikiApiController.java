package ac.kr.soundofwind.controller.api;

import ac.kr.soundofwind.config.auth.PrincipalDetail;
import ac.kr.soundofwind.domain.Board;
import ac.kr.soundofwind.domain.Wiki;
import ac.kr.soundofwind.dto.ResponseDto;
import ac.kr.soundofwind.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class WikiApiController {

    @Autowired
    private WikiService wikiService;

    //wiki 작성
    @PostMapping("/api/manager/wiki")
    public ResponseDto<Integer> wikiSave(@RequestBody Wiki wiki,
                                          @AuthenticationPrincipal PrincipalDetail principalDetail){
        wikiService.writeApi(wiki,principalDetail.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value());

    }

    //wiki 수정
    @PutMapping("/api/manager/wiki/{id}")
    public ResponseDto<Integer> update(@PathVariable Integer id, @RequestBody Wiki wiki){
        wikiService.updateWiki(id, wiki);
        return new ResponseDto<Integer>(HttpStatus.OK.value());
    }

    //wiki 삭제
    @DeleteMapping("/api/manager/wiki/{id}")
    public ResponseDto<Integer> delete(@PathVariable Integer id){
        System.out.println("delete호출");
        wikiService.deleteWiki(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value());
    }
}

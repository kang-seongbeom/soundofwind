package ac.kr.soundofwind.controller.api;

import ac.kr.soundofwind.config.auth.PrincipalDetail;
import ac.kr.soundofwind.dto.ResponseDto;
import ac.kr.soundofwind.model.Board;
import ac.kr.soundofwind.model.User;
import ac.kr.soundofwind.service.BoardService;
import ac.kr.soundofwind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> boardSave(@RequestBody Board board,
                                          @AuthenticationPrincipal PrincipalDetail principalDetail){

        Board joinBoard = boardService.writeApi(board,principalDetail.getUser());

        if( joinBoard != null)
            return new ResponseDto<Integer>(HttpStatus.OK.value());
        else
            return new ResponseDto<Integer>(HttpStatus.BAD_REQUEST.value());
    }
}

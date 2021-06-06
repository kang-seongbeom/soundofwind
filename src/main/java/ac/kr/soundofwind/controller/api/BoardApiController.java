package ac.kr.soundofwind.controller.api;

import ac.kr.soundofwind.config.auth.PrincipalDetail;
import ac.kr.soundofwind.dto.RequestReplySaveDto;
import ac.kr.soundofwind.dto.ResponseDto;
import ac.kr.soundofwind.model.Board;
import ac.kr.soundofwind.model.Reply;
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

        boardService.writeApi(board,principalDetail.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value());

    }

    @PostMapping("/api/board/{boardId}/reply")
    public ResponseDto<Integer> writeReply(@RequestBody RequestReplySaveDto replySaveRequestDto){
        System.out.println("-------------"+replySaveRequestDto);
        boardService.writReplyeApi(replySaveRequestDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value());

    }
}

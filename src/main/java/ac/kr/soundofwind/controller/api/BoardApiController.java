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
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    //게시글 작성
    @PostMapping("/api/board")
    public ResponseDto<Integer> boardSave(@RequestBody Board board,
                                          @AuthenticationPrincipal PrincipalDetail principalDetail){

        boardService.writeApi(board,principalDetail.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value());

    }

    //게시글 수정
    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable Integer id, @RequestBody Board board){
        boardService.updateBoard(id, board);
        return new ResponseDto<Integer>(HttpStatus.OK.value());
    }

    //게시글 삭제
    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> delete(@PathVariable Integer id){
        boardService.deleteBoard(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value());
    }

    //댓글 작성
    @PostMapping("/api/board/{boardId}/reply")
    public ResponseDto<Integer> writeReply(@RequestBody RequestReplySaveDto replySaveRequestDto){
        boardService.writeReplyeApi(replySaveRequestDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value());
    }

    //댓글 삭제
    @DeleteMapping("/api/board/{boardId}/reply/{replyId}")
    public ResponseDto<Integer> updateReply(@PathVariable Integer replyId){
        boardService.deleteReply(replyId);
        return new ResponseDto<Integer>(HttpStatus.OK.value());
    }
}

package ac.kr.soundofwind.controller.api;

import ac.kr.soundofwind.config.auth.PrincipalDetail;
import ac.kr.soundofwind.dto.RequestReplySaveDto;
import ac.kr.soundofwind.dto.RequestSearch;
import ac.kr.soundofwind.dto.ResponseDto;
import ac.kr.soundofwind.domain.Board;
import ac.kr.soundofwind.dto.ResponseParameterDto;
import ac.kr.soundofwind.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //검색
    @GetMapping("/api/search/board")
    public ResponseParameterDto search(@RequestParam(value = "item") String item, @RequestParam(value = "text") String text){
        System.out.println("-----"+item+"/"+text);
        RequestSearch requestSearch = new RequestSearch(item, text);
        List<Board> list = boardService.search(requestSearch);
        Object[] objects = new Object[list.size()];
        for(int i=0; i<list.size(); i++){
            System.out.println("id는"+list.get(i).getId());
            objects[i] += list.get(i).getId()+",";
        }
        System.out.println("-----"+objects);
        return new ResponseParameterDto(objects);
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

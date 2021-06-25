package ac.kr.soundofwind.controller;

import ac.kr.soundofwind.domain.Board;
import ac.kr.soundofwind.dto.RequestSearch;
import ac.kr.soundofwind.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/board/details")
    public String board(Model model,
                        @PageableDefault(size = 7,sort="id",direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("boards", boardService.allBoards(pageable));
        return "/board/boards";
    }

    @GetMapping("/board/details/get-boards")
    public String returnSearchBoard(@RequestParam(value = "boardId") String boardIds,
                                    @PageableDefault(size = 3,sort="id",direction = Sort.Direction.DESC) Pageable pageable,
                                    Model model){
        model.addAttribute("searchBoards", boardIds);
        model.addAttribute("boards", boardService.allBoards(pageable));
        return "/board/boards";
    }

    //게시글 상세 보기
    @GetMapping("/board/details/{id}")
    public String detail(@PathVariable Integer id, Model model){
        model.addAttribute("board", boardService.showDetails(id));
        return "/board/detail";
    }

    //게시글 작성
    @GetMapping({"/board/save"})
    public String saveForm(){
        System.out.println("sout");
        return "/board/saveForm";
    }

    //게시글 수정
    @GetMapping("/board/{id}/update")
    public String updateForm(@PathVariable Integer id, Model model){
        model.addAttribute("board", boardService.showDetails(id));
        return "/board/updateForm";
    }

}

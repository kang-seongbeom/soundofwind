package ac.kr.soundofwind.controller;

import ac.kr.soundofwind.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시글 보기
    @GetMapping("/board/{id}")
    public String detail(@PathVariable Integer id, Model model){
        model.addAttribute("board", boardService.showDetails(id));
        return "/board/detail";
    }

    //게시글 작성
    @GetMapping({"/board/saveForm"})
    public String saveForm(){
        return "board/saveForm";
    }

    //게시글 수정
    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable Integer id, Model model){
        model.addAttribute("board", boardService.showDetails(id));
        return "/board/updateForm";
    }

}

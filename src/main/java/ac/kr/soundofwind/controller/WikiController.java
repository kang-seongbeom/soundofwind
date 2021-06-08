package ac.kr.soundofwind.controller;


import ac.kr.soundofwind.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WikiController {

    @Autowired
    private WikiService wikiService;

    @GetMapping("/wiki/details")
    public String board(){
        return "/wiki/detail";
    }

    @GetMapping("/wiki/details/{id}")
    public String detail(@PathVariable Integer id, Model model){
        model.addAttribute("wiki", wikiService.showDetails(id));
        return "/wiki/detail";
    }

    //게시글 작성
    @GetMapping({"/manager/wiki/save"})
    public String saveForm(){
        return "/wiki/saveForm";
    }

}

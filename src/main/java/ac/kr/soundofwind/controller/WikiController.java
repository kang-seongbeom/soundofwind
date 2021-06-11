package ac.kr.soundofwind.controller;


import ac.kr.soundofwind.config.auth.PrincipalDetail;
import ac.kr.soundofwind.config.auth.PrincipalDetailService;
import ac.kr.soundofwind.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WikiController {

    @Autowired
    private WikiService wikiService;

    @GetMapping("/wiki/details")
    public String board(Model model, @PageableDefault(size = 3,sort="id",direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("wikis", wikiService.allWikis(pageable));
        return "/wiki/wikis";
    }

    @GetMapping("/wiki/details/{id}")
    public String detail(@PathVariable Integer id, Model model){
        model.addAttribute("wiki", wikiService.showDetails(id));
        return "/wiki/detail";
    }

    //wiki 작성
    @GetMapping({"/manager/wiki/save"})
    public String saveForm(){
        return "/wiki/saveForm";
    }

    //wiki 수정
    @GetMapping("/manager/wiki/{id}/update")
    public String updateForm(@PathVariable Integer id, Model model){
        model.addAttribute("wiki", wikiService.showDetails(id));
        return "/wiki/updateForm";
    }

}

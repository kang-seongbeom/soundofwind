package ac.kr.soundofwind.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/test")
    public String index(){
        return "test";
    }
}

package ac.kr.soundofwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/join")
    public String join(){
        return "joinForm";

    }
}
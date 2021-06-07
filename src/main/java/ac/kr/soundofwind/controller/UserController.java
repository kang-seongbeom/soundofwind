package ac.kr.soundofwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/join")
    public String join(){
        return "user/joinForm";
    }

    @GetMapping("/auth/login")
    public String loginForm(){
        return "user/loginForm";
    }


    @GetMapping("/user/update")
    public String updateForm(){
        return "user/updateForm";
    }
}

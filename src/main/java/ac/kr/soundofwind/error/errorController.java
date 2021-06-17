package ac.kr.soundofwind.error;

import org.springframework.web.bind.annotation.GetMapping;

public class errorController {
    @GetMapping("/error/accessDenied")
    public String accessDenied(){
        return "error/accessDenied";
    }
}

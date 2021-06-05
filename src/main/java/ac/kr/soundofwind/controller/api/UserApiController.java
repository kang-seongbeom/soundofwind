package ac.kr.soundofwind.controller.api;

import ac.kr.soundofwind.dto.ResponseDto;
import ac.kr.soundofwind.model.User;
import ac.kr.soundofwind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinApi")
    public ResponseDto<Integer> join(@RequestBody User user){
        User joinUser = userService.signUp(user);

        if(joinUser != null)
            return new ResponseDto<Integer>(HttpStatus.OK.value());
        else
            return new ResponseDto<Integer>(HttpStatus.BAD_REQUEST.value());

    }
}

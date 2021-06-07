package ac.kr.soundofwind.controller.api;

import ac.kr.soundofwind.dto.ResponseDto;
import ac.kr.soundofwind.model.User;
import ac.kr.soundofwind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinApi")
    public ResponseDto<Integer> join(@RequestBody User user){
        userService.signUp(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value());
    }

    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user) {

        userService.updateApi(user);

        //찾아보니 유저가 Authentication객체를 상속받기 때문에 아래의 코드는 필요 없다.
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseDto<Integer>(HttpStatus.OK.value());
    }
}

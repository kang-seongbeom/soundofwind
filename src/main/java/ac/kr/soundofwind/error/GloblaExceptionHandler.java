package ac.kr.soundofwind.error;


import ac.kr.soundofwind.dto.ResponseErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //예외 발생 시 spring이 GloblaExceptionHandler클래스에 접근하도록 함
@RestController
public class GloblaExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    public ResponseErrorDto<String> handleArgumentException(Exception e){
        return new ResponseErrorDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }
}


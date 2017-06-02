package bz.sunlight.SpringJpaDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

/**
 * RestResponseEntityExceptionHandler
 * Created by chen_yong on 2017/6/2.
 */
@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
    public String constraintViolationException(Exception ex) {
        return " ~~exception info......."+ex.getMessage();
    }


}

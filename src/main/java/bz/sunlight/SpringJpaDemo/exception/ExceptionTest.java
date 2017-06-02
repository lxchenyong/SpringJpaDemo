package bz.sunlight.SpringJpaDemo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

/**
 * ExceptionTest
 * Created by chen_yong on 2017/6/2.
 */
//@ControllerAdvice
public class ExceptionTest extends ResponseEntityExceptionHandler{

    /**
     * 数据找不到异常
     * http://www.baeldung.com/exception-handling-for-rest-with-spring
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleDataNotFoundException(Exception ex, WebRequest request) throws IOException {
//        return getResponseEntity(ex,request);
        return new ResponseEntity<Object>(
                "Access denied message here~~"+ex.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    /**
     * 根据各种异常构建 ResponseEntity 实体. 服务于以上各种异常
     * @param ex
     * @param request
     * @return
     */
    private ResponseEntity<Object> getResponseEntity(Exception ex, WebRequest request) {

        System.out.println("~~~~~~~Access denied message here~~"+ex.getMessage());
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.OK, request);

    }

}

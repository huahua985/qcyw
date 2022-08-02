package qcyw.xchqcyws.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import qcyw.xchqcyws.common.domain.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //token失效异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = TokenException.class)
    public Result handler(TokenException e){
        return Result.fail(401, e.getMessage());
    }

}

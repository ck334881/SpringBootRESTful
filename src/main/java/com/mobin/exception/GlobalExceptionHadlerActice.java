package com.mobin.exception;

import com.mobin.entity.ErrorMessage;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by Mobin on 2017/11/16.
 */
@RestControllerAdvice
public class GlobalExceptionHadlerActice {
    private static final long serialVersionUID = 1L;

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ErrorMessage NoHandlerFoundException(HttpServletRequest request, Exception e){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
        errorMessage.setMessage(e.getLocalizedMessage());
        errorMessage.setUrl(request.getRequestURL().toString());
        return errorMessage;
    }
}

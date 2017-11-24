package com.mobin.exception;

import com.mobin.common.StatusCode;
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

    @ExceptionHandler(value = Exception.class)
    public ErrorMessage entityNotFoundException(HttpServletRequest request, Exception e){
        ErrorMessage em = new ErrorMessage();
        if(e instanceof EntityNotFoundException){
            em.setStatus(StatusCode.BXOO2.getStatusCode());
            em.setMessage(StatusCode.BXOO2.getMessage());
        }else if (e instanceof EntityNotFoundException){
            em.setStatus(StatusCode.BX003.getStatusCode());
            em.setMessage(StatusCode.BX003.getMessage());
        }
        em.setUrl(request.getRequestURL().toString());
        return em;
    }
}

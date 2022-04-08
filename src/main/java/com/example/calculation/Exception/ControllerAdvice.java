package com.example.calculation.Exception;

import com.example.calculation.DTO.ErrorDTO;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers,
                                                                          HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ErrorDTO("Missing request parameter",
                status.toString(),
                ((ServletWebRequest)request).getRequest().getRequestURI()),
                HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ErrorDTO("Parameters must be numeric",
                status.toString(),
                ((ServletWebRequest) request).getRequest().getRequestURI()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorDTO("Arithmetic exception. " + ex.getMessage(),
                "400 BAD_REQUEST",
                ((ServletWebRequest) request).getRequest().getRequestURI()),
                HttpStatus.BAD_REQUEST);
    }

}

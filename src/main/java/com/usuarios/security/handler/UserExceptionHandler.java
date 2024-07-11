package com.usuarios.security.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usuarios.security.exceptions.CustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    final ObjectMapper mapper = new ObjectMapper();

    @ExceptionHandler({ CustomException.class })
    public ResponseEntity<Object> handleBadRequestException(CustomException ex, WebRequest request) {
        ResponseEntity<Object> responseEntity;

        try {
            String jsonErrorMessage = mapper.writeValueAsString(ex.getErrorObject());
            responseEntity = new ResponseEntity<>(jsonErrorMessage, HttpStatus.BAD_REQUEST);
        } catch (JsonProcessingException e) {
            responseEntity = new ResponseEntity<>("Bad Request" + e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

}

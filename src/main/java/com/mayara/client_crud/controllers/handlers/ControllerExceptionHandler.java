package com.mayara.client_crud.controllers.handlers;

import com.mayara.client_crud.DTOs.CustomError;
import com.mayara.client_crud.DTOs.ValidationError;
import com.mayara.client_crud.services.excepitions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e,HttpServletRequest request){
        HttpStatus status =HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err =new ValidationError(Instant.now(),status.value(),"Invalid Data",request.getRequestURI());
        for (FieldError f: e.getBindingResult().getFieldErrors()){
            err.addList(f.getField(),f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);

    }
}



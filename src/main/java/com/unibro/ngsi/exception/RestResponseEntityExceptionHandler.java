/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nguyenductho
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NotfoundException.class)
    protected ResponseEntity<Object> handleBusinessException(RuntimeException ex, WebRequest request) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(GeneralException.NOTFOUND);
        errors.setPath(((ServletWebRequest) request).getRequest().getRequestURI());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AlreadyExistException.class)
    protected ResponseEntity<Object> handleAlreadyExistException(RuntimeException ex, WebRequest request) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(GeneralException.EXIST_OBJECT);
        errors.setPath(((ServletWebRequest) request).getRequest().getRequestURI());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = GeneralException.class)
    protected ResponseEntity<Object> handleGeneralException(RuntimeException ex, WebRequest request) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(GeneralException.GENERAL);
        errors.setPath(((ServletWebRequest) request).getRequest().getRequestURI());

        return new ResponseEntity<>(errors, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    protected ResponseEntity<Object> handleGeneralUnauthorizedException(RuntimeException ex, WebRequest request) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(GeneralException.ACCESS_DENY);
        errors.setPath(((ServletWebRequest) request).getRequest().getRequestURI());

        return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = ForbiddenException.class)
    protected ResponseEntity<Object> handleGeneralForbiddenException(RuntimeException ex, WebRequest request) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(GeneralException.ACCESS_DENY);
        errors.setPath(((ServletWebRequest) request).getRequest().getRequestURI());

        return new ResponseEntity<>(errors, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = BadRequestException.class)
    protected ResponseEntity<Object> handleGeneralBadRequestException(RuntimeException ex, WebRequest request) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(GeneralException.GENERAL_INVALID_DATA);
        errors.setPath(((ServletWebRequest) request).getRequest().getRequestURI());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<CustomErrorResponse> handleConstraintViolation(
            ConstraintViolationException ex,
            WebRequest request) {
        List<String> details = ex.getConstraintViolations()
                .parallelStream()
                .map(e -> e.getMessage())
                .collect(Collectors.toList());

        String ret = "";
        ret = details.stream().map((detail) -> detail + "\n").reduce(ret, String::concat);
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ret);
        errors.setStatus(GeneralException.GENERAL_INVALID_DATA);
        errors.setPath(((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

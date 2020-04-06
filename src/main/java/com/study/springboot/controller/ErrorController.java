package com.study.springboot.controller;

import com.study.springboot.exception.BadRequestException;
import com.study.springboot.exception.ConflictException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler({IllegalArgumentException.class, HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class,
            BadRequestException.class})
    public ResponseEntity<?> handleAllBadRequestExceptions(Exception ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(new HttpHeaders()).body(new RestErrorInfo(ex));
    }

    @ExceptionHandler({ConflictException.class})
    public ResponseEntity<?> handleAllConflictExceptions(Exception ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.CONFLICT).headers(new HttpHeaders()).body(new RestErrorInfo(ex));
    }

    private class RestErrorInfo {
        public final String detail;
        public final String message;

        RestErrorInfo(Exception ex) {
            this.message = ex.getLocalizedMessage();
            this.detail = ex.getClass().getName();
        }
    }
}

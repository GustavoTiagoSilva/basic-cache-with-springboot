package com.demo.basic_cache_with_springboot.controllers.exceptions;

import com.demo.basic_cache_with_springboot.dto.HttpErrorResponseDto;
import com.demo.basic_cache_with_springboot.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HttpErrorResponseDto> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest req) {

        log.error("Error: ", e);

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        HttpErrorResponseDto httpExceptionHandlerResponse = new HttpErrorResponseDto(
                Instant.now(),
                httpStatus.value(),
                "Resource not found",
                e.getMessage(),
                req.getRequestURI()
        );

        return new ResponseEntity<>(httpExceptionHandlerResponse, httpStatus);
    }

}

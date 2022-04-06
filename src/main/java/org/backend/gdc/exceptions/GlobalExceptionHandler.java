package org.backend.gdc.exceptions;

import org.backend.gdc.dto.ErrorDTO;
import org.backend.gdc.enums.ErrorCode;
import org.backend.gdc.exceptions.technical.IllegalNullParamException;
import org.backend.gdc.exceptions.technical.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalNullParamException.class})
    protected ResponseEntity<ErrorDTO> handleConflict(IllegalNullParamException ex, WebRequest request) {

        return new ResponseEntity<>(ErrorDTO.builder()
                .code(ErrorCode.CODE_1.name())
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build(),
                HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {ObjectNotFoundException.class})
    protected ResponseEntity<ErrorDTO> handleConflict(ObjectNotFoundException ex, WebRequest request) {

        return new ResponseEntity<>(ErrorDTO.builder()
                .code(ErrorCode.CODE_2.getCode())
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build(),
                HttpStatus.NOT_FOUND);
    }


}

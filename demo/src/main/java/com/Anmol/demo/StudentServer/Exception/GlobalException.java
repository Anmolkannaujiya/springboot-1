package com.Anmol.demo.StudentServer.Exception;

import com.Anmol.demo.StudentServer.DTO.ExceptionResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDTO> handleRuntimeException(RuntimeException e, HttpServletRequest req){

        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        //using DTO
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage(),
                req.getRequestURI()

        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<String> handleCheckedException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("An external system dependency " +
                "failed to respond.");
    }
}

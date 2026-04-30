package com.example.Revisao7.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

public class GlobalException {
    @ExceptionHandler (RuntimeException.class)
    public ResponseEntity<Map<String, Object>> runtimeException(RuntimeException Erro){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("Mensagem",Erro.getMessage()));
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> IllegalArgumentException(IllegalArgumentException Erro){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("Mensagem",Erro.getMessage()));
    }


}


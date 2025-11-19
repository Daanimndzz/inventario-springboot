package com.miempresa.inventario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Esto convierte a la clase en un "interceptor" de errores global
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // Devolverá un error 400 (Petición Incorrecta)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> manejarErroresDeValidacion(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();

        // Extrae cada campo que falló y su mensaje de error
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        return errores; // Devuelve un JSON limpio: {"precio": "El precio debe ser mayor a 0"}
    }
}
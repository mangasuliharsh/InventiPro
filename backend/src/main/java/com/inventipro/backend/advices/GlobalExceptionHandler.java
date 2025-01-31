package com.inventipro.backend.advices;

import com.inventipro.backend.exceptions.NoSuchResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> exception(Exception e) {
        ApiError error = ApiError.builder()
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return buildApiResponse(error);
    }

    @ExceptionHandler(NoSuchResourceException.class)
    public ResponseEntity<ApiResponse<?>> exception(NoSuchResourceException e) {
        ApiError error = ApiError.builder()
                .message("No Such Resource Found")
                .status(HttpStatus.NOT_FOUND)
                .build();

        return buildApiResponse(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> exception(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError error = ApiError
                .builder()
                .message("Input Validation Failed")
                .status(HttpStatus.BAD_REQUEST)
                .subErrors(errors)
                .build();

        return buildApiResponse(error);
    }

    public ResponseEntity<ApiResponse<?>> buildApiResponse(ApiError error) {
        return new ResponseEntity<>(new ApiResponse<>(error), error.getStatus());
    }
}

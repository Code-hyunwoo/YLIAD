package com.carver.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({CustomException.class})
  public ResponseEntity<ErrorResponse> handleRestApiException(final CustomException exception) {
    return this.makeErrorResponseEntity(exception.getCustomErrorResult());
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<ErrorResponse> handleException(final Exception exception) {
    return this.makeErrorResponseEntity(exception);
  }

  private ResponseEntity<ErrorResponse> makeErrorResponseEntity(
      final CustomErrorResult errorResult) {
    return ResponseEntity.status(errorResult.getHttpStatus())
        .body(new ErrorResponse(errorResult.name(), errorResult.getDetail()));
  }

  private ResponseEntity<ErrorResponse> makeErrorResponseEntity(final Exception exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(
            new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.name(), exception.getMessage()));
  }

  @Getter
  @RequiredArgsConstructor
  static class ErrorResponse {

    private final String code;
    private final String message;
  }
}

package it.epicode.blogApi.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler {


        @ExceptionHandler(value = EntityNotFoundException.class)
        protected ResponseEntity<ErrorMessage> entityNotFound(EntityNotFoundException ex) {
            ErrorMessage e = new ErrorMessage();
            e.setMessage("Error da classe: " + ex.getMessage());
            e.setStatusCode(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(e, e.getStatusCode());
        }
}

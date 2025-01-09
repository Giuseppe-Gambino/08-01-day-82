package it.epicode.blogApi.exceptions;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ErrorMessage {
    // Getters e Setters
    private String message;
    private HttpStatus statusCode;

    // Costruttore predefinito
    public ErrorMessage() {}

}

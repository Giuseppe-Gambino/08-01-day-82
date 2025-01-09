package it.epicode.blogApi.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class requestPost {

    @NotEmpty(message = "Il campo titolo non può essere vuoto")
    private String titolo;

    @NotEmpty(message = "Il campo contenuto non può essere vuoto")
    private String contenuto;

    @NotEmpty(message = "Il campo tempo di lettura non può essere vuoto")
    private int tempoDiLettura;

}

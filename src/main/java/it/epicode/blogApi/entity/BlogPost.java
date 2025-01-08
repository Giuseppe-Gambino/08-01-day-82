package it.epicode.blogApi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@NamedQuery(name="Trova_tutto_BlogPost", query="SELECT a FROM BlogPost a")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "cover")
    private String cover;

    @Column(name = "contenuto")
    private String contenuto;

    @Column(name = "tempo_di_lettura")
    private Integer tempoDiLettura;
}

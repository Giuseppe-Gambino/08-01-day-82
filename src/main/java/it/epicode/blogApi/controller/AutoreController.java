package it.epicode.blogApi.controller;

import it.epicode.blogApi.services.AutoreSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    @Autowired
    private AutoreSvc autoreSvc;

}

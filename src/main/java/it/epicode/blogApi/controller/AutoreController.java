package it.epicode.blogApi.controller;

import it.epicode.blogApi.entity.Autore;
import it.epicode.blogApi.entity.BlogPost;
import it.epicode.blogApi.services.AutoreSvc;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    @Autowired
    private AutoreSvc autoreSvc;


    @GetMapping
    public ResponseEntity<List<Autore>> getAll() {
        return ResponseEntity.ok(autoreSvc.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(autoreSvc.findById(id));
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Autore autore) {
        return new ResponseEntity<>(autoreSvc.save(autore), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Autore autore) {
        return ResponseEntity.ok(autoreSvc.edit(id, autore));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        autoreSvc.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

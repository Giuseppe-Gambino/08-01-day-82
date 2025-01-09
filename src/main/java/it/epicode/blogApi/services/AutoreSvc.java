package it.epicode.blogApi.services;

import it.epicode.blogApi.entity.Autore;
import it.epicode.blogApi.repo.AutoreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutoreSvc {
    private final AutoreRepository autoreRepo;

    public List<Autore> getAll() {
        return autoreRepo.findAll();
    }

    public Optional<Autore> findById(Long id) {
        if(!autoreRepo.existsById(id)) {
            throw new EntityNotFoundException("l'autore non è stato trovato");
        }

        return autoreRepo.findById(id);
    }

    public Autore save(Autore Autore) {
        return autoreRepo.save(Autore);
    }

    public Autore edit(Long id, Autore autore) {

        Autore existingAutore = autoreRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Autore with ID " + id + " not found"));

        BeanUtils.copyProperties(autore, existingAutore, "id");


        return autoreRepo.save(existingAutore);
    }


    public void delete(Long id) {
        autoreRepo.deleteById(id);
    }

}

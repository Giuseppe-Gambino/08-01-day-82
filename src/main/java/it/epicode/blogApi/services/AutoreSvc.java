package it.epicode.blogApi.services;

import it.epicode.blogApi.entity.Autore;
import it.epicode.blogApi.entity.BlogPost;
import it.epicode.blogApi.repo.AutoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutoreSvc {
    private final AutoreRepository autoreRepo;

    public List<Autore> getAllAutori() {
        return autoreRepo.findAll();
    }

    public Optional<Autore> findById(Long id) {
        return autoreRepo.findById(id);
    }

    public Autore saveAutore(Autore Autore) {
        return autoreRepo.save(Autore);
    }


    public void deleteAutore(Long id) {
        autoreRepo.deleteById(id);
    }

}

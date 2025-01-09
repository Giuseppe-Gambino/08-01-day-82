package it.epicode.blogApi.repo;

import it.epicode.blogApi.entity.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Long> {
    boolean existsById(Long id);
}
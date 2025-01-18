package br.com.alura.literAlura.repository;

import br.com.alura.literAlura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
    List<Author>findByDeathYearGreaterThan(Integer year);
}

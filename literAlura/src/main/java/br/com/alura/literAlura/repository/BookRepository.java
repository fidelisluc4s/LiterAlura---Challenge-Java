package br.com.alura.literAlura.repository;

import br.com.alura.literAlura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitleContainingIgnoreCase(String titulo);

    @Query("SELECT l FROM Book l WHERE l.language = :language")
    List<Book> findBooksByLanguage(@Param("language") String language);
}

package org.alura.literalura.repository;

import org.alura.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
// Interface que extiende de JpaRepository para realizar operaciones CRUD en la tabla de autores
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
  @Query("SELECT a FROM Author a WHERE a.birthYear <= :year AND a.deathYear >= :year")
  List<Author> searchAuthorbyYear(int year);
  Optional<Author> findByName(String name);
}

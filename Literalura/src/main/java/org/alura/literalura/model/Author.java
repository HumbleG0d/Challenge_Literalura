package org.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "authors")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int birthYear;
  private int deathYear;
  @OneToMany(mappedBy ="autor", fetch = FetchType.EAGER)
  private List<Books> books;

  public Author(String name, int deathYear, int birthYear) {
    this.name = name;
    this.deathYear = deathYear;
    this.birthYear = birthYear;
  }

  public Author() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }

  public int getDeathYear() {
    return deathYear;
  }

  public void setDeathYear(int deathYear) {
    this.deathYear = deathYear;
  }

  public List<Books> getBooks() {
    return books;
  }

  public void setBooks(List<Books> books) {
    books.forEach(book -> book.setAutor(this));
    this.books = books;
  }

  @Override
  public String toString() {
    return "Author{" +
            "name='" + name + '\'' +
            ", birthYear=" + birthYear +
            ", deathYear=" + deathYear +
            '}';
  }
}


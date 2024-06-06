package org.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class Books {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true)
  private String titulo;
  private int decargas;
  @ManyToOne(fetch = FetchType.EAGER)
  private Author autor;
  @ElementCollection(targetClass = Languages.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "lenguajes", joinColumns = @JoinColumn(name = "book_id"))
  @Enumerated(EnumType.STRING)
  @Column(name = "language")
  private List<Languages> idiomas;

  public Books(DataBooks dataBooks , DataAuthors dataAuthors ){
    this.titulo = dataBooks.titulo();
    this.decargas = dataBooks.decargas();
    this.autor = new Author(dataAuthors.nombre() , dataAuthors.anioMuerte() , dataAuthors.anioNacimiento());
    this.idiomas = Languages.getLanguages(dataBooks.idiomas()).stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toList());;
  }

  public Books(){

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getDecargas() {
    return decargas;
  }

  public void setDecargas(int decargas) {
    this.decargas = decargas;
  }

  public Author getAutor() {
    return autor;
  }

  public void setAutor(Author autor) {
    this.autor = autor;
  }

  public List<Languages> getIdiomas() {
    return idiomas;
  }

  public void setIdiomas(List<Languages> idiomas) {
    this.idiomas = idiomas;
  }

  @Override
  public String toString() {
    return "Titulo : " + titulo + "\n" +
            "Autor : " + autor.getName() + "\n" +
            "Idiomas : " + idiomas + "\n"+
            "Número de decargas : " + decargas + "\n" ;
  }
}

package org.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Libros {
  private String titulo;
  private int decargas;
  private List<DataAuthors> autores;
  private List<String> idiomas;

  public Libros(String titulo , int descargas , DataAuthors dataAuthors)
}

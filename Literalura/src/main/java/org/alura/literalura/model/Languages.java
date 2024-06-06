package org.alura.literalura.model;

import java.util.Arrays;
import java.util.List;

//Este enum contiene los idiomas en los que se pueden encontrar los libros
public enum Languages {
  ENGLISH("en"),
  SPANISH("es");

  private final String language;

  Languages(String language){
    this.language = language;
  }

  //Este metodo recibe una lista de idiomas y devuelve una lista de idiomas validos
  public static List<Languages> getLanguages(List<String> languages){
    return Arrays.stream(Languages.values()).map(l ->{
      if(languages.contains(l.language)){
        return l;
      }
      return null;
    }).toList();
  }
}

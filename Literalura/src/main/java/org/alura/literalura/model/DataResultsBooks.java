package org.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
//Este record es el resultado de la busqueda de libros
public record DataResultsBooks(
        @JsonAlias("next") String nextURL,
        @JsonAlias("results") List<DataBooks> dataBooks
) {
}

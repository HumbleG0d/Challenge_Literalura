package org.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataResults(
        @JsonAlias("title") String titulo,
        @JsonAlias("download_count") int decargas
) {
}

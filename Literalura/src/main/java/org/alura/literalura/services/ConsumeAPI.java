package org.alura.literalura.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;

public class ConsumeAPI {
  public String getData(String url){

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
    try{
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      if(response.statusCode() == 200) {
        return response.body();
      }else{
        throw new RuntimeException("Error en la petición. Código de error: " + response.statusCode());
      }
    }catch(HttpTimeoutException e){
      throw new RuntimeException("Tiempo finalizado para la petición. " + e);
    }catch (RuntimeException e){
      throw new RuntimeException("Error al consumir la API. " + e);
    }catch(Exception e){
      throw new RuntimeException("Error en la petición. " + e);
    }
  }
}

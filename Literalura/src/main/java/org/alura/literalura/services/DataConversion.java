package org.alura.literalura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConversion implements IConvertData {
  private final ObjectMapper objectMapper = new ObjectMapper();
  @Override
  public <T> T convertData(String json, Class<T> type) {
    try{
      return objectMapper.readValue(json, type);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error al convertir los datos." + e);
    }
  }
}

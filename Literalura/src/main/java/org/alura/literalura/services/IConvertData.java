package org.alura.literalura.services;

public interface IConvertData {
  <T> T convertData(String data, Class<T> type);
}

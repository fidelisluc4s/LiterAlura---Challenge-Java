package br.com.alura.literAlura.service;

public interface IDataConverter {
    <T> T  getData(String json, Class<T> classT);
}


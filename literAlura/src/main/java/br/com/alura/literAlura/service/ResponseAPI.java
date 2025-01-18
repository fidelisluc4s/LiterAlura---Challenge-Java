package br.com.alura.literAlura.service;


import br.com.alura.literAlura.model.DataBook;
import lombok.Data;
import java.util.List;

@Data
public class ResponseAPI {
    private int count;
    private String next;
    private String previous;
    private List<DataBook> results;

    @Override
    public String toString() {
        return "ResponseAPI{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }
}

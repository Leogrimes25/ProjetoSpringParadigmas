package com.example.vinicius.ProjetoSpringParadigmas.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Produtos")
public class Produto {
    @Id
    private String id;
    private String nome;
    private String marca;
    private Double valor;
    private Integer estoque;
    private String categoria;

    public Produto(){

    }
    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", valor=" + valor +
                ", estoque=" + estoque +
                ", categoria='" + categoria + '\'' +
                '}';
    }


}


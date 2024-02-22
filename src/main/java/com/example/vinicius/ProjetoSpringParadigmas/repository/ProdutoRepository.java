package com.example.vinicius.ProjetoSpringParadigmas.repository;

import com.example.vinicius.ProjetoSpringParadigmas.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto,String> {
}

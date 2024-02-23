package com.example.vinicius.ProjetoSpringParadigmas.controller;
import com.example.vinicius.ProjetoSpringParadigmas.model.Produto;
import com.example.vinicius.ProjetoSpringParadigmas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping()
    public List<Produto> visualizarTodos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> visualizarPorId(@PathVariable String id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        return produtoOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produto> adicionarDocumento(@RequestBody Produto produto) {
        Produto novoProduto = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarPorId(@PathVariable String id, @RequestBody Produto produto) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produto _produto = produtoOptional.get();
            _produto.setNome(produto.getNome());
            _produto.setMarca(produto.getMarca());
            _produto.setValor(produto.getValor());
            _produto.setEstoque(produto.getEstoque());
            _produto.setCategoria(produto.getCategoria());

            return new ResponseEntity<>(produtoRepository.save(_produto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarDocumento(@PathVariable String id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            produtoRepository.deleteById(id);
            return new ResponseEntity<>("Documento Deletado com sucesso! ID: " + id, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}







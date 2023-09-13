package com.catalisa.biblioteca.controller;

import com.catalisa.biblioteca.model.LivroModel;
import com.catalisa.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    LivroService livroService;
    @GetMapping
    public List<LivroModel> listar(){

        return  livroService.listar();

    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<LivroModel> buscar(@PathVariable Long id){

        Optional<LivroModel> livro = livroService.buscar(id);
        if(livro.isPresent()){

            return ResponseEntity.ok(livro.get());

        } else

            return ResponseEntity.notFound().build();

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroModel adicionar(@RequestBody LivroModel livro){
        return livroService.salvar(livro);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<LivroModel> atualizar(@PathVariable Long id, @RequestBody LivroModel livro) {

        Optional<LivroModel> livroAtual = livroService.alterar(livro, id);
        if (livroAtual.isPresent()) {

            return ResponseEntity.ok().build();

        } else

            return ResponseEntity.notFound().build();

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remover(@PathVariable Long id) {

        livroService.excluir(id);

    }

}

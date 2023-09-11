package com.catalisa.biblioteca.service;

import com.catalisa.biblioteca.model.Livro;
import com.catalisa.biblioteca.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
1- Exibir todos os livros
2- Exibir um livro específico
3- Cadastro de um novo livro
4- Alteração de um livro
5- Deleção de um livro
 */
@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public List<Livro> listar() {

        return livroRepository.findAll();

    }

    public Optional<Livro> buscar(Long id) {

        return livroRepository.findById(id);

    }

    public Livro salvar(Livro livro) {

        return livroRepository.save(livro);

    }

    public Optional<Livro> alterar(Livro livro, Long id) {

        Optional<Livro> livroAtual = buscar(id);

        if (livroAtual.isPresent()) {

            BeanUtils.copyProperties(livro, livroAtual.get(), "id");

            salvar(livro);


        }

        return livroAtual;
    }

    public void excluir(Long id) {

        livroRepository.deleteById(id);

    }

}

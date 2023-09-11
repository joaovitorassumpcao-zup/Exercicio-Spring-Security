package com.catalisa.biblioteca.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "tb_biblioteca")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(name = "data_lancamento",nullable = false)
    private LocalDate dataLancamento;

    @Column(length = 50, nullable = false)
    private String autor;

    @Column(length = 50, nullable = false)
    private String codigo;

}

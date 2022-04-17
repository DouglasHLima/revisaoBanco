package com.revisao.banco.revisaoBanco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@Builder
public class Aluno {
    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String matricula;
}

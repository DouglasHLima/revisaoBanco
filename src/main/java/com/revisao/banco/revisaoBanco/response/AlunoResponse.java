package com.revisao.banco.revisaoBanco.response;

import com.revisao.banco.revisaoBanco.model.Aluno;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class AlunoResponse {
    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String matricula;

    public AlunoResponse(Aluno aluno) {
        this.nome = aluno.getNome();
        this.cpf = aluno.getCpf();
        this.email = aluno.getEmail();
        this.matricula = aluno.getMatricula();
    }
}

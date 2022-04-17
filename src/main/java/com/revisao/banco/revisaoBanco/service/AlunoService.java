package com.revisao.banco.revisaoBanco.service;

import com.revisao.banco.revisaoBanco.model.Aluno;
import com.revisao.banco.revisaoBanco.request.AlunoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    List<Aluno> alunos = new ArrayList<>();

    public Aluno criarAluno(AlunoRequest alunoRequest) {
        Aluno aluno = Aluno.builder()
                .id(UUID.randomUUID())
                .nome(alunoRequest.getNome())
                .cpf(alunoRequest.getCpf())
                .email(alunoRequest.getEmail())
                .matricula(alunoRequest.getMatricula())
                .build();
        this.alunos.add(aluno);
        return aluno;
    }

    public List<Aluno> buscaAlunos(UUID id) {
        return alunos.stream().filter(
                    aluno -> aluno.getId() == id
                ).collect(Collectors.toList());
    }

    public List<Aluno> buscaAlunos() {
        return alunos;
    }
}


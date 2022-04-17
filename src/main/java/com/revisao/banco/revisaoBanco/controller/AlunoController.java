package com.revisao.banco.revisaoBanco.controller;

import com.revisao.banco.revisaoBanco.model.Aluno;
import com.revisao.banco.revisaoBanco.request.AlunoRequest;
import com.revisao.banco.revisaoBanco.response.AlunoResponse;
import com.revisao.banco.revisaoBanco.service.AlunoService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(
        name = "/alunos",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AlunoResponse> criarPerdido(
            @RequestBody @Valid AlunoRequest pedidoRequest,
            UriComponentsBuilder uriComponentsBuilder
            ) {
        Aluno aluno = alunoService.criarAluno(pedidoRequest);
        URI uri = uriComponentsBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoResponse(aluno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AlunoResponse>> getAlunos(
            @PathVariable("id") UUID id
    ) {
        val response = alunoService.buscaAlunos(id).stream()
                .map(AlunoResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> getAlunos(){
        val response = alunoService.buscaAlunos().stream()
                .map(AlunoResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

}

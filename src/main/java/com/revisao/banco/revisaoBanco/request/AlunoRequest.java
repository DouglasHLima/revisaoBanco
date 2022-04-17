package com.revisao.banco.revisaoBanco.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
public class AlunoRequest {
    @NotEmpty @NotNull(message = "nome não pode ser nullo") @Size(min = 3)
    private String nome;
    @NotNull @NotEmpty @CPF
    private String cpf;
    @NotNull @NotEmpty @Email
    private String email;
    @NotEmpty @NotEmpty
    private String matricula;
}

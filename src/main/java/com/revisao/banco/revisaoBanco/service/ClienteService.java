package com.revisao.banco.revisaoBanco.service;

import com.revisao.banco.revisaoBanco.request.ClienteRequest;
import com.revisao.banco.revisaoBanco.model.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ClienteService {

    public Cliente cadastraCliente(ClienteRequest clienteRequest) {

        return new Cliente(UUID.randomUUID(),
                clienteRequest.getNome(),
                clienteRequest.getEmail(),
                clienteRequest.getSenha());
    }

    public List<Cliente> buscaCliente() {
        log.info("buscando clientes .... ");
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = new Cliente(UUID.randomUUID(), "doughlima", "doughhdelima@gmail.com", "4534534");
        Cliente cliente2 = new Cliente(UUID.randomUUID(), "douglasLima", "doughhdelima@gmail.com", "1234568");

        clientes.add(cliente);
        clientes.add(cliente2);

        return clientes;
    }
}

package com.bancopichincha.retojava.application.ports.output;

import com.bancopichincha.retojava.domain.model.Cliente;

import java.util.Optional;

public interface ClienteOutputPort {
    Cliente save(Cliente cliente);

    Optional<Cliente> get(Long clienteId);

    void delete(Cliente cliente);
}

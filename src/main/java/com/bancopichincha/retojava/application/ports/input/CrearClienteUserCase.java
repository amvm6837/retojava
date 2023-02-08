package com.bancopichincha.retojava.application.ports.input;

import com.bancopichincha.retojava.domain.model.Cliente;

public interface CrearClienteUserCase {
    Cliente crearCliente(Cliente cliente);
}

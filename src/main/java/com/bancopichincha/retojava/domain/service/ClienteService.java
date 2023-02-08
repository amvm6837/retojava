package com.bancopichincha.retojava.domain.service;

import com.bancopichincha.retojava.application.ports.input.ActualizarClienteUserCase;
import com.bancopichincha.retojava.application.ports.input.ConsultarClienteUserCase;
import com.bancopichincha.retojava.application.ports.input.CrearClienteUserCase;
import com.bancopichincha.retojava.application.ports.input.EliminarClienteUserCase;
import com.bancopichincha.retojava.application.ports.output.ClienteOutputPort;
import com.bancopichincha.retojava.domain.exception.ClienteNotFound;
import com.bancopichincha.retojava.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService implements CrearClienteUserCase, ConsultarClienteUserCase, EliminarClienteUserCase, ActualizarClienteUserCase {

    private ClienteOutputPort clienteOutputPort;

    @Autowired
    public ClienteService(ClienteOutputPort clienteOutputPort) {
        this.clienteOutputPort = clienteOutputPort;
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteOutputPort.save(cliente);
    }

    @Override
    public Cliente consultarCliente(Long clienteId) {
        return clienteOutputPort.get(clienteId).orElseThrow(
                () -> new ClienteNotFound("Cliente no encontrado con id " + clienteId));
    }

    @Override
    public void eliminarCliente(Long clienteId) {

        Optional<Cliente> cliente = clienteOutputPort.get(clienteId);

        if(cliente.isPresent()){
            clienteOutputPort.delete(cliente.get());
        }else {
            throw new ClienteNotFound("Cliente no encontrado con id " + clienteId);
        }
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {

        Optional<Cliente> optionalCliente = clienteOutputPort.get(cliente.getId());

        if(optionalCliente.isPresent()){
            return clienteOutputPort.save(cliente);
        }else {
            throw new ClienteNotFound("Cliente no encontrado con id " + cliente.getId());
        }
    }
}

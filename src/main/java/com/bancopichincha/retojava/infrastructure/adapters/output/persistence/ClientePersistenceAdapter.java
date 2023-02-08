package com.bancopichincha.retojava.infrastructure.adapters.output.persistence;

import com.bancopichincha.retojava.application.ports.output.ClienteOutputPort;
import com.bancopichincha.retojava.domain.exception.ClienteNotFound;
import com.bancopichincha.retojava.domain.model.Cliente;
import com.bancopichincha.retojava.infrastructure.adapters.output.persistence.entity.ClienteEntity;
import com.bancopichincha.retojava.infrastructure.adapters.output.persistence.mapper.ClientePersistenceMapper;
import com.bancopichincha.retojava.infrastructure.adapters.output.persistence.repository.IClienteRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientePersistenceAdapter implements ClienteOutputPort {

    private IClienteRepository clienteRepository;

    private ClientePersistenceMapper clientePersistenceMapper;

    @Autowired
    public ClientePersistenceAdapter(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

        this.clientePersistenceMapper = Mappers.getMapper(ClientePersistenceMapper.class);
    }

    @Override
    public Cliente save(Cliente cliente) {
       //mapeo la clase cliente a la interfaz cliente
        ClienteEntity clienteEntity = clientePersistenceMapper.toClienteEntity(cliente);

        clienteEntity = clienteRepository.save(clienteEntity);

        return clientePersistenceMapper.toCliente(clienteEntity);
    }

    @Override
    public Optional<Cliente> get(Long clienteId) {
        Optional<Cliente> result;

        //mapeo la clase cliente a la interfaz cliente
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(clienteId);

        if(clienteEntity.isPresent()){
            result = Optional.of(clientePersistenceMapper.toCliente(clienteEntity.get()));
        }else{
            result = Optional.empty();
        }

        return result;
    }

    @Override
    public void delete(Cliente cliente) {
        ClienteEntity clienteEntity = clientePersistenceMapper.toClienteEntity(cliente);

        clienteRepository.delete(clienteEntity);
    }
}

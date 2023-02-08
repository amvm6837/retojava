package com.bancopichincha.retojava.infrastructure.adapters.output.persistence.mapper;

import com.bancopichincha.retojava.domain.model.Cliente;
import com.bancopichincha.retojava.infrastructure.adapters.input.rest.mapper.ClienteRestMapper;
import com.bancopichincha.retojava.infrastructure.adapters.output.persistence.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientePersistenceMapper {

    ClientePersistenceMapper INSTANCE = Mappers.getMapper(ClientePersistenceMapper.class);
    ClienteEntity toClienteEntity(Cliente cliente);

    Cliente toCliente(ClienteEntity clienteEntity);
}

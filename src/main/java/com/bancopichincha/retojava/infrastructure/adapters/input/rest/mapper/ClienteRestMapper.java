package com.bancopichincha.retojava.infrastructure.adapters.input.rest.mapper;

import com.bancopichincha.retojava.domain.model.Cliente;
import com.bancopichincha.retojava.infrastructure.adapters.input.rest.data.request.ClienteRequest;
import com.bancopichincha.retojava.infrastructure.adapters.input.rest.data.response.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteRestMapper {
    ClienteRestMapper INSTANCE = Mappers.getMapper(ClienteRestMapper.class);
    Cliente toCliente(ClienteRequest clienteRequest);

    ClienteResponse toClientResponse(Cliente cliente);

}

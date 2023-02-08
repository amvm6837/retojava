package com.bancopichincha.retojava.infrastructure.adapters.input.rest;

import com.bancopichincha.retojava.application.ports.input.ActualizarClienteUserCase;
import com.bancopichincha.retojava.application.ports.input.ConsultarClienteUserCase;
import com.bancopichincha.retojava.application.ports.input.CrearClienteUserCase;
import com.bancopichincha.retojava.application.ports.input.EliminarClienteUserCase;
import com.bancopichincha.retojava.domain.model.Cliente;
import com.bancopichincha.retojava.infrastructure.adapters.input.rest.data.request.ClienteRequest;
import com.bancopichincha.retojava.infrastructure.adapters.input.rest.data.response.ClienteResponse;
import com.bancopichincha.retojava.infrastructure.adapters.input.rest.mapper.ClienteRestMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteRestAdapter {

    private CrearClienteUserCase crearClienteUserCase;
    private ConsultarClienteUserCase consultarClienteUserCase;
    private EliminarClienteUserCase eliminarClienteUserCase;

    private ActualizarClienteUserCase actualizarClienteUserCase;

    private ClienteRestMapper clienteRestMapper;

    @Autowired
    public ClienteRestAdapter(CrearClienteUserCase crearClienteUserCase,
                              ConsultarClienteUserCase consultarClienteUserCase,
                              EliminarClienteUserCase eliminarClienteUserCase,
                              ActualizarClienteUserCase actualizarClienteUserCase) {
        this.crearClienteUserCase = crearClienteUserCase;
        this.consultarClienteUserCase = consultarClienteUserCase;
        this.eliminarClienteUserCase = eliminarClienteUserCase;
        this.actualizarClienteUserCase = actualizarClienteUserCase;

        this.clienteRestMapper = Mappers.getMapper(ClienteRestMapper.class);
    }


    @PostMapping
    public ResponseEntity<ClienteResponse> createCliente(@RequestBody ClienteRequest clienteCreateRequest) {
        //mapeo a la clase de dominio
        Cliente cliente = clienteRestMapper.toCliente(clienteCreateRequest);

        //llamo la lógica que crea el cliente
        cliente = crearClienteUserCase.crearCliente(cliente);

        return new ResponseEntity<>(clienteRestMapper.toClientResponse(cliente), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponse> leerCliente(@PathVariable("id") Long clienteId){
        Cliente cliente = consultarClienteUserCase.consultarCliente(clienteId);

        return new ResponseEntity<>(clienteRestMapper.toClientResponse(cliente), HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    public void eliminarCliente(@PathVariable("id") Long clienteId){
        eliminarClienteUserCase.eliminarCliente(clienteId);
    }

    @PutMapping
    public ResponseEntity<ClienteResponse> actualizarCliente(@RequestBody ClienteRequest clienteRequest){
        Cliente cliente = clienteRestMapper.toCliente(clienteRequest);

        cliente =  actualizarClienteUserCase.actualizarCliente(cliente);

        return new ResponseEntity<>(clienteRestMapper.toClientResponse(cliente), HttpStatus.OK);
    }

}

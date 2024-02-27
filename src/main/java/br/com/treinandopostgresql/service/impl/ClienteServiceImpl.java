/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.treinandopostgresql.service.impl;

import br.com.treinandopostgresql.model.Cliente;
import br.com.treinandopostgresql.payload.ClienteDto;
import br.com.treinandopostgresql.repository.ClienteRepository;
import br.com.treinandopostgresql.service.ClienteService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class ClienteServiceImpl implements ClienteService{
    
    private ClienteRepository clienteRepository;
    private ModelMapper model;
    
    public ClienteServiceImpl(ClienteRepository clienteRepository, ModelMapper model) {
        this.clienteRepository = clienteRepository;
        this.model = model;
    }

    @Override
    public ClienteDto createCliente(ClienteDto clienteDto) {
        Cliente cliente = model.map(clienteDto, Cliente.class);
        Cliente novoCliente = clienteRepository.save(cliente);
        
        ClienteDto clienteResponse = model.map(novoCliente, ClienteDto.class);
                
        return clienteResponse;
    }

    @Override
    public List<ClienteDto> getAllClientes() {
        List<Cliente> clientes = new ArrayList();
        clientes = clienteRepository.findAll();
        
        return clientes.stream().map(cliente -> model.map(cliente, ClienteDto.class)).collect(Collectors.toList());
    }

    @Override
    public ClienteDto updateCliente(ClienteDto clienteDto, Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        
        cliente.setNome(clienteDto.getNome());
        cliente.setSobrenome(clienteDto.getSobrenome());
        cliente.setIdade(clienteDto.getIdade());
        clienteRepository.save(cliente);
        
        return model.map(cliente, ClienteDto.class);
    }

    @Override
    public void deleteCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        
        clienteRepository.delete(cliente);
    }
}

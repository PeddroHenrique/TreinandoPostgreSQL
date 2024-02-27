/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.treinandopostgresql.service;

import br.com.treinandopostgresql.payload.ClienteDto;
import br.com.treinandopostgresql.repository.ClienteRepository;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface ClienteService{
    
    ClienteDto createCliente(ClienteDto clienteDto);
    List<ClienteDto> getAllClientes();
    ClienteDto updateCliente(ClienteDto clienteDto, Long id);
    void deleteCliente(Long id);
    
}

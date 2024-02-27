/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.treinandopostgresql.controller;

import br.com.treinandopostgresql.model.Cliente;
import br.com.treinandopostgresql.payload.ClienteDto;
import br.com.treinandopostgresql.service.ClienteService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pedro
 */
@RestController
@RequestMapping("/api")
public class ClienteController {
    
    private ClienteService clienteService;
    
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @PostMapping
    public ResponseEntity<ClienteDto> createCliente(@RequestBody ClienteDto clienteDto) {
        return new ResponseEntity(clienteService.createCliente(clienteDto), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<ClienteDto>> getClientes() {
        return ResponseEntity.ok(clienteService.getAllClientes());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> updateCliente(@RequestBody ClienteDto clienteDto, @PathVariable(name = "id") Long id) {
        ClienteDto cliente = clienteService.updateCliente(clienteDto, id);
        
        return ResponseEntity.ok(cliente);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable(name = "id") Long id) {
        clienteService.deleteCliente(id);
        
        return ResponseEntity.ok("Cliente deletado com sucesso!");
    }
}

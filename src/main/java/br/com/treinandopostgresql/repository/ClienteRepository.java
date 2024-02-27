/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.treinandopostgresql.repository;

import br.com.treinandopostgresql.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Pedro
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}

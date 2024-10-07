package com.empresa.clientes.repository;

import com.empresa.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.nombre = ?1 AND c.apellidoPaterno = ?2 AND c.apellidoMaterno = ?3")
    Optional<Cliente> findByNombreAndApellidoPaternoAndApellidoMaterno(String nombre, String apellidoPaterno, String apellidoMaterno);
}

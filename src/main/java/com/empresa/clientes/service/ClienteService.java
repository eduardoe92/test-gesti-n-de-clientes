package com.empresa.clientes.service;

import com.empresa.clientes.model.Cliente;
import com.empresa.clientes.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente) {
        Optional<Cliente> existente = clienteRepository.findByNombreAndApellidoPaternoAndApellidoMaterno(
                cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno());

        if (existente.isPresent()) {
            logger.error("El cliente ya existe: ", cliente);
            throw new IllegalArgumentException("Ya existe un cliente con el mismo nombre y apellidos.");
        }

        logger.info("Creando cliente: ", cliente.getNombre());
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void eliminarTodosLosClientes() {
        clienteRepository.deleteAll();
    }

    public Cliente obtenerClientePorNombreCompleto(String nombre, String apellidoPaterno, String apellidoMaterno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

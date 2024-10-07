package com.empresa.clientes.controller;

import com.empresa.clientes.model.Cliente;
import com.empresa.clientes.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Crear un nuevo cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @Operation(summary = "Obtener cliente por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    
    @GetMapping("/{id}")
    public Optional<Cliente> obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }
}

package com.empresa.clientes;

import com.empresa.clientes.model.Cliente;
import com.empresa.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClienteService clienteService;

    @Override
    public void run(String... args) {
        Cliente cliente = new Cliente();
        cliente.setNombre("Mario");
        cliente.setApellidoPaterno("Alvarez");
        cliente.setApellidoMaterno("Suarez");
        cliente.setFechaNacimiento(LocalDate.of(1991, 9, 18));
        cliente.setSexo("M");
        cliente.setCorreo("mario.alvarez@example.com");
        cliente.setTelefono("636-595-741");

        clienteService.crearCliente(cliente);
        System.out.println("Cliente creado: " + cliente.getNombre());
    }
}

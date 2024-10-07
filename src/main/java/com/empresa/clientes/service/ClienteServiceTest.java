package com.empresa.clientes.service;

import com.empresa.clientes.model.Cliente;
import com.empresa.clientes.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCrearCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Iván");
        cliente.setApellidoPaterno("Castillo");
        cliente.setApellidoMaterno("Perez");
        cliente.setFechaNacimiento(LocalDate.of(1994, 5, 9));
        cliente.setSexo("M");
        cliente.setCorreo("ivan.castillo@example.com");
        cliente.setTelefono("636-595-741");

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente creado = clienteService.crearCliente(cliente);

        assertNotNull(creado);
        assertEquals(cliente.getNombre(), creado.getNombre());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void testObtenerClientePorId() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Carlos");
        
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> encontrado = clienteService.obtenerClientePorId(1L);

        assertTrue(encontrado.isPresent());
        assertEquals(cliente.getNombre(), encontrado.get().getNombre());
        verify(clienteRepository, times(1)).findById(1L);
    }
}

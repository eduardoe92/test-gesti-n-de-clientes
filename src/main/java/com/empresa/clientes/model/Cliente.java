package com.empresa.clientes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(nullable = false, name = "apellido_materno")
    private String apellidoMaterno;

    @Column(nullable = false, name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false, unique = true)
    private String correo;

    private String telefono;
}

# Microservicio de Gestión de Clientes

Este proyecto es un microservicio para la gestión de clientes que permite almacenar y consultar información básica, como nombre, apellidos, fecha de nacimiento, sexo, correo y teléfono. El microservicio ha sido desarrollado utilizando **Java 17** y **Spring Boot 3.4.4**, creado a partir de [Spring Initializr](https://start.spring.io/) con las siguientes configuraciones:

- **Project:** Maven
- **Group:** com.empresa
- **Artifact:** clientes
- **Name:** test
- **Description:** Demo project for Spring Boot
- **Package name:** com.empresa.clientes;
- **Packaging:** Jar

## Dependencias

El proyecto incluye las siguientes dependencias esenciales:

- **Spring Web:** Permite construir aplicaciones web, incluyendo aplicaciones RESTful, utilizando Spring MVC y utiliza Apache Tomcat como contenedor embebido por defecto.
- **Spring Data JPA:** Permite persistir datos en almacenes SQL utilizando la API de Persistencia de Java (JPA) con Spring Data y Hibernate.
- **MySQL Driver:** Controlador JDBC para MySQL.
- **Spring Boot DevTools:** Proporciona reinicios rápidos de la aplicación, LiveReload y configuraciones para una experiencia de desarrollo mejorada.
- **Lombok:** Biblioteca de anotaciones de Java que ayuda a reducir el código repetitivo (boilerplate).
- **Spring Boot Actuator:** Soporta puntos finales integrados (o personalizados) que permiten monitorear y gestionar tu aplicación, como la salud de la aplicación, métricas, sesiones, etc.

## Funcionalidades

- Crear un nuevo cliente.
- Consultar información de un cliente por su identificador único.
- Asegurar que no existan dos clientes con el mismo nombre completo.
- Loggeo de acciones realizadas en el microservicio.

## Requisitos

- JDK 17
- Maven 3.8.x
- MySQL o cualquier otra base de datos compatible con JPA

## Instalación

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/tu_usuario/nombre_del_repositorio.git
   cd nombre_del_repositorio
   
2. **Configurar la base de datos:**

   ```bash
   CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido_paterno VARCHAR(255) NOT NULL,
    apellido_materno VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    sexo CHAR(1) NOT NULL,
    correo VARCHAR(255) NOT NULL UNIQUE,
    telefono VARCHAR(15)
   );

4. **Compilar el proyecto:**
      
   ```bash
   mvn clean install

5. **Ejecutar la aplicación:**
   
   Edita el archivo src/main/resources/application.properties y configura las propiedades de conexión a la base de datos:
   
   ```bash
   mvn spring-boot:run


## Contrato de Interfaz

El microservicio implementa un contrato de interfaz YAML siguiendo el estándar OpenAPI 2.0 para documentar las API expuestas.

## Pruebas

El proyecto incluye pruebas unitarias para verificar el correcto funcionamiento de los métodos del servicio ClienteService.

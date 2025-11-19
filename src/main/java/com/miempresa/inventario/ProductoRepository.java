package com.miempresa.inventario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // ¡Aquí está la magia!
    // Al extender de JpaRepository, ya tienes automáticamente métodos como:
    // .save(), .findAll(), .findById(), .deleteById()
    // No hace falta escribir nada más.
}
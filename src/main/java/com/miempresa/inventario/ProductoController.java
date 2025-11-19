package com.miempresa.inventario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService servicio; // Ahora usamos el Servicio, no el Repositorio

    @GetMapping
    public List<Producto> listar() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    // Añadimos @Valid antes de @RequestBody
    public Producto guardar(@Valid @RequestBody Producto producto) {
        return servicio.guardar(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
package com.miempresa.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Esto le dice a Spring que aquí va la Lógica de Negocio
public class ProductoService {

    @Autowired
    private ProductoRepository repositorio;

    public List<Producto> obtenerTodos() {
        // Aquí podrías poner lógica extra, ej: ordenar por nombre
        return repositorio.findAll();
    }

    public Producto guardar(Producto producto) {
        // Aquí podrías validar cosas antes de guardar
        // Ej: if(producto.getPrecio() < 0) lanzar error...
        return repositorio.save(producto);
    }

    public void eliminar(Long id) {
        // Validar si existe antes de borrar
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
        } else {
            throw new RuntimeException("El producto no existe");
        }
    }
}
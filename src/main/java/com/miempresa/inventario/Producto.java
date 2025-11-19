package com.miempresa.inventario;

import jakarta.persistence.*;
import jakarta.validation.constraints.*; // Importante para las validaciones

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío") // No permite null ni "" ni " "
    private String nombre;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0") // Solo permite números positivos
    private Double precio;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo") // Mínimo 0
    private Integer stock;

    // Constructores, Getters y Setters siguen igual...
    // (No hace falta que borres los métodos de abajo, solo cambia las variables arriba)

    public Producto() {}

    public Producto(String nombre, Double precio, Integer stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // ... (mantén tus getters y setters aquí) ...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
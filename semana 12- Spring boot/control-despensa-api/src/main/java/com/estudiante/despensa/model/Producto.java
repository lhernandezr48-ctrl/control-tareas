package com.estudiante.despensa.model;

public class Producto {

    private Long id;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precioUnitario;

    public Producto(Long id, String nombre, String categoria,
                    int cantidad, double precioUnitario) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor que cero");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        if (precioUnitario <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }

        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }
}

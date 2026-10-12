package com.estudiante.despensa.controller;

import com.estudiante.despensa.model.Producto;
import com.estudiante.despensa.model.ResumenInventario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    // Datos almacenados en memoria
    private final List<Producto> productos = new ArrayList<>();

    public ProductoController() {
        agregarProducto(new Producto(1L, "Leche entera",    "Lácteos",  6,  9.50));
        agregarProducto(new Producto(2L, "Queso fresco",    "Lácteos",  2, 22.00));
        agregarProducto(new Producto(3L, "Arroz",           "Granos",   4,  8.50));
        agregarProducto(new Producto(4L, "Frijol negro",    "Granos",  10, 12.00));
        agregarProducto(new Producto(5L, "Detergente",      "Limpieza", 3, 25.00));
        agregarProducto(new Producto(6L, "Jugo de naranja", "Bebidas",  8, 11.50));
    }

    // Registra un producto validando que el id no esté repetido
    private void agregarProducto(Producto nuevo) {
        for (Producto p : productos) {
            if (p.getId().equals(nuevo.getId())) {
                throw new IllegalArgumentException(
                        "Identificador duplicado: " + nuevo.getId());
            }
        }
        productos.add(nuevo);
    }

    // 1. GET /api/productos
    @GetMapping
    public List<Producto> listarProductos() {
        return productos;
    }

    // 2. GET /api/productos/{id}  -> 200 o 404
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // 3. GET /api/productos/categoria/{categoria}
    @GetMapping("/categoria/{categoria}")
    public List<Producto> buscarPorCategoria(@PathVariable String categoria) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // 4. GET /api/productos/stock-bajo  (cantidad <= 3)
    @GetMapping("/stock-bajo")
    public List<Producto> stockBajo() {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCantidad() <= 3) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // 5. GET /api/productos/mayor-valor  (mayor cantidad x precio)
    @GetMapping("/mayor-valor")
    public ResponseEntity<Producto> mayorValor() {
        Producto mayor = null;
        for (Producto p : productos) {
            if (mayor == null || p.calcularSubtotal() > mayor.calcularSubtotal()) {
                mayor = p;
            }
        }
        if (mayor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mayor);
    }

    // 6. GET /api/productos/resumen
    @GetMapping("/resumen")
    public ResumenInventario resumen() {
        int totalUnidades = 0;
        double valorTotal = 0;
        for (Producto p : productos) {
            totalUnidades += p.getCantidad();
            valorTotal += p.calcularSubtotal();
        }
        return new ResumenInventario(productos.size(), totalUnidades, valorTotal);
    }
}
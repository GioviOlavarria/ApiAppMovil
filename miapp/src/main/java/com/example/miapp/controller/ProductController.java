package com.example.miapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.miapp.model.Product;
import com.example.miapp.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Permite peticiones desde frontend
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Obtener todos los productos
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Obtener Producto por ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Crear un nuevo producto
    @PostMapping
    public Product createProduct(@RequestBody Product producto) {
        return productRepository.save(producto);
    }

    // Actualizar producto existente
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product producto = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        producto.setName(productDetails.getName());
        producto.setDescription(productDetails.getDescription());
        return productRepository.save(producto);
    }

    // Eliminar Producto
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}

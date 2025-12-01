package com.example.miapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.miapp.model.Product;
import com.example.miapp.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }


    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        product.setId(null);
        return productRepository.save(product);
    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product producto = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        producto.setName(productDetails.getName());
        producto.setPrice(productDetails.getPrice());
        producto.setDescription(productDetails.getDescription());
        producto.setCategory(productDetails.getCategory());

        return productRepository.save(producto);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}

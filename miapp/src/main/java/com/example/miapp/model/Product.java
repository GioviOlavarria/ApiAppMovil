package com.example.miapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // Esta clase se convierte en tabla
@Data // Lombok genera getters/setters/toString/etc.
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los campos
public class Product {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incrementa el id
    private Long id;

    private String name; 
    private Double price;
    private String description;
    private String category;

}


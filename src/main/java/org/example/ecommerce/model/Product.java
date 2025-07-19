package org.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a product in the store.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /** Product ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Product name */
    private String name;

    /** Product description */
    private String description;

    /** Product price */
    private BigDecimal price;

    /** Available quantity in stock */
    private Integer quantity;

    /** Product image path or URL */
    private String image;

    /** List of user comments on this product */
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}

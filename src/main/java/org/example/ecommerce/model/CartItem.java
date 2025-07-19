package org.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a product item in a cart.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    /** Unique ID of the cart item */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The cart this item belongs to */
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    /** The product added to the cart */
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    /** Quantity of the product in the cart */
    private Integer quantity;
}

package org.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Represents a single item in an order.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    /** ID of the order item */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The order to which this item belongs */
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    /** The product being purchased */
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    /** Quantity of the product ordered */
    private Integer quantity;

    /** Price per item at the time of purchase */
    private BigDecimal price;
}

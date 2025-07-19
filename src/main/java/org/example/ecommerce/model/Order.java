package org.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer's order.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    /** Primary key of the order */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The user who placed the order */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /** Shipping address */
    private String address;

    /** Phone number of the customer */
    private String phoneNumber;

    /** Current status of the order */
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    /** Enum for order status */
    public enum OrderStatus {
        PREPARING, DELIVERING, DELIVERED, CANCELED
    }

    /** Date and time when the order was created */
    private LocalDateTime createdAt;

    /** Items included in the order */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();
}

package org.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart for a user.
 * Each user has one cart containing multiple cart items.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    /** Primary key of the cart */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The user who owns this cart.
     * Each user has one cart (OneToOne relationship).
     */
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * The items contained in this cart.
     * One cart can have multiple cart items.
     * - cascade = CascadeType.ALL: propagate all operations (persist, remove, etc.)
     * - orphanRemoval = true: remove items from DB if removed from the list.
     */
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();
}

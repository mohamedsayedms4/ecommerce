package org.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a user's comment on a product.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    /** ID of the comment */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The comment text */
    private String content;

    /** Score or rating given by the user */
    private Integer score;

    /** The product being commented on */
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    /** The user who wrote the comment */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

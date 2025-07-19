package org.example.ecommerce.dto;

import lombok.Data;

@Data
public class CartDTO {
    private Long id;
    private Long userId; //usedId
    private List<CartItemDTO> items;
}
package org.example.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.example.ecommerce.model.Order;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Long id;
    private Long userId;
    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "Phone name is required")
    private String phoneNumber;
    private Order.OrderStatus status;
    private LocalDateTime createdAt;
    private List<OrderItemDTO> orderItems;
}

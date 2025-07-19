package org.example.ecommerce.mapper;

import org.example.ecommerce.dto.CartDTO;
import org.example.ecommerce.dto.CartItemDTO;
import org.example.ecommerce.model.Cart;
import org.example.ecommerce.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "userId" , source = "user.id")
    CartDTO toDTO(Cart cart);

    @Mapping(target="user.id", source = "userId")
    Cart toEntity(CartDTO cartDTO);

    @Mapping(target="productId", source="product.id")
    CartItemDTO toDTO(CartItem cartItem);

    @Mapping(target="product.id", source="productId")
    CartItem toEntity(CartItemDTO cartItemDTO);

}

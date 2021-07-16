package com.boot.services.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.boot.services.dto.CartDTO;
import com.boot.services.model.Cart;





public class CartMapper {

	public static CartDTO cartEntityToDto(Cart cart) {
		return new CartDTO().setId(cart.getId()).setUser(UserMapper.UserEntityToDto(cart.getUser()))
				.setProductList(ProductMapper.productEntityToDtoList(cart.getProductList())).setTotal(cart.getTotal())
				.setCompletedOn(cart.getLastUpdatedOn());
	}

	public static Cart dtoToCartEntity(CartDTO cartDto) {
		return new Cart().setId(cartDto.getId()).setUser(UserMapper.DtoToUserEntity(cartDto.getUser()))
				.setProductList(ProductMapper.dtoToProductEntityList(cartDto.getProductList()))
				.setTotal(cartDto.getTotal()).setLastUpdatedOn(cartDto.getCompletedOn());
	}

	public static Cart updateDtoToCartEntity(Cart cart, CartDTO cartDto) {
		return cart.setId(cartDto.getId()).setUser(UserMapper.DtoToUserEntity(cartDto.getUser()))
				.setProductList(ProductMapper.dtoToProductEntityList(cartDto.getProductList()))
				.setTotal(cartDto.getTotal()).setLastUpdatedOn(cartDto.getCompletedOn());
	}

	public static Set<CartDTO> cartEntityToDtoList(List<Cart> cartList) {

		Set<CartDTO> cartDTOList = new HashSet<>();

		cartList.stream().forEach(c -> cartDTOList.add(CartMapper.cartEntityToDto(c)));

		return cartDTOList;
	}

	public static Set<Cart> dtoToCartEntityList(List<CartDTO> cartDTOList) {

		Set<Cart> cartList = new HashSet<>();

		cartDTOList.stream().forEach(cDTO -> cartList.add(CartMapper.dtoToCartEntity(cDTO)));

		return cartList;
	}

}
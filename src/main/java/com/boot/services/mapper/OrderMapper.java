package com.boot.services.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.boot.services.dto.OrderDTO;
import com.boot.services.model.Order;





public class OrderMapper {

	public static OrderDTO cartEntityToDto(Order order) {
		return new OrderDTO()
				.setId(order.getId())
				.setUser(UserMapper.UserEntityToDto(order.getUser()))
				.setStatus(order.getStatus())
				.setProductList(ProductMapper.productEntityToDtoList(order.getProductList()))
				.setTotal(order.getTotal())
				.setCompletedOn(order.getLastUpdatedOn());
	}

	public static Order dtoToCartEntity(OrderDTO orderDto) {
		return new Order()
				.setId(orderDto.getId())
				.setUser(UserMapper.DtoToUserEntity(orderDto.getUser()))
				.setStatus(orderDto.getStatus())
				.setProductList(ProductMapper.dtoToProductEntityList(orderDto.getProductList()))
				.setTotal(orderDto.getTotal())
				.setLastUpdatedOn(orderDto.getCompletedOn());
	}

	public static Order updateDtoToProductEntity(Order order, OrderDTO orderDto) {
		return order
				.setId(orderDto.getId())
				.setUser(UserMapper.DtoToUserEntity(orderDto.getUser()))
				.setStatus(orderDto.getStatus())
				.setProductList(ProductMapper.dtoToProductEntityList(orderDto.getProductList()))
				.setTotal(orderDto.getTotal())
				.setLastUpdatedOn(orderDto.getCompletedOn());
	}

	public static Set<OrderDTO> cartEntityToDtoList(List<Order> orderList) {

		Set<OrderDTO> orderDTOList = new HashSet<>();

		orderList.stream().forEach(o -> orderDTOList.add(OrderMapper.cartEntityToDto(o)));

		return orderDTOList;
	}

	public static Set<Order> dtoToCartEntityList(List<OrderDTO> orderDTOList) {

		Set<Order> orderList = new HashSet<>();

		orderDTOList.stream().forEach(oDTO -> orderList.add(OrderMapper.dtoToCartEntity(oDTO)));

		return orderList;
	}

}

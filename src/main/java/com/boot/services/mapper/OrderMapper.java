package com.boot.services.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.boot.services.dto.OrderDTO;
import com.boot.services.model.Order;





public class OrderMapper {

	public static OrderDTO orderEntityToDto(Order order) {
		return new OrderDTO()
				.setId(order.getId())
				.setUuid(order.getUuid())
				.setUser(UserMapper.UserEntityToDto(order.getUser()))
				.setStatus(order.getStatus())
				.setProductsInCartList(ProductMapper.productEntityToDtoMap(order.getProductList()))
				.setTotal(order.getTotal())
				.setCompletedOn(order.getLastUpdatedOn());
	}

	public static Order dtoToOrderEntity(OrderDTO orderDto) {
		return new Order()
				.setId(orderDto.getId())
				.setUuid(orderDto.getUuid())
				.setUser(UserMapper.DtoToUserEntity(orderDto.getUser()))
				.setStatus(orderDto.getStatus())
				.setProductList(ProductMapper.dtoToProductEntityMap(orderDto.getProductsInCartList()))
				.setTotal(orderDto.getTotal())
				.setLastUpdatedOn(orderDto.getCompletedOn());
	}

	public static Order updateDtoToOrderEntity(Order order, OrderDTO orderDto) {
		return order
				.setId(orderDto.getId())	
				.setUuid(orderDto.getUuid())
				.setUser(UserMapper.DtoToUserEntity(orderDto.getUser()))
				.setStatus(orderDto.getStatus())
				.setProductList(ProductMapper.dtoToProductEntityMap(orderDto.getProductsInCartList()))
				.setTotal(orderDto.getTotal())
				.setLastUpdatedOn(orderDto.getCompletedOn());
	}

	public static Set<OrderDTO> orderEntityToDtoList(List<Order> orderList) {

		Set<OrderDTO> orderDTOList = new HashSet<>();

		orderList.stream().forEach(o -> orderDTOList.add(OrderMapper.orderEntityToDto(o)));

		return orderDTOList;
	}

	public static Set<Order> dtoToOrderEntityList(List<OrderDTO> orderDTOList) {

		Set<Order> orderList = new HashSet<>();

		orderDTOList.stream().forEach(oDTO -> orderList.add(OrderMapper.dtoToOrderEntity(oDTO)));

		return orderList;
	}

}

package com.boot.services.mapper;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.boot.services.dto.OrderDTO;
import com.boot.services.model.Order;





public class OrderMapper {

	public static OrderDTO orderEntityToDto(Order order) {
		return new OrderDTO()
				.setUuid(order.getUuid())
				.setFirstName((order.getFirstName()))
				.setLastName((order.getLastName()))
				.setAddressLine1((order.getAddressLine1()))
				.setAddressLine2((order.getAddressLine2()))
				.setCity((order.getCity()))
				.setState((order.getState()))
				.setZipPostalCode((order.getZipPostalCode()))
				.setCountry((order.getCountry()))
				.setNameOnCard((order.getNameOnCard()))
				.setCardNumber((order.getCardNumber()))
				.setExpiryDate((order.getExpiryDate()))
				.setCvv((order.getCvv()));
	}

	public static Order dtoToOrderEntity(OrderDTO orderDto) {
		return new Order()
				.setUuid(orderDto.getUuid())
				.setFirstName((orderDto.getFirstName()))
				.setLastName((orderDto.getLastName()))
				.setAddressLine1((orderDto.getAddressLine1()))
				.setAddressLine2((orderDto.getAddressLine2()))
				.setCity((orderDto.getCity()))
				.setState((orderDto.getState()))
				.setZipPostalCode((orderDto.getZipPostalCode()))
				.setCountry((orderDto.getCountry()))
				.setNameOnCard((orderDto.getNameOnCard()))
				.setCardNumber((orderDto.getCardNumber()))
				.setExpiryDate((orderDto.getExpiryDate()))
				.setCvv((orderDto.getCvv()));

	}

	public static Order updateDtoToOrderEntity(Order order, OrderDTO orderDto) {
		return order
				.setUuid(order.getUuid())
				.setFirstName((order.getFirstName()))
				.setLastName((order.getLastName()))
				.setAddressLine1((order.getAddressLine1()))
				.setAddressLine2((order.getAddressLine2()))
				.setCity((order.getCity()))
				.setState((order.getState()))
				.setZipPostalCode((order.getZipPostalCode()))
				.setCountry((order.getCountry()))
				.setNameOnCard((order.getNameOnCard()))
				.setCardNumber((order.getCardNumber()))
				.setExpiryDate((order.getExpiryDate()))
				.setCvv((order.getCvv()));
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

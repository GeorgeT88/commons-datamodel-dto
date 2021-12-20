package com.boot.services.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.boot.services.model.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

	private long id;
	
	private UUID uuid;

	private UserDTO user;
	
	private OrderStatus status;

	private List<ProductInCartDTO> productsInCartList;

	private double total;

	private LocalDateTime completedOn;


}

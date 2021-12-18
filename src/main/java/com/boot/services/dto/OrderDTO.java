package com.boot.services.dto;

import java.time.LocalDateTime;
import java.util.Map;
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

	private Map<ProductDTO, Integer> productMap;

	private double total;

	private LocalDateTime completedOn;


}

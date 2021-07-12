package com.boot.services.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.boot.services.model.OrderStatus;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

	private long id;

	private UserDTO user;
	
	private OrderStatus status;

	private List<ProductDTO> productList;

	private double total;

	private LocalDateTime completedOn;


}

package com.boot.services.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

	private long id;

	private UserDTO user;

	private List<ProductInCartDTO> productsInCartList;
	
	private double total;
}

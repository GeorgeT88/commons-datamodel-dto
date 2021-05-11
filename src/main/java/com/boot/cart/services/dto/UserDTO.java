package com.boot.cart.services.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private long id;
	
	private String firstName;

	private String lastName;

	private String userName;

	private LocalDate birthDate;

	private String password;

	private String phoneNumber;

	private String email;

	private String deliveryAddress;

	// userOrder : boolean--- user can order if he is over 18 years
	private boolean userOrder;
	
	private Set<ProductDTO> favoriteProductList;
}
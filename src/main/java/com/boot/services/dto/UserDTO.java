package com.boot.services.dto;

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

	private LocalDate birthDate;

	private String password;

	private String phoneNumber;

	private String email;

	private String deliveryAddress;
	
	private String role;
			
	private Set<ProductDTO> favoriteProductList;
	
	private boolean isActivated;
}
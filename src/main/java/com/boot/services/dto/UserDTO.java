package com.boot.services.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private long id;

	@Size(min = 3, message = "Min First name size is 3 characters!")
	@Size(max = 30, message = "Max First name size is 30 characters!")
	@NotBlank
	@NotNull
	private String firstName;

	@Size(min = 3, message = "Min Last name size is 3 characters!")
	@Size(max = 30, message = "Max Last name size is 30 characters!")
	@NotBlank
	@NotNull
	private String lastName;

	@Size(min = 8, message = "Min Password size is 8 characters!")
	@Size(max = 30, message = "Max Password size is 30 characters!")
	@NotBlank
	@NotNull
	private String password;

	@Pattern(regexp="^(?=(?:[07]){2})(?=[0-9]{10}).*", message = "Invalid Phone Number!")
	private String phoneNumber;

	@Email(regexp="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$", message = "Invalid Email!")
	@NotNull
	private String email;


	@Size(min = 3, message = "Min Delivery address size is 8 characters!")
	@Size(max = 300, message = "Max Delivery address size is 300 characters!")
	@NotBlank
	@NotNull
	private String deliveryAddress;

	@NotEmpty
	@NotNull
	private String role;
			
	private Set<ProductDTO> favoriteProductList;
	
	private boolean isActivated;
}
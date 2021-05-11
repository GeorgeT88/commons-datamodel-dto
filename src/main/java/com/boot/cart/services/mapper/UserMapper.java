package com.boot.cart.services.mapper;

import java.time.LocalDate;
import java.time.Period;

import com.boot.cart.services.dto.UserDTO;
import com.boot.services.model.User;


public class UserMapper {

	public static UserDTO UserEntityToDto(User user) {
		return new UserDTO()	
				.setId(user.getId())
				.setFirstName(user.getFirstName())
				.setLastName(user.getLastName())
				.setUserName(user.getUserName())
				.setBirthDate(user.getBirthDate())
				.setPassword(user.getPassword())
				.setPhoneNumber(user.getPhoneNumber())
				.setEmail(user.getEmail())
				.setDeliveryAddress(user.getDeliveryAddress())
				.setUserOrder(checkUserAge(user.getBirthDate()))
				.setFavoriteProductList(ProductMapper.productEntityToDtoList(user.getFavoriteProductList()));
	}

	private static boolean checkUserAge(LocalDate birthday) {
		LocalDate currentDate = LocalDate.now();
		Period p = Period.between(birthday,currentDate );
		System.out.println("User has 18 years: " + (p.getYears() >= 18 ? true : false));
		return p.getYears() >= 18 ? true : false;
	}

	
	public static User DtoToUserEntity(UserDTO userDto) {
		return new User()
				.setId(userDto.getId())
				.setFirstName(userDto.getFirstName())
				.setLastName(userDto.getLastName())
				.setUserName(userDto.getUserName())
				.setBirthDate(userDto.getBirthDate())
				.setPassword(userDto.getPassword())
				.setPhoneNumber(userDto.getPhoneNumber())
				.setDeliveryAddress(userDto.getDeliveryAddress())
				.setEmail(userDto.getEmail())
				.setFavoriteProductList(ProductMapper.dtoToProductEntityList(userDto.getFavoriteProductList()));
	}
	
	
	public static User updateDtoToUserEntity(User user, UserDTO userDto) {
		return user
				.setId(userDto.getId())
				.setFirstName(userDto.getFirstName())
				.setLastName(userDto.getLastName())
				.setUserName(userDto.getUserName())
				.setBirthDate(userDto.getBirthDate())
				.setPassword(userDto.getPassword())
				.setPhoneNumber(userDto.getPhoneNumber())
				.setDeliveryAddress(userDto.getDeliveryAddress())
				.setEmail(userDto.getEmail())
				.setFavoriteProductList(ProductMapper.dtoToProductEntityList(userDto.getFavoriteProductList()));
	}
	
	public static UserDTO updateUserEntityToDto(User user, UserDTO userDto) {
		return userDto
				.setId(user.getId())
				.setFirstName(user.getFirstName())
				.setLastName(user.getLastName())
				.setUserName(user.getUserName())
				.setBirthDate(user.getBirthDate())
				.setPassword(user.getPassword())
				.setPhoneNumber(user.getPhoneNumber())
				.setDeliveryAddress(user.getDeliveryAddress())
				.setEmail(user.getEmail())
				.setFavoriteProductList(ProductMapper.productEntityToDtoList(user.getFavoriteProductList()));
               
	}


}

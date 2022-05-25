package com.boot.services.mapper;

import com.boot.services.dto.UserDTO;
import com.boot.services.model.User;

public class UserMapper {

    public static UserDTO userEntityToDto(User user) {
        return new UserDTO()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .setPhoneNumber(user.getPhoneNumber())
                .setEmail(user.getEmail())
                .setDeliveryAddress(user.getDeliveryAddress())
                .setRole(user.getRole())
                .setActivated(user.isActivated());

    }


    public static User dtoToUserEntity(UserDTO userDto) {
        return new User()
                .setId(userDto.getId())
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setPassword(userDto.getPassword())
                .setPhoneNumber(userDto.getPhoneNumber())
                .setDeliveryAddress(userDto.getDeliveryAddress())
                .setEmail(userDto.getEmail())
                .setRole(userDto.getRole())
                .setActivated(userDto.isActivated());
    }


    public static User updateDtoToUserEntity(User user, UserDTO userDto) {
        return user
                .setId(userDto.getId())
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setPassword(userDto.getPassword())
                .setPhoneNumber(userDto.getPhoneNumber())
                .setDeliveryAddress(userDto.getDeliveryAddress())
                .setEmail(userDto.getEmail())
                .setRole(userDto.getRole())
                .setActivated(userDto.isActivated());
    }

    public static UserDTO updateUserEntityToDto(User user, UserDTO userDto) {
        return userDto
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .setPhoneNumber(user.getPhoneNumber())
                .setDeliveryAddress(user.getDeliveryAddress())
                .setEmail(user.getEmail())
                .setRole(userDto.getRole())

                .setActivated(userDto.isActivated());
    }

}

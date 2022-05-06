package com.boot.services.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.boot.services.model.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

	private UUID uuid;

	private String firstName;

	private String lastName;

	private String addressLine1;

	private String addressLine2;

	private String city;

	private String state;

	private String zipPostalCode;

	private String country;

	private String nameOnCard;

	private long cardNumber;

	private LocalDateTime expiryDate;

	private int cvv;
}

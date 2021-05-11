package com.boot.cart.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private long id;

	private String productName;

	private String productDescription;

	private long productPrice;

	private String productPhotoLink;

	private String productCategory;

	private int productStock;
}
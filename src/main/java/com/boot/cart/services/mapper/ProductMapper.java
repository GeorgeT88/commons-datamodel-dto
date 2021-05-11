package com.boot.cart.services.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.boot.cart.services.dto.ProductDTO;
import com.boot.services.model.Product;


public class ProductMapper {

	public static ProductDTO ProductEntityToDto(Product product) {
		return new ProductDTO()
				.setId(product.getId())
				.setProductName(product.getProductName())
				.setProductDescription(product.getProductDescription())
				.setProductPrice(product.getProductPrice())
				.setProductPhotoLink(product.getProductPhotoLink())
				.setProductCategory(product.getProductCategory())
				.setProductStock(product.getProductStock());
	}

	public static Product DtoToProductEntity(ProductDTO productDto) {
		return new Product()
				.setId(productDto.getId())
				.setProductName(productDto.getProductName())
				.setProductDescription(productDto.getProductDescription())
				.setProductPrice(productDto.getProductPrice())
				.setProductPhotoLink(productDto.getProductPhotoLink())
				.setProductCategory(productDto.getProductCategory())
				.setProductStock(productDto.getProductStock());		
	}
	
	public static Product updateDtoToProductEntity(Product product,ProductDTO productDto) {
		return  product
				.setId(productDto.getId())
				.setProductName(productDto.getProductName())
				.setProductDescription(productDto.getProductDescription())
				.setProductPrice(productDto.getProductPrice())
				.setProductPhotoLink(productDto.getProductPhotoLink())
				.setProductCategory(productDto.getProductCategory())
				.setProductStock(productDto.getProductStock());		
	}
	public static List<ProductDTO> productEntityToDtoList(List<Product> productList){
		
		List<ProductDTO> productDTOList = new ArrayList<>();

		productList.stream().forEach(p -> productDTOList.add(ProductMapper.ProductEntityToDto(p)));	
				
		return productDTOList;
	}
	
	public static List<Product> dtoToProductEntityList(List<ProductDTO> productDTOList){
		
		List<Product> productList = new ArrayList<>();
			
		productDTOList.stream().forEach(pDTO -> productList.add(ProductMapper.DtoToProductEntity(pDTO)));	
		
		return 	productList;
	}
	
	public static Set<ProductDTO> productEntityToDtoList(Set<Product> productList){
		
		Set<ProductDTO> productDTOList = new HashSet<>();

		productList.stream().forEach(p -> productDTOList.add(ProductMapper.ProductEntityToDto(p)));	
				
		return productDTOList;
	}
	
	public static Set<Product> dtoToProductEntityList(Set<ProductDTO> productDTOList){
		
		Set<Product> productList = new HashSet<>();
			
		productDTOList.stream().forEach(pDTO -> productList.add(ProductMapper.DtoToProductEntity(pDTO)));	
		
		return 	productList;
	}
}

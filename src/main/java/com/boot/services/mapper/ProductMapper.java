package com.boot.services.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.boot.services.dto.ProductDTO;
import com.boot.services.dto.ProductInCartDTO;
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
		return new Product().setId(productDto.getId())
				.setProductName(productDto.getProductName())
				.setProductDescription(productDto.getProductDescription())
				.setProductPrice(productDto.getProductPrice())
				.setProductPhotoLink(productDto.getProductPhotoLink())
				.setProductCategory(productDto.getProductCategory())
				.setProductStock(productDto.getProductStock());
	}

	public static Product updateDtoToProductEntity(Product product, ProductDTO productDto) {
		return product.setId(productDto.getId())
				.setProductName(productDto.getProductName())
				.setProductDescription(productDto.getProductDescription())
				.setProductPrice(productDto.getProductPrice())
				.setProductPhotoLink(productDto.getProductPhotoLink())
				.setProductCategory(productDto.getProductCategory())
				.setProductStock(productDto.getProductStock());
	}

	public static List<ProductInCartDTO> productEntityToDtoMap(List<Product> productList) {

		Map<ProductDTO, Integer> productDTOMap = new HashMap<>();
		
		for (Product p : productList) {
			ProductDTO prod= ProductMapper.ProductEntityToDto(p);
			if(productDTOMap.containsKey(prod)) {
				Integer value = productDTOMap.get(prod)+1;
				productDTOMap.put(ProductMapper.ProductEntityToDto(p), value);
			}else {
				productDTOMap.put(ProductMapper.ProductEntityToDto(p), 1);
			}
		}
		
	
		List<ProductInCartDTO> productsInCartList = new ArrayList<>();
		
		productDTOMap.forEach((k, v) -> {
			
			productsInCartList.add(new ProductInCartDTO()
					.setProductDto(new ProductDTO()
					.setId(k.getId())
					.setProductName(k.getProductName())
					.setProductDescription(k.getProductDescription())
					.setProductPrice(k.getProductPrice())
					.setProductPhotoLink(k.getProductPhotoLink())
					.setProductCategory(k.getProductCategory())					
					.setProductStock(k.getProductStock()))
					.setQuantity(v)
					.setProductTotalPrice(k.getProductPrice()*v));			        
		});
			
			
		Collections.sort(productsInCartList, new Comparator<ProductInCartDTO>() {
		    @Override
		    public int compare(ProductInCartDTO o1, ProductInCartDTO o2) {
		        return o1.getProductDto().getProductName().compareTo(o2.getProductDto().getProductName());
		    }
		});
		
		return productsInCartList;
	}

	


	
	public static List<Product> dtoToProductEntityMap(List<ProductInCartDTO> productInCartDTOList) {

		List<Product> productList = new ArrayList<>();

		productInCartDTOList.stream().forEach(pDTO -> productList.add(ProductMapper.DtoToProductEntity(pDTO.getProductDto())));

		return productList;
	}

	public static Set<ProductDTO> productEntityToDtoList(Set<Product> productList) {

		Set<ProductDTO> productDTOList = new HashSet<>();

		productList.stream().forEach(p -> productDTOList.add(ProductMapper.ProductEntityToDto(p)));

		return productDTOList;
	}

	public static Set<Product> dtoToProductEntityList(Set<ProductDTO> productDTOList) {

		Set<Product> productList = new HashSet<>();
		if (productDTOList != null) {
			productDTOList.stream().forEach(pDTO -> productList.add(ProductMapper.DtoToProductEntity(pDTO)));
		}
		return productList;
	}

}

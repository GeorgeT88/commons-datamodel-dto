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

    public static ProductDTO productEntityToDto(Product product) {
        return new ProductDTO()
                .setId(product.getId())
                .setProductName(product.getProductName())
                .setProductDescription(product.getProductDescription())
                .setProductPrice(product.getProductPrice())
                .setProductPhotoLink(product.getProductPhotoLink())
                .setProductCategory(product.getProductCategory())
                .setProductStock(product.getProductStock())
                .setStatus(product.getStatus());
    }

    public static Product dtoToProductEntity(ProductDTO productDto) {
        return new Product().setId(productDto.getId())
                .setProductName(productDto.getProductName())
                .setProductDescription(productDto.getProductDescription())
                .setProductPrice(productDto.getProductPrice())
                .setProductPhotoLink(productDto.getProductPhotoLink())
                .setProductCategory(productDto.getProductCategory())
                .setProductStock(productDto.getProductStock())
                .setStatus(productDto.getStatus());
    }

    public static Product updateDtoToProductEntity(Product product, ProductDTO productDto) {
        return product.setId(productDto.getId())
                .setProductName(productDto.getProductName())
                .setProductDescription(productDto.getProductDescription())
                .setProductPrice(productDto.getProductPrice())
                .setProductPhotoLink(productDto.getProductPhotoLink())
                .setProductCategory(productDto.getProductCategory())
                .setProductStock(productDto.getProductStock())
                .setStatus(productDto.getStatus());
    }

    public static List<ProductInCartDTO> productEntityToDtoMap(List<Product> productList) {

        Map<ProductDTO, Integer> productDTOMap = new HashMap<>();

        for (Product p : productList) {
            ProductDTO prod = ProductMapper.productEntityToDto(p);
            if (productDTOMap.containsKey(prod)) {
                Integer value = productDTOMap.get(prod) + 1;
                productDTOMap.put(ProductMapper.productEntityToDto(p), value);
            } else {
                productDTOMap.put(ProductMapper.productEntityToDto(p), 1);
            }
        }

        List<ProductInCartDTO> productsInCartList = new ArrayList<>();

        productDTOMap.forEach((k, v) -> {

            productsInCartList.add(new ProductInCartDTO()
                    .setProductDto(new ProductDTO()
                            .setStatus(k.getStatus())
                            .setId(k.getId())
                            .setProductName(k.getProductName())
                            .setProductDescription(k.getProductDescription())
                            .setProductPrice(k.getProductPrice())
                            .setProductPhotoLink(k.getProductPhotoLink())
                            .setProductCategory(k.getProductCategory())
                            .setProductStock(k.getProductStock()))
                    .setQuantity(v)
                    .setProductTotalPrice(k.getProductPrice() * v));
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

        productInCartDTOList.stream().forEach(pDTO -> productList.add(ProductMapper.dtoToProductEntity(pDTO.getProductDto())));

        return productList;
    }


}

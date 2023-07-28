package com.mantis.mapper;

import com.mantis.data.dto.ProductDTO;
import com.mantis.data.dto.ShopDTO;
import com.mantis.data.entity.Product;
import com.mantis.data.entity.Shop;

public class ProductMapper {
    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        return productDTO;
    }

    public Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        return product;
    }
}

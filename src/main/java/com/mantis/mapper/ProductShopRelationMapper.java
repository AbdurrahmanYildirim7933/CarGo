package com.mantis.mapper;

import com.mantis.data.dto.ProductShopRelationDTO;
import com.mantis.data.entity.ProductShopRelation;

public class ProductShopRelationMapper {

    public ProductShopRelationDTO toDTO(ProductShopRelation productShopRelation)
    {
        ProductShopRelationDTO productShopRelationDTO = new ProductShopRelationDTO();
        productShopRelationDTO.setId(productShopRelation.getId());
        productShopRelationDTO.setName(productShopRelation.getName());
        productShopRelationDTO.setDescription(productShopRelation.getDescription());
        productShopRelationDTO.setQuantity(productShopRelation.getQuantity());
        productShopRelationDTO.setPrice(productShopRelation.getPrice());
        ProductMapper productMapper = new ProductMapper();
        ShopMapper shopMapper = new ShopMapper();
        productShopRelationDTO.setProductDTO(productMapper.toDTO(productShopRelation.getProduct()));
        productShopRelationDTO.setShopDTO(shopMapper.toDTO(productShopRelation.getShop()));

        return productShopRelationDTO;
    }

    public ProductShopRelation toEntity(ProductShopRelationDTO productShopRelationDTO)
    {
        ProductShopRelation productShopRelation = new ProductShopRelation();
        productShopRelation.setId(productShopRelationDTO.getId());
        productShopRelation.setName(productShopRelationDTO.getName());
        productShopRelation.setDescription(productShopRelationDTO.getDescription());
        productShopRelation.setQuantity(productShopRelationDTO.getQuantity());
        productShopRelation.setPrice(productShopRelationDTO.getPrice());
        ProductMapper productMapper = new ProductMapper();
        ShopMapper shopMapper = new ShopMapper();
        productShopRelation.setProduct(productMapper.toEntity(productShopRelationDTO.getProductDTO()));
        productShopRelation.setShop(shopMapper.toEntity(productShopRelationDTO.getShopDTO()));

        return productShopRelation;
    }

}

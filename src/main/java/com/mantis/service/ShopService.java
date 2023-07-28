package com.mantis.service;

import com.mantis.data.dto.ProductShopRelationDTO;
import com.mantis.data.dto.ShopDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.logic.ShopLogic;
import com.mantis.logic.UserLogic;
import com.mantis.mapper.ProductShopRelationMapper;
import com.mantis.mapper.ShopMapper;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ShopService {
    @Autowired
    private ShopLogic shopLogic;

    private ShopMapper shopMapper= new ShopMapper();
    private ProductShopRelationMapper productShopRelationMapper = new ProductShopRelationMapper();
    @PreAuthorize("hasAuthority('CREATE_SHOP')")
    public ShopDTO createShop(ShopDTO shopDTO) {
        return  this.shopMapper.toDTO(shopLogic.createShop(shopMapper.toEntity(shopDTO))) ;
    }

    @PreAuthorize("hasAuthority('CREATE_PRODUCT_SHOP_RELATION')")
    public ProductShopRelationDTO createProductShopRelation(ProductShopRelationDTO productShopRelationDTO) {
        return  this.productShopRelationMapper.toDTO(shopLogic.createProductShopRelation(productShopRelationMapper.toEntity(productShopRelationDTO))) ;
    }

}
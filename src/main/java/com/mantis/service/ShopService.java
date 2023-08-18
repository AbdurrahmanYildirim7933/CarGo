package com.mantis.service;

import com.mantis.data.dto.ProductShopRelationDTO;
import com.mantis.data.dto.ShopDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.Shop;
import com.mantis.logic.ShopLogic;
import com.mantis.logic.UserLogic;
import com.mantis.mapper.ProductShopRelationMapper;
import com.mantis.mapper.ShopMapper;
import com.mantis.mapper.UserMapper;
import com.mantis.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @PreAuthorize("hasAuthority('DELETE_SHOP')")
    public void deleteShop(Integer id){
        shopLogic.deleteShop(id);
    }

    @PreAuthorize("hasAuthority('GET_SHOP')")
    public Page<ShopDTO> getShops(Pageable pageable){
        List <ShopDTO> dtoList =
                shopLogic.getShops(pageable).getContent().stream()
                        .map(s->shopMapper.toDTO(s)).collect(Collectors.toList());
        Page<ShopDTO> dtoPages = new PageImpl<>(dtoList);

        return dtoPages;
    }



}
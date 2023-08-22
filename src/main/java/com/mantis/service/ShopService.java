package com.mantis.service;

import com.mantis.data.dto.ProductShopRelationDTO;
import com.mantis.data.dto.ShopDTO;
import com.mantis.data.dto.ShopFilterDTO;
import com.mantis.logic.ShopFilterLogic;
import com.mantis.logic.ShopLogic;
import com.mantis.mapper.ProductShopRelationMapper;
import com.mantis.mapper.ShopFilterMapper;
import com.mantis.mapper.ShopMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ShopService {

    @Autowired
    private ShopLogic shopLogic;
    @Autowired
    ShopFilterLogic shopFilter;

    ShopFilterMapper shopFilterMapper=new ShopFilterMapper();

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
    public Page<ShopDTO> getShops(ShopFilterDTO shopFilterDTO,Pageable pageable){
        List <ShopDTO> dtoList =
                shopLogic.getShops(shopFilterDTO,pageable).getContent().stream()
                        .map(s->shopMapper.toDTO(s)).collect(Collectors.toList());
        Page<ShopDTO> dtoPages = new PageImpl<>(dtoList);
        return dtoPages;
    }

    public List <ShopDTO> findByName(String name){
List<ShopDTO> shopDTOS=shopLogic.findByName(name)
        .stream()
        .map(shopMapper::toDTO)
        .collect(Collectors.toList());
return shopDTOS;
    }

    public List<ShopFilterDTO> searchShopByTerm(ShopFilterDTO shopFilterDTO) {
        List<ShopFilterDTO> filterDTOS = shopLogic.searchShopByTerm(shopFilterMapper.toEntity(shopFilterDTO))
                .stream()
                .map(shopFilterMapper::toDTO)
                .collect(Collectors.toList());
        return filterDTOS;


    }
}
package com.mantis.service;

import com.mantis.data.dto.UserDTO;
import com.mantis.logic.DutyLogic;
import com.mantis.logic.EmailLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    EmailLogic emailLogic;


//@PreAuthorize("hasAuthority('CREATE_PRODUCT_SHOP_RELATION')")
//    public ProductShopRelationDTO createProductShopRelation(ProductShopRelationDTO productShopRelationDTO) {
//        return  this.productShopRelationMapper.toDTO(shopLogic.createProductShopRelation(productShopRelationMapper.toEntity(productShopRelationDTO))) ;
//    }

}

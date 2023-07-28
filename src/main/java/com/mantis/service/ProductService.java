package com.mantis.service;

import com.mantis.data.dto.DutyDTO;
import com.mantis.data.dto.ProductDTO;
import com.mantis.data.dto.ProductShopRelationDTO;
import com.mantis.data.dto.RepairShopDutyDTO;
import com.mantis.data.entity.Product;
import com.mantis.logic.DutyLogic;
import com.mantis.logic.ProductLogic;
import com.mantis.mapper.DutyMapper;
import com.mantis.mapper.ProductMapper;
import com.mantis.mapper.ProductShopRelationMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductLogic productLogic;
    ProductMapper productMapper = new ProductMapper();

    @PreAuthorize("hasAuthority('CREATE_PRODUCT')")
    public ProductDTO createProduct(ProductDTO productDTO) {
        return productMapper.toDTO(productLogic.createProduct(productMapper.toEntity(productDTO)));
    }


}

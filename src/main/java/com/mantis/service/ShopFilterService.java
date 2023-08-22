package com.mantis.service;

import com.mantis.data.dto.ShopFilterDTO;
import com.mantis.logic.ShopFilterLogic;
import com.mantis.mapper.ShopFilterMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ShopFilterService {
    @Autowired
    ShopFilterLogic shopFilterLogic;
    ShopFilterMapper shopFilterMapper =new ShopFilterMapper();

   /* public List<ShopFilterDTO> searchShopByTerm(ShopFilterDTO shopFilterDTO){
        List<ShopFilterDTO> filterDTOS=shopFilterLogic.searchShopByTerm(shopFilterMapper.toEntity(shopFilterDTO))
                .stream()
                .map(shopFilterMapper::toDTO)
                .collect(Collectors.toList());
        return filterDTOS;

    }*/



}

package com.mantis.mapper;

import com.mantis.data.dto.ShopDTO;
import com.mantis.data.dto.ShopFilterDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.Shop;
import com.mantis.data.entity.User;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ShopFilterMapper {

    public ShopFilterDTO toDTO(Shop shop) {
        ShopFilterDTO shopFilterDTO = new ShopFilterDTO();
        ShopFilterMapper shopFilterMapper = new ShopFilterMapper();
     shopFilterDTO.setId(shop.getId());
     shopFilterDTO.setName(shop.getName());
     shopFilterDTO.setAddress(shop.getAddress());
     shopFilterDTO.setOwner(shop.getOwner());

        return shopFilterDTO;
    }

    public Shop toEntity(ShopFilterDTO shopFilterDTO){
        ShopFilterMapper shopFilterMapper = new ShopFilterMapper();
        Shop shop = new Shop();
        shop.setId(shopFilterDTO.getId());
        shop.setName(shopFilterDTO.getName());
        shop.setAddress(shopFilterDTO.getAddress());
        shop.setOwner(shopFilterDTO.getOwner());

        return shop;
    }
    }



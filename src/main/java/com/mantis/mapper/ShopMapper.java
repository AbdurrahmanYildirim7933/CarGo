package com.mantis.mapper;

import com.mantis.data.dto.ShopDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.Shop;
import com.mantis.data.entity.User;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ShopMapper {

    public ShopDTO toDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        UserMapper userMapper = new UserMapper();
        shopDTO.setId(shop.getId());
        shopDTO.setName(shop.getName());
        shopDTO.setPhone(shop.getPhone());
        shopDTO.setAddress(shop.getAddress());
        shopDTO.setOwner(shop.getOwner());
       if (!ObjectUtils.isEmpty(shop.getUsers())) {
            List<UserDTO> userDTOS = shop.getUsers().stream()
                    .map(u -> userMapper.toDTO(u)).collect(Collectors.toList());

            shopDTO.setUsers(userDTOS);
        }

        return shopDTO;
    }

    public Shop toEntity(ShopDTO shopDTO) {
        UserMapper userMapper = new UserMapper();
        Shop shop = new Shop();
        shop.setId(shopDTO.getId());
        shop.setName(shopDTO.getName());
        shop.setPhone(shopDTO.getPhone());
        shop.setAddress(shopDTO.getAddress());
        shop.setOwner(shopDTO.getOwner());
        if (!ObjectUtils.isEmpty(shopDTO.getUsers())){
            List<User> users = shopDTO.getUsers().stream()
                    .map(u->userMapper.toEntity(u)).collect(Collectors.toList());
            shop.setUsers(users);
        }


        return shop;
    }

}


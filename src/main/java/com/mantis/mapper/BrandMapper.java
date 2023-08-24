package com.mantis.mapper;

import com.mantis.data.dto.BrandDTO;
import com.mantis.data.dto.CarDTO;
import com.mantis.data.dto.ModelDTO;
import com.mantis.data.dto.UserDTO;
import com.mantis.data.entity.Brand;
import com.mantis.data.entity.Car;
import com.mantis.data.entity.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BrandMapper {


    public BrandDTO toDTO(Brand brand){

        BrandDTO _brand = new BrandDTO();
        _brand.setId(brand.getId());
        _brand.setName(brand.getName());

        return _brand;}
    public Brand toEntity(BrandDTO brandDTO){

        Brand _brand = new Brand();
        _brand.setId(brandDTO.getId());
        _brand.setName(brandDTO.getName());

        return _brand;
    }
}

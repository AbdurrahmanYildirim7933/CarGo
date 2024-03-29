package com.mantis.mapper;

import com.mantis.data.dto.BrandDTO;
import com.mantis.data.dto.CarDTO;
import com.mantis.data.dto.ModelDTO;
import com.mantis.data.entity.Brand;
import com.mantis.data.entity.Car;
import com.mantis.data.entity.Model;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapper {


    public ModelDTO toDTO(Model model){

        ModelDTO _model = new ModelDTO();
        _model.setId(model.getId());
        _model.setName(model.getName());

        return _model;}
    public Model toEntity(ModelDTO modelDTO){

        Model _model = new Model();
        _model.setId(modelDTO.getId());
        _model.setName(modelDTO.getName());

        return _model;
    }

    public List<ModelDTO> toListDTO(List<Model> models){

        return models.stream().map(m->toDTO(m)).collect(Collectors.toList());
    }
    public List<Model> toListEntity(List<ModelDTO> modelDTOS){

        return modelDTOS.stream().map(m->toEntity(m)).collect(Collectors.toList());
    }

}

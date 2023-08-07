package com.Mapsa.onlineshop.Mapper;

import com.Mapsa.onlineshop.Modeles.Entities.BaseEntity;

public interface BaseMapper <E extends BaseEntity,D>{
    E dtoToEntity(D d);
    D entityToDto(E e);
}

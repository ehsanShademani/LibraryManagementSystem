package com.Mapsa.onlineshop.Mapper;

import com.Mapsa.onlineshop.Modeles.Dtos.PersonDto;
import com.Mapsa.onlineshop.Modeles.Entities.PersonEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

    @Component
    public class PersonMapper implements BaseMapper<PersonEntity, PersonDto> {

    @Override
    public PersonEntity dtoToEntity(PersonDto personDto) {
        PersonEntity personEntity = new PersonEntity();
        BeanUtils.copyProperties(personDto,personEntity);
        return personEntity;
    }

    @Override
    public PersonDto entityToDto(PersonEntity personEntity) {
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(personEntity,personDto);
        return personDto;
    }
}

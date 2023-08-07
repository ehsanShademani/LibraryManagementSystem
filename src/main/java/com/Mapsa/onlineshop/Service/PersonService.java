package com.Mapsa.onlineshop.Service;

import com.Mapsa.onlineshop.Mapper.PersonMapper;
import com.Mapsa.onlineshop.Modeles.Dtos.PersonDto;
import com.Mapsa.onlineshop.Modeles.Entities.BaseEntity;
import com.Mapsa.onlineshop.Modeles.Entities.PersonEntity;
import com.Mapsa.onlineshop.Repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonService implements BaseService<PersonDto> {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    @Override
    public PersonDto create(PersonDto dto) {
        PersonEntity personEntity = personRepository.save(personMapper.dtoToEntity(dto));
        return personMapper.entityToDto(personEntity);
    }

    @Override
    public List<PersonDto> getAll() {
        List<PersonDto> personDtos = new ArrayList<>();
        List<PersonEntity> personEntities = personRepository.findAll();
        personEntities.stream().filter(BaseEntity::getAviliable).forEach(item->personDtos.add(personMapper.entityToDto(item)));
        return personDtos;
    }

    @Override
    public PersonDto getById(Long id) {
      PersonEntity personEntity = personRepository.findById(id).orElseThrow();
      if (!personEntity.getAviliable()){
          System.err.println("Person has been deleted");
          return null;
      }
      return personMapper.entityToDto(personEntity);
    }

    @Override
    public PersonDto update(PersonDto dto) {
        if (dto== null){
            return null;
        }
        PersonEntity exist =personRepository.findById(dto.getId()).orElseThrow();
        exist.setFirstName(dto.getFirstName());
        if (dto.getLastName()!=null){
            exist.setLastName(dto.getLastName());
        }
        if (dto.getMemberEntity()!=null){
            exist.setMemberEntity(dto.getMemberEntity());
        }
        if (dto.getLiberianEntity()!=null){
            exist.setLiberianEntity(dto.getLiberianEntity());
        }
        return create(personMapper.entityToDto(exist));
    }
    @Override
    public void delete(Long id) {
    PersonEntity personEntity = personRepository.findById(id).orElseThrow();
    personEntity.setAviliable(false);
    personRepository.save(personEntity);
    }
}

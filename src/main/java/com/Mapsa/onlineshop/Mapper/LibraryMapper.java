package com.Mapsa.onlineshop.Mapper;

import com.Mapsa.onlineshop.Modeles.Dtos.LibraryDto;
import com.Mapsa.onlineshop.Modeles.Entities.LibraryEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LibraryMapper implements BaseMapper<LibraryEntity,LibraryDto>{
    @Override
    public LibraryEntity dtoToEntity(LibraryDto libraryDto){
        LibraryEntity libraryEntity = new LibraryEntity();
        BeanUtils.copyProperties(libraryDto,libraryEntity);
        return libraryEntity ;
    }
    @Override
    public LibraryDto entityToDto(LibraryEntity libraryEntity){
        LibraryDto libraryDto = new LibraryDto();
        BeanUtils.copyProperties(libraryEntity,libraryDto);
        return libraryDto;
    }
}

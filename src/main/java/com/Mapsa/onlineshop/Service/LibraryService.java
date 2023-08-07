package com.Mapsa.onlineshop.Service;

import com.Mapsa.onlineshop.Mapper.LibraryMapper;
import com.Mapsa.onlineshop.Modeles.Dtos.LibraryDto;
import com.Mapsa.onlineshop.Modeles.Entities.BaseEntity;
import com.Mapsa.onlineshop.Modeles.Entities.LibraryEntity;
import com.Mapsa.onlineshop.Repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService implements BaseService<LibraryDto> {

   private final LibraryRepository libraryRepository;
   private final LibraryMapper libraryMapper;
    public List<LibraryDto> getAll(){
        List<LibraryDto> libraryDtos = new ArrayList<>();
        List<LibraryEntity> libraryEntities = libraryRepository.findAll();
        libraryEntities.stream().filter(BaseEntity::getAviliable).forEach(item-> libraryDtos.add(libraryMapper.entityToDto(item)));
        return libraryDtos;

    }
    public LibraryDto getById(Long id){
        LibraryEntity libraryEntity = libraryRepository.findById(id).orElseThrow();
        if (!libraryEntity.getAviliable()){
            System.err.println("library has been deleted");
            return null;
        }
        return libraryMapper.entityToDto(libraryEntity);
    }
    public List<LibraryDto> getByName(String libraryName){
        List<LibraryDto> libraryDtos = new ArrayList<>();
        List<LibraryEntity> libraryEntities = libraryRepository.findByName(libraryName);
        libraryEntities.forEach(item -> libraryDtos.add(libraryMapper.entityToDto(item)));

        return libraryDtos;
    }
    @Override
    public LibraryDto create(LibraryDto library){
        LibraryEntity libraryEntity=libraryRepository.save(libraryMapper.dtoToEntity(library));
        return libraryMapper.entityToDto(libraryEntity);
    }
    @Override
    public LibraryDto update(LibraryDto updateLibraryDto){
        if (updateLibraryDto==null){
            return null;
        }
            LibraryEntity exist =libraryRepository.findById(updateLibraryDto.getId()).orElseThrow();
            exist.setName(updateLibraryDto.getName());

          if (updateLibraryDto.getBookEntities()!=null){
              exist.setBookEntities(updateLibraryDto.getBookEntities());
          }
            return create(libraryMapper.entityToDto(exist));
    }
    public void delete(Long id){
        LibraryEntity libraryEntity = libraryRepository.findById(id).orElseThrow();
        libraryEntity.setAviliable(false);
        libraryRepository.save(libraryEntity);
    }
}

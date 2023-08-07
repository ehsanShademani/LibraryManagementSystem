package com.Mapsa.onlineshop.Service;

import com.Mapsa.onlineshop.Mapper.BookMapper;
import com.Mapsa.onlineshop.Modeles.Dtos.BookDto;
import com.Mapsa.onlineshop.Modeles.Entities.BaseEntity;
import com.Mapsa.onlineshop.Modeles.Entities.BookEntity;
import com.Mapsa.onlineshop.Repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements BaseService<BookDto>{

  private final BookRepository bookRepository;
  public final BookMapper bookMapper;

    public List<BookDto> getAll(){
        List<BookDto> bookDtos = new ArrayList<>();
        List<BookEntity> bookEntities = bookRepository.findAll();
        bookEntities.stream().filter(BaseEntity::getAviliable).forEach(item->bookDtos.add(bookMapper.entityToDto(item)));
        return bookDtos;
    }
    public BookDto getById(Long id){
        BookEntity book =bookRepository.findById(id).orElseThrow();
        if (!book.getAviliable()){
            System.err.println("Book has been deleted");
            return null;
        }
        return bookMapper.entityToDto(book);
    }
    public List<BookDto> getByTitle(String title){
        List<BookDto> bookDtos = new ArrayList<>();
        List<BookEntity> book = bookRepository.findByTitle(title);
        book.stream().forEach(item->bookDtos.add(bookMapper.entityToDto(item)));
        return bookDtos;
    }
    public BookDto create(BookDto bookDto){
        BookEntity book = bookRepository.save(bookMapper.dtoToEntity(bookDto));
        return bookMapper.entityToDto(book);
    }
    public BookDto update(BookDto updateBookDto){
        if (updateBookDto==null){
            return null;
        }
        BookEntity exist = bookRepository.findById(updateBookDto.getId()).orElseThrow(EntityNotFoundException::new);
       exist.setTitle(updateBookDto.getTitle());
       if (updateBookDto.getLibraryEntity()!=null){
           exist.setLibraryEntity(updateBookDto.getLibraryEntity());
       }
       return create(bookMapper.entityToDto(exist)) ;
    }
    public void delete(Long id){
        BookEntity book = bookRepository.findById(id).orElseThrow();
        book.setAviliable(false);
        bookRepository.save(book);
    }

}

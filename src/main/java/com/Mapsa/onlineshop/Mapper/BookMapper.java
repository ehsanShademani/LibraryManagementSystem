package com.Mapsa.onlineshop.Mapper;

import com.Mapsa.onlineshop.Modeles.Dtos.BookDto;
import com.Mapsa.onlineshop.Modeles.Entities.BookEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements BaseMapper<BookEntity, BookDto> {
    @Override
    public BookEntity dtoToEntity(BookDto dto){
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(dto,bookEntity);
        return bookEntity;
    }
    @Override
    public BookDto entityToDto(BookEntity book){
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book,bookDto);
        return bookDto;
    }
}

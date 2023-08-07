package com.Mapsa.onlineshop.Modeles.Dtos;

import com.Mapsa.onlineshop.Modeles.Entities.LibraryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements BaseDto {
    private Long id;
    private String title;
    private LibraryEntity libraryEntity;
}

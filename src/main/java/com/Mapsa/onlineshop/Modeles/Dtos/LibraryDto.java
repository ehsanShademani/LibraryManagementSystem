package com.Mapsa.onlineshop.Modeles.Dtos;

import com.Mapsa.onlineshop.Modeles.Entities.BookEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDto implements BaseDto {
    private Long id;
    @NotBlank
    private String name;
    private Set<BookEntity> bookEntities;
}

package com.Mapsa.onlineshop.Modeles.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookEntity extends BaseEntity{

    private String title;
    @ManyToOne
    @JoinColumn(name = "libraryEntity")
    private LibraryEntity libraryEntity;
    @OneToMany(mappedBy = "bookEntity",cascade = CascadeType.ALL)
    private Set<BorrowEntity> borrowEntity;


}

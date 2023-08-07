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
public class LibraryEntity extends BaseEntity{

    @Column(name = "Library_Name")
    private String name;
    @OneToMany(mappedBy = "libraryEntity",cascade = CascadeType.ALL)
    private Set<BookEntity> bookEntities;
}

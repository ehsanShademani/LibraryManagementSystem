package com.Mapsa.onlineshop.Modeles.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PersonEntity extends BaseEntity {

    private String firstName;
    private String lastName;
    @OneToOne
    (mappedBy = "personEntity",cascade = CascadeType.ALL)
    private MemberEntity memberEntity;
    @OneToOne(mappedBy = "personEntity",cascade = CascadeType.ALL)
    private LiberianEntity liberianEntity;
}

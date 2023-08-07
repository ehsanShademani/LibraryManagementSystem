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
public class MemberEntity extends BaseEntity {

    private String code;
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL)
    private Set<BorrowEntity> borrowEntities;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private PersonEntity personEntity;
}

package com.Mapsa.onlineshop.Modeles.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LiberianEntity extends BaseEntity {

    private String code;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liberian_id")
    private PersonEntity personEntity;
}

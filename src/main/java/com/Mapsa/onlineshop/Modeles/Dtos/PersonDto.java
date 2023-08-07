package com.Mapsa.onlineshop.Modeles.Dtos;

import com.Mapsa.onlineshop.Modeles.Entities.LiberianEntity;
import com.Mapsa.onlineshop.Modeles.Entities.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private MemberEntity memberEntity;
    private LiberianEntity liberianEntity;
}

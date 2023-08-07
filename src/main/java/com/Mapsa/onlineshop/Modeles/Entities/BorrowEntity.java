package com.Mapsa.onlineshop.Modeles.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BorrowEntity extends BaseEntity{

    private Date start_date;
    private Date end_date;
    @ManyToOne
    @JoinColumn(name = "bookEntity-id")
    private BookEntity bookEntity;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;
}

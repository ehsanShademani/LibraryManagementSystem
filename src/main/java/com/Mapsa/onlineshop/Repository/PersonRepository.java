package com.Mapsa.onlineshop.Repository;

import com.Mapsa.onlineshop.Modeles.Entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity,Long> {

}

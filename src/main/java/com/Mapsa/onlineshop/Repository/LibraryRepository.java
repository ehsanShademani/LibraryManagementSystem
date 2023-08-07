package com.Mapsa.onlineshop.Repository;

import com.Mapsa.onlineshop.Modeles.Entities.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity,Long> {
   public List<LibraryEntity> findByName(String name);
}

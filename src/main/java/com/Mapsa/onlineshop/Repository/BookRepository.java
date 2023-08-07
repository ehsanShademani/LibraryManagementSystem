package com.Mapsa.onlineshop.Repository;

import com.Mapsa.onlineshop.Modeles.Entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    public List<BookEntity> findByTitle(String title);
}

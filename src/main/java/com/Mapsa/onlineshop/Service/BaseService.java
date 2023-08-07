package com.Mapsa.onlineshop.Service;

import java.util.List;

public interface BaseService <D>{
 D create(D dto);
 List<D> getAll();
 D getById(Long id);
// List<LibraryDto> getByName(String libraryName);
 D update(D dto);
 void delete(Long id);
}

package com.Mapsa.onlineshop.Controller;

import com.Mapsa.onlineshop.Modeles.Dtos.LibraryDto;
import com.Mapsa.onlineshop.Service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Libraries")
@AllArgsConstructor
public class LibraryController  {

    private final LibraryService libraryService;
    @GetMapping("/getAll")
    public List<LibraryDto> getAllLibrary(){
        return libraryService.getAll();
    }
    @GetMapping("getById/{id}")
    public LibraryDto getLibraryById(@PathVariable Long id){
        return libraryService.getById(id);
    }
    @GetMapping("getByName/{name}")
    public List<LibraryDto> getLibraryByName(@PathVariable String name){
        return libraryService.getByName(name);
    }
    @PostMapping()
    public LibraryDto createLibrary(@RequestBody LibraryDto library){
        return libraryService.create(library);
    }
    @PutMapping()
    public LibraryDto updateLibrary(@RequestBody LibraryDto updateDto){
        return libraryService.update(updateDto);
    }
    @DeleteMapping("{id}")
    public void deleteLibraryById(@PathVariable Long id){
        libraryService.delete(id);
    }

}

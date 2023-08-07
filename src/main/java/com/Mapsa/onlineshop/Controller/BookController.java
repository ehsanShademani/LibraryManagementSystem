package com.Mapsa.onlineshop.Controller;

import com.Mapsa.onlineshop.Modeles.Dtos.BookDto;
import com.Mapsa.onlineshop.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
@AllArgsConstructor
public class BookController {

   private final BookService bookService;
    @GetMapping("/getAll")
    public List<BookDto> getAllBook(){
        return bookService.getAll();
    }
    @GetMapping("getById/{id}")
    public BookDto getBookById(@PathVariable Long id){
        return bookService.getById(id);
    }
    @GetMapping("getByTitle/{title}")
    public List<BookDto> getBookByTitle(@PathVariable String title){
        return bookService.getByTitle(title);
    }
    @PostMapping()
    public BookDto createBook(@RequestBody BookDto bookDto){
        return bookService.create(bookDto);
    }
    @PutMapping()
    public BookDto updateBook(@RequestBody BookDto updateBookDto){
        return bookService.update(updateBookDto);
    }
    @DeleteMapping("delete/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookService.delete(id);
    }
}

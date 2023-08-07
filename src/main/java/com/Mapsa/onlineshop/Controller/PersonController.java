package com.Mapsa.onlineshop.Controller;

import com.Mapsa.onlineshop.Modeles.Dtos.PersonDto;
import com.Mapsa.onlineshop.Service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
@AllArgsConstructor
public class PersonController {
    private  final PersonService personService;
     @PostMapping()
     public PersonDto createPerson(@PathVariable PersonDto personDto){
         return personService.create(personDto);
      }
  @GetMapping("/getAll")
  public List<PersonDto> getAllPerson(){
        return personService.getAll();
  }
  @GetMapping("getById/{id}")
    public PersonDto getPersonById(@PathVariable Long id){
        return personService.getById(id);
    }
    @PutMapping()
    public PersonDto updatePerson(@RequestBody PersonDto personDto){
        return personService.update(personDto);
    }
    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable Long id){
       personService.delete(id);
    }
}

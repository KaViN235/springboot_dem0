package com.kgisl.sb1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.sb1.entity.Person;
import com.kgisl.sb1.service.PersonService;


@RequestMapping("/")
@RestController
public class PersonController {
  @Autowired
  PersonService service;

  @GetMapping("/persons")
  public List<Person> getAllPerson() {

    return service.get();
  }

  @GetMapping("/person/{id}")
  public ResponseEntity<Person> getPerson(@PathVariable("id") long id) {

    Optional<Person> stock = service.getPersonById(id);
    if (stock.isPresent()) {
        return ResponseEntity.ok(stock.get());
    } else {
        return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/add")
  public Person insertPerson(@RequestBody Person person1) {
    return service.insertperson(person1);
  }
  

  @DeleteMapping("/delete/{id}")
  public String delete(@PathVariable("id") Long id) {
    return service.deleteId(id);
  }

  @PutMapping("/update/{id}")
  public Person update(@PathVariable("id") Long id, @RequestBody Person person1) {

    return service.update(id, person1);
  }

}

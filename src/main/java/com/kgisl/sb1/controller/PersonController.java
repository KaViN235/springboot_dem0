package com.kgisl.sb1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kgisl.sb1.Model.Person;
import com.kgisl.sb1.Service.PersonService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RequestMapping("/")
@RestController
public class PersonController {
  @Autowired
  PersonService service;

  @GetMapping("/persons")
  public List<Person> getAllPersonserviceository() {

    return service.get();
  }

  @PostMapping("/add")
  public ResponseEntity<String> insertPerson(@RequestBody @Valid Person p) {
   try {
    System.out.println("kavin");
        return service.insertperson(p);
    } catch (Exception e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Optional<Person>> delete(@PathVariable("id") Long id) {
    return service.deleteId(id);
  }
  
  @PutMapping("/update/{id}")
  public ResponseEntity<Void> update(@PathVariable("id") Long id,@RequestBody Person p){

    return service.update(id,p);
  }

}

package com.kgisl.sb1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kgisl.sb1.entity.Person;
import com.kgisl.sb1.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository rep;

    public List<Person> get() {
        List<Person> p =rep.findAll();
       return p;
    }
    
    public Optional<Person> getPersonById(long id) {
      return rep.findById(id);
    }


    public Person insertperson(Person person1) {
        return rep.save(person1);
    }

    public String deleteId(Long id) {
        rep.deleteById(id);
        return "removed";
    }

    public Person update(Long id, Person p) {
        
        return rep.save(p);
    }

   
}

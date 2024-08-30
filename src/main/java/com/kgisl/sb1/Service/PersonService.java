package com.kgisl.sb1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kgisl.sb1.model.Person;
import com.kgisl.sb1.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository rep;

    public List<Person> get() {

        return rep.findAll();
    }

    public ResponseEntity<String> insertperson(Person p) {

        System.out.println(rep.findAll());
        rep.save(p);
        return new ResponseEntity<>("done", HttpStatus.CREATED);

    }

    public ResponseEntity<Optional<Person>> deleteId(Long id) {
        Optional<Person> p = rep.findById(id);
        rep.deleteById(id);
        return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Void> update(Long id, Person p) {
        rep.save(p);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    // public ResponseEntity<String> insertperson(long id, String uname, String
    // email) {
    // Person p = new Person(id,uname, email);
    // System.out.println(p);
    // rep.save(p);
    // return new ResponseEntity<>("Working",HttpStatus.CREATED);
    // }

}

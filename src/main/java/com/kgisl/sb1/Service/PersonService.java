package com.kgisl.sb1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kgisl.sb1.DAO.PersonRepository;
import com.kgisl.sb1.Model.Person;

@Service
public class PersonService {
    
    @Autowired
    PersonRepository rep;

    public List<Person> get() {
      
        return rep.findAll();
     }

    public ResponseEntity<String> insertperson(Person p) {

        try {
            rep.save(p);
            return new ResponseEntity<>("done", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    public ResponseEntity<Optional<Person>> deleteId(Long id) {
        Optional<Person> p = rep.findById(id);
        rep.deleteById(id);
        return new ResponseEntity<>(p,HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Void> update(Long id,Person p) {
        rep.save(p);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    


    
}

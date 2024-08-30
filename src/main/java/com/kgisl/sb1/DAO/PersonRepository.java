package com.kgisl.sb1.DAO;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.sb1.Model.Person;
@Repository
public interface PersonRepository extends ListCrudRepository<Person,Long>{
    
}

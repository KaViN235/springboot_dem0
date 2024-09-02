package com.kgisl.sb1.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kgisl.sb1.entity.Person;
import com.kgisl.sb1.service.PersonService;

/**
 * PersonController
 */

@ExtendWith(MockitoExtension.class)

public class PersonControllerTest {
    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    public static List<Person> expected;

    Person person1 = new Person(1l, "Alice", "alice@example.com");

    Optional<Person> person3 = Optional.ofNullable(new Person(1l, "Alice", "alice@example.com"));
    Person person2 = new Person(2l, "Bob", "bob@example.com");
    // ResponseEntity<Person> person4 = new Person(2l, "Bob", "bob@example.com");

    // public Person person2 = new PersonBuilder().id(2L).name("aravinth").build();

    @Test
    public void getallPersonsTest() {

        expected = Arrays.asList(person1, person2);
        System.out.println(expected);
        when(personService.get()).thenReturn(expected);
        List<Person> actual = personController.getAllPerson();
        assertNotNull(actual);
        // assertEquals(expected, actual.getBody());
        // assertEquals(HttpStatus.OK, actual.getStatusCode());
        assertEquals(expected, actual);
    }

    @Test
    public void getPersonByIdTest() {
        long id = 1;
        when(personService.getPersonById(id)).thenReturn(person3);
        ResponseEntity<Person> actual = personController.getPerson(id);
        assertNotNull(actual);
    }

    @Test
    public void createPersonTest() {
        when(personService.insertperson(person1)).thenReturn(person1);
        personController.insertPerson(person1);
    }

    @Test
    public void updatePersonTest() {
        // Person edit = new PersonBuilder().name("shanmugam").build();
        long id = 1;
        // when(personService.updatePerson(id, person1)).thenReturn(person1);
        Person actual = personController.update(id, person1);
        //assertNotNull(actual);
        // System.out.println("Actual is  " + actual.getBody());
        // System.out.println("expected-->" + expected);
        // assertEquals(edit, actual.getBody());
        assertEquals(expected, actual);
    }

    // @Test
    // public void deletePersonTest() {
    //     long id = 1;
    //     when(personService.getPersonById(id)).thenReturn(person1);
    //     personController.delete(id);
    //     verify(personService).deleteId(id);
    // }
}
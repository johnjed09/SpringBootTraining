package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;
import com.example.demo.utilities.Utility;

public interface PersonDao {
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        int age = Utility.computeAgeByYear(person.getBirthDate());
        person.setAge(age);
        return insertPerson(id, person);
    }

    int insertPerson(UUID id, Person person);

    List<Person> selectAllPeople();

    Optional<Person> selectByPersonId(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}

package com.example.demo.dao;

import com.example.demo.model.Person;
import com.example.demo.utilities.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

  private static List<Person> DB = new ArrayList<>();

  @Override
  public int insertPerson(UUID id, Person person) {
    DB.add(new Person(id, person.getName(), person.getBirthDate(), person.getAge()));
    return 1;
  }

  @Override
  public List<Person> selectAllPeople() {
    return DB;
  }

  @Override
  public Optional<Person> selectByPersonId(UUID id) {
    return DB.stream()
        .filter(person -> person.getID().equals(id))
        .findFirst();
  }

  @Override
  public int deletePersonById(UUID id) {
    Optional<Person> personMaybe = selectByPersonId(id);
    if (personMaybe.isEmpty()) {
      return 0;
    }

    DB.remove(personMaybe.get());

    return 1;
  }

  @Override
  public int updatePersonById(UUID id, Person update) {

    return selectByPersonId(id)
        .map(person -> {
          int indexOfPersonToBeUpdate = DB.indexOf(person);
          if (indexOfPersonToBeUpdate >= 0) {
            DB.set(indexOfPersonToBeUpdate, new Person(id, update.getName(), update.getBirthDate()));
            return 1;
          }
          return 0;
        }).orElse(0);
  }
}

package com.example.prkt5upseva.Repository;
import com.example.prkt5upseva.Models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByNameContaining(String name);
}
package ru.lichagin.dao;

import org.springframework.stereotype.Component;
import ru.lichagin.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDto {
    private static int COUNT_PERSON;
    private List<Person> person = new ArrayList<>();

    public List<Person> index() {
        return person;
    }

    public Person show(int id) {
        return person.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++COUNT_PERSON);

        this.person.add(person);
    }

    public void update(int id, Person person) {
        Person updPerson = show(id);
        updPerson.setAge(person.getAge());
        updPerson.setName(person.getName());
        updPerson.setSurname(person.getSurname());
    }

    public void delete(int id) {
        person.removeIf(e -> e.getId() == id);
    }
}

package ru.albertgazin.mvc.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.albertgazin.mvc.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Albert", 33, "123@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Marat", 23, "4556@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Ivan", 42, "987@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Evgeniy", 27, "765@yahoo.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}

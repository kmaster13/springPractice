package ru.kmaster.springMVC.dao;

import org.springframework.stereotype.Component;
import ru.kmaster.springMVC.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Kirill", 19, "keriesa13@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 34, "bobikXD@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Max", 21, "max@ssau.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Danil", 35, "den4k@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
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

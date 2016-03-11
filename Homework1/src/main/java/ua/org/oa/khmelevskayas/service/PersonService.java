package ua.org.oa.khmelevskayas.service;

import java.util.List;
import java.util.Scanner;

import ua.org.oa.khmelevskayas.model.Person;

public interface PersonService {
    public void savePerson(Person person);
    public List<Person> searchPerson(Person person);
    public Scanner getScanner();
    public void setScanner(Scanner sc);
    public Person inputPerson();
}



package ua.org.oa.khmelevskayas.dao;

import java.util.List;
import ua.org.oa.khmelevskayas.model.Person;

public interface PersonDao {
    public void addPerson(Person person);
    public boolean isEmailExist(String email);
    public List<Person> findPerson(String name, Integer age, String email);
}

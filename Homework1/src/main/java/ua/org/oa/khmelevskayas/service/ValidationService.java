package ua.org.oa.khmelevskayas.service;

import ua.org.oa.khmelevskayas.model.Person;

public interface ValidationService {
    
    boolean isValidName(String name);
    boolean isValidAge(Integer age);
    boolean isValidEmail(String email);
    boolean isEmailExist(String email);
    boolean isValidPerson(Person person);
}


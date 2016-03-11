package ua.org.oa.khmelevskayas.service;

import java.util.List;
import java.util.Scanner;

import ua.org.oa.khmelevskayas.dao.PersonDao;
import ua.org.oa.khmelevskayas.dao.PersonDaoImpl;
import ua.org.oa.khmelevskayas.model.Person;

public class PersonServiceImpl implements PersonService {
    private PersonDao personDao = new PersonDaoImpl();
    ValidationService validationService = new ValidationServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
	return scanner;
    }

    public void setScanner(Scanner scanner) {
	this.scanner = scanner;
    }

    @Override
    public Person inputPerson() {
	Person person = null;
	System.out.println("Input name:");
	String name = scanner.nextLine().trim();
	System.out.println("Input age:");
	Integer age = null;
	do {
	    try {
		String ageString = scanner.nextLine().trim();
		age = Integer.parseInt(ageString);
		break;
	    } catch (Exception e) {
		System.out.println("Age should be an integer number. Try again.");
	    }
	} while (true);
	System.out.println("Input email:");
	String email = scanner.nextLine().trim();
	person = new Person(name, age, email);
	return person;
    }
    public void savePerson(Person person) {
	personDao.addPerson(person);
    }

    @Override
    public List<Person> searchPerson(Person person) {
	return personDao.findPerson(person.getName(), person.getAge(), person.getEmail());
    }
}



/*
Field[] fields = example.getClass().getDeclaredFields();
List<Field> notEmptyFields = new ArrayList<>();
for (Field field : fields) {
    field.setAccessible(true);
    Object value = field.get(example);
    if (value != null && value instanceof String && !((String) value).isEmpty()) {
	notEmptyFields.add(field);
    }
}

for (Person person : personList) {
    boolean isEqual = true;
    for (Field field : notEmptyFields) {
	if (!field.get(example).equals(field.get(person))) {
	    isEqual = false;
	}
    }
    if (isEqual) {
	result.add(person);
    }
}*/

package ua.org.oa.khmelevskayas.service;

import org.apache.commons.validator.routines.EmailValidator;

import ua.org.oa.khmelevskayas.dao.PersonDao;
import ua.org.oa.khmelevskayas.dao.PersonDaoImpl;
import ua.org.oa.khmelevskayas.model.Person;
import ua.org.oa.khmelevskayas.util.Constants;

public class ValidationServiceImpl implements ValidationService {

    private PersonDao personDao = new PersonDaoImpl();
    
    @Override
    public boolean isValidName(String name) {
	if (name.isEmpty()) {
	    System.out.println("Name shouldn't be empty.");
	    return false;
	}
	if (name.length() < Constants.NAME_MIN_LENGTH) {
	    System.out.println("The name's lenght shouldn't be less than " + Constants.NAME_MIN_LENGTH + " characters.");
	    return false;
	}
	return true;
    }

    @Override
    public boolean isValidAge(Integer age) {
	if (age == null) {
	    System.out.println("Age shouldn't be empty.");
	    return false;
	}
	if (age >= Constants.MAX_AGE || age <= Constants.MIN_AGE) {
	    System.out.println("Age should be in range from " + Constants.MIN_AGE + " to " + Constants.MAX_AGE);
	    return false;
	}

	return true;
    }

    @Override
    public boolean isValidEmail(String email) {
	if (email.isEmpty()) {
	    return true;
	}
	EmailValidator emailValidator = EmailValidator.getInstance();
	if (!emailValidator.isValid(email)){
	    System.out.println("Wrong email format.");
	    return false;
	}
	return true;
    }

    @Override
    public boolean isEmailExist(String email) {
	boolean exists = personDao.isEmailExist(email);
	if (exists) {
	    System.out.println("Such email already exists.");
	}
	return exists;
/*	int index = Collections.binarySearch(personList, person, new Comparator<Person>() {
	    @Override
	    public int compare(Person o1, Person o2) {
		return o1.getEmail().compareToIgnoreCase(o2.getEmail());
	    }
	});
	return index < 0;
*/
    }

    @Override
    public boolean isValidPerson(Person person) {
	if (!isValidName(person.getName()) 
		| !isValidAge(person.getAge()) 
		| !isValidEmail(person.getEmail()) 
		| isEmailExist(person.getEmail())){
	    return false;
	}
	return true;
    }
}

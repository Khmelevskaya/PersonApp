package ua.org.oa.khmelevskayas.action;

import ua.org.oa.khmelevskayas.model.Person;
import ua.org.oa.khmelevskayas.service.PersonService;
import ua.org.oa.khmelevskayas.service.PersonServiceImpl;
import ua.org.oa.khmelevskayas.service.ValidationService;
import ua.org.oa.khmelevskayas.service.ValidationServiceImpl;

public class PersonCreateAction implements PersonAction{

    private PersonService personService = new PersonServiceImpl();
    private ValidationService validationService = new ValidationServiceImpl();
    
    @Override
    public void perform() {
	Person person = personService.inputPerson();
	if (validationService.isValidPerson(person)) {
	    personService.savePerson(person);
	    System.out.println("Person successfully created.");
	} else {
	    System.out.println("Unable to create Person.");
	}
    }
}

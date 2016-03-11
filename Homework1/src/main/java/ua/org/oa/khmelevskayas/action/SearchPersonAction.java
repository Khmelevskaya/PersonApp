package ua.org.oa.khmelevskayas.action;

import java.util.List;

import ua.org.oa.khmelevskayas.model.Person;
import ua.org.oa.khmelevskayas.service.PersonService;
import ua.org.oa.khmelevskayas.service.PersonServiceImpl;

public class SearchPersonAction implements PersonAction {

    private PersonService personService = new PersonServiceImpl();
    
    @Override
    public void perform() {
	Person person = personService.inputPerson();
	List<Person> personList = personService.searchPerson(person);
	for (Person personItem : personList) {
	    System.out.println(personItem);
	}
	if (personList.isEmpty()) {
	    System.out.println("Nothing found");
	}
    }

}

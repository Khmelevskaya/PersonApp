package ua.org.oa.khmelevskayas.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonServiceImplTest {
    PersonService personService;
    
    @Before
    public void setUp(){
	personService = new PersonServiceImpl();
    }
    
    @After
    public void tearDown(){
	personService = null;
    }
/*
    @Test
    public void testSearchPerson() throws Exception {
	List<Person> personList = new ArrayList<>();
	personList.add(new Person("Petya", 23, "www@gmail.com"));
	personList.add(new Person("Vasya", 25, "wqw@gmail.com"));
	personList.add(new Person("Petya", 23, "wjw@mail.ru"));
	personList.add(new Person("Sveta", 28, "kh@gmail.com"));
	personList.add(new Person("Kolya", 28, ""));
	List<Person> resultList = personService.searchPerson(personList, new Person("Petya", 23, ""));
	assertThat(resultList, contains(new Person("Petya", 23, "www@gmail.com"), new Person("Petya", 23, "wjw@mail.ru")));
	resultList = personService.searchPerson(personList, new Person("Sveta", 28, "kh@gmail.com"));
	assertThat(resultList, contains(new Person("Sveta", 28, "kh@gmail.com")));
	resultList = personService.searchPerson(personList, new Person("Sveta1", 28, "kh@gmail.com"));
	assertTrue(resultList.isEmpty());
    }
    ?*/
}

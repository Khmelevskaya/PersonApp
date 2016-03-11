package ua.org.oa.khmelevskayas.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.org.oa.khmelevskayas.model.Person;

public class ValidationServiceImplTest {
    static ValidationService validationService;
    
    @Before
    public void setUp(){
	validationService = new ValidationServiceImpl();
    }
    
    @After 
    public void tearDown(){
	validationService = null;
    }

    @Test
    public void testIsValidName() {
	boolean actual = validationService.isValidName("");
	assertFalse(actual);
	actual = validationService.isValidName("Pet");
	assertFalse(actual);
	actual = validationService.isValidName("Petya");
	assertTrue(actual);
    }
    
    @Test
    public void testIsValidAge(){
	boolean actual = validationService.isValidAge(null);
	assertFalse(actual);
	actual = validationService.isValidAge(0);
	assertFalse(actual);
	actual = validationService.isValidAge(101);
	assertFalse(actual);
	actual = validationService.isValidAge(99);
	assertTrue(actual);
    }
    
    @Test
    public void testIsValidEmail(){
	boolean actual = validationService.isValidEmail("khmelevskaya.Svetlana@gmail.com");
	assertTrue(actual);
	actual = validationService.isValidEmail("khmelevskaya.Svetlanagmail.com");
	assertFalse(actual);
	actual = validationService.isValidEmail("khmelevskaya.Svetlana@gmail.aa");
	assertFalse(actual);
    }
    
    @Test
    public void testIsValidPerson() {
	Person person = new Person("test", 23, "test@test1.ua");
	assertTrue(validationService.isValidPerson(person));
	
	Person person1 = new Person("tes", 23, "test@test1.ua");
	assertFalse(validationService.isValidPerson(person1));
    }
}

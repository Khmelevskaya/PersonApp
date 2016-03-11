package ua.org.oa.khmelevskayas;

import ua.org.oa.khmelevskayas.action.ExitAction;
import ua.org.oa.khmelevskayas.action.PersonAction;
import ua.org.oa.khmelevskayas.action.PersonCreateAction;
import ua.org.oa.khmelevskayas.action.SearchPersonAction;

public enum MenuItemsEnum {
    CREATE("1", "Create person", new PersonCreateAction()),
    SEARCH("2", "Search person", new SearchPersonAction()),
    EXIT("3", "Exit the application", new ExitAction());

    private String value;
    private String text;
    private PersonAction personAction;
    
    private MenuItemsEnum(String value, String text, PersonAction personAction) {
	this.value = value;
	this.text = text;
	this.personAction = personAction;
    }
    
    public String getValue() {
	return value;
    }
    
    public String getText() {
	return text;
    }
    
    public PersonAction getPersonAction() {
	return personAction;
    }
    
    public static MenuItemsEnum resolve(String string) {
	for (MenuItemsEnum item : MenuItemsEnum.values()) {
	    if (item.getValue().equals(string)) {
		return item;
	    }
	}
	return null;
    }
}

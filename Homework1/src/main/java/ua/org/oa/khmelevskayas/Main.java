package ua.org.oa.khmelevskayas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	do {
	    for (MenuItemsEnum menuItem : MenuItemsEnum.values()) {
		System.out.println(menuItem.getValue() + " - " + menuItem.getText());
	    }
	    String value = sc.nextLine().trim();
	    MenuItemsEnum menuItem = MenuItemsEnum.resolve(value.trim());
	    if (menuItem == null) {
		System.out.println("Invalid input. Try again.");
		continue;
	    }
	    menuItem.getPersonAction().perform();
	} while (true);
    }
    
}

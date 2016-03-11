package ua.org.oa.khmelevskayas.action;

public class ExitAction implements PersonAction {

    @Override
    public void perform() {
	System.out.println("Exiting... Bye!");
	System.exit(0);
    }

}

package PiotrFilip.Calendar;

public class App 
{
	@SuppressWarnings("unused")
	public static void main( String[] args )
	{
        DataRepository xmlRepo = new XMLRepository();
        UserInterface userInterface = new UserInterface(xmlRepo);
    }
}

package PiotrFilip.Calendar;

public class App 
{
	@SuppressWarnings("unused")
	public static void main( String[] args )
	{
        DataRepository XmlRepo = new XMLRepository();
       
        UserInterface Interface = new UserInterface(XmlRepo);
    }
}

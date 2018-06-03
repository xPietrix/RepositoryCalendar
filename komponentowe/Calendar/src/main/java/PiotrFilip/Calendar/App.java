package PiotrFilip.Calendar;

public class App 
{
	@SuppressWarnings("unused")
	public static void main( String[] args )
	{
        DataRepository XmlRepo = new XMLRepository();
        DataRepository SQLRepo = new MySQLRepository();
        DataService XMLService = new DataService(XmlRepo);
        DataService SQLService = new DataService(SQLRepo);
        UserInterface userInterface = new UserInterface(XMLService, SQLService);
    }
}

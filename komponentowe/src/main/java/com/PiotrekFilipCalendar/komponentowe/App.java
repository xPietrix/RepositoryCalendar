package com.PiotrekFilipCalendar.komponentowe;

public class App 
{
	@SuppressWarnings("unused")
	public static void main( String[] args )
	{
        DataRepository XmlRepo = new XmlRepository();
        DataRepository SQLRepo = new MySqlRepository();
        DataService XMLService = new DataService(XmlRepo);
        DataService SQLService = new DataService(SQLRepo);
        UserInterface userInterface = new UserInterface(XMLService, SQLService);
    }
}

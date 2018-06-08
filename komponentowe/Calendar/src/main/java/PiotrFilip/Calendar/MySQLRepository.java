package PiotrFilip.Calendar;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySQLRepository implements DataRepository 
{
	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

	public Event getEvent(String name) throws NotExistingNameException 
	{
		boolean flag = false;
		Event event = new Event();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://db4free.net:3306/baza_kompo";
			connect = DriverManager.getConnection(url, "kompo_210175", "prostehaslo");
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Events");
			while(resultSet.next() && !flag)
			{
				if(name.equals(resultSet.getString("name")))
				{
					flag = true;
					
					java.util.Date date;
					Timestamp timestamp = resultSet.getTimestamp("date");
					date = new java.util.Date(timestamp.getTime());
					
					event.setName(resultSet.getString("name"));
					event.setDescription(resultSet.getString("description"));
					event.setDate(date);
					event.setPlace(resultSet.getString("place"));
				}
			}
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			try
			{
				connect.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		if(!flag)
		{
			throw new NotExistingNameException();
		}
		
		return event;
	}

	public Event getEvent(Date date) throws NotExistingDateException {
		
		boolean flag = false;
		Event event = new Event();
		java.util.Date dateVar;
		Timestamp timestamp;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://db4free.net:3306/baza_kompo";
			connect = DriverManager.getConnection(url, "kompo_210175", "prostehaslo");
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Events");
			while(resultSet.next() && !flag)
			{
				timestamp = resultSet.getTimestamp("date");
				dateVar = new java.util.Date(timestamp.getTime());
				
				if(date.equals(dateVar))
				{
					flag = true;
					
					event.setName(resultSet.getString("name"));
					event.setDescription(resultSet.getString("description"));
					event.setDate(date);
					event.setPlace(resultSet.getString("place"));
				}
			}
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			try 
			{
				connect.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		if(!flag)
		{
			throw new NotExistingDateException();
		}
		
		return event;
	}

	public List<Event> getAllEvents() {
		
		Event event = new Event();
		List<Event> eventList = new ArrayList<Event>();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://db4free.net:3306/baza_kompo";
			connect = DriverManager.getConnection(url, "kompo_210175", "prostehaslo");
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Events");
			while(resultSet.next())
			{
				java.util.Date date;
				Timestamp timestamp = resultSet.getTimestamp("date");
				date = new java.util.Date(timestamp.getTime());
				
				event = new Event();
				event.setName(resultSet.getString("name"));
				event.setDescription(resultSet.getString("description"));
				event.setDate(date);
				event.setPlace(resultSet.getString("place"));
				
				eventList.add(event);
			}
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			try {
				connect.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return eventList;
	}

	public void addEvent(Event newEvent) {
		
		PreparedStatement preparedStmt;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://db4free.net:3306/baza_kompo";
			connect = DriverManager.getConnection(url, "kompo_210175", "prostehaslo");
			preparedStmt = connect.prepareStatement("INSERT INTO Events (name, description, date, place)"
			        + " values (?, ?, ?, ?)");
			
			preparedStmt.setString(1, newEvent.getName());
			preparedStmt.setString(2, newEvent.getDescription());
			preparedStmt.setTimestamp(3, new java.sql.Timestamp(newEvent.getDate().getTime()));
			preparedStmt.setString(4, newEvent.getPlace());
			
			preparedStmt.execute();
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			try 
			{
				connect.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

	}

	public void deleteEvent(String name) throws NotExistingNameException
	{

		PreparedStatement preparedStmt;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://db4free.net:3306/baza_kompo";
			connect = DriverManager.getConnection(url, "kompo_210175", "prostehaslo");
			preparedStmt = connect.prepareStatement("delete from Events where name = ?");
			
			preparedStmt.setString(1, name);
	
			
			preparedStmt.execute();
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			try 
			{
				connect.close();
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void deleteEvent(Date date) throws NotExistingDateException 
	{
		PreparedStatement preparedStmt;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://db4free.net:3306/baza_kompo";
			connect = DriverManager.getConnection(url, "kompo_210175", "prostehaslo");
			preparedStmt = connect.prepareStatement("delete from Events where date = ?");
			
			preparedStmt.setTimestamp(1, new java.sql.Timestamp(date.getTime()));
	
			
			preparedStmt.execute();
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			try 
			{
				connect.close();
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void updateEvent(String name, Event newEvent) throws NotExistingNameException 
	{
		
		boolean flag = false;
		PreparedStatement preparedStmt;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://db4free.net:3306/baza_kompo";
			connect = DriverManager.getConnection(url, "kompo_210175", "prostehaslo");
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Events");
			while(resultSet.next() && !flag)
			{
				if(name.equals(resultSet.getString("name")))
				{
					flag = true;
				}
			}
		}
		catch (Exception e)
		{
			
		}
		
		
		if(!flag)
		{
			try {
				connect.close();
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			throw new NotExistingNameException();
		}
		else
		{
			try 
			{
				preparedStmt = connect.prepareStatement("INSERT INTO Events (name, description, date, place)"
				        + " values (?, ?, ?, ?)");
			
			
				preparedStmt.setString(1, newEvent.getName());
				preparedStmt.setString(2, newEvent.getDescription());
				preparedStmt.setTimestamp(3, new java.sql.Timestamp(newEvent.getDate().getTime()));
				preparedStmt.setString(4, newEvent.getPlace());
			
				preparedStmt.execute();
			}
			catch (Exception e)
			{
				
			}
			finally
			{
				try {
					connect.close();
				} catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		

	}

	public void updateEvent(Date date, Event newEvent) throws NotExistingDateException 
	{
		boolean flag = false;
		PreparedStatement preparedStmt;
		java.util.Date dateVar;
		Timestamp timestamp;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://db4free.net:3306/baza_kompo";
			connect = DriverManager.getConnection(url, "kompo_210175", "prostehaslo");
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Events");
			while(resultSet.next() && !flag)
			{
				timestamp = resultSet.getTimestamp("date");
				dateVar = new java.util.Date(timestamp.getTime());
				if(date.equals(dateVar))
				{
					flag = true;
				}
			}
		}
		catch (Exception e)
		{
			
		}
		
		
		if(!flag)
		{
			try {
				connect.close();
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			throw new NotExistingDateException();
		}
		else
		{
			try 
			{
				preparedStmt = connect.prepareStatement("INSERT INTO Events (name, description, date, place)"
				        + " values (?, ?, ?, ?)");
			
			
				preparedStmt.setString(1, newEvent.getName());
				preparedStmt.setString(2, newEvent.getDescription());
				preparedStmt.setTimestamp(3, new java.sql.Timestamp(newEvent.getDate().getTime()));
				preparedStmt.setString(4, newEvent.getPlace());
			
				preparedStmt.execute();
			}
			catch (Exception e)
			{
				
			}
			finally
			{
				try 
				{
					connect.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			
		}

	}

}

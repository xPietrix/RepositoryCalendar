package com.PiotrekFilipCalendar.komponentowe;

import java.io.FileNotFoundException;   
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;

public class XmlRepository implements DataRepository
{
	public Event getEvent(String name) throws NotExistingNameException 
	{
		
		EventsList list = new EventsList();
		FileReader reader = null;
		
		try
		{
			reader = new FileReader("Events.xml");
			XStream xstream = new XStream();
			xstream.alias("event", Event.class);
			xstream.alias("events", EventsList.class);
			xstream.addImplicitCollection(EventsList.class, "events", Event.class);
			DateConverter dateConverter = new DateConverter("yyyy-MM-dd HH:mm:ss", new String[] {});
			xstream.registerConverter(dateConverter);
			list = (EventsList) xstream.fromXML(reader);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		for(int i=0; i<list.getEvents().size(); i++)
		{
			if(list.getEvents().get(i).getName().equals(name))
			{
				return list.getEvents().get(i);
			}
		}
		throw new NotExistingNameException();
		
	}

	public Event getEvent(Date date) throws NotExistingDateException 
	{
		EventsList list = new EventsList();
		FileReader reader = null;
		
		try
		{
			reader = new FileReader("Events.xml");
			XStream xstream = new XStream();
			xstream.alias("event", Event.class);
			xstream.alias("events", EventsList.class);
			xstream.addImplicitCollection(EventsList.class, "events", Event.class);
			DateConverter dateConverter = new DateConverter("yyyy-MM-dd HH:mm:ss", new String[] {});
			xstream.registerConverter(dateConverter);
			list = (EventsList) xstream.fromXML(reader);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.getEvents().size(); i++)
		{
			if(list.getEvents().get(i).getDate().equals(date))
			{
				return list.getEvents().get(i);
			}
		}
		throw new NotExistingDateException();
	}

	public List<Event> getAllEvents() 
	{
		EventsList list = new EventsList();
		FileReader reader = null;
		
		try
		{
			reader = new FileReader("Events.xml");
			XStream xstream = new XStream();
			xstream.alias("event", Event.class);
			xstream.alias("events", EventsList.class);
			xstream.addImplicitCollection(EventsList.class, "events", Event.class);
			DateConverter dateConverter = new DateConverter("yyyy-MM-dd HH:mm:ss", new String[] {});
			xstream.registerConverter(dateConverter);
			list = (EventsList) xstream.fromXML(reader);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		return list.getEvents();
	}

	public void addEvent(Event newEvent)
	{
		EventsList list = new EventsList();
		FileReader reader = null;
		PrintWriter writer = null;
		XStream xstream = new XStream();
		
		try
		{
			reader = new FileReader("Events.xml");
			xstream.alias("event", Event.class);
			xstream.alias("events", EventsList.class);
			xstream.addImplicitCollection(EventsList.class, "events", Event.class);
			DateConverter dateConverter = new DateConverter("yyyy-MM-dd HH:mm:ss", new String[] {});
			xstream.registerConverter(dateConverter);
			list = (EventsList) xstream.fromXML(reader);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		list.getEvents().add(newEvent);
		
		try 
		{
			writer = new PrintWriter("Events.xml");
			System.out.println(xstream.toXML(list));
			writer.println(xstream.toXML(list));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			writer.close();
		}
		

	}

	public void deleteEvent(String name) throws NotExistingNameException
	{
		EventsList list = new EventsList();
		FileReader reader = null;
		PrintWriter writer = null;
		XStream xstream = new XStream();
		boolean flag = false;
		
		try
		{
			reader = new FileReader("Events.xml");
			xstream.alias("event", Event.class);
			xstream.alias("events", EventsList.class);
			xstream.addImplicitCollection(EventsList.class, "events", Event.class);
			DateConverter dateConverter = new DateConverter("yyyy-MM-dd HH:mm:ss", new String[] {});
			xstream.registerConverter(dateConverter);
			list = (EventsList) xstream.fromXML(reader);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.getEvents().size(); i++)
		{
			if(list.getEvents().get(i).getName().equals(name))
			{
				flag = true;
				list.getEvents().remove(i);
			}
		}
		
		if(flag)
		{
			throw new NotExistingNameException();
		}
		
		
		try 
		{
			writer = new PrintWriter("Events.xml");
			writer.println(xstream.toXML(list));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			writer.close();
		}

	}

	public void deleteEvent(Date date) throws NotExistingDateException 
	{
		EventsList list = new EventsList();
		FileReader reader = null;
		PrintWriter writer = null;
		XStream xstream = new XStream();
		boolean flag = false;
		
		try
		{
			reader = new FileReader("Events.xml");
			xstream.alias("event", Event.class);
			xstream.alias("events", EventsList.class);
			xstream.addImplicitCollection(EventsList.class, "events", Event.class);
			DateConverter dateConverter = new DateConverter("yyyy-MM-dd HH:mm:ss", new String[] {});
			xstream.registerConverter(dateConverter);
			list = (EventsList) xstream.fromXML(reader);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.getEvents().size(); i++)
		{
			if(list.getEvents().get(i).getDate().equals(date))
			{
				flag = true;
				list.getEvents().remove(i);
			}
		}
		
		if(flag)
		{
			throw new NotExistingDateException();
		}
		
		
		try 
		{
			writer = new PrintWriter("Events.xml");
			writer.println(xstream.toXML(list));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			writer.close();
		}

	}

	public void updateEvent(String name, Event newEvent) throws NotExistingNameException 
	{
		EventsList list = new EventsList();
		FileReader reader = null;
		PrintWriter writer = null;
		XStream xstream = new XStream();
		boolean flag = false;
		
		try
		{
			reader = new FileReader("Events.xml");
			xstream.alias("event", Event.class);
			xstream.alias("events", EventsList.class);
			xstream.addImplicitCollection(EventsList.class, "events", Event.class);
			DateConverter dateConverter = new DateConverter("yyyy-MM-dd HH:mm:ss", new String[] {});
			xstream.registerConverter(dateConverter);
			list = (EventsList) xstream.fromXML(reader);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.getEvents().size(); i++)
		{
			if(list.getEvents().get(i).getName().equals(name))
			{
				flag = true;
				list.getEvents().remove(i);
			}
		}
		
		if(flag)
		{
			throw new NotExistingNameException();
		}
		
		list.getEvents().add(newEvent);
		
		try 
		{
			writer = new PrintWriter("Events.xml");
			writer.println(xstream.toXML(list));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			writer.close();
		}

	}

	public void updateEvent(Date date, Event newEvent) throws NotExistingDateException 
	{
		EventsList list = new EventsList();
		FileReader reader = null;
		PrintWriter writer = null;
		XStream xstream = new XStream();
		boolean flag = false;
		
		try
		{
			reader = new FileReader("Events.xml");
			xstream.alias("event", Event.class);
			xstream.alias("events", EventsList.class);
			xstream.addImplicitCollection(EventsList.class, "events", Event.class);
			DateConverter dateConverter = new DateConverter("yyyy-MM-dd HH:mm:ss", new String[] {});
			xstream.registerConverter(dateConverter);
			list = (EventsList) xstream.fromXML(reader);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<list.getEvents().size(); i++)
		{
			if(list.getEvents().get(i).getDate().equals(date))
			{
				flag = true;
				list.getEvents().remove(i);
			}
		}
		
		if(flag)
		{
			throw new NotExistingDateException();
		}
		
		list.getEvents().add(newEvent);
		
		try 
		{
			writer = new PrintWriter("Events.xml");
			writer.println(xstream.toXML(list));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			writer.close();
		}

	}

}

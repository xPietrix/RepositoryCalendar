package PiotrFilip.Calendar;

import java.io.File;
import java.io.FileNotFoundException;    
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.StreamException;

public class XMLRepository implements DataRepository
{
	public Event getEvent(String name) throws NotExistingNameException 
	{
		
		EventsList list = new EventsList();
		FileReader reader = null;
		PrintWriter writer = null;
		
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
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (StreamException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (ConversionException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
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
		PrintWriter writer = null;
		
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
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (StreamException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (ConversionException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
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
		PrintWriter writer = null;
		
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
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (StreamException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (ConversionException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
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
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		} 
		catch (StreamException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (ConversionException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
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
		List<Event> listPom = new ArrayList<Event>();
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
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (StreamException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (ConversionException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
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
			if(!list.getEvents().get(i).getName().equals(name))
			{
				listPom.add(list.getEvents().get(i));
			}
		}
		
		if(list.getEvents().size() == listPom.size())
		{
			throw new NotExistingNameException();
		}
		
		list.setEvents(listPom);
		
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
		List<Event> listPom = new ArrayList<Event>();
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
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (StreamException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (ConversionException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
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
			if(!list.getEvents().get(i).getDate().equals(date))
			{
				listPom.add(list.getEvents().get(i));
			}
		}
		
		if(list.getEvents().size() == listPom.size())
		{
			throw new NotExistingDateException();
		}
		
		list.setEvents(listPom);
		
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
		List<Event> listPom = new ArrayList<Event>();
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
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (StreamException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (ConversionException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
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
			if(!list.getEvents().get(i).getName().equals(name))
			{
				listPom.add(list.getEvents().get(i));
			}
		}
		
		if(list.getEvents().size() == listPom.size())
		{
			throw new NotExistingNameException();
		}
		
		list.setEvents(listPom);
		
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
		List<Event> listPom = new ArrayList<Event>();
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
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (StreamException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
		}
		catch (ConversionException e) 
		{
			File file = new File("Events.xml");
			try
			{
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println("<events>");
				writer.println("</events>");
				writer.close();
				
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Tworzenie nowego pliku na dane - ponów próbę");
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
			if(!list.getEvents().get(i).getDate().equals(date))
			{
				listPom.add(list.getEvents().get(i));
			}
		}
		
		if(list.getEvents().size() == listPom.size())
		{
			throw new NotExistingDateException();
		}
		
		list.setEvents(listPom);
		
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

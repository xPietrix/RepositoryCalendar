package PiotrFilip.Calendar;

import java.util.ArrayList;
import java.util.Date; 
import java.util.List;

public class DataService {
	
	private DataRepository dataRepo;
	
	public DataService(DataRepository dataRepo)
	{
		this.dataRepo = dataRepo;
	}
	
	/// CRUD
	
	public Event getEvent(String name) throws NotExistingNameException
	{
		try 
		{
			return dataRepo.getEvent(name);
		} 
		catch (NotExistingNameException e) 
		{
			throw e;
		}
	}
	
	public Event getEvent(Date date) throws NotExistingDateException
	{
		try 
		{
			return dataRepo.getEvent(date);
		}
		catch (NotExistingDateException e)
		{
			throw e;
		}
	}
	
	public List<Event> getEventList() 
	{
		return dataRepo.getAllEvents();
	}
	
	public void addEvent(String name, String description, Date date, String place)
	{
		Event newEvent = new Event(name, description, date, place);
		dataRepo.addEvent(newEvent);
	}
	
	public void deleteEvent(String name) throws NotExistingNameException
	{
		try 
		{
			dataRepo.deleteEvent(name);
		} 
		catch (NotExistingNameException e) 
		{
			throw e;
		}
	}
	
	public void deleteEvent(Date date) throws NotExistingDateException
	{
		try {
			dataRepo.deleteEvent(date);
		} 
		catch (NotExistingDateException e)
		{
			throw e;
		}
	}
	
	public void updateEvent(String prevName, String name, String description, Date date, String place) throws NotExistingNameException
	{
		try {
			dataRepo.deleteEvent(prevName);
		} 
		catch (NotExistingNameException e)
		{
			throw e;
		}
		
		Event newEvent = new Event(name, description, date, place);
		dataRepo.addEvent(newEvent);
	}
	
	public void updateEvent(Date prevDate, String name, String description, Date date, String place) throws NotExistingDateException
	{
		try {
			dataRepo.deleteEvent(prevDate);
		} 
		catch (NotExistingDateException e)
		{
			throw e;
		}
		
		Event newEvent = new Event(name, description, date, place);
		dataRepo.addEvent(newEvent);
	}
	
	/// Filtrowanie
	
	public List<Event> getEventsByPlace(String place)
	{
		List<Event> eventList = dataRepo.getAllEvents();
		for(int i=0; i<eventList.size(); i++)
		{
			if(!eventList.get(i).getPlace().equals(place))
			{
				eventList.remove(i);
			}
		}
		return eventList;
	}
	
	public List<Event> getEventsByDates(Date from, Date to)
	{
		List<Event> eventList = dataRepo.getAllEvents();
		List<Event> eventListPom = new ArrayList<Event>();
		
		for(int i=0; i<eventList.size(); i++)
		{
			
			if(eventList.get(i).getDate().after(from) && eventList.get(i).getDate().before(to))
			{
				eventListPom.add(eventList.get(i));
			}
		}
		
		return eventListPom;
	}
	
	public void removeEventsOlderThan(Date when)
	{
		List<Event> eventList = dataRepo.getAllEvents();
		for(int i=0; i<eventList.size(); i++)
		{
			if(eventList.get(i).getDate().before(when))
			{
				try
				{
					dataRepo.deleteEvent(eventList.get(i).getDate());
				} 
				catch (NotExistingDateException e)
				{
					System.out.println("XD");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void exportToICal()
	{
		ICalExporter exporter = new ICalExporter(this);
		exporter.export();
	}
	
	public Event getClosestEventFromNow() throws NoEventsException 
	{
		List<Event> eventList = dataRepo.getAllEvents();
		List<Event> eventListPom = new ArrayList<Event>();
		
		if(eventList.size() == 0)
		{
			throw new NoEventsException();
		}
		
		for(int i=0; i<eventList.size(); i++)
		{
			
			if(eventList.get(i).getDate().after(new Date()))
			{
				eventListPom.add(eventList.get(i));
			}
		}
		
		eventList = eventListPom;
		Event eventToReturn = eventList.get(0);
		for(int i=1; i<eventList.size(); i++)
		{
			if(eventToReturn.getDate().after(eventList.get(i).getDate()))
			{
				eventToReturn = eventList.get(i);
			}
		}
		return eventToReturn;
	}

}

package PiotrFilip.Calendar;

import java.util.ArrayList;
import java.util.Date; 
import java.util.List;

public class DataService 
{
	
	private DataRepository dataRepo;
	
	/**
	 * Konstruktor tworzacy nowy obiekt klasy DataService
	 * @param dataRepo repozytorium 
	 */
	public DataService(DataRepository dataRepo)
	{
		this.dataRepo = dataRepo;
	}
	
	/**
	 * Metoda zwracajaca wydarzenia o podanej nazwie
	 * @param name nazwa wydarzenia
	 * @return zwraca nazwe wydarzenia
	 * @throws NotExistingNameException wyjatek rzucany, gdy nie wystepuje wydarzenie o danej nazwie
	 */
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
	
	/**
	 * Metoda zwracajaca wydarzenie o podanej dacie
	 * @param date data wydarzenia
	 * @return zwraca wydarzenie o podanej dacie
	 * @throws NotExistingDateException wyjatek rzucany, gdy nie wystepuje wydarzenie o danej dacie
	 */
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
	
	/**
	 * Metoda zwracajaca liste wszystkich wydarzen
	 * @return lista wszystkich wydarzen
	 */
	public List<Event> getEventList() 
	{
		return dataRepo.getAllEvents();
	}
	
	/**
	 * Metoda dodajaca wydarzenie o podanych danych do repozytorium
	 * @param name nazwa wydarzenia
	 * @param description opis wydarzenia
	 * @param date data wydarzenia 
	 * @param place miejsce wydarzenia
	 */
	public void addEvent(String name, String description, Date date, String place)
	{
		Event newEvent = new Event(name, description, date, place);
		dataRepo.addEvent(newEvent);
	}
	
	/**
	 * Metoda usuwajaca wydarzenie o podanej nazwie
	 * @param name nazwa usuwanego wydarzenia
	 * @throws NotExistingNameException wyjatek rzucany, gdy nie wystepuje wydarzenie o danej nazwie 
	 */
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
	
	/**
	 * Metoda usuwajaca wydarzenie o podanej dacie
	 * @param date data wydarzenia, ktore chcemy usunac
	 * @throws NotExistingDateException wyjatek rzucany, gdy nie wystepuje w repozytorium wydarzenie o podanej dacie
	 */
	public void deleteEvent(Date date) throws NotExistingDateException
	{
		try 
		{
			dataRepo.deleteEvent(date);
		} 
		catch (NotExistingDateException e)
		{
			throw e;
		}
	}
	
	/**
	 * Metoda uaktualniajaca nazwe podanego wydarzenia 
	 * @param prevName nazwa uaktualnianego wydarzenia
	 * @param name nowa nazwa wydarzenia
	 * @param description opis wydarzenia
	 * @param date data wydarzenia
	 * @param place miejsce wydarzenia
	 * @throws NotExistingNameException wyjatek rzucany, gdy nie wystepuje w repozytorium wydarzenie o danej nazwie
	 */
	public void updateEvent(String prevName, String name, String description, Date date, String place) throws NotExistingNameException
	{
		try
		{
			dataRepo.deleteEvent(prevName);
		} 
		catch (NotExistingNameException e)
		{
			throw e;
		}
		
		Event newEvent = new Event(name, description, date, place);
		dataRepo.addEvent(newEvent);
	}
	
	/**
	 * Metoda uaktualniajca date danego wydarzenia
	 * @param prevDate data uaktualnianego wydarzenia
	 * @param name nowa nazwa wydarzenia
	 * @param description opis wydarzenia
	 * @param date data wydarzenia
	 * @param place miejsce wydarzenia
	 * @throws NotExistingDateException wyjatek rzucany, gdy nie wystepuje w repozytorium wydarzenie o danej dacie
	 */
	public void updateEvent(Date prevDate, String name, String description, Date date, String place) throws NotExistingDateException
	{
		try 
		{
			dataRepo.deleteEvent(prevDate);
		} 
		catch (NotExistingDateException e)
		{
			throw e;
		}
		
		Event newEvent = new Event(name, description, date, place);
		dataRepo.addEvent(newEvent);
	}
	

	/**
	 * Metoda zwracajaca wydarzenia o danym miejscu
	 * @param place miejce wydarzenia
	 * @return lista wydarzen o danym miejscu
	 */
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
	
	/**
	 * Metoda zwracajaca wydarzenia pomiedzy danymi datami
	 * @param from data poczatkowa 
	 * @param to data koncowa
	 * @return lista wydarzen pomiedzy danymi datami
	 */
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
	
	/**
	 * Metoda usuwajaca wydarzenia starsze niz podana data
	 * @param when data wydarzenia
	 */
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
	
	/**
	 * Metoda eksportujaca wydarzenia do formatu ICallendar
	 */
	public void exportToICal()
	{
		ICalExporter exporter = new ICalExporter(this);
		exporter.export();
	}
	
	/**
	 * Metoda zwracaja najblizsze w czasie wydarzenie
	 * @return najwczesniejsze wydarzenie
	 * @throws NoEventsException wyjatek rzucany, gdy nie ma najblizszego w czasie wydarzenia
	 */
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
		
		if(eventList.size() == 0)
		{
			throw new NoEventsException();
		}
		
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
	
	/**
	 * Metoda zwracaja wydarzenia od najwczesniejszego do najpozniejszego
	 * @return posortowana lista wydarzen
	 */
	public List<Event> getSortedEventList()
	{
		ArrayList<Event> eventList = (ArrayList<Event>) dataRepo.getAllEvents();
		eventList.sort(new DateComparator());
		return eventList;
	}
	
	public void clearEvents()
	{
		dataRepo.clear();
	}

}

package PiotrFilip.Calendar;

import java.util.ArrayList; 
import java.util.List;

public class EventsList {
	
	private List<Event> events = new ArrayList<Event>();
	
	/**
	 * Metoda zwracajaca liste wydarzen
	 * @return lista wydarzen
	 */
	public List<Event> getEvents()
	{
		return events;
	}
	
	/**
	 * Metoda przypisania listy wydarzen
	 * @param events lista wydarzen
	 */
	public void setEvents(List<Event> events)
	{
		this.events = events;
	}

}

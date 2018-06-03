package com.PiotrekFilipCalendar.komponentowe;

import java.util.ArrayList;
import java.util.List;

public class EventsList {
	
	private List<Event> events = new ArrayList<Event>();
	
	public List<Event> getEvents()
	{
		return events;
	}
	
	public void setEvents(List<Event> events)
	{
		this.events = events;
	}

}

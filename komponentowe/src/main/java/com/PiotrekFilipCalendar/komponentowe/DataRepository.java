package com.PiotrekFilipCalendar.komponentowe;

import java.util.Date; 
import java.util.List;

public interface DataRepository 
{
	public Event getEvent(String name) throws NotExistingNameException;
	public Event getEvent(Date date) throws NotExistingDateException;
	public List<Event> getAllEvents();
	public void addEvent(Event newEvent);
	public void deleteEvent(String name) throws NotExistingNameException;
	public void deleteEvent(Date date) throws NotExistingDateException;
	public void updateEvent(String name, Event newEvent) throws NotExistingNameException;
	public void updateEvent(Date date, Event newEvent) throws NotExistingDateException;

}

package PiotrFilip.Calendar;

import java.util.Date;  
import java.util.List;

public interface DataRepository 
{
	/**
	 * Metoda zwraca z repozytorium rzadane wydarzenie po nazwie
	 * @param name nazwa wydarzenia
	 * @return oczekiwane wydarzenie
	 * @throws NotExistingNameException Wyjatek rzucany w momencie nie wystepowania podanej nazwy na liscie nazw wydarzen w repozytorium
	 */
	public Event getEvent(String name) throws NotExistingNameException;
	/**
	 * Metoda zwraca z repozytorium rzadane wydarzenie po dacie
	 * @param date data wydarzenia
	 * @return oczekiwane wydarzenie
	 * @throws NotExistingDateException Wyjatek rzucany w momencie nie wystepowania podanej daty na liscie dat wydarzen w repozytorium
	 */
	public Event getEvent(Date date) throws NotExistingDateException;
	/**
	 * Metoda zwraca liste wszystkich wydarzen z repozytorium
	 * @return lista wydarzen
	 */
	public List<Event> getAllEvents();
	/**
	 * Metoda dodaje nowe wydarzenie do repozytorium
	 * @param newEvent nowe wydarzenie do dodania
	 */
	public void addEvent(Event newEvent);
	/**
	 * Metoda usuwa wydarzenie o podanej nazwie
	 * @param name nazwa wydarzenia do usuniecia
	 * @throws NotExistingNameException Wyjatek rzucany w momencie nie wystepowania podanej nazwy na liscie nazw wydarzen w repozytorium
	 */
	public void deleteEvent(String name) throws NotExistingNameException;
	/**
	 * Metoda usuwa wydarzenie o podanej dacie
	 * @param date data wydarzenia do usuniecia
	 * @throws NotExistingDateException Wyjatek rzucany w momencie nie wystepowania podanej daty na liscie dat wydarzen w repozytorium
	 */
	public void deleteEvent(Date date) throws NotExistingDateException;
	/**
	 * Metoda zamieniajaca podane wydarzenie na nowe
	 * @param name nazwa wydarzenia do zamiany
	 * @param newEvent nowe wydarzenie
	 * @throws NotExistingNameException Wyjatek rzucany w momencie nie wystepowania podanej nazwy na liscie nazw wydarzen w repozytorium
	 */
	public void updateEvent(String name, Event newEvent) throws NotExistingNameException;
	/**
	 * @param date data wydarzenia do zamiany
	 * @param newEvent nowe wydarzenie
	 * @throws NotExistingDateException Wyjatek rzucany w momencie nie wystepowania podanej daty na liscie dat wydarzen w repozytorium
	 */
	public void updateEvent(Date date, Event newEvent) throws NotExistingDateException;
	
	public void clear();

}

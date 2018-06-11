package PiotrFilip.Calendar;

import java.text.SimpleDateFormat;   
import java.util.Date;

/**
 * Klasa reprezentujaca wydarzenie
 *
 */
public class Event 
{
	private String name;
	private String description;
	private Date date;
	private String place;

	/**
	 * Konstruktor klasy Event tworzacy nowe wydarzenie z podanych danych
	 * @param name nazwa wydarzenia
	 * @param description opis wydarzenia 
	 * @param date data wydarzenia
	 * @param place miejsce wydarzenia
	 */
	public Event(String name, String description, Date date, String place)
	{
		this.name = name;
		this.description = description;
		this.date = date;
		this.place = place;
	}
	
	/**
	 * Konstruktor klasy Event tworzacy nowe wydarzenie z ustawieniem null 
	 */
	public Event() 
	{
		this.name = null;
		this.description = null;
		this.date = null;
		this.place = null;
	}

	/**
	 * Metoda zwracajaca nazwe wydarzenia
	 * @return zwraca nazwe
	 */
	public String getName()
	{
		return name;
	}
	 
	
	/**
	 * Metoda ustawiajaca nowa nazwe wydarzenia
	 * @param newName nowa nazwa wydarzenia
	 */
	public void setName(String newName)
	{
		name = newName;
	}
	
	/**
	 * Metoda zwracajaca opis wydarzenia
	 * @return zwraca opis wydarzenia
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * Metoda ustawiajaca opis wydarzenia
	 * @param newDescription opis wydarzenia
	 */
	public void setDescription(String newDescription)
	{
		description = newDescription;
	}
	
	/**
	 * Metoda zwracajaca date wydarzenia
	 * @return zwraca date wydarzenia
	 */
	public Date getDate()
	{
		return date;
	}
	
	public String getMySqlDate()
	{
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}
	
	/**
	 * Metoda ustawiajaca date wydarzenia
	 * @param newDate data wydarzenia
	 */
	public void setDate(Date newDate)
	{
		date = newDate;
	}
	
	/**
	 * Metoda zwracajaca miejsce wydarzenia
	 * @return zwraca miejce wydarzenia
	 */
	public String getPlace()
	{
		return place;
	}
	
	
	/**
	 * Metoda ustawiajaca miejsce wydarzenia
	 * @param newPlace miejsce wydarzenia
	 */
	public void setPlace(String newPlace)
	{
		place = newPlace;
	}
	
	public String toString()
	{
		String event = name + "  " + place + "  " + date.toString() + "  " + description;
		return event;
	}

}

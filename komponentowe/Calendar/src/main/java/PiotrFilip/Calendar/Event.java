package PiotrFilip.Calendar;

import java.text.SimpleDateFormat;   
import java.util.Date;

public class Event {
	
	private String name;
	private String description;
	private Date date;
	private String place;

	public Event(String name, String description, Date date, String place)
	{
		this.name = name;
		this.description = description;
		this.date = date;
		this.place = place;
	}
	
	public Event() {
		this.name = null;
		this.description = null;
		this.date = null;
		this.place = null;
	}

	public String getName()
	{
		return name;
	}
	 
	public void setName(String newName)
	{
		name = newName;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String newDescription)
	{
		description = newDescription;
	}
	
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
	
	public void setDate(Date newDate)
	{
		date = newDate;
	}
	
	public String getPlace()
	{
		return place;
	}
	
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

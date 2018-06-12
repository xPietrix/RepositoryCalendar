package PiotrFilip.Calendar;

import java.util.Comparator;

public class DateComparator implements Comparator<Event> 
{

	public int compare(Event arg0, Event arg1) 
	{
		return arg0.getDate().compareTo(arg1.getDate());
	}

}

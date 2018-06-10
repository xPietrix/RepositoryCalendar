package PiotrFilip.Calendar;

import java.io.File; 
import java.io.IOException;
import java.util.Date;
import java.util.List;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.property.Summary;
import biweekly.util.Duration;

public class ICalExporter {
	
	DataService service;
	
	ICalExporter(DataService service)
	{
		this.service = service;
	}
	
	void export()
	{
		ICalendar ical = new ICalendar();
		List<Event> list = service.getEventList();
		VEvent event;
		
		for(int i=0; i<list.size(); i++)
		{
			event = new VEvent();
			Summary summary = event.setSummary(list.get(i).getName());
			summary.setLanguage("en-us");
			event.addComment(list.get(i).getName());
			Date start = list.get(i).getDate();
			event.setDateStart(start);
			Duration duration = new Duration.Builder().minutes(1).build();
			event.setDuration(duration);
			ical.addEvent(event);
		}
		
		File file = new File("meeting.ics");
		try 
		{
			Biweekly.write(ical).go(file);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

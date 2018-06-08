package PiotrFilip.Calendar;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JList;

@SuppressWarnings("serial")
public class EventsReaderWindow extends JFrame 
{
	JPanel contentPane;
	DataService service;
	UserInterface userInterface;
	JList<?> list;
	
	public EventsReaderWindow(DataService Service, UserInterface userInterface) 
	{
		this.service = Service;
		this.userInterface = userInterface; 
		
		setBounds(100, 100, 1021, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList<Object>();
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(34, 26, 937, 577);
		contentPane.add(list);
		refreshList(Service, userInterface);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	private void refreshList(DataService Service, UserInterface userInterface)
	{
		@SuppressWarnings("rawtypes")
		DefaultListModel dlm = new DefaultListModel();
		
		ArrayList <Event> eventsList;
		Date from = new Date();
		Date to = new Date();
		
		from.setYear(userInterface.calendar.getDate().getYear());
		from.setMonth(userInterface.calendar.getDate().getMonth());
		from.setDate(userInterface.calendar.getDate().getDate());
		from.setHours(0);
		from.setMinutes(0);
		from.setSeconds(0);
		
		to.setYear(userInterface.calendar.getDate().getYear());
		to.setMonth(userInterface.calendar.getDate().getMonth());
		to.setDate(userInterface.calendar.getDate().getDate());
		to.setHours(23);
		to.setMinutes(59);
		to.setSeconds(59);
		
		eventsList = (ArrayList<Event>) userInterface.service.getEventsByDates(from, to);
		
		System.out.println(eventsList);
		
		for(Event event: eventsList)
		{
				dlm.addElement(event.getName());	
				dlm.addElement(event.getDate().toString());
				dlm.addElement(event.getDescription());
				dlm.addElement(" ");
		}
		
		list.setModel(dlm);
	}
	
}
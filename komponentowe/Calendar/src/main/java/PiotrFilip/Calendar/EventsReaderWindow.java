package PiotrFilip.Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JList;

public class EventsReaderWindow extends JFrame 
{
	JPanel contentPane;
	DataService Service;
	UserInterface userInterface;
	JList<?> list;
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EventsReaderWindow(DataService Service, UserInterface userInterface) 
	{
		this.Service = Service;
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

	@SuppressWarnings("deprecation")
	private void refreshList(DataService Service, UserInterface userInterface)
	{
		DefaultListModel dlm = new DefaultListModel();
		
		ArrayList <Event> EventsList;
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
		
		EventsList = (ArrayList<Event>) userInterface.Service.getEventsByDates(from, to);
		
		System.out.println(EventsList);
		
		for(Event event: EventsList)
		{
				dlm.addElement(event.getName());	
				dlm.addElement(event.getDate().toString());
				dlm.addElement(event.getDescription());
				dlm.addElement(" ");
		}
		
		list.setModel(dlm);
	}
	
}

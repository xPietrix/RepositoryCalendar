package PiotrFilip.Calendar;

import java.awt.event.ActionEvent;   
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener
{
	JButton SaveButton;
	AddEventWindow AddWindow;
	UserInterface userInterface;
	EventsReaderWindow eventsReaderWindow;
	DeleteEventsWindow deleteEventsWindow;
	
	public ButtonListener(UserInterface userInterface)
	{
		this.userInterface = userInterface;
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) 
	{
		Date date;
		
		String name, place, description;
		String hour;
		int hours;
		
		if(e.getSource() == userInterface.AddWindowItem)
		{
			AddWindow = new AddEventWindow(userInterface.Service, userInterface.buttonListener);
			AddWindow.setVisible(true);
		}
		else if(e.getSource() == userInterface.SetXML)
		{
			System.out.println("zmienilo sie na XML");
			userInterface.changeToXml();
		}
		else if(e.getSource() == userInterface.SetSQL)
		{
			System.out.println("zmienilo sie na SQL");
			userInterface.changeToSQL();
		}
		else if(e.getSource() == userInterface.RefreshButton)
		{
			eventsReaderWindow = new EventsReaderWindow(userInterface.Service, userInterface);
			eventsReaderWindow.setVisible(true);
			
		}
		else if(e.getSource() == userInterface.DeleteWindowItem)
		{
			deleteEventsWindow = new DeleteEventsWindow(userInterface) ;
			deleteEventsWindow.setVisible(true);
			
		} 
		
		else if(e.getSource() == deleteEventsWindow.DeleteButton)
		{
			String nameToDelete = deleteEventsWindow.textField.getText();
			System.out.println("XDD");
			try 
			{
				userInterface.Service.deleteEvent(nameToDelete);
			} 
			catch (NotExistingNameException e1) 
			{
				deleteEventsWindow.textField.setText("Nie ma takiej nazwy");
				e1.printStackTrace();
			}	
		}
		
		else if(e.getSource() == deleteEventsWindow.DeleteOlder)
		{
			System.out.println("XDDAAA");
			date = deleteEventsWindow.dateChooser.getDate();
			userInterface.Service.removeEventsOlderThan(date);
		}
		
		else if(e.getSource() == AddWindow.AddButton)
		{
			System.out.println("SaveButton is working");
			
			try
			{
				name = AddWindow.textField.getText();
				place = AddWindow.textField_1.getText();
				description = AddWindow.textField_2.getText();
				date = AddWindow.dateChooser.getDate();
				hour = (String) AddWindow.comboBox.getSelectedItem(); 
				
				
				AddWindow.Service.addEvent(name, place, date, description);
				
				System.out.println("Data z kalendarza: " + date + "  " + hour);
				
				System.out.println(name);
				System.out.println(place);
				System.out.println(description);
				System.out.println(date);
				
			}
			catch(NumberFormatException excep)
			{
				JOptionPane.showMessageDialog(AddWindow, "Please Enter the Right Info", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(0); 
			}
		}
		
	}
}
package PiotrFilip.Calendar;

import java.awt.event.ActionEvent;    
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener
{
	AddEventWindow addWindow;
	UserInterface userInterface;
	EventsReaderWindow eventsReaderWindow;
	DeleteEventsWindow deleteEventsWindow;
	AboutProgramWindow aboutProgramWindow;
	
	public ButtonListener(UserInterface userInterface)
	{
		this.userInterface = userInterface;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		Date date;
		
		String name, place, description;
		String hour;
		
		if(e.getSource() == userInterface.addWindowItem)
		{
			addWindow = new AddEventWindow(userInterface);
			addWindow.setVisible(true);
		}
		else if(e.getSource() == userInterface.setXML)
		{
			System.out.println("zmienilo sie na XML");
			userInterface.changeToXml();
		}
		else if(e.getSource() == userInterface.setSQL)
		{
			System.out.println("zmienilo sie na SQL");
			userInterface.changeToSQL();
		}
		else if(e.getSource() == userInterface.refreshButton)
		{
			eventsReaderWindow = new EventsReaderWindow(userInterface.service, userInterface);
			eventsReaderWindow.setVisible(true);
			
		}
		else if(e.getSource() == userInterface.deleteWindowItem)
		{
			deleteEventsWindow = new DeleteEventsWindow(userInterface) ;
			deleteEventsWindow.setVisible(true);
			
		} 
		else if(e.getSource() == userInterface.aboutProgramItem)
		{
			aboutProgramWindow = new AboutProgramWindow(userInterface);
			aboutProgramWindow.setVisible(true);
		}
		else if(e.getSource() == addWindow.addButton)
		{
			System.out.println("SaveButton is working");
			
			try
			{
				name = addWindow.textField.getText();
				place = addWindow.textField_1.getText();
				description = addWindow.textField_2.getText();
				date = addWindow.dateChooser.getDate();
				hour = (String) addWindow.comboBox.getSelectedItem(); 
				
				
				addWindow.service.addEvent(name, place, date, description);
				
				System.out.println("Data z kalendarza: " + date + "  " + hour);
				
				System.out.println(name);
				System.out.println(place);
				System.out.println(description);
				System.out.println(date);
			}
			catch(NumberFormatException excep)
			{
				JOptionPane.showMessageDialog(addWindow, "Please Enter the Right Info", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(0); 
			}
		}
		else if(e.getSource() == deleteEventsWindow.deleteButton)
		{
			String nameToDelete = deleteEventsWindow.textField.getText();
			System.out.println("XDD");
			try 
			{
				userInterface.service.deleteEvent(nameToDelete);
			} 
			catch (NotExistingNameException e1) 
			{
				deleteEventsWindow.textField.setText("Nie ma takiej nazwy");
				e1.printStackTrace();
			}	
		}
		else if(e.getSource() == deleteEventsWindow.deleteOlder)
		{
			System.out.println("XDDAAA");
			date = deleteEventsWindow.dateChooser.getDate();
			userInterface.service.removeEventsOlderThan(date);
		}
		
	}
}
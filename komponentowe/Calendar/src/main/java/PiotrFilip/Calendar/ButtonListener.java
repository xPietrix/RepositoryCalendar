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
	AlarmSettingsWindow alarmSettingsWindow;
	
	public ButtonListener(UserInterface userInterface)
	{
		this.userInterface = userInterface;
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) 
	{
		Date date;
		String name, place, description, stringHour, stringMinutes;
		int hour, minutes;
		
		if(e.getSource() == userInterface.addWindowItem)
		{
			addWindow = new AddEventWindow(userInterface);
			deleteEventsWindow = new DeleteEventsWindow(userInterface);
			alarmSettingsWindow = new AlarmSettingsWindow(userInterface);
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
		else if(e.getSource() == userInterface.export)
		{
			userInterface.service.exportToICal();
		}
		else if(e.getSource() == userInterface.setAlarm)
		{
			alarmSettingsWindow = new AlarmSettingsWindow(userInterface);
			addWindow = new AddEventWindow(userInterface);
			deleteEventsWindow = new DeleteEventsWindow(userInterface);
			alarmSettingsWindow.setVisible(true);
		}
		
		else if(e.getSource() == userInterface.refreshButton)
		{
			eventsReaderWindow = new EventsReaderWindow(userInterface.service, userInterface);
			eventsReaderWindow.setVisible(true);
			
		}
		else if(e.getSource() == userInterface.deleteWindowItem)
		{
			addWindow = new AddEventWindow(userInterface);
			deleteEventsWindow = new DeleteEventsWindow(userInterface);
			alarmSettingsWindow = new AlarmSettingsWindow(userInterface);
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
				stringHour = (String) addWindow.hoursComboBox.getSelectedItem();
				stringMinutes = (String) addWindow.minutesComboBox.getSelectedItem();
				System.out.println("Data z kalendarza: " + date);
				hour = Integer.parseInt(stringHour);
				minutes = Integer.parseInt(stringMinutes);
				date.setHours(hour);
				date.setMinutes(minutes);
				
				addWindow.service.addEvent(name, place, date, description);
				
				System.out.println("Data ze zmieniona godzina: " + date);
			}
			catch(NumberFormatException excep)
			{
				JOptionPane.showMessageDialog(addWindow, "Please Enter the Right Info", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(0); 
			}
		}
		else if(e.getSource() == alarmSettingsWindow.confirmButton)
		{
			String alarmMinutesString;
			int alarmMinutes;
			
			alarmMinutesString = (String) alarmSettingsWindow.minutesChooser.getSelectedItem();
			System.out.println("Alarm zostal ustawiony na " + alarmMinutesString + " minut przed wydarzeniem");	
			alarmMinutes = Integer.parseInt(alarmMinutesString);
			
		}
		else if(e.getSource() == deleteEventsWindow.deleteButton)
		{
			String nameToDelete = deleteEventsWindow.textField.getText();
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
			date = deleteEventsWindow.dateChooser.getDate();
			System.out.println(date);
			userInterface.service.removeEventsOlderThan(date);
		}
		
	}
}
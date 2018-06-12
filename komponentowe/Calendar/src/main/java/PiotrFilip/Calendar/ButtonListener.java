package PiotrFilip.Calendar;

import java.awt.event.ActionEvent;    
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;


/**
 * @author Piotr Wasiak, Filip Florczyk
 *
 */
public class ButtonListener implements ActionListener
{
	
	/**
	 *  Obiekt klasy AddEventWindow - okno dodawania nowych wydarzen
	 */
	public AddEventWindow addWindow;
	/**
	 * Obiekt klasy UserInterface - glowne okno programu
	 */
	public UserInterface userInterface;
	/**
	 * Obiekt klasy EventsReaderWindow - okno wyswietlania wydarzen
	 */
	public EventsReaderWindow eventsReaderWindow;
	/**
	 * Obiekt klasy DeleteEventsWindow - Okno usuwania wydarzen
	 */
	public DeleteEventsWindow deleteEventsWindow;
	/**
	 * Obiekt klasy AboutProgramWindow - Okno wyswietlania informacji o programie
	 */
	public AboutProgramWindow aboutProgramWindow;
	/**
	 * Obiekt klasy AlarmSettingsWindow - Okno ustawien alarmu
	 */
	public AlarmSettingsWindow alarmSettingsWindow;
	
	
	/**
	 * Konstruktor klasy ButtonListener
	 * @param userInterface - glowne okno programu
	 */
	public ButtonListener(UserInterface userInterface)
	{
		this.userInterface = userInterface;
		alarmSettingsWindow = new AlarmSettingsWindow(userInterface);
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) 
	{
		Date date;
		String name, place, description, stringHour, stringMinutes;
		int hour, minutes;
		
		if(e.getSource() == userInterface.addWindowItem)
		{
			addWindow = new AddEventWindow(userInterface);
			deleteEventsWindow = new DeleteEventsWindow(userInterface);
			addWindow.setVisible(true);
		}
		else if(e.getSource() == userInterface.setXML)
		{
			userInterface.changeToXml();
		}
		else if(e.getSource() == userInterface.setSQL)
		{
			userInterface.changeToSQL();
		}
		else if(e.getSource() == userInterface.export)
		{
			userInterface.service.exportToICal();
		}
		else if(e.getSource() == userInterface.setAlarm)
		{
			alarmSettingsWindow.setVisible(true);
		}
		
		else if(e.getSource() == userInterface.refreshButton)
		{
			eventsReaderWindow = new EventsReaderWindow(userInterface.service, userInterface, true);
			eventsReaderWindow.setVisible(true);
			userInterface.alarm.set(alarmSettingsWindow.getAlarmSetting());
		}
		else if(e.getSource() == userInterface.showAllButton)
		{
			eventsReaderWindow = new EventsReaderWindow(userInterface.service, userInterface, false);
			eventsReaderWindow.setVisible(true);
			userInterface.alarm.set(alarmSettingsWindow.getAlarmSetting());
		}
		else if(e.getSource() == userInterface.deleteWindowItem)
		{
			addWindow = new AddEventWindow(userInterface);
			deleteEventsWindow = new DeleteEventsWindow(userInterface);
			deleteEventsWindow.setVisible(true);
			
		} 
		else if(e.getSource() == userInterface.aboutProgramItem)
		{
			aboutProgramWindow = new AboutProgramWindow(userInterface);
			aboutProgramWindow.setVisible(true);
		}
		else if(e.getSource() == addWindow.addButton)
		{	
			try
			{
				name = addWindow.textField.getText();
				place = addWindow.textField_1.getText();
				description = addWindow.textField_2.getText();
				date = addWindow.dateChooser.getDate();
				stringHour = (String) addWindow.hoursComboBox.getSelectedItem();
				stringMinutes = (String) addWindow.minutesComboBox.getSelectedItem();
				hour = Integer.parseInt(stringHour);
				minutes = Integer.parseInt(stringMinutes);
				date.setHours(hour);
				date.setMinutes(minutes);
				date.setSeconds(0);
				
				addWindow.service.addEvent(name, place, date, description);
			}
			catch(NumberFormatException excep)
			{
				JOptionPane.showMessageDialog(addWindow, "Please Enter the Right Info", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(0); 
			}
			userInterface.alarm.set(alarmSettingsWindow.getAlarmSetting());
		}
		else if(e.getSource() == alarmSettingsWindow.confirmButton)
		{
			String alarmMinutesString;
			int alarmMinutes;
			
			alarmMinutesString = (String) alarmSettingsWindow.minutesChooser.getSelectedItem();	
			alarmMinutes = Integer.parseInt(alarmMinutesString);
			userInterface.alarm.set(alarmSettingsWindow.getAlarmSetting());
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
			userInterface.alarm.set(alarmSettingsWindow.getAlarmSetting());
		}
		else if(e.getSource() == deleteEventsWindow.deleteOlder)
		{
			date = deleteEventsWindow.dateChooser.getDate();
			date.setHours(Integer.parseInt((String) deleteEventsWindow.comboBox.getSelectedItem()));
			date.setMinutes(0);
			date.setSeconds(0);
			userInterface.service.removeEventsOlderThan(date);
			userInterface.alarm.set(alarmSettingsWindow.getAlarmSetting());
		}
	}
}
package PiotrFilip.Calendar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import fr.dyade.jdring.AlarmEntry;
import fr.dyade.jdring.AlarmListener;
import fr.dyade.jdring.AlarmManager;
import fr.dyade.jdring.PastDateException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Alarm {
	
	private UserInterface userInterface;
	AlarmManager mgr;
	AlarmWindow window;
	
	/**
	 * Konstruktor tworzacy obiekt klasy Alarm
	 * @param userInterface obiekt glownego okna aplikacji
	 */
	Alarm (UserInterface userInterface)
	{
		this.userInterface = userInterface;
		mgr = new AlarmManager();
	}
	
	/**
	 * Metoda ustawiajaca alarm na najblizsze wydarzenia wraz z uwzglednieniem wydarzenia
	 * @param antyDelayMinutes opoznienie w minutach dla aktywacji alarmu
	 */
	public void set(final int antyDelayMinutes)
	{
		
		Event event = null;
		
		try
		{
			event = userInterface.service.getClosestEventFromNow();
		}
		catch(NoEventsException e)
		{
			
		}
		
		final String text = event.getName() + "\n" + event.getDescription() + "\n" + event.getPlace();
		
		try
		{
			Date date = new Date(event.getDate().getTime() - antyDelayMinutes * 60 * 1000);
			mgr.addAlarm(date,
			           new AlarmListener() 
			{
				public void handleAlarm(AlarmEntry entry) 
				{
					try 
					{
						Player player = new Player(new FileInputStream("alarm.mp3"));
						window = new AlarmWindow(userInterface, antyDelayMinutes, text);
						window.setVisible(true);
						player.play();
					} 
					catch (FileNotFoundException e)
					{
						e.printStackTrace();
					} 
					catch (JavaLayerException e) 
					{
						e.printStackTrace();
					}
				}
			});
		} 
		catch (PastDateException e) 
		{
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			
		}
	}
}



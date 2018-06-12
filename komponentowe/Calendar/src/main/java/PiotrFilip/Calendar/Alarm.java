package PiotrFilip.Calendar;

import java.awt.Toolkit;
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
	
	/**
	 * Konstruktor tworzacy obiekt klasy Alarm
	 * @param userInterface obiekt glownego okna aplikacji
	 */
	Alarm (UserInterface userInterface)
	{
		this.userInterface = userInterface;
		
	}
	
	/**
	 * Metoda ustawiajaca alarm na najblizsze wydarzenia wraz z uwzglednieniem wydarzenia
	 * @param antyDelayMinutes opoznienie w minutach dla aktywacji alarmu
	 */
	public void set(int antyDelayMinutes)
	{
		mgr = new AlarmManager();
		Event event = null;
		
		try
		{
			event = userInterface.service.getClosestEventFromNow();
		}
		catch(NoEventsException e)
		{
			
		}
		
		
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



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
	
	Alarm (UserInterface userInterface)
	{
		this.userInterface = userInterface;
		
	}
	
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
		
		System.out.print("###" + event.getName());
		
		try
		{
			System.out.print(antyDelayMinutes);
			Date date = new Date(event.getDate().getTime() - antyDelayMinutes * 60 * 1000);
			System.out.println(date);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



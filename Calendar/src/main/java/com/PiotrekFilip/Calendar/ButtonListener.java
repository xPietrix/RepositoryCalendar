package com.PiotrekFilip.Calendar;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener
{
	JButton SaveButton;
	Window _window;
	
	public ButtonListener(JButton sButton, Window window)
	{
		SaveButton = sButton;
		_window = window;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		Date date;
		
		String name, place, description;
		if(e.getSource() == SaveButton)
		{
			System.out.println("SaveButton is working");
			
			try
			{
				name = _window.NameTextField.getText();
				place = _window.PlaceTextField.getText();
				description = _window.DescriptionTextField.getText();
				date = _window.Calendar.getDate();
				
				_window.XMLService.addEvent(name, place, date, description);
				_window.SQLService.addEvent(name, place, date, description);
				
				System.out.println("Data z kalendarza: " + date);
				
				System.out.println(name);
				System.out.println(place);
				System.out.println(description);
				System.out.println(date);
				
			}
			catch(NumberFormatException excep)
			{
				JOptionPane.showMessageDialog(_window, "Please Enter the Right Info", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(0); 
			}
		}	
	}
}

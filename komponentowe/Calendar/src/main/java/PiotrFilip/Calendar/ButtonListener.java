package PiotrFilip.Calendar;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener
{
	JButton SaveButton;
	AddEventWindow AddWindow;
	
	public ButtonListener(JButton sButton, AddEventWindow addEventWindow)
	{
		SaveButton = sButton;
		AddWindow = addEventWindow;
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) 
	{
		Date date;
		
		String name, place, description;
		String hour;
		int hours;
		if(e.getSource() == SaveButton)
		{
			System.out.println("SaveButton is working");
			
			try
			{
				name = AddWindow.textField.getText();
				place = AddWindow.textField_1.getText();
				description = AddWindow.textField_2.getText();
				date = AddWindow.dateChooser.getDate();
				hour = (String) AddWindow.comboBox.getSelectedItem(); 
				
				
				AddWindow.XMLService.addEvent(name, place, date, description);
				AddWindow.SQLService.addEvent(name, place, date, description);
				
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
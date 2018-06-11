package PiotrFilip.Calendar;

import javax.swing.JFrame;   
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AlarmSettingsWindow extends JFrame 
{
	JPanel contentPane;
	DataService service;
	ButtonListener bListener;
	JLabel chooseMinutes;
	@SuppressWarnings("rawtypes")
	JComboBox minutesChooser;
	JButton confirmButton;
	
	/**
	 * Konstruktor tworzacy obiekt klasy AlarmSettingsWindow
	 * @param userInterface obiekt glownego okna aplikacji
	 */
	public AlarmSettingsWindow(UserInterface userInterface) 
	{
		service = userInterface.service;
		this.bListener = userInterface.buttonListener; 
		initialize();
	}
	
	/**
	 * Metoda inicjalizujaca wyglad okna ustawien alarmu
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize()
	{
		setBounds(100, 100, 595, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chooseMinutes = new JLabel("Wybierz liczbę minut przed wydarzeniem:");
		chooseMinutes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chooseMinutes.setBounds(59, 35, 454, 42);
		contentPane.add(chooseMinutes);
		
		minutesChooser = new JComboBox();
		minutesChooser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		minutesChooser.setBounds(90, 105, 109, 42);
		minutesChooser.setModel(new DefaultComboBoxModel(new String[] {"0", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60"}));
		contentPane.add(minutesChooser);
		
		confirmButton = new JButton("Zatwierdź");
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		confirmButton.setBounds(323, 105, 154, 42);
		contentPane.add(confirmButton);
		confirmButton.addActionListener(bListener);
	}
	
	/**
	 * Metoda zwracajaca opoznienie alarmu w minutach
	 * @return ustawienie opoznienia alarmu
	 */
	public int getAlarmSetting()
	{
		String stringMinutes = (String) minutesChooser.getSelectedItem();
		return Integer.parseInt(stringMinutes);
	}
}
package PiotrFilip.Calendar;

import javax.swing.JFrame;   
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class AddEventWindow extends JFrame 
{
	JPanel contentPane;
	DataService service;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	ButtonListener bListener;
	JDateChooser dateChooser;
	@SuppressWarnings("rawtypes")
	JComboBox hoursComboBox, minutesComboBox;
	JButton addButton;
	private JLabel minutesLabel;
	private JComboBox comboBox_1;
	
	
	/**
	 * Konstruktor tworzacy obiekt klasy AddEventWindow
	 * @param userInterface obiekt glownego okna aplikacji
	 */
	public AddEventWindow(UserInterface userInterface) 
	{
		service = userInterface.service;
		bListener = userInterface.buttonListener;
		initialize();
	}
	
	/**
	 * Metoda inicjalizujaca wyglad okna dodawania wydarzen
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize()
	{
		setBounds(100, 100, 738, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel putYourDataLabel = new JLabel("PODAJ DANE PONIŻEJ:");
		putYourDataLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		putYourDataLabel.setBounds(253, 16, 269, 42);
		contentPane.add(putYourDataLabel);
		
		JLabel lblName = new JLabel("NAZWA: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblName.setBounds(44, 69, 98, 30);
		contentPane.add(lblName);
		
		JLabel lblPlace = new JLabel("MIEJSCE:");
		lblPlace.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPlace.setBounds(44, 134, 127, 20);
		contentPane.add(lblPlace);
		
		JLabel lblDescription = new JLabel("OPIS: ");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDescription.setBounds(44, 190, 170, 20);
		contentPane.add(lblDescription);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setBounds(203, 67, 384, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		addButton = new JButton("DODAJ");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		addButton.setBackground(new Color(0, 255, 0));
		addButton.setBounds(279, 367, 137, 42);
		contentPane.add(addButton);
		
		addButton.addActionListener(bListener);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(203, 127, 384, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(203, 183, 384, 34);
		contentPane.add(textField_2);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(99, 276, 127, 42);
		dateChooser.setPreferredSize(new Dimension(100,100));
		contentPane.add(dateChooser);
		
		JLabel lblDate = new JLabel("DATA: ");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDate.setBounds(15, 287, 170, 20);
		contentPane.add(lblDate);
		
		hoursComboBox = new JComboBox();
		hoursComboBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		hoursComboBox.setModel(new DefaultComboBoxModel(new String[] {"00", "01" , "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		hoursComboBox.setBounds(389, 276, 86, 42);
		contentPane.add(hoursComboBox);
		
		JLabel hourLabel = new JLabel("GODZINA: ");
		hourLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		hourLabel.setBounds(262, 287, 127, 20);
		contentPane.add(hourLabel);
		
		minutesLabel = new JLabel("MINUT: ");
		minutesLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		minutesLabel.setBounds(514, 287, 127, 20);
		contentPane.add(minutesLabel);
		
		minutesComboBox = new JComboBox();
		minutesComboBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		minutesComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60"}));
		minutesComboBox.setBounds(608, 276, 86, 42);
		contentPane.add(minutesComboBox);
	}
}
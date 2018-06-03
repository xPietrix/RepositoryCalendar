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

public class AddEventWindow extends JFrame 
{
	JPanel contentPane;
	DataService XMLService;
	DataService SQLService;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	ButtonListener BListener;
	JDateChooser dateChooser;
	JComboBox comboBox;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AddEventWindow(DataService XMLService, DataService SQLService) 
	{
		this.XMLService = XMLService;
		this.SQLService = SQLService;
	
		setBounds(100, 100, 592, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPutYourData = new JLabel("PODAJ DANE PONIŻEJ:");
		lblPutYourData.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPutYourData.setBounds(203, 16, 269, 42);
		contentPane.add(lblPutYourData);
		
		JLabel lblName = new JLabel("NAZWA: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblName.setBounds(15, 69, 98, 30);
		contentPane.add(lblName);
		
		JLabel lblPlace = new JLabel("MIEJSCE:");
		lblPlace.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPlace.setBounds(15, 134, 127, 20);
		contentPane.add(lblPlace);
		
		JLabel lblDescription = new JLabel("OPIS: ");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDescription.setBounds(15, 190, 170, 20);
		contentPane.add(lblDescription);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setBounds(193, 69, 269, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("DODAJ");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(203, 369, 137, 42);
		contentPane.add(btnNewButton);
		
		BListener = new ButtonListener(btnNewButton, this);
		
		btnNewButton.addActionListener(BListener);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(193, 129, 269, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(193, 185, 269, 34);
		contentPane.add(textField_2);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(122, 276, 127, 42);
		dateChooser.setPreferredSize(new Dimension(100,100));
		contentPane.add(dateChooser);
		
		JLabel lblDate = new JLabel("DATA: ");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDate.setBounds(37, 287, 170, 20);
		contentPane.add(lblDate);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"00", "01" , "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox.setBounds(417, 276, 86, 42);
		contentPane.add(comboBox);
		
		JLabel lblHour = new JLabel("GODZINA: ");
		lblHour.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHour.setBounds(291, 287, 127, 20);
		contentPane.add(lblHour);
	}
}
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

public class DeleteEventsWindow extends JFrame 
{
	JPanel contentPane;
	UserInterface userInterface;
	JTextField textField;
	JButton deleteButton;
	JButton deleteOlder;
	JDateChooser dateChooser;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DeleteEventsWindow(UserInterface userInterface) 
	{
		this.userInterface = userInterface;
		
		setBounds(100, 100, 592, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPutYourData = new JLabel("PODAJ NAZWE PONIŻEJ:");
		lblPutYourData.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPutYourData.setBounds(193, 16, 269, 42);
		contentPane.add(lblPutYourData);
		
		JLabel lblName = new JLabel("NAZWA: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblName.setBounds(15, 69, 98, 30);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setBounds(193, 69, 269, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		deleteButton = new JButton("USUŃ");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteButton.setBackground(new Color(0, 255, 0));
		deleteButton.setBounds(231, 131, 137, 42);
		deleteButton.addActionListener(userInterface.buttonListener);
		contentPane.add(deleteButton);
		
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(86, 248, 127, 42);
		dateChooser.setPreferredSize(new Dimension(100,100));
		contentPane.add(dateChooser);
		
		comboBox = new JComboBox();
		comboBox.setBounds(411, 248, 98, 42);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"00", "01" , "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		contentPane.add(comboBox);
		
		deleteOlder = new JButton("USUŃ WSZYSTKIE PRZED DATĄ");
		deleteOlder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteOlder.setBackground(Color.GREEN);
		deleteOlder.setBounds(96, 330, 398, 42);
		contentPane.add(deleteOlder);
		deleteOlder.addActionListener(userInterface.buttonListener);
	}
}
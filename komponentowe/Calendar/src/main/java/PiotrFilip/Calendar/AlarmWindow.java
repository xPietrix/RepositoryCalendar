package PiotrFilip.Calendar;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AlarmWindow extends JFrame 
{
	
	JPanel contentPane;
	DataService service;
	int antyDelayMinutes;
	String text;
	
	public AlarmWindow(UserInterface userInterface, int antyDelayMinutes, String text)
	{
		this.antyDelayMinutes = antyDelayMinutes;
		service = userInterface.service;
		this.text = text;
		initialize();
	}

	private void initialize()
	{
		setBounds(100, 100, 592, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea aboutProgramInfo = new JTextArea();
		aboutProgramInfo.setFont(new Font("Monospaced", Font.PLAIN, 16));
		aboutProgramInfo.setText("Przypomnienie !!! \n" + text + "\n\nNa " + String.valueOf(antyDelayMinutes) + " minut przed terminem" );
		aboutProgramInfo.setBounds(15, 16, 540, 372);
		contentPane.add(aboutProgramInfo);
		
	}
}

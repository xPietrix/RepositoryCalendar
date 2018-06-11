package PiotrFilip.Calendar;

import javax.swing.JFrame;   
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AboutProgramWindow extends JFrame 
{
	JPanel contentPane;
	DataService service;
	ButtonListener bListener;
	
	public AboutProgramWindow(UserInterface userInterface) 
	{
		service = userInterface.service;
		this.bListener = userInterface.buttonListener; 
		initialize();
	}
	
	private void initialize()
	{
		String text = new String("Projekt końcowy - Termianrz \n"
								+ "Programowanie komponentowe \n"
								+ "Filip Florczyk 210175 \n"
								+ "Piotr Wasiak 210346 \n"
								+ "\n"
								+ "");
		
		setBounds(100, 100, 592, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea aboutProgramInfo = new JTextArea();
		aboutProgramInfo.setFont(new Font("Monospaced", Font.PLAIN, 16));
		aboutProgramInfo.setText(text);
		aboutProgramInfo.setBounds(15, 16, 540, 372);
		contentPane.add(aboutProgramInfo);
	}
}
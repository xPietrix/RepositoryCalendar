package PiotrFilip.Calendar;


import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;

public class UserInterface 
{
	
	private JFrame frame;
	DataService Service;
	ButtonListener buttonListener;
	DataRepository Repo;
	JMenuBar menuBar;
	JMenu SettingsMenu;
	JMenuItem SetXML;
	JMenuItem SetSQL;
	JMenuItem AddWindowItem;
	JMenuItem DeleteWindowItem;
	JButton RefreshButton;
	JCalendar calendar;
	JMenu DeleteMenu;

	/**
	 * Create the application.
	 */

	public UserInterface(DataRepository Repository) 
	{
		Service = new DataService(Repository);
		buttonListener = new ButtonListener(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() 
	{
		//UserInterface window = new UserInterface();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1400, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		calendar = new JCalendar();
		calendar.getYearChooser().getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 24));
		calendar.getYearChooser().setPreferredSize(new Dimension(100, 50));
		calendar.getMonthChooser().getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 24));
		calendar.getMonthChooser().setPreferredSize(new Dimension(100, 50));
		calendar.getDayChooser().setWeekdayForeground(Color.BLUE);
		calendar.getDayChooser().setWeekOfYearVisible(false);
		calendar.getDayChooser().setSundayForeground(Color.RED);
		calendar.getDayChooser().setForeground(Color.BLACK);
		calendar.getDayChooser().setDecorationBordersVisible(true);
		calendar.getDayChooser().setDecorationBackgroundColor(Color.GREEN);
		calendar.getDayChooser().setDayBordersVisible(true);
		calendar.getDayChooser().setFont(new Font("Segoe UI", Font.PLAIN, 25));
		calendar.getDayChooser().setBackground(Color.lightGray);
		calendar.getYearChooser().setFont(new Font("Segoe UI", Font.PLAIN, 25));
		calendar.setBounds(50, 50, 900, 650);
		calendar.getMonthChooser().setBounds(100, 100, 100, 100);
		
		frame.getContentPane().add(calendar);
		
		RefreshButton = new JButton("Pokaż wydarzenia");
		RefreshButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		RefreshButton.addActionListener(buttonListener);
		RefreshButton.setBounds(1061, 50, 243, 58);
		frame.getContentPane().add(RefreshButton);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.setPreferredSize(new Dimension(1000, 75));
		frame.setJMenuBar(menuBar);
		
		SettingsMenu = new JMenu("Ustawienia");
		SettingsMenu.setFont(new Font("Segoe UI", 24, 24));
		menuBar.add(SettingsMenu);
		
		SettingsMenu.addSeparator();
		
		SetXML = new JMenuItem("Wykorzystaj XML");
		SetXML.addActionListener(buttonListener);
		SetXML.setFont(new Font("Segoe UI", 24, 24));
		SettingsMenu.add(SetXML);
		
		SetSQL = new JMenuItem("Wykorzystaj MySQLServer");
		SetSQL.setFont(new Font("Segoe UI", 24, 24));
		SetSQL.addActionListener(buttonListener);
		SettingsMenu.add(SetSQL);
		
		JMenu EksportMenu = new JMenu("Eksport");
		EksportMenu.setFont(new Font("Segoe UI", 24, 24));
		menuBar.add(EksportMenu);
		
		EksportMenu.addSeparator();
		
		JMenu OProgramieMenu = new JMenu("O programie");
		OProgramieMenu.setFont(new Font("Segoe UI", 24, 24));
		menuBar.add(OProgramieMenu);
		
		OProgramieMenu.addSeparator();
		
		JMenu DodajWydarzenieMenu = new JMenu("Dodaj wydarzenie");
		DodajWydarzenieMenu.setFont(new Font("Segoe UI", 24, 24));
		menuBar.add(DodajWydarzenieMenu);
		
		DodajWydarzenieMenu.addSeparator();
		
		AddWindowItem = new JMenuItem("Dodaj");
		AddWindowItem.setFont(new Font("Segoe UI", 24, 24));
		AddWindowItem.addActionListener(buttonListener);
		DodajWydarzenieMenu.add(AddWindowItem);
		DodajWydarzenieMenu.addSeparator();
		
		DeleteMenu = new JMenu("Usuń wydarzenie");
		DeleteMenu.setFont(new Font("Segoe UI", 24, 24));
		menuBar.add(DeleteMenu);
		menuBar.setMargin(null);
		
		DeleteWindowItem = new JMenuItem("Usun wydarzenie");
		DeleteWindowItem.setFont(new Font("Segoe UI", 24, 24));
		DeleteWindowItem.addActionListener(buttonListener);
		DeleteMenu.add(DeleteWindowItem);
		
		this.frame.setVisible(true);
	}
	
	
	public void changeToXml()
	{
		Service = new DataService(new XMLRepository());
	}
	
	public void changeToSQL()
	{
		Service = new DataService(new MySQLRepository());
	}
}
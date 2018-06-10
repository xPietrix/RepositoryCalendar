package PiotrFilip.Calendar;


import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class UserInterface 
{
	
	private JFrame frame;
	DataService service;
	ButtonListener buttonListener;
	DataRepository repo;
	JMenuBar menuBar;
	JMenu settingsMenu, deleteMenu, exportMenu, aboutProgramMenu, addWindowMenu;
	JMenuItem setXML, setSQL, setAlarm, addWindowItem, deleteWindowItem, aboutProgramItem;
	JButton refreshButton;
	JCalendar calendar;

	/**
	 * Create the application.
	 */

	public UserInterface(DataRepository Repository) 
	{
		service = new DataService(Repository);
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
		
		refreshButton = new JButton("Pokaż wydarzenia");
		refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		refreshButton.addActionListener(buttonListener);
		refreshButton.setBounds(1061, 50, 243, 58);
		frame.getContentPane().add(refreshButton);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.setPreferredSize(new Dimension(1000, 75));
		frame.setJMenuBar(menuBar);
		
		settingsMenu = new JMenu("Ustawienia");
		settingsMenu.setFont(new Font("Segoe UI", 24, 24));
		menuBar.add(settingsMenu);
		
		settingsMenu.addSeparator();
		
		setXML = new JMenuItem("Wykorzystaj XML");
		setXML.addActionListener(buttonListener);
		setXML.setFont(new Font("Segoe UI", 24, 24));
		settingsMenu.add(setXML);
		
		setSQL = new JMenuItem("Wykorzystaj MySQLServer");
		setSQL.setFont(new Font("Segoe UI", 24, 24));
		setSQL.addActionListener(buttonListener);
		settingsMenu.add(setSQL);
		
		setAlarm = new JMenuItem("Ustawienia alarmu");
		setAlarm.setFont(new Font("Segoe UI", 24, 24));
		setAlarm.addActionListener(buttonListener);
		settingsMenu.add(setAlarm);
		
		exportMenu = new JMenu("Eksport");
		exportMenu.setFont(new Font("Segoe UI", 24, 24));
		menuBar.add(exportMenu);
		
		exportMenu.addSeparator();
		
		aboutProgramMenu = new JMenu("O programie");
		aboutProgramMenu.setFont(new Font("Segoe UI", 24, 24));
		menuBar.add(aboutProgramMenu);
		
		aboutProgramMenu.addSeparator();
		
		aboutProgramItem = new JMenuItem("Informacje o programie");
		aboutProgramItem.setFont(new Font("Segoe UI", 24, 24));
		aboutProgramItem.addActionListener(buttonListener);
		aboutProgramMenu.add(aboutProgramItem);
		
		
		addWindowMenu = new JMenu("Dodaj wydarzenie");
		addWindowMenu.setFont(new Font("Segoe UI", 24, 24));
		menuBar.add(addWindowMenu);
		
		addWindowMenu.addSeparator();
		
		addWindowItem = new JMenuItem("Dodaj");
		addWindowItem.setFont(new Font("Segoe UI", 24, 24));
		addWindowItem.addActionListener(buttonListener);
		addWindowMenu.add(addWindowItem);
		addWindowMenu.addSeparator();
		
		deleteMenu = new JMenu("Usuń wydarzenie");
		deleteMenu.setFont(new Font("Segoe UI", 24, 24));
		menuBar.add(deleteMenu);
		menuBar.setMargin(null);
		
		deleteWindowItem = new JMenuItem("Usun wydarzenie");
		deleteWindowItem.setFont(new Font("Segoe UI", 24, 24));
		deleteWindowItem.addActionListener(buttonListener);
		deleteMenu.add(deleteWindowItem);
		
		this.frame.setVisible(true);
	}
	
	
	public void changeToXml()
	{
		service = new DataService(new XMLRepository());
	}
	
	public void changeToSQL()
	{
		service = new DataService(new MySQLRepository());
	}
}
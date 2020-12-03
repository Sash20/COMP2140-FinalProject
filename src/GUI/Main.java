package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import business.Inventory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	private JFrame gas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {public void run() {
				try 
				{
					Main window = new Main();
					window.gas.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}}});
	}

	/**
	 * Create the application.
	 */
	public Main() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		// initialize all panels
		JPanel change = new JPanel();
		
		InventoryGUI inventory = new InventoryGUI();
		UserGUI user = new UserGUI();
		Component sale = null;
		Component cust = null;
		//SuppliersGUI suppliers = new SuppliersGUI();
		
		gas = new JFrame();
		gas.setTitle("Greater Portmore Cooking Gas Outlet");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		gas.setSize(screenSize.width, screenSize.height);
		//frame.setBounds(100, 100, 726, 427);
		//frmPearlOfThe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gas.addWindowListener(new WindowAdapter() {
			 
			@Override
			public void windowClosing(WindowEvent e) 
			{
				inventory.save();
			    System.exit(0);
			}
			 
			  });
		
		JPanel header = new JPanel();
		header.setBorder(new EmptyBorder(10, 2, 0, 10));
		header.setBackground(new Color(255, 153, 51));
		gas.getContentPane().add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(50, 10));
		
		JPanel headerName = new JPanel();
		headerName.setBackground(new Color(255, 153, 51));
		header.add(headerName, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Greater Portmore Cooking Gas Outlet");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		headerName.add(lblNewLabel);
		
		JPanel dateTime = new JPanel();
		FlowLayout fl_dateTime = (FlowLayout) dateTime.getLayout();
		fl_dateTime.setHgap(80);
		dateTime.setBackground(new Color(255, 153, 51));
		header.add(dateTime, BorderLayout.CENTER);
		
		SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
		dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("GMT-5"));
		String date = dateTimeInGMT.format(new Date());
		String[] parts = date.split(" ");
		
		JLabel newLabel2 = new JLabel("Date: " + parts[0] );
		newLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		dateTime.add(newLabel2);
		
		JLabel newLabel1 = new JLabel("Time: " + parts[1] + " " + parts[2]);
		newLabel1.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		newLabel1.setBackground(new Color(255, 153, 51));
		dateTime.add(newLabel1);
		
		JPanel logout = new JPanel();
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JDialog.setDefaultLookAndFeelDecorated(true);
				
			    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    
			    if (response == JOptionPane.NO_OPTION) 
			    {
			      System.out.println("No button clicked");
			    } 
			    else if (response == JOptionPane.YES_OPTION)
			    {
			      System.out.println("Yes button clicked");
			      inventory.save();
			      System.exit(0);
			    } 
			    else if (response == JOptionPane.CLOSED_OPTION) 
			    {
			      System.out.println("JOptionPane closed");
			    }
			}
		});
		logout.setBackground(new Color(255, 153, 51));
		header.add(logout, BorderLayout.EAST);
		
		JLabel newLabel3 = new JLabel("Logout");
		newLabel3.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		logout.add(newLabel3);
		
		JPanel options = new JPanel();
		options.setBorder(new EmptyBorder(0, 10, 10, 10));
		options.setBackground(new Color(255, 153, 51));
		gas.getContentPane().add(options, BorderLayout.WEST);
		options.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		JButton newButton1 = new JButton("USER MANAGEMENT");
		newButton1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				gas.remove(change);
				gas.remove(inventory);
				gas.remove(sale);
				gas.remove(cust);
				
				//gas.getContentPane().add(sale,BorderLayout.CENTER);
				gas.repaint();
				gas.validate();
			}
		});
		options.add(newButton1);
		
		JButton newButton_1 = new JButton("INVENTORY");
		newButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				gas.remove(change);
				gas.remove(sale);
				gas.remove(user);
				
				
				//frmPearlOfThe.removeAll();
				gas.getContentPane().add(inventory,BorderLayout.CENTER);
				gas.repaint();
				gas.validate();
			}
		});
		options.add(newButton_1);
		
		JButton newButton2 = new JButton("USERS");
		newButton2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				gas.remove(change);
				gas.remove(inventory);
				gas.remove(sale);
				
				//frmPearlOfThe.removeAll();
				gas.getContentPane().add(user,BorderLayout.CENTER);
				gas.repaint();
				gas.validate();
			}
		});
		options.add(newButton2);
		
		JButton newButton3 = new JButton("SUPPLIERS");
		newButton3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				gas.remove(change);
				gas.remove(inventory);
				gas.remove(user);
				gas.remove(sale);
				
				//frmPearlOfThe.removeAll();
				gas.getContentPane().add(cust,BorderLayout.CENTER);
				gas.repaint();
				gas.validate();
			}
		});
		options.add(newButton3);
		
		JButton btnNewButton_4 = new JButton("REPORTS");
		options.add(btnNewButton_4);
		
		//change = new JPanel();
		change.setBackground(new Color(255, 153, 51));
		change.setBorder(new EmptyBorder(0, 0, 10, 10));
		gas.getContentPane().add(change, BorderLayout.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("WELCOME !");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 73));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_change = new GroupLayout(change);
		gl_change.setHorizontalGroup(
			gl_change.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_change.createSequentialGroup()
					.addGap(391)
					.addComponent(lblNewLabel_4)
					.addContainerGap(417, Short.MAX_VALUE))
		);
		gl_change.setVerticalGroup(
			gl_change.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_change.createSequentialGroup()
					.addContainerGap(356, Short.MAX_VALUE)
					.addComponent(lblNewLabel_4)
					.addGap(338))
		);
		change.setLayout(gl_change);
	}

}

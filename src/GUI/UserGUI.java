package GUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import business.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UserGUI extends JPanel {
	private JTable table;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField DOB;
	private JTextField DOE;
	private User users = new User();
	private ArrayList<String[]> data = users.getUsers();;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public UserGUI() 
	{
		String[] col = {"FIRST NAME","LAST NAME", "DATE OF BIRTH","DATE OF EMPLOYMENT", "ADDRESS"};
		model = new DefaultTableModel(col,0);
		
		setBorder(new EmptyBorder(0, 0, 0, 10));
		setBackground(Color.blue);
		setLayout(new BorderLayout(15, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(30, 0));
		
		JTextPane textpane = new JTextPane();
		textpane.setEditable(false);
		panel.add(textpane);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel.add(panel1, BorderLayout.SOUTH);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.white);
		panel1.add(panel3);
		panel3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel newLabel = new JLabel("FIRST NAME:");
		panel3.add(newLabel);
		
		firstName = new JTextField();
		panel3.add(firstName);
		firstName.setText("");
		
		JLabel newLabel1 = new JLabel("LAST NAME:");
		panel3.add(newLabel1);
		
		lastName = new JTextField();
		panel3.add(lastName);
		lastName.setText("");
		
		JLabel newLabel2 = new JLabel("DATE OF BIRTH:");
		panel3.add(newLabel2);
		
		DOB = new JTextField();
		panel3.add(DOB);
		DOB.setText("");
		
		JLabel newLabel3 = new JLabel("DATE OF EMPLOYMENT:");
		panel3.add(newLabel3);
		
		DOE = new JTextField();
		panel3.add(DOE);
		DOE.setText("");
		
		JLabel newLabel5 = new JLabel("ADDRESS:");
		panel3.add(newLabel5);
		
		JTextPane address = new JTextPane();
		panel3.add(address);
		
		JButton newButton = new JButton("EDIT");
		newButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				/*int num = table.getSelectedRow();
				String select = table.getValueAt(num, 0).toString();
				
				if (!(name.getText()).equals(""))
				{
					inventory.editItem(select, "NAME", name.getText());
				}
				
				if (!(cp.getText()).equals(""))
				{
					inventory.editItem(select, "COST", cp.getText());
				}
				
				if (!(sp.getText()).equals(""))
				{
					inventory.editItem(select, "SELL", sp.getText());
				}
				
				if (!(quantity.getText()).equals(""))
				{
					inventory.editItem(select, "QUANTITY", quantity.getText());
				}
				
				data = inventory.getInventory();
				
				name.setText("");
				cp.setText("");
				sp.setText("");
				quantity.setText("");
				
				String display = "";
				for(String[] x : data)
				{
					String code = x[0];
					if (code.equals(select))
					{
						display += "Code: " + x[0] + "\n \n";
						display += "Name: " + x[1] + "\n \n";
						display += "Cost Price: " + x[2] + "\n \n";
						display += "Selling Price: " + x[3] + "\n \n";
						display += "Quantity: " + x[4] + "\n \n";
						display += "Profit: " + x[5] + "\n \n";
						display += "Value: " + x[6] + "\n \n";
						
						model.setValueAt(x[1], num, 1);
						model.setValueAt(x[2], num, 2);
						model.setValueAt(x[3], num, 3);
						model.setValueAt(x[4], num, 4);
						model.setValueAt(x[5], num, 5);
						model.setValueAt(x[6], num, 6);
					}
				}
				txtpane.setText(display);*/
			}
		});
		panel1.add(newButton, BorderLayout.SOUTH);
		
		JLabel newLabel4 = new JLabel("User Information");
		newLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(newLabel4, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 153, 51));
		add(panel2, BorderLayout.SOUTH);
		
		JButton newButton1 = new JButton("ADD USER");
		newButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				/*inventory.addItem(name.getText(), Double.parseDouble(cp.getText()), Double.parseDouble(sp.getText()), Integer.parseInt(quantity.getText()));
				data = inventory.getInventory();
				
				for(String[] x : data)
				{
					model.addRow(x);
				}*/
				
			}
		});
		panel2.add(newButton1);
		
		JButton newButton2 = new JButton("REMOVE USER");
		newButton2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JDialog.setDefaultLookAndFeelDecorated(true);
				String select = table.getValueAt(table.getSelectedRow(), 0).toString();
				String display = "";
				for(String[] x : data)
				{
					String fName = x[0];
					if (fName.equals(select))
					{
						display += "\nFirst Name: " + x[0];
						display += "\nLast Name: " + x[1];
					}
				}
				
			    int confirmation = JOptionPane.showConfirmDialog(null, "Please confirm. Would you like to delete the item below?"
			    		+ display, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    
			    if (confirmation == JOptionPane.NO_OPTION) 
			    {
			      System.out.println("No button clicked");
			    } 
			    else if (confirmation == JOptionPane.YES_OPTION)
			    {
			      System.out.println("Yes button selected");
			      int selectedRow =  table.getSelectedRow();
				    if(selectedRow!=-1)
				    {
				            model.removeRow(selectedRow);
				            textpane.setText("");
				    }
			    } 
			    else if (confirmation == JOptionPane.CLOSED_OPTION) 
			    {
			      System.out.println("JOptionPane closed");
			    }
			}
		});
		panel2.add(newButton2);
		
		JPanel panel4 = new JPanel();
		panel4.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel4, BorderLayout.CENTER);
		panel4.setLayout(new BorderLayout(0, 0));
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{
			@Override
			public void valueChanged(ListSelectionEvent e) 
			{
				String select = table.getValueAt(table.getSelectedRow(), 0).toString();
				String display = "";
				
				for(String[] x : data)
				{
					String fName = x[0];
					if (fName.equals(select))
					{
						display += "First Name: " + x[0] + "\n \n";
						display += "Last Name: " + x[1] + "\n \n";
						display += "Date of Birth: " + x[4] + "\n \n";
						display += "Date of Employment: " + x[5] + "\n \n";
						display += "Address: " + x[6] + "\n \n";
					}
				}
				textpane.setText(display);
			}
		});
		panel4.add(table);
		table.setBorder(null);
		table.setBackground(new Color(255, 239, 213));
		panel4.add(table.getTableHeader(), BorderLayout.NORTH);
		
		for(String[] x : data)
		{
			model.addRow(x);
		}
	}

}

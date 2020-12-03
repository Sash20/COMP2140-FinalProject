package GUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import business.Inventory;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryGUI extends JPanel 
{
	private JTable table;
	private JTextField name;
	private JTextField prodCode;
	private JTextField description;
	private JTextField price;
	private JTextField quantity;
	private JTextField stockLevel;
	private Inventory inventory = new Inventory();
	private ArrayList<String[]> data;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public InventoryGUI() 
	{
		String[] col = {"PRODUCT CODE","PRODUCT NAME", "DESCRIPTION", "PRICE", "QUANTITY","SROCK LEVEL"};
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
		
		JLabel newLabel = new JLabel("PRODUCT NAME:");
		panel3.add(newLabel);
		
		name = new JTextField();
		panel3.add(name);
		name.setText("");
		
		JLabel newLabel1 = new JLabel("PRODUCT CODE:");
		panel3.add(newLabel1);
		
		prodCode = new JTextField();
		panel3.add(prodCode);
		prodCode.setText("");
		
		JLabel newLabel2 = new JLabel("PRICE:");
		panel3.add(newLabel2);
		
		price = new JTextField();
		panel3.add(price);
		price.setText("");
		
		JLabel newLabel3 = new JLabel("QUANTITY:");
		panel3.add(newLabel3);
		
		quantity = new JTextField();
		panel3.add(quantity);
		quantity.setText("");
		
		JButton btnNewButton = new JButton("EDIT");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int num = table.getSelectedRow();
				String select = table.getValueAt(num, 0).toString();
				
				if (!(name.getText()).equals(""))
				{
					inventory.editItem(select, "NAME", name.getText());
				}
				
				if (!(prodCode.getText()).equals(""))
				{
					inventory.editItem(select, "CODE", prodCode.getText());
				}
				
				if (!(price.getText()).equals(""))
				{
					inventory.editItem(select, "COST", price.getText());
				}
				
				if (!(quantity.getText()).equals(""))
				{
					inventory.editItem(select, "QUANTITY", quantity.getText());
				}
				
				name.setText("");
				prodCode.setText("");
				price.setText("");
				quantity.setText("");
				
				data = inventory.printInventory();
				String display = "";
				
				for(String[] x : data)
				{
					String code = x[0];
					if (code.equals(select))
					{
						display += "Code: " + x[0] + "\n \n";
						display += "Name: " + x[1] + "\n \n";
						display += "Description: " + x[2] + "\n \n";
						display += "Price: " + x[3] + "\n \n";
						display += "Quantity: " + x[4] + "\n \n";
						display += "Stock Level: " + x[5] + "\n \n";
						
						model.setValueAt(x[1], num, 1);
						model.setValueAt(x[2], num, 2);
						model.setValueAt(x[3], num, 3);
						model.setValueAt(x[4], num, 4);
						model.setValueAt(x[5], num, 5);
						model.setValueAt(x[6], num, 6);
					}
				}
				textpane.setText(display);
			}
		});
		panel1.add(btnNewButton, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_4 = new JLabel("Product Information");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 153, 51));
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("ADD ITEM");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JTextField itemName = new JTextField();
				JTextField code = new JTextField();
			    JTextField cost = new JTextField();
			    JTextField quan = new JTextField();

			    JPanel myPanel = new JPanel();
			    myPanel.setLayout(new GridLayout(0, 2, 0, 0));
			    myPanel.add(new JLabel("Name:"));
			    myPanel.add(itemName);
			    //myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			    myPanel.add(new JLabel("Code:"));
			    myPanel.add(code);
			    myPanel.add(new JLabel("Price:"));
			    myPanel.add(cost);
			    myPanel.add(new JLabel("Quantity:"));
			    myPanel.add(quan);

			    int result = JOptionPane.showConfirmDialog(null, myPanel,
			        "Please Enter Item information", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION) 
			    {
			      inventory.addItem(itemName.getText(), Double.parseDouble(cost.getText()), Integer.parseInt(quan.getText()));
			      data = inventory.printInventory();
			    }
				
				for(String[] x : data)
				{
					if((itemName.getText()).equals(x[1]))
					{
						model.addRow(x);
					}
				}
				
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REMOVE ITEM");
		btnNewButton_2.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e)
			{
				JDialog.setDefaultLookAndFeelDecorated(true);
				String select = table.getValueAt(table.getSelectedRow(), 0).toString();
				String display = "";
				
				data = inventory.printInventory();
				for(String[] x : data)
				{
					String code = x[0];
					if (code.equals(select))
					{
						display += "\nCode: " + x[0];
						display += "\nName: " + x[1];
					}
				}
				
			    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the item below?" + display, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    
			    if (response == JOptionPane.NO_OPTION) 
			    {
			      System.out.println("No button clicked");
			    } 
			    else if (response == JOptionPane.YES_OPTION)
			    {
			      System.out.println("Yes button clicked");
			      int selectedRow =  table.getSelectedRow();
				    if(selectedRow!=-1)
				    {
				            model.removeRow(selectedRow);
				            textpane.setText("");
				    }
			    } 
			    else if (response == JOptionPane.CLOSED_OPTION) 
			    {
			      System.out.println("JOptionPane closed");
			    }
			}
		});
		panel_2.add(btnNewButton_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{
			@Override
			public void valueChanged(ListSelectionEvent e) 
			{
				String select = table.getValueAt(table.getSelectedRow(), 0).toString();
				String display = "";
				data = inventory.printInventory();
				for(String[] x : data)
				{
					String code = x[0];
					if (code.equals(select))
					{
						display += "Name: " + x[0] + "\n \n";
						display += "Code: " + x[1] + "\n \n";
						display += "Description: " + x[2] + "\n \n";
						display += "Price: " + x[3] + "\n \n";
						display += "Quantity: " + x[4] + "\n \n";
						display += "Stock Level: " + x[5] + "\n \n";
					}
				}
				textpane.setText(display);
			}
		});
		panel_4.add(table);
		table.setBorder(null);
		table.setBackground(new Color(255, 239, 213));
		panel_4.add(table.getTableHeader(), BorderLayout.NORTH);
		
		data = inventory.printInventory();
		for(String[] x : data)
		{
			model.addRow(x);
		}
		
	}

	
	public ArrayList<String[]> getInventory()
	{
		return inventory.printInventory();
	}
	

}

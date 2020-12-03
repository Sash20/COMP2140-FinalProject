package GUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EmptyBorder;

import business.Transaction;

import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class SalesGUI extends JPanel {
	private JTextField sub;
	private JTextField tax;
	private JTextField total;
	private JTextField codeText;
	private JTextField quanText;
	private JTextPane textPane = new JTextPane();
	private JTextPane textPane_1 = new JTextPane();
	private Transaction sale = new Transaction(null);;
	private JTextField cash;
	private Locale locale = Locale.ENGLISH;
	private NumberFormat nf = NumberFormat.getNumberInstance(locale);
	/**
	 * Create the panel.
	 */
	public SalesGUI()
	{
		
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		
		setBackground(new Color(255, 153, 51));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(10, 10));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 51));
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 153, 51));
		panel.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setBackground(new Color(255, 153, 51));
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel code = new JLabel("CODE:");
		code.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(code);
		
		codeText = new JTextField();
		panel_5.add(codeText);
		codeText.setColumns(10);
		
		JLabel quantity = new JLabel("QUANTITY:");
		panel_5.add(quantity);
		
		quanText = new JTextField();
		panel_5.add(quanText);
		quanText.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("SEARCH");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String text = sale.searchitem(codeText.getText());
				textPane_1.setText(text);
				codeText.setText("");
			}
		});
		panel_4.add(btnNewButton_6, BorderLayout.SOUTH);
		
		JButton btnNewButton_5 = new JButton("ADD ITEM");
		panel_4.add(btnNewButton_5, BorderLayout.CENTER);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean add = sale.additem(codeText.getText(), Integer.parseInt(quanText.getText()));
				if (add == true)
				{
					textPane.setText(sale.toString());
					tax.setText(nf.format(sale.getTax()));
					total.setText(nf.format(sale.getTotal()));
					
					codeText.setText("");
					quanText.setText("");
				}
				else
				{
					System.out.println("Out of Stock");
				}
			}
		});
		textPane_1.setEditable(false);
		
		//JTextPane textPane_1 = new JTextPane();
		panel.add(textPane_1, BorderLayout.CENTER);
		
		JPanel billing = new JPanel();
		billing.setBackground(new Color(255, 153, 51));
		add(billing, BorderLayout.WEST);
		billing.setLayout(new BorderLayout(0, 5));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 153, 51));
		billing.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("SubTotal:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel);
		
		sub = new JTextField();
		sub.setHorizontalAlignment(SwingConstants.CENTER);
		sub.setText("0.00");
		sub.setBackground(new Color(255, 153, 0));
		sub.setEditable(false);
		panel_3.add(sub);
		sub.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tax:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_1);
		
		tax = new JTextField();
		tax.setHorizontalAlignment(SwingConstants.CENTER);
		tax.setText("0.00");
		tax.setBackground(new Color(255, 153, 51));
		tax.setEditable(false);
		panel_3.add(tax);
		tax.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_2);
		
		total = new JTextField();
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setText("0.00");
		total.setBackground(new Color(255, 153, 51));
		total.setEditable(false);
		panel_3.add(total);
		total.setColumns(10);
		
		//JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(0, 0, 10, 10);
		textPane.setSize(new Dimension(10, 10));
		billing.add(textPane, BorderLayout.CENTER);
		textPane.setText(sale.toString());
		
		JLabel lblNewLabel_3 = new JLabel("BILL");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		billing.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setBackground(new Color(255, 153, 51));
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton_1 = new JButton("CARD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			    int response = JOptionPane.showConfirmDialog(null, "Has the payment be successful?\n", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    
			    if (response == JOptionPane.NO_OPTION) 
			    {
			      System.out.println("No button clicked");
			    } 
			    else if (response == JOptionPane.YES_OPTION)
			    {
			      System.out.println("Yes button clicked");
			      Transaction s = new Transaction();
				  sale = s;
				  textPane.setText(sale.toString());
				  cash.setText("");
				  tax.setText("0.00");
				  total.setText("0.00");
			    } 
			    else if (response == JOptionPane.CLOSED_OPTION) 
			    {
			      System.out.println("JOptionPane closed");
			    }
				
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("CASH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (!(cash.getText()).equals(""))
				{
					JDialog.setDefaultLookAndFeelDecorated(true);
					double due = Double.parseDouble(cash.getText()) - sale.getTotal();
					
				    JOptionPane.showMessageDialog(null, "CHANGE: " + nf.format(due));
				    
				    Transaction s = new Transaction();
				    sale = s;
				    textPane.setText(sale.toString());
				    cash.setText("");
				    sub.setText("0.00");
				    tax.setText("0.00");
				    total.setText("0.00");
				}
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("CANCEL");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				sale.cancel();
				textPane.setText(sale.toString());
				sub.setText("0.00");
				tax.setText("0.00");
				total.setText("0.00");
			}
		});
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("REMOVE ITEM");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			    String result = JOptionPane.showInputDialog(null, "Enter item code:");
			    
			    if(!result.equals("") || ! result.equals(null))
			    
			    {
				    
				    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the item below?\n" + result, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    
				    if (response == JOptionPane.NO_OPTION) 
				    {
				      System.out.println("No button clicked");
				    } 
				    else if (response == JOptionPane.YES_OPTION)
				    {
				      System.out.println("Yes button clicked");
				      sale.removeItem(result);
				      textPane.setText(sale.toString());
				      sub.setText(nf.format(sale.getSubtotal()));
				      tax.setText(nf.format(sale.getTax()));
				      total.setText(nf.format(sale.getTotal()));
						
				    } 
				    else if (response == JOptionPane.CLOSED_OPTION) 
				    {
				      System.out.println("JOptionPane closed");
				    }
			    }
			}
		});
		panel_2.add(btnNewButton_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 153, 51));
		panel_1.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("CASH");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblNewLabel_4);
		
		cash = new JTextField();
		panel_6.add(cash);
		cash.setColumns(10);

	}

}


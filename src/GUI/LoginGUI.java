package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

public class LoginGUI extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	JButton loginButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton cancelButton = new JButton("Cancel");
		
		loginButton = new JButton("Login");
		
		JLabel newLabel = new JLabel("Login");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JLabel newLabel1 = new JLabel("Username");
		
		JLabel newLabel2 = new JLabel("Password");
		GroupLayout panel1 = new GroupLayout(panel);
		panel1.setHorizontalGroup(
			panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(panel1.createSequentialGroup()
					.addGroup(panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(panel1.createSequentialGroup()
							.addGap(190)
							.addComponent(newLabel))
						.addGroup(panel1.createSequentialGroup()
							.addGap(87)
							.addGroup(panel1.createParallelGroup(Alignment.TRAILING)
								.addComponent(newLabel1)
								.addComponent(newLabel2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(panel1.createParallelGroup(Alignment.CENTER, false)
								.addComponent(passwordField, Alignment.TRAILING)
								.addComponent(cancelButton)
								.addComponent(loginButton)
								.addComponent(textField, Alignment.TRAILING))))
					.addContainerGap(167, Short.MAX_VALUE))
		);
		panel1.setVerticalGroup(
			panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(panel1.createSequentialGroup()
					.addContainerGap()
					.addComponent(newLabel)
					.addGap(44)
					.addGroup(panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(newLabel1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(newLabel2))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(loginButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cancelButton)
					.addGap(55))
		);
		panel.setLayout(panel1);
	}
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		String username = textField.getText();
		String password = passwordField.getText();
		
		if (username.isEmpty()) {
			System.out.println("Please eenter username");
		}else {
			System.out.println(username);
		}
		
		
	}
	
}

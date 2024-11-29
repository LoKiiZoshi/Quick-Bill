package com.view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.model.UserLogin;
import com.service.UserService;
import com.service.UserServiceImpl;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JButton btnNewButton_1 = new JButton("Login");
	private JTextField text2;
	private JTextField text1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(45, 40, 95, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(46, 117, 95, 39);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("Cancle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BillAU().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(110, 182, 135, 39);
		contentPane.add(btnNewButton);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create a new UserLogin object
				UserLogin us = new UserLogin();

				// Set the username and password from the text fields
				us.setUsername(text1.getText());
				us.setPassword(text2.getText());

				// Instantiate UserServiceImpl
				UserService add = new UserServiceImpl();

				// Add the user login details to the database
				add.addUserLogin(us);

				// Show a success message using JOptionPane
				JOptionPane.showMessageDialog(null, "Login success");
				new Dashbord2().setVisible(true);
				dispose();
					
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(312, 182, 135, 39);
		contentPane.add(btnNewButton_1);
		
		text2 = new JTextField();
		text2.setBounds(192, 120, 210, 39);
		contentPane.add(text2);
		text2.setColumns(10);
		
		text1 = new JTextField();
		text1.setColumns(10);
		text1.setBounds(192, 43, 210, 39);
		contentPane.add(text1);
		
		JLabel lblNewLabel_1 = new JLabel("Click here to");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(161, 265, 106, 27);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Signup");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignupForm().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(267, 263, 135, 31);
		contentPane.add(btnNewButton_2);
	}
}

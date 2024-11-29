package com.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignupForm extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField lasttxt;
	private JTextField passtxt;
	private JTextField utext;
	private JTextField pass2txt;
	private JTextField addresstxt;
	private JTextField birthtxt;
	private JTextField firsttxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupForm frame = new SignupForm();
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
	public SignupForm() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 552);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(42, 26, 95, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(42, 83, 112, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(42, 139, 95, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(42, 184, 95, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Retypepass");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(44, 254, 93, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("BirthDate");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(42, 314, 95, 35);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(42, 376, 83, 22);
		contentPane.add(lblNewLabel_6);
		
		lasttxt = new JTextField();
		lasttxt.setBounds(178, 87, 198, 32);
		contentPane.add(lasttxt);
		lasttxt.setColumns(10);
		
		passtxt = new JTextField();
		passtxt.setColumns(10);
		passtxt.setBounds(178, 188, 198, 32);
		contentPane.add(passtxt);
		
		utext = new JTextField();
		utext.setColumns(10);
		utext.setBounds(178, 138, 198, 32);
		contentPane.add(utext);
		
		pass2txt = new JTextField();
		pass2txt.setColumns(10);
		pass2txt.setBounds(178, 259, 198, 32);
		contentPane.add(pass2txt);
		
		addresstxt = new JTextField();
		addresstxt.setColumns(10);
		addresstxt.setBounds(157, 361, 254, 61);
		contentPane.add(addresstxt);
		
		birthtxt = new JTextField();
		birthtxt.setColumns(10);
		birthtxt.setBounds(178, 319, 198, 32);
		contentPane.add(birthtxt);
		
		firsttxt = new JTextField();
		firsttxt.setColumns(10);
		firsttxt.setBounds(178, 30, 198, 32);
		contentPane.add(firsttxt);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BillAU().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(90, 432, 123, 40);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.setForeground(new Color(64, 0, 64));
		btnRegister.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
		                    // Assuming you have a User object

			    	     User  user = new User();
			    	     
			    	    // user.setFirstName(firsttxt.getText());
			    	     user.setFirstName(firsttxt.getText());
			    	     user.setLastname(lasttxt.getText());
			    	     user.setUsername(utext.getText());
			    	     user.setPassword(passtxt.getText());
			    	     user.setRetypepass(pass2txt.getText());
			    	     user.setBirthdate(birthtxt.getText());
			    	     user.setAddress(addresstxt.getText());
			    	     
			    	     
			    	     
			    	     UserService  us = new UserServiceImpl();
			    	     us.addUser(user);
		      
			    	     JOptionPane.showMessageDialog(null, "Register  success");
			    	     
			    	     //clear form
			    	     firsttxt.setText("");
			    	     
			    	     
		            }
		        });
	
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegister.setBounds(288, 432, 123, 40);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_7 = new JLabel("Click here to ");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new LoginForm().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(178, 485, 83, 22);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserLoginForm().setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(260, 480, 112, 31);
		contentPane.add(btnNewButton_1);
	}
}

package com.view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Dashbord2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashbord2 frame = new Dashbord2();
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
	public Dashbord2() {
		setTitle("Quick Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 10, 1052, 85);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Create Bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewBill().setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("Search Bill");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBillForm().setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1_1_1 = new JButton("Product Information");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductInfoForm().setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1_1 = new JButton("Sales");
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewBill().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BillAU().setVisible(true);
				dispose();

			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		panel.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

}

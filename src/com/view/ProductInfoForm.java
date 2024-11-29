package com.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.model.Product;
import com.service.ProductService;
import com.service.Productinfoimpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProductInfoForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductInfoForm frame = new ProductInfoForm();
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
	public ProductInfoForm() {
		setTitle("Product Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(32, 52, 76, 29);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String data = textField.getText();
				
				ProductService  us = new Productinfoimpl();
			       List<Product> plist = us.searchProduct(data.trim());
		           DefaultTableModel tmodel1 = (DefaultTableModel) table.getModel();
				   tmodel1.setRowCount(0);
			       for(Product pd : plist){
				   tmodel1.addRow(new Object[] {pd.getId(),pd.getName(),pd.getQuantity(),pd.getQuentityAded(),pd.getMrp()});		 
				
				    }
			}
		});
		textField.setBounds(141, 55, 252, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(445, 52, 119, 29);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		scrollPane.setBounds(10, 111, 596, 415);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product id", "Product Name", "Quentity", "QuentityAdded", "Mrp"
			}
		));
		scrollPane.setViewportView(table);
		displayData();
	}
	protected void displayData() {
		ProductService  us = new Productinfoimpl();
	       List<Product> plist = us.getAllProduct();
           DefaultTableModel tmodel1 = (DefaultTableModel) table.getModel();
		   tmodel1.setRowCount(0);
	       for(Product pd : plist){
	    	   
		   tmodel1.addRow(new Object[] {pd.getId(),pd.getName(),pd.getQuantity(),pd.getQuentityAded(),pd.getMrp()});		 
		
		    }
	}
			 

}

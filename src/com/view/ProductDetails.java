package com.view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.model.Product;
import com.service.ProductService;
import com.service.Productinfoimpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ProductDetails extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField pdname;
	private JTextField qa;
	private JTextField qad;
	private JTextField mrp;
	private JTable table;
	//private Product[] plist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductDetails frame = new ProductDetails();
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
	public ProductDetails() {
		setTitle("Upadete Stock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product id");
		lblNewLabel.setBounds(28, 45, 107, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblProductName = new JLabel("Quantity Available");
		lblProductName.setBounds(28, 159, 148, 29);
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblProductName);
		
		JLabel lblProductName_1 = new JLabel("Product Name");
		lblProductName_1.setBounds(28, 98, 128, 29);
		lblProductName_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblProductName_1);
		
		JLabel lblQuantityAdded = new JLabel("Mrp");
		lblQuantityAdded.setBounds(25, 272, 97, 29);
		lblQuantityAdded.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblQuantityAdded);
		
		JLabel lblQuantityAdded_1 = new JLabel("Quantity Added");
		lblQuantityAdded_1.setBounds(28, 221, 130, 29);
		lblQuantityAdded_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblQuantityAdded_1);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product pd = new Product();
				pd.setId(id.getText());
				pd.setName(pdname.getText());
				pd.setQuantity(qa.getText());
				pd.setQuentityAded(qad.getText());
				pd.setMrp(mrp.getText());
				ProductService  us = new Productinfoimpl();
         	    us.addProduct(pd);
         	   JOptionPane.showMessageDialog(null, "Product ADD  success");
				
				
			}
		});
		btnNewButton.setBounds(39, 378, 117, 39);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Product pd = new Product();
			pd.setId(id.getText());
			pd.setName(pdname.getText());
			pd.setQuantity(qa.getText());
			pd.setQuentityAded(qad.getText());
			pd.setMrp(mrp.getText());
			
			ProductService  us = new Productinfoimpl();
			us.addProduct(pd);
			JOptionPane.showMessageDialog(null, "update sucess");
			 displayData();
			
          
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(186, 378, 128, 39);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);
		
		id = new JTextField();
		id.setBounds(186, 48, 187, 29);
		contentPane.add(id);
		id.setColumns(10);
		
		pdname = new JTextField();
		pdname.setBounds(186, 101, 187, 29);
		pdname.setColumns(10);
		contentPane.add(pdname);
		
		qa = new JTextField();
		qa.setBounds(186, 159, 187, 29);
		qa.setColumns(10);
		contentPane.add(qa);
		
		qad = new JTextField();
		qad.setBounds(186, 221, 187, 29);
		qad.setColumns(10);
		contentPane.add(qad);
		
		mrp = new JTextField();
		mrp.setBounds(186, 275, 187, 29);
		mrp.setColumns(10);
		contentPane.add(mrp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
          	int row = table.getSelectedRow();
				id.setText(table.getModel().getValueAt(row, 1).toString());
				pdname.setText(table.getModel().getValueAt(row, 2).toString());
				qa.setText(table.getModel().getValueAt(row, 3).toString());
				qad.setText(table.getModel().getValueAt(row, 4).toString());
				mrp.setText(table.getModel().getValueAt(row, 5).toString());
				
			}
		});
		scrollPane.setBounds(389, 10, 555, 490);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product ID", "Product Name", "Quantity Available", "QuantityAdded", "Mrp"
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

	


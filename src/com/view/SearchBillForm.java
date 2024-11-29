package com.view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Bill;
import com.service.NewBillImpl;
import com.service.NewBillService;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchBillForm extends JFrame {

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
					SearchBillForm frame = new SearchBillForm();
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
	public SearchBillForm() {
		setTitle("Search Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bill No");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(59, 56, 71, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(431, 51, 147, 38);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(128, 51, 259, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(10, 101, 623, 422);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bill no", "Customer name", "ProductId", "Name", "Mrp", "Quantity", "Discount", "Date", "Total"
			}
		));
		scrollPane.setViewportView(table);
		displayData();
	}
	protected void displayData() {
		NewBillService b = new NewBillImpl();
		 List<Bill> blist = b.getAllBill();
		 
	  DefaultTableModel  tmodel	= (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		
		for(Bill bi : blist) {
			tmodel.addRow(new Object[] {bi.getBillno(),bi.getCustomername(),bi.getProductId(),bi.getName(),bi.getMrp(),bi.getQuantiy(),bi.getDiscount(),bi.getDate(),bi.getTotal()});
			
			
		}
     }
}

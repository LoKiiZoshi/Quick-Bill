package com.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.model.Bill;
import com.service.NewBillImpl;
import com.service.NewBillService;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class NewBill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt7;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt8;
	private JTable table;
	private JTextField txt0;
	protected int cid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBill frame = new NewBill();
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
	public NewBill() {
		setTitle("New Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1090, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bill no");
		lblNewLabel.setBounds(53, 31, 62, 36);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(53, 77, 129, 36);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblCustomerName);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setBounds(53, 123, 108, 22);
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblProductId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(53, 165, 54, 36);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("Mrp");
		lblNewLabel_1.setBounds(53, 219, 62, 36);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1.setBounds(53, 278, 96, 36);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Discount");
		lblNewLabel_1_1_1.setBounds(53, 328, 108, 36);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setBounds(458, 34, 57, 31);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_2);
		
		txt7 = new JTextField();
		txt7.setBounds(509, 37, 257, 31);
		contentPane.add(txt7);
		txt7.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Total");
		lblNewLabel_3.setBounds(471, 480, 62, 31);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			Bill bi = new Bill();
			bi.setBillno(txt1.getText());
			bi.setCustomername(txt2.getText());
			bi.setProductId(txt0.getText());
			bi.setName(txt3.getText());
			bi.setMrp(txt4.getText());
			bi.setQuantiy(txt5.getText());
			bi.setDiscount(txt6.getText());
			bi.setDate(txt7.getText());
			bi.setTotal(txt8.getText());
			
			
			//UserServiceimpl us  = new UserService();
			NewBillService b = new NewBillImpl();
            b.addBill(bi);
           JOptionPane.showMessageDialog(null, " Bill  ADD  success");
			
			
			}
		});
		btnNewButton.setBounds(74, 433, 122, 36);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(244, 433, 122, 36);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(table.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(null, "plz. select any row");
			return;
		}
		if(table.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(null, "plz. select any row");				
			return;
		} 
				
				int row = table.getSelectedRow();
				String id = (String) table.getModel().getValueAt(row, 0);
			    NewBillService b = new NewBillImpl();
				b.deleteBill(id);
				JOptionPane.showMessageDialog(null, "remove success");
				displayData();
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);
		
		txt1 = new JTextField();
		txt1.setBounds(189, 43, 193, 31);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(189, 89, 193, 31);
		txt2.setColumns(10);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setBounds(189, 171, 193, 31);
		txt3.setColumns(10);
		contentPane.add(txt3);
		
		txt4 = new JTextField();
		txt4.setBounds(189, 225, 193, 31);
		txt4.setColumns(10);
		contentPane.add(txt4);
		
		txt5 = new JTextField();
		txt5.setBounds(189, 284, 193, 31);
		txt5.setColumns(10);
		contentPane.add(txt5);
		
		txt6 = new JTextField();
		txt6.setBounds(189, 334, 193, 31);
		txt6.setColumns(10);
		contentPane.add(txt6);
		
		txt8 = new JTextField();
		txt8.setBounds(533, 480, 268, 31);
		txt8.setColumns(10);
		contentPane.add(txt8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

		int row = table.getSelectedRow();
		cid = (int) table.getModel().getValueAt(row, 0);
		txt1.setText(table.getModel().getValueAt(row, 1).toString());
		txt2.setText(table.getModel().getValueAt(row, 2).toString());
		txt0.setText(table.getModel().getValueAt(row, 3).toString());
		txt3.setText(table.getModel().getValueAt(row, 4).toString());
		txt4.setText(table.getModel().getValueAt(row, 5).toString());
		txt5.setText(table.getModel().getValueAt(row, 6).toString());
		txt6.setText(table.getModel().getValueAt(row, 7).toString());
		txt7.setText(table.getModel().getValueAt(row, 8).toString());
		txt8.setText(table.getModel().getValueAt(row, 9).toString());
		
		
		
		}
		});
		scrollPane.setBounds(457, 77, 609, 396);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bill No", "Customer Name", "Product Id", "Name", "Mrp", ",Quantiy", "Discount", "Date", "Total"
			}
		));
		scrollPane.setViewportView(table);
		
     	txt0 = new JTextField();
	    txt0.setBounds(189, 130, 193, 31);
		contentPane.add(txt0);
     	txt0.setColumns(10);
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

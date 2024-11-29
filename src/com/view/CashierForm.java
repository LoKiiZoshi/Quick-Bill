package com.view;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.model.Cashier;
import com.service.CashierService;
import com.service.CashierServiceImpl;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CashierForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField number;
	private JTextField address;
	private JTextField email;
	private JTextField password;
	private JTable table;
	
	private int cid = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierForm frame = new CashierForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param <CashierService>
	 */
	public CashierForm() {
		setTitle("Add Cashier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Cashier Details");
		lblNewLabel.setBounds(139, 23, 164, 24);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cashier id");
		lblNewLabel_1.setBounds(12, 72, 118, 33);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cashier Name");
		lblNewLabel_2.setBounds(12, 115, 118, 33);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile Number");
		lblNewLabel_3.setBounds(12, 158, 139, 33);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(10, 216, 73, 31);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email-Id");
		lblNewLabel_5.setBounds(10, 274, 85, 33);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setBounds(12, 329, 102, 33);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Add New");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  
				Cashier cs  = new Cashier();
				//cs.setId(id.getColumns());
				cs.setName(name.getText());
				cs.setNumber(number.getText());
				cs.setAddress(address.getText());
				cs.setEmailid(email.getText());
				cs.setPassword(password.getText());
				
				CashierService  c = new CashierServiceImpl();
				 c.addCashierDetails(cs);
				 JOptionPane.showMessageDialog(null, "Add sucess");
				 displayData();
				 
			}
		});
		btnNewButton.setBounds(5, 411, 125, 38);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Upadete");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cashier cs  = new Cashier();
				cs.setId(cid);
				cs.setName(name.getText());
				cs.setNumber(number.getText());
				cs.setAddress(address.getText());
				cs.setEmailid(email.getText());
				cs.setPassword(password.getText());
				
				CashierService c = new CashierServiceImpl();
				
				 c.updateCashier(cs);
				
				 JOptionPane.showMessageDialog(null, "update success");
				 
				 displayData();
			}
		});
		btnNewButton_1.setBounds(166, 411, 118, 38);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "plz. select any row");
					return;
				}
				
				
				int row = table.getSelectedRow();
				int id = (int) table.getModel().getValueAt(row, 0);
				
				
				CashierService c =  new CashierServiceImpl();
				c.deleteCashier(id);
				JOptionPane.showMessageDialog(null, "delete success");
				displayData();
			}
		});
		btnNewButton_2.setBounds(309, 413, 102, 35);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton_2);
		
		id = new JTextField();
		id.setEnabled(false);
		id.setBounds(140, 75, 251, 33);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(140, 115, 251, 33);
		name.setColumns(10);
		contentPane.add(name);
		
		number = new JTextField();
		number.setBounds(140, 158, 251, 33);
		number.setColumns(10);
		contentPane.add(number);
		
		address = new JTextField();
		address.setBounds(140, 216, 251, 33);
		address.setColumns(10);
		contentPane.add(address);
		
		email = new JTextField();
		email.setBounds(140, 274, 251, 33);
		email.setColumns(10);
		contentPane.add(email);
		
		password = new JTextField();
		password.setBounds(140, 329, 251, 33);
		password.setColumns(10);
		contentPane.add(password);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(446, 23, 551, 426);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				  cid = (int) table.getModel().getValueAt(row, 0);
				 name.setText(table.getModel().getValueAt(row, 1).toString());
				 number.setText(table.getModel().getValueAt(row, 2).toString());
				 address.setText(table.getModel().getValueAt(row, 3).toString());
				 email.setText(table.getModel().getValueAt(row, 4).toString());
				 password.setText(table.getModel().getValueAt(row, 5).toString());
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name","Mobile Number", "Address", "Email-Id", "Password"
			}
		));
		scrollPane.setViewportView(table);
		
		displayData();
	}
	
	
	//display data in table
	private void displayData() {
		
		CashierService c =  new CashierServiceImpl();
		
		 List<Cashier> clist = c.getAllCashier();
		 
	  DefaultTableModel  tmodel	= (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		
		for(Cashier ch : clist) {
			tmodel.addRow(new Object[] {ch.getId(),ch.getName(),ch.getNumber(),ch.getAddress(),ch.getEmailid(),ch.getPassword()});
		}
	}
	
}



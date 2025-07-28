package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Bill;
public class NewBillImpl implements NewBillService{
	@Override
	public void addBill(Bill bi) {
		
		 try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
				  PreparedStatement pstmt = con.prepareStatement("INSERT INTO Billdetails(Billno,Customername,ProductId,Name,Mrp,Quantiy,Discount,Date,Total) VALUES (?,?,?,?,?,?,?,?,?)");){
		pstmt.setString(1, bi.getBillno());
		pstmt.setString(2, bi.getCustomername());
		pstmt.setString(3, bi.getProductId());
		pstmt.setString(4,bi.getName());
		pstmt.setString(5, bi.getMrp());
		pstmt.setString(6,bi.getQuantiy());
		pstmt.setString(7, bi.getDiscount());
		pstmt.setString(8, bi.getDate());
		pstmt.setString(9, bi.getTotal());
		
		 int rowsAffected = pstmt.executeUpdate();
		  System.out.println(rowsAffected + "row(s) inserted .");
	  }catch(SQLException ex) {
		  ex.printStackTrace();			 
	  }	
	}

	
	@Override
	public List<Bill> getAllBill() {

		List<Bill> blist = new ArrayList<>();

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
			String sql = "select * from billdetails";
			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				Bill b = new Bill();
				b.setBillno(rs.getString("Billno"));
				b.setCustomername(rs.getString("Customername"));
				b.setProductId(rs.getString("ProductId"));
				b.setName(rs.getString("Name"));
				b.setMrp(rs.getString("Mrp"));
				b.setQuantiy(rs.getString("Quantiy"));
				b.setDiscount(rs.getString("Discount"));
				b.setDate(rs.getString("Date"));
				b.setTotal(rs.getString("Total"));
				
				

			  blist.add(b);
			
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return blist;
	}

	@Override
	public void deleteBill(int id) {
		
	try {
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
	String sql = "delete from billdetails where id = "+id;
		Statement stm = con.createStatement();
		
		stm.execute(sql);
		
	} 
	catch (SQLException ex) {
			ex.printStackTrace();
	}
	}


	@Override
	public void deleteBill(String id) {
		//to do some method 
	}
}

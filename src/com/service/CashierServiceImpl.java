package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.model.Cashier;

public class CashierServiceImpl implements CashierService {
	@Override
	public List<Cashier> getAllCashier() {

		List<Cashier> clist = new ArrayList<>();

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
			String sql = "select * from cashierdetails";
			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				Cashier c = new Cashier();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setEmailid(rs.getString("email"));
				c.setNumber(rs.getString("number"));
				c.setPassword(rs.getString("password"));

				clist.add(c);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return clist;
	}

	@Override
	public void deleteCashier(int id) {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
			String sql = "delete from cashierdetails  where id = "+id;
			Statement stm = con.createStatement();
			
			stm.execute(sql);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void updateCashier(Cashier cs) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
				PreparedStatement pstmt = con.prepareStatement(
						"update  CashierDetails set Name= ?, Number= ?, Address= ?, Email= ?, Password= ? where id = ? ")) {
			pstmt.setString(1, cs.getName());
			pstmt.setString(2, cs.getNumber());
			pstmt.setString(3, cs.getAddress());
			pstmt.setString(4, cs.getEmailid());
			pstmt.setString(5, cs.getPassword());
			pstmt.setInt(6, cs.getId());

			int rowsAffected = pstmt.executeUpdate();
			System.out.println(rowsAffected + "row(s) updated .");
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}

	@Override
	public void addCashierDetails(Cashier cs) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO CashierDetails (Name, Number, Address, Email, Password) VALUES (?,?,?,?,?)");) {
			pstmt.setString(1, cs.getName());
			pstmt.setString(2, cs.getNumber());
			pstmt.setString(3, cs.getAddress());
			pstmt.setString(4, cs.getEmailid());
			pstmt.setString(5, cs.getPassword());

			int rowsAffected = pstmt.executeUpdate();
			System.out.println(rowsAffected + "row(s) inserted .");
		} catch (SQLException ex) {
			ex.printStackTrace();

		}

	}
		
	}	



	
	

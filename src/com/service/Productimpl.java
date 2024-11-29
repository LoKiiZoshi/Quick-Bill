package com.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.model.Product;

public class Productimpl implements ProductService{
	@Override
	public void addProduct(Product pd) {
		  try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
				  PreparedStatement pstmt = con.prepareStatement("INSERT INTO Productdetails (Id, Name, Quantity,QuantityAdded,Mrp) VALUES (?,?,?,?,?)");){
			 pstmt.setString(1,pd.getId());
			 pstmt.setString(2,pd.getName());
			 pstmt.setString(3,pd.getQuantity());
			 pstmt.setString(4,pd.getQuentityAded());
			 pstmt.setString(5,pd.getMrp());
			 
			 
			 int rowsAffected = pstmt.executeUpdate();
			  System.out.println(rowsAffected + "row(s) inserted .");
		  }catch(SQLException ex) {
			  ex.printStackTrace();			 
		  }
		
		
	}
	@Override
	public List<Product> getAllProduct() {

		List<Product> plist = new ArrayList<>();

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
			String sql = "select * from Productdetails";
			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				Product p = new Product();

				p.setId(rs.getString("Id"));
				p.setName(rs.getString("Name"));
				p.setQuantity(rs.getString("Quantity"));
				p.setQuentityAded(rs.getString("QuentityAdded"));
				p.setMrp(rs.getString("Mrp"));

			  plist.add(p);
			
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return plist;
	}
	@Override
	public void updateProduct(Product ps) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
				PreparedStatement pstmt = con.prepareStatement(
						"update  Productdetails set Id= ?, Name= ?, Quantity= ?, QuantityAdded= ?, Mrp= ? where id = ? ")) {
			
			pstmt.setString(1,ps.getId());
			pstmt.setString(2, ps.getName());
			pstmt.setString(3, ps.getQuantity());
			pstmt.setString(4, ps.getQuentityAded());
			pstmt.setString(5, ps.getMrp());

			int rowsAffected = pstmt.executeUpdate();
			System.out.println(rowsAffected + "row(s) updated .");
		} catch (SQLException ex) {
			ex.printStackTrace();
			

		}

	}
	@Override
	public List<Product> searchProduct(String data) {
		// TODO Auto-generated method stub
		return null;
	}
}

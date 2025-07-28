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
import com.model.User;
import com.model.User2Login;
import com.model.UserLogin;

public class  UserServiceImpl implements UserService{
	@Override
	public void addUser(User user) {
		 
		try {
            // Establish database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
            
            // Prepare SQL statement
            String sql = "INSERT INTO User (FirstName, LastName, Username, Password, Retypepass, BirthDate, Address) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastname());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword() );
            pstmt.setString(5, user.getRetypepass());
            pstmt.setString(6, user.getBirthdate());
            pstmt.setString(7, user.getAddress());
            
            // Execute the insert query
           //int rowsAffected = pstmt.executeUpdate();
            pstmt.executeUpdate();
          
            // Close resources
            pstmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
	}
	
	@Override
	public void addUserLogin(UserLogin us) {
	    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
	         PreparedStatement pstmt = con.prepareStatement("INSERT INTO UserLogin (Username,Password) VALUES (?,?)")) {

	        pstmt.setString(1, us.getUsername());
	        pstmt.setString(2, us.getPassword());

	        int rowsAffected = pstmt.executeUpdate();
	        System.out.println(rowsAffected + " row(s) inserted.");

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		}
	
	
	public void addUser2Login(User2Login u2) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickbill", "root", "");
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO userloginb (Username,Password) VALUES (?,?)")) {
 
              pstmt.setString(1, u2.getUsername());
              pstmt.setString(2, u2.getPassword());
	        int rowsAffected = pstmt.executeUpdate();
	        System.out.println(rowsAffected + " row(s) inserted.");

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		}

	@Override
	public List<Product> getAllProductinfo() {

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
	public void addUseru2Login(User2Login u2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}
}

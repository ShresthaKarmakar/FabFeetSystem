package FabFeetDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import FabFeetWorking.Customers;

public class CustomersDAO {

	public static boolean insertNewCustomer(Customers cust) {
		Connection c = ConnectToDB.getConnection();
		
		boolean flag = false;
		
		String sql = "insert into orcluser.customers(customer_name,customer_phone) values(?,?)";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, cust.getCustomer_name());
			ps.setInt(2, cust.getCustomer_phone());
			
			
			int res = ps.executeUpdate();
			if(res > 0) {
				//System.out.println("Row inserted");
				flag = true;
			}
			ConnectToDB.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
}

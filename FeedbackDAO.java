package FabFeetDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import FabFeetWorking.Feedback;
import FabFeetWorking.Products;

public class FeedbackDAO {

	
	public static ArrayList<Feedback> listFeedback(){
		Connection con = ConnectToDB.getConnection();
		ArrayList<Feedback> feed = new ArrayList<Feedback>();
		
		Feedback fb;
		
		String sql = "select * from feedback";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next() == false) {
				System.out.println("No Feedback");
			}else {
				do {
					fb  = new Feedback();
					fb.setReview_id(rs.getInt("review_id"));
					fb.setBranch_id(rs.getInt("branch_id"));
					fb.setCustomer_name(rs.getString("customer_name"));
					fb.setProduct_name(rs.getString("product_name"));
					fb.setReview(rs.getString("review"));
					feed.add(fb);
				}while(rs.next());
			}
			
			ConnectToDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feed;
	}
	
	
	
	
	
	public static boolean insertFeedback(Feedback fb) {
		Connection c = ConnectToDB.getConnection();
		
		boolean flag = false;
		
		String sql = "insert into orcluser.feedback(branch_id,customer_name,product_name,review) values(?,?,?,?)";
		
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, fb.getBranch_id());
			ps.setString(2,fb.getCustomer_name());
			ps.setString(3, fb.getProduct_name());
			ps.setString(4, fb.getReview());
			
			
			
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

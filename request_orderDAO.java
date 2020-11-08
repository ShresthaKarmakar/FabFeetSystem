package FabFeetDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import FabFeetWorking.Products;
import FabFeetWorking.request_order;

public class request_orderDAO {

	public static ArrayList<request_order> listrequest_order(){
		Scanner sc=new Scanner(System.in);
		int choice=0;
		Connection con = ConnectToDB.getConnection();
		ArrayList<request_order> ro = new ArrayList<request_order>();
		
		request_order req;
		System.out.println("Enter 1 if you want to view request orders of all the branches");
		System.out.println("Enter 2 if you want to view request orders of a specific branch only");
		choice=sc.nextInt();
		if(choice==1) {
		
		String sql = "select * from request_order";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next() == false) {
				System.out.println("No Orders");
			}else {
				do {
					req  = new request_order();
					req.setBranch_id(rs.getInt("request_id"));
					req.setManager_id(rs.getInt("manager_id"));
					req.setProduct_id(rs.getInt("product_id"));
					req.setProduct_size(rs.getInt("product_size"));
					req.setProduct_design(rs.getInt("product_design"));
					req.setQty(rs.getInt("qty"));
					ro.add(req);
				}while(rs.next());
			}
			
			ConnectToDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}else
		if(choice==2) {
			int b=0;
			String sql=null;
			Connection c = ConnectToDB.getConnection();
			
			boolean flag = false;
			System.out.println("Enter the branch ID:");
			b=sc.nextInt();
			if(b==1) {
			sql = "select * from request_order where branch_id=1";
			}else
		    if(b==2) {
		    sql = "select * from request_order where branch_id=2";	
		    }else
		    if(b==3) {
		    sql = "select * from request_order where branch_id=3";
		    }else
			if(b==4) {
			sql = "select * from request_order where branch_id=4";
			}else
			if(b==5) {
			sql = "select * from request_order where branch_id=5";
			}else
			if(b==6) {
		    sql = "select * from request_order where branch_id=6";
			}
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.next() == false) {
					System.out.println("No Products");
				}else {
					do {
						req  = new request_order();
						req.setBranch_id(rs.getInt("request_id"));
						req.setManager_id(rs.getInt("manager_id"));
						req.setProduct_id(rs.getInt("product_id"));
						req.setProduct_size(rs.getInt("product_size"));
						req.setProduct_design(rs.getInt("product_design"));
						req.setQty(rs.getInt("qty"));
						ro.add(req);
					}while(rs.next());
				}
				
				ConnectToDB.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return ro;
	}
	
	
	
	
	public static boolean insertNewOrder(request_order r) {
		Connection c = ConnectToDB.getConnection();
		
		boolean flag = false;
		
		String sql = "insert into request_order(branch_id,manager_id,product_id,product_size,product_design,qty) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, r.getBranch_id());
			ps.setInt(2, r.getManager_id());
			ps.setInt(3, r.getProduct_id());
			ps.setInt(4, r.getProduct_size());
			ps.setInt(5, r.getProduct_design());
			ps.setInt(6, r.getQty());
			
			
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

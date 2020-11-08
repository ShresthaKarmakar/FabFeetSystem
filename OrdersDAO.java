package FabFeetDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import FabFeetWorking.Orders;
import FabFeetWorking.Products;

public class OrdersDAO {
	
	

	public static boolean insertNewOrder(Orders o) {
	Connection c = ConnectToDB.getConnection();
	
	boolean flag = false;
	
	String sql = "insert into orders(customer_id,product_id,branch_id,size_product,qty,amount,date_purchased) values(?,?,?,?,?,?,?)";
	
	try {
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, o.getCustomer_id());
		ps.setInt(2, o.getProduct_id());
		ps.setInt(3, o.getBranch_id());
		ps.setInt(4, o.getSize());
		ps.setInt(5, o.getQty());
		ps.setInt(6, o.getAmount());
		ps.setString(7, o.getDate_purchased());
		
		
		int res = ps.executeUpdate();
		if(res > 0) {
			//System.out.println("Row inserted");
			flag = true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return flag;
}
	
public static void cancelExistingOrder(int c_id,int p_id) {
		
		Connection c = ConnectToDB.getConnection();
		
		boolean flag = false;
		String sql1="commit";
		String sql = "delete from orders where customer_id=? and product_id=? ";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, c_id );
			ps.setInt(2, p_id);
			
			ps.executeUpdate();
			PreparedStatement ps1 = c.prepareStatement(sql1);
			ps1.executeQuery();
			System.out.println("Stock updated");
			ProductsDAO.productUpdate(p_id);
			ConnectToDB.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

public static ArrayList<Orders> listAll(){
	Scanner sc=new Scanner(System.in);
	Connection con = ConnectToDB.getConnection();
	ArrayList<Orders> o = new ArrayList<Orders>();
	
	Orders ord;
		
	String sql = "select * from orders";
	try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next() == false) {
			System.out.println("No Orders");
		}else {
			do {
				ord  = new Orders();
				ord.setOrder_id(rs.getInt("order_id"));
				ord.setCustomer_id(rs.getInt("customer_id"));
				ord.setProduct_id(rs.getInt("product_id"));
				ord.setBranch_id(rs.getInt("branch_id"));
				ord.setSize(rs.getInt("size_product"));
				ord.setQty(rs.getInt("qty"));
				ord.setAmount(rs.getInt("amount"));
				ord.setDate_purchased(rs.getString("date_purchased"));
				o.add(ord);
			}while(rs.next());
		}
		
		ConnectToDB.closeConnection(con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return o;

}

public static ArrayList<Orders> listCustomer(int c_id){
	Connection con = ConnectToDB.getConnection();
	ArrayList<Orders> o = new ArrayList<Orders>();
	
	Orders ord;
		
	String sql = "select * from orders where customer_id=?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,c_id);
		ResultSet rs=ps.executeQuery();
		if(rs.next() == false) {
			System.out.println("No Orders");
		}else {
			do {
				ord  = new Orders();
				ord.setOrder_id(rs.getInt("order_id"));
				ord.setCustomer_id(rs.getInt("customer_id"));
				ord.setProduct_id(rs.getInt("product_id"));
				ord.setBranch_id(rs.getInt("branch_id"));
				ord.setSize(rs.getInt("size_product"));
				ord.setQty(rs.getInt("qty"));
				ord.setAmount(rs.getInt("amount"));
				ord.setDate_purchased(rs.getString("date_purchased"));
				o.add(ord);
			}while(rs.next());
		}
		ConnectToDB.closeConnection(con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return o;	
}

public static ArrayList<Orders> listBranch(){
int b=0;
String sql=null;
Scanner sc=new Scanner(System.in);
Connection con = ConnectToDB.getConnection();
ArrayList<Orders> o = new ArrayList<Orders>();

Orders ord;

boolean flag = false;
System.out.println("Enter the branch ID:");
b=sc.nextInt();
if(b==1) {
sql = "select * from orders where branch_id=1";
}else
if(b==2) {
sql = "select * from orders where branch_id=2";	
}else
if(b==3) {
sql = "select * from orders where branch_id=3";
}else
if(b==4) {
sql = "select * from orders where branch_id=4";
}else
if(b==5) {
sql = "select * from orders where branch_id=5";
}else
if(b==6) {
sql = "select * from orders where branch_id=6";
}
Statement stmt;
try {
	stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	if(rs.next() == false) {
		System.out.println("No POrders in this branch");
	}else {
		do {
			ord  = new Orders();
			ord.setOrder_id(rs.getInt("order_id"));
			ord.setCustomer_id(rs.getInt("customer_id"));
			ord.setProduct_id(rs.getInt("product_id"));
			ord.setBranch_id(rs.getInt("branch_id"));
			ord.setSize(rs.getInt("size_product"));
			ord.setQty(rs.getInt("qty"));
			ord.setAmount(rs.getInt("amount"));
			ord.setDate_purchased(rs.getString("date_purchased"));
			o.add(ord);
		}while(rs.next());
	}
	
	ConnectToDB.closeConnection(con);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

return o;
}



}



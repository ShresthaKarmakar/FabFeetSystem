package FabFeetDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import FabFeetWorking.Customers;
import FabFeetWorking.Products;

public class ProductsDAO {
	
	public static ArrayList<Products> findProducts(){
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Products prod;
		ArrayList<Products> p = new ArrayList<Products>();
		System.out.println("Product name to Search: ");
		String prod_name=null;
		try {
			prod_name = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection connection = ConnectToDB.getConnection();
		String sql = "select * from products where product_name = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, prod_name);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next() == false) {
				System.out.println("No such products");
			}else {
				do {
					prod  = new Products();
					prod.setProduct_id(rs.getInt("product_id"));
					prod.setProduct_name(rs.getString("product_name"));
					prod.setSize(rs.getInt("size_product"));
					prod.setQty(rs.getInt("qty"));
					prod.setDesign(rs.getInt("design"));
					p.add(prod);
				}while(rs.next());
				}
			
			ConnectToDB.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
		
	}
		
	
	
	
	
	public static ArrayList<Products> listProducts(){
		Scanner sc=new Scanner(System.in);
		int choice=0;
		Connection con = ConnectToDB.getConnection();
		ArrayList<Products> p = new ArrayList<Products>();
		
		Products prod;
		System.out.println("Enter 1 if you want to view products and stock of all the branches");
		System.out.println("Enter 2 if you want to view products and stock of a specific branch only");
		choice=sc.nextInt();
		if(choice==1) {
		
		String sql = "select * from products";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next() == false) {
				System.out.println("No Products");
			}else {
				do {
					prod  = new Products();
					prod.setProduct_id(rs.getInt("product_id"));
					prod.setProduct_name(rs.getString("product_name"));
					prod.setSize(rs.getInt("size_product"));
					prod.setQty(rs.getInt("qty"));
					prod.setDesign(rs.getInt("design"));
					p.add(prod);
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
			sql = "select * from products where branch_id=1";
			}else
		    if(b==2) {
		    sql = "select * from products where branch_id=2";	
		    }else
		    if(b==3) {
		    sql = "select * from products where branch_id=3";
		    }else
			if(b==4) {
			sql = "select * from products where branch_id=4";
			}else
			if(b==5) {
			sql = "select * from products where branch_id=5";
			}else
			if(b==6) {
		    sql = "select * from products where branch_id=6";
			}
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.next() == false) {
					System.out.println("No Products");
				}else {
					do {
						prod  = new Products();
						prod.setProduct_id(rs.getInt("product_id"));
						prod.setProduct_name(rs.getString("product_name"));
						prod.setSize(rs.getInt("size_product"));
						prod.setQty(rs.getInt("qty"));
						prod.setDesign(rs.getInt("design"));
						p.add(prod);
					}while(rs.next());
				}
				
				ConnectToDB.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return p;
	
	}
	
	public static boolean insertNewProduct(Products p) {
		Connection c = ConnectToDB.getConnection();
		
		boolean flag = false;
		
		String sql = "insert into products(product_name,branch_id,size_product,qty,price,design) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, p.getProduct_name());
			ps.setInt(2, p.getBranch_id());
			ps.setInt(3, p.getSize());
			ps.setInt(4, p.getQty());
			ps.setInt(5, p.getPrice());
			ps.setInt(6, p.getDesign());
			
			
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
	
	public static void updateStock(int p_id,int q) {
		
		Connection c = ConnectToDB.getConnection();
		
		boolean flag = false;
		String sql1="commit";
		String sql = "update products set qty=qty-? where product_id=?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, q);
			ps.setInt(2, p_id);
			
			ps.executeUpdate();
			PreparedStatement ps1 = c.prepareStatement(sql1);
			ps1.executeQuery();
			System.out.println("Stock updated");
			ConnectToDB.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

public static void productUpdate(int p_id) {
		
		Connection c = ConnectToDB.getConnection();
		
		boolean flag = false;
		String sql1="commit";
		String sql = "update products set qty=qty+1 where product_id=?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, p_id);
			ps.executeUpdate();
			PreparedStatement ps1 = c.prepareStatement(sql1);
			ps1.executeQuery();
			System.out.println("Stock updated");
			ConnectToDB.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

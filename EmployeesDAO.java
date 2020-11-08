package FabFeetDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import FabFeetWorking.Employees;
import FabFeetWorking.Products;

public class EmployeesDAO {

	public static ArrayList<Employees> listEmployees(){
		Scanner sc=new Scanner(System.in);
		int choice=0;
		Connection con = ConnectToDB.getConnection();
		ArrayList<Employees> e = new ArrayList<Employees>();
		
		Employees emp;
		System.out.println("Enter 1 if you want to view employees of all the branches");
		System.out.println("Enter 2 if you want to view employees of a specific branch only");
		choice=sc.nextInt();
		if(choice==1) {
		
		String sql = "select * from employees";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next() == false) {
				System.out.println("No Employees");
			}else {
				do {
					emp  = new Employees();
					emp.setEmployee_id(rs.getInt("employee_id"));
					emp.setEmployee_name(rs.getString("employee_name"));
					emp.setDesignation(rs.getString("designation"));
					emp.setBranch_id(rs.getInt("branch_id"));
					emp.setEmp_phone(rs.getLong("emp_phone"));
					emp.setSalary(rs.getLong("salary"));
					emp.setLeaves(rs.getLong("leaves"));
					emp.setTotal_working_days(rs.getLong("total_working_days"));
					e.add(emp);
				}while(rs.next());
			}
			
			ConnectToDB.closeConnection(con);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
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
			sql = "select * from employees where branch_id=1";
			}else
		    if(b==2) {
		    sql = "select * from employees where branch_id=2";	
		    }else
		    if(b==3) {
		    sql = "select * from employees where branch_id=3";
		    }else
			if(b==4) {
			sql = "select * from employees where branch_id=4";
			}else
			if(b==5) {
			sql = "select * from employees where branch_id=5";
			}else
			if(b==6) {
		    sql = "select * from employees where branch_id=6";
			}
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.next() == false) {
					System.out.println("No Employees in this branch");
				}else {
					do {
						emp  = new Employees();
						emp.setEmployee_id(rs.getInt("employee_id"));
						emp.setEmployee_name(rs.getString("employee_name"));
						emp.setDesignation(rs.getString("designation"));
						emp.setBranch_id(rs.getInt("branch_id"));
						emp.setEmp_phone(rs.getLong("emp_phone"));
						emp.setSalary(rs.getLong("salary"));
						emp.setLeaves(rs.getLong("leaves"));
						emp.setTotal_working_days(rs.getLong("total_working_days"));
						e.add(emp);
					}while(rs.next());
				}
				
				ConnectToDB.closeConnection(con);
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
			
		}
		return e;
	
	}
	
	
	
	
	public boolean validate(int id, String pass) {
		boolean flag = false;
		Connection connection = ConnectToDB.getConnection();
		String sql = "select password from employees where employee_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next() == false) {
				System.out.println("The user does not exist.Please try again");
			}else {
				String data = rs.getString("password");
				
				if(pass.equals(data)) {
					flag = true;
				}
			}
			ConnectToDB.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}

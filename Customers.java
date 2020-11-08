package FabFeetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import FabFeetDAO.CustomersDAO;
public class Customers {
	Scanner sc = new Scanner(System.in);
	private int customer_id;
	private String customer_name;
	private int customer_phone;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(int customer_phone) {
		this.customer_phone = customer_phone;
	}
	
	public void getCustomerDetails() {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				
		Customers cust = new Customers();
		System.out.println("Customer Name: ");
		String cname;
		try {
			cname = br.readLine();
			cust.setCustomer_name(cname);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				//sc.next();
		System.out.println("Customer Phone: ");
		cust.setCustomer_phone(sc.nextInt());
		
		
		
		boolean flag = CustomersDAO.insertNewCustomer(cust);
		
		if(flag == true)
			System.out.println("Customer added to the database");
		else
			System.out.println("Unable to add the Customer");
	}
}

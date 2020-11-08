package FabFeetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import FabFeetDAO.OrdersDAO;
import FabFeetDAO.ProductsDAO;

public class Orders {

	Scanner sc=new Scanner(System.in);
	private int order_id;
	private int customer_id;
	private int product_id;
	private int branch_id;
	private int size;
	private int qty;
	private int amount;
	String date_purchased;
	//private Date date;
	
	public int getOrder_id() {
		return order_id;
	}
	public String getDate_purchased() {
		return date_purchased;
	}
	public void setDate_purchased(String date_purchased) {
		this.date_purchased = date_purchased;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}

	@Override
	public String toString() {
		return "Order Details [order_id=" + order_id + ", Customer ID=" + customer_id + ", Product ID=" + product_id
				+ ", Branch ID=" + branch_id + ", Size=" + size + ",Quantity="+qty+",Amount="+amount+"]";
	}
	public void viewAll() {
ArrayList<Orders> orderList = new ArrayList<Orders>();
		
		orderList = OrdersDAO.listAll();
		for(Orders order: orderList) {
			System.out.println(order.toString());
		}	
	}
	
	public void viewBranch() {
		ArrayList<Orders> orderList = new ArrayList<Orders>();
				
				orderList = OrdersDAO.listBranch();
				for(Orders order: orderList) {
					System.out.println(order.toString());
				}	
			}
			
	public void viewCustomers() {
		ArrayList<Orders> orderList = new ArrayList<Orders>();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the customer ID whose orders you want to view");
		int c_id=0;
		c_id=sc.nextInt();
				 orderList=OrdersDAO.listCustomer(c_id);
				for(Orders order: orderList) {
					System.out.println(order.toString());
				}	
			}
	
	public void placeOrder() {
		
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			int p_id=0;
			int qty=0;
			Orders o = new Orders();
			System.out.println("Your Customer Id: ");
			o.setCustomer_id(sc.nextInt());
			System.out.println("Product ID: ");
			p_id=sc.nextInt();
			o.setProduct_id(p_id);
			
			System.out.println("Branch ID: ");
			o.setBranch_id(sc.nextInt());
			
			System.out.println("Size: ");
			o.setSize(sc.nextInt());
			
			System.out.println("Quantity: ");
			qty=sc.nextInt();
			o.setQty(qty);
			
			System.out.println("Amount: ");
			o.setAmount(sc.nextInt());
			
			System.out.println("Date:(MM/dd/yyyy): ");
			//String strDate = "29/07/2020";
			String strDate=null;
			strDate=sc.next();

			
			 SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
			    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
			    Date date;
				try {
					date = format1.parse(strDate);
					 System.out.println(format2.format(date));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		      
			boolean flag = OrdersDAO.insertNewOrder(o);
			
			if(flag == true) {
				System.out.println("Order placed successfully!!");
			    ProductsDAO.updateStock(p_id,qty);	
				
			}
			else
				System.out.println("Order could not be placed!!");
		}
	
	
public void cancelOrder() {
	
	
	int p_id=0;
	int c_id=0;
	Orders o = new Orders();
	System.out.println("Your Customer Id: ");
	c_id=sc.nextInt();
	o.setCustomer_id(c_id);
	System.out.println("Product ID: ");
	p_id=sc.nextInt();
	o.setProduct_id(p_id);

	OrdersDAO.cancelExistingOrder(c_id,p_id);
	
		System.out.println("Order cancelled successfully!!");
	    
	
}
}



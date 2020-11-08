package FabFeetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import FabFeetDAO.ProductsDAO;
import FabFeetDAO.request_orderDAO;
import java.util.*;
public class request_order {

	Scanner sc=new Scanner(System.in);
	private int request_id;
	private int branch_id;
	private int manager_id;
	private int product_id;
	private int product_size;
	private int product_design;
	private int qty;
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_size() {
		return product_size;
	}
	public void setProduct_size(int product_size) {
		this.product_size = product_size;
	}
	public int getProduct_design() {
		return product_design;
	}
	public void setProduct_design(int product_design) {
		this.product_design = product_design;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public void getOrderPlaced() {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int branch_id=0;
		int manager_id=0;
		int product_id=0;
		int product_size=0;
		int product_design=0;
		int qty=0;
		request_order r = new request_order();
		System.out.println("Branch ID: ");
		r.setBranch_id(sc.nextInt());
		
		System.out.println("Manager ID: ");
		r.setManager_id(sc.nextInt());
		
		System.out.println("Product ID: ");
		r.setManager_id(sc.nextInt());
		
		System.out.println("Product Size: ");
		r.setProduct_size(sc.nextInt());
		
		System.out.println("Product Design: ");
		r.setProduct_design(sc.nextInt());
		
		System.out.println("Quantity-Enter 6 if you want to order the entire set of all the sizes: ");
		r.setQty(sc.nextInt());
		
		boolean flag = request_orderDAO.insertNewOrder(r);
		
		if(flag == true)
			System.out.println("Order placed Sucessfully!!!");
		else
			System.out.println("Order not placed.Please try again!!!!");
	}
	@Override
	public String toString() {
		return "The orders requested are: [request_id=" + request_id + ", Branch ID=" + branch_id + ", Manager ID=" + manager_id
				+ ", Product ID=" + product_id + ", Product Size=" + product_size + ",Product Design="+product_design+",Quantity="+qty+"]";
	}
	public void viewOrders() {
ArrayList<request_order> requestList = new ArrayList<request_order>();
		
		requestList = request_orderDAO.listrequest_order();
		for(request_order request: requestList) {
			System.out.println(request.toString());
		}	
	}
	
}

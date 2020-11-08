package FabFeetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import FabFeetDAO.CustomersDAO;
import FabFeetDAO.ProductsDAO;

public class Products {
Scanner sc=new Scanner(System.in);
	private int product_id;
	private String product_name;
	private int branch_id;
	private int size;
	private int qty;
	private int price;
	private int design;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDesign() {
		return design;
	}
	public void setDesign(int design) {
		this.design = design;
	}
	@Override
	public String toString() {
		return "Product Details [product_id=" + product_id + ", product Name=" + product_name + ", Branch ID=" + branch_id
				+ ", Size=" + size + ", Quantity=" + qty + ",Price="+qty+",Design="+design+"]";
	}
	public void viewProductDetails() {
ArrayList<Products> prodList = new ArrayList<Products>();
		
		prodList = ProductsDAO.listProducts();
		for(Products prod: prodList) {
			System.out.println(prod.toString());
		}	
	}
	
	
	
	public void getProductDetails() {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				
		Products p = new Products();
		System.out.println("Product Name: ");
		String pname;
		try {
			pname = br.readLine();
			p.setProduct_name(pname);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				//sc.next();
		System.out.println("Branch ID: ");
		p.setBranch_id(sc.nextInt());
		
		System.out.println("Size: ");
		p.setSize(sc.nextInt());
		
		System.out.println("Quantity: ");
		p.setQty(sc.nextInt());
		
		System.out.println("Price: ");
		p.setPrice(sc.nextInt());
		
		System.out.println("Design: ");
		p.setDesign(sc.nextInt());
		
		boolean flag = ProductsDAO.insertNewProduct(p);
		
		if(flag == true)
			System.out.println("Product added to the database");
		else
			System.out.println("Unable to add the Product");
	}
	
	public void productSearch() {
ArrayList<Products> prodList = new ArrayList<Products>();
		
		prodList = ProductsDAO.findProducts();
		for(Products prod: prodList) {
			System.out.println(prod.toString());
		}
	}
}

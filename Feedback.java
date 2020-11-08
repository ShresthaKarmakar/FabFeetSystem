package FabFeetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import FabFeetDAO.CustomersDAO;
import FabFeetDAO.FeedbackDAO;
import FabFeetDAO.ProductsDAO;

public class Feedback {

	Scanner sc=new Scanner(System.in);
	private int review_id;
	private int branch_id;
	private String customer_name;
	private String product_name;
	private String review;
	public int getReview_id() {
		return review_id;
	}
	
	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	@Override
	public String toString() {
		return "FEEDBACK [review_id=" + review_id + ", Branch ID=" + branch_id + ", Customer Name=" + customer_name
				+ ", Feedback=" + review +"]";
	}
	public void viewFeedback() {
    ArrayList<Feedback> feedList = new ArrayList<Feedback>();
		
		feedList = FeedbackDAO.listFeedback();
		for(Feedback feed: feedList) {
			System.out.println(feed.toString());
		}	
	}
	
	public void giveFeedback() {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				
		Feedback fb=new Feedback();
		System.out.println("Customer Name: ");
		String cname;
		String pname;
		String review;
		try {
			cname = br.readLine();
			fb.setCustomer_name(cname);
			System.out.println("Product Name: ");
			pname=br.readLine();
			fb.setProduct_name(pname);
			System.out.println("Review: ");
			review=br.readLine();
			fb.setReview(review);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				//sc.next();
		System.out.println("Enter branch ID:");
		fb.setBranch_id(sc.nextInt());
		
		
		boolean flag = FeedbackDAO.insertFeedback(fb);
		
		if(flag == true)
			System.out.println("Thank you for your Feedback!!!!");
		else
			System.out.println("Unable to add the Feedback");
	}
	
}

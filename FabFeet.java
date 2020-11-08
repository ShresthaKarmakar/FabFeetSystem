package FabFeetManager;
import java.util.*;

import FabFeetWorking.Customers;
import FabFeetWorking.Employees;
import FabFeetWorking.Feedback;
import FabFeetWorking.Orders;
import FabFeetWorking.Products;
import FabFeetWorking.request_order;
public class FabFeet {

static Scanner sc = new Scanner(System.in);
	
	static void mainMenu() {
				int choice = 0;
                int your_post=0;

                System.out.println("********** WELCOME TO FABFEET SHOP *************");
                System.out.println("Enter Your choice!!!!");
                System.out.println("If you are a customer then Press 1");
                System.out.println("If you are a owner then Press 2");
                System.out.println("If you are a manager then Press 3");
                
                your_post=sc.nextInt();
        
                
                if(your_post==1)
                {
                	do {
                		
                		System.out.println();
                		System.out.println("1. Product Search");
                		System.out.println("2. Placing product order");
                		System.out.println("3. Cancel order");
                		System.out.println("4. Return Order ");
                		System.out.println("5. Feedback");
                		
                		System.out.println("Enter your choice: ");
                		choice = sc.nextInt();
                		
                		switch(choice) {
                		case 1: System.out.println("Product Search");
                				new Products().productSearch();
                				break;
                		case 2: System.out.println("Placing product order");
                		int ch=0;
                		boolean flag=false;
                		String name=null;
                		Long phone;
                		System.out.println("Register if not registered and press '1'  or press '2' if already registered:");
                		ch=sc.nextInt();
                		if(ch==1) {
                			new Customers().getCustomerDetails();
                			new Orders().placeOrder();
                			
                		}else
                		if(ch==2) {
//                				System.out.println("Enter your name and phone number to fetch Your ID and then proceed");
//                				System.out.println("Enter your name:");
//                				name=sc.next();
//                				System.out.println("Enter your phone number:");
//                				phone=sc.nextLong();
//                				flag=new Customers().validateCustomer(name,phone);
//                				if(flag!=false) {
                					new Orders().placeOrder();
//                				}else
//                				{
//                					System.out.println("Please register Yourself!!No records Found !!");
//                				}
                			}
                		
                				
                				break;
                		case 3: System.out.println("Cancel order");
                		        new Orders().cancelOrder();
                				break;
                		case 4: System.out.println("Return Order");
                				new Orders().cancelOrder();
                				System.out.println("Your order is cancelled!!!Please make another order!!!");
                				new Orders().placeOrder();
                				break;
                		case 5: System.out.println("Feedback");
                		        new Feedback().giveFeedback();
                		        
        				        break;
                		default:System.out.println("Exiting!!!!"); 
                				System.exit(0);
                				break;
                	        }
                       }while(choice>1 && choice<5);
                }
                
                else
                	
          if(your_post==2)
          {
		           login1();
					
		  }
          else
          	
          if(your_post==3)
           {
    	          login2();
    	   }
	}
   static void owner_call() {  
	   int choice=0;
	do {
		System.out.println("********** WELCOME TO FABFEET SHOP*************");
        System.out.println();
        System.out.println("1. View Request Orders");
        System.out.println("2. View Employees");
        System.out.println("3. View Customer Feedbacks");
        System.out.println("4. View Stocks and products ");
        System.out.println("5. View all the orders of all branches and customers ");
        System.out.println("6. View Orders of a particular branch ");
        System.out.println("7. View orders of a particular customer ");
        System.out.println("8. Exit");

    System.out.println("Enter your choice: ");
    choice = sc.nextInt();

   
		switch(choice) {
		case 1: System.out.println(" View Orders");
				new request_order().viewOrders();
				break;
		case 2: System.out.println(" View Employees");
				new Employees().viewEmployeeDetails();
				break;
		case 3: System.out.println(" View Customer Feedbacks");
		        new Feedback().viewFeedback();
				break;
		case 4: System.out.println(" View Stocks and products");
		        new Products().viewProductDetails();
				break;
		case 5:System.out.println("5. View all the orders of all branches and customers ");
				new Orders().viewAll();
		        break;
		case 6:System.out.println("6. View Orders of a particular branch ");
				new Orders().viewBranch();
		        break;
		case 7:System.out.println("7. View orders of a particular customer ");
				new Orders().viewCustomers();
				break;
		default:System.out.println("Exiting!!!!"); 
				System.exit(0);
				break;
	        }
    
	}while(choice>1 && choice<8);
   }
   
   static void manager_call() {  
	   int choice=0;
	do {
		System.out.println("********** WELCOME TO FABFEET SHOP*************");
        System.out.println("1. Register a product");
		System.out.println("2. View stock and product");
		System.out.println("3. View employee");
		System.out.println("4. Check customer Feedback");
		System.out.println("5. Create customer profile");
		System.out.println("6. Billing");
		System.out.println("7. Request a new order");
		System.out.println("8. Exit");

    System.out.println("Enter your choice: ");
    choice = sc.nextInt();

   
		switch(choice) {
		case 1: System.out.println("Register a product");
				new Products().getProductDetails();
				break;
		case 2: System.out.println("View stock and product");
		        new Products().viewProductDetails();
				break;
		case 3: System.out.println("View employee");
		        new Employees().viewEmployeeDetails();
				break;
		case 4: System.out.println(" Check customer Feedback");
				new Feedback().viewFeedback();
				break;
		case 5: System.out.println(" Create customer profile");
				new Customers().getCustomerDetails();
				break;
		case 6: System.out.println("Billing");
				break;
		case 7: System.out.println("Request a new order");
		        new request_order().getOrderPlaced();
		        break;
		default:System.out.println("Exiting!!!!"); 
				System.exit(0);
				break;
	        }
    
	}while(choice>1 && choice<8);
   }
   
   
	static void login1() {
		System.out.println("******WELCOME TO FABFEET SHOP********");
		System.out.println();
		
		System.out.print("Enter the password : ");
		String pass = sc.next();
		
		
		if(pass.equals("owner_fabfeet123")) {
			owner_call();
		}else {
			System.out.println("A wrong password!!!Access Denied!!!!");
		}
		
	}
	
	static void login2() {
		System.out.println("******WELCOME TO FABFEET SHOP********");
		System.out.println();
		System.out.print("Enter your ID: ");
		int id = sc.nextInt();
		System.out.print("Enter the password : ");
		String pass = sc.next();
		
		boolean flag = Employees.validateCredentials(id, pass);
		if(flag == true) {
			manager_call();
		}else {
			System.out.println("Wrong ID or Password. Please try again!");
			System.exit(0);
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		mainMenu();
	}

}

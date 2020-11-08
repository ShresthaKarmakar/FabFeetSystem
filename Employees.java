package FabFeetWorking;

import java.util.ArrayList;

import FabFeetDAO.EmployeesDAO;
import FabFeetDAO.ProductsDAO;

public class Employees {

	private int employee_id;
	private String employee_name;
	private String designation;
	private String password;
	private int branch_id;
	private Long emp_phone;
	private Long salary;
	private Long leaves;
	private Long total_working_days;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public Long getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(Long emp_phone) {
		this.emp_phone = emp_phone;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public Long getLeaves() {
		return leaves;
	}
	public void setLeaves(Long leaves) {
		this.leaves = leaves;
	}
	public Long getTotal_working_days() {
		return total_working_days;
	}
	public void setTotal_working_days(Long total_working_days) {
		this.total_working_days = total_working_days;
	}
	@Override
	public String toString() {
		return "Employee Details [employee_id=" + employee_id + ", employee Name=" + employee_name + ", Employee Password=" + password
				+ ", Designation=" + designation + ", Branch ID=" + branch_id + ",Phone="+emp_phone+",Salary="+salary
				+",Leaves"+leaves+"total Working Days"+total_working_days+"]";
	}
	public void viewEmployeeDetails() {
		ArrayList<Employees> empList = new ArrayList<Employees>();
		
		empList = EmployeesDAO.listEmployees();
		for(Employees emp: empList) {
			System.out.println(emp.toString());
		}	
	}
	
	
	
	public static boolean validateCredentials(int id, String pass) {
		return new EmployeesDAO().validate(id, pass);
	}
}

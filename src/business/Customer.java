package business;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import DataManager.CustomerDataManager;


public class Customer
{
	private String name;
	private String address;
	private String telno;
	private String gas_type;
	private double balance;
	private CustomerDataManager temp = new CustomerDataManager();
	private ArrayList<String[]> cust = new ArrayList<String[]>();
	
	
	public Customer(String name, String address, String tel_number, String gas_type, double balance){
		
		this.name = name;
		this.address = address;
		this.telno = tel_number;
		this.gas_type = gas_type;
		this.balance = balance;
		
	}
	
	public Customer()
	{
		List<List<String>> i = temp.getCustomer();
		
		for (List<String> x: i)
		{
			String[] objs = {x.get(0),x.get(1),x.get(4),x.get(5),x.get(6)};
			cust.add(objs);
		}
	
	}
	
	public ArrayList<String[]> getCustomer()
	{
		return cust;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNo() {
		return telno;
	}

	public void setTelNo(String telno) {
		this.telno = telno;
	}
	
	public String getGasType() {
		return gas_type;
	}
	
	public void setGasType(String type) {
		gas_type = type;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String balToString(double balance) {
		String s = Double.toString(balance);
		return s;
	}
	
	
	public String toString() {
		return name + " " + address + " " + telno + " " + gas_type + " "
				+ balance;
	}

}

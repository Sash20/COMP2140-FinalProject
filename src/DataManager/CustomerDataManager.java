package DataManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.Customer;


public class CustomerDataManager 
{
	Customer u;
	String name;
	File file = new File("Customer.txt");
	private List<List<String>> users = new ArrayList<List<String>>();
	private List<String> cust;	
	String end = "";
	String s = "";
	Scanner scan;
	String line = "";
	
	public CustomerDataManager()
	{
		readFromFile();
	}

	public void readFromFile()
	{
		try
		{
			scan = new Scanner(file);
			while (scan.hasNext()) 
			{
				s = scan.nextLine();
				String[] cust = s.split(";");
				//String b = String.valueOf(u.getBalance());
				String balance =u.getBalance();
				String bal = u.balToString(balance);
				
					String name = cust[0];
		    		String address = cust[1];
		    		String telNo = cust[2];
		    		String gas_type = cust[3];
		    		bal = cust[4];
		    		
		    		cust = new ArrayList<String>();
		    	
	    			cust.add(name);
	    			cust.add(address);
	    			cust.add(telNo);
	    			cust.add(gas_type);
	    			cust.add(balance);
	    		
	    			customer.add(empl);
	    	}
		}
		catch (IOException e)
    	{
    		System.out.println(e);
    	}
	}
	
	public List<List<String>> getUsers()
	{
		return users;
	}
	
	public String searchCustomer(String name) throws IOException {
		Scanner scans = new Scanner(file);
		String line = "";
		while (scans.hasNext()) {
			String s = scans.nextLine().toString();
			if (s.contains(name)){
				line = line + s + "\n";
			}
		}return line;
	}
	
	public void addCustomer(String name, String address, String telno,
			String gas_type, double balance) throws IOException {

		Customer newCustomer = new Customer(name, address, telno, gas_type, balance);
		line = newCustomer.toString();
		
		addToFile(file);
	}
	
	public void addToFile(File file) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter pw = new BufferedWriter(fw);
		
		pw.newLine();
		pw.write(line);
		
		pw.close();
		fw.close();
		
		System.out.println("Record has been successfully added");
	}
	
	public static void main(String[] args) {
		
	}
}

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

import business.User;


public class UserDataManager 
{
	User u;
	String name;
	File file = new File("User.txt");
	private List<List<String>> users = new ArrayList<List<String>>();
	private List<String> empl;	
	String end = "";
	String s = "";
	Scanner scan;
	String line = "";
	
	public UserDataManager()
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
				String[] emp = s.split(";");
				
				String firstname = emp[0];
		    		String lastname = emp[1];
		    		String username = emp[2];
		    		String pw = emp[3];
		    		String DOB = emp[4];
		    		String DOE = emp[5];
		    		String address = emp[6];
		    		
		    		empl = new ArrayList<String>();
		    	
	    			empl.add(firstname);
	    			empl.add(lastname);
	    			empl.add(username);
	    			empl.add(pw);
	    			empl.add(DOB);
	    			empl.add(DOE);
	    			empl.add(address);
	    		
	    			users.add(empl);
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
	
	public String searchEmployee(String username) throws IOException {
		Scanner scans = new Scanner(file);
		String line = "";
		while (scans.hasNext()) {
			String s = scans.nextLine().toString();
			if (s.contains(username)){
				line = line + s + "\n";
			}
		}return line;
	}
	
	public void addEmployee(String fname, String lname, String uname,
			String pw, String DOB, String DOE, String address) throws IOException {

		User newUser = new User(fname, lname, uname, pw, DOB, DOE, address);
		line = newUser.toString();
		
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

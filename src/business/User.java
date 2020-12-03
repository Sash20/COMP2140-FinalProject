package business;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import DataManager.UserDataManager;

public class User 
{
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String DOB;
	private String DOE;
	private String address;
	private UserDataManager temp = new UserDataManager();
	private ArrayList<String[]> users = new ArrayList<String[]>();
	
	
	public User(String fname, String lname, String uname, String pw, String DOB, String DOE, String address) 
	
	{
		firstName = fname;
		lastName = lname;
		username = uname;
		password = pw;
		this.DOB = DOB;
		this.DOE = DOE;
		this.address = address;
	}
	
	public User()
	{
		List<List<String>> i = temp.getUsers();
		
		for (List<String> x: i)
		{
			String[] objs = {x.get(0),x.get(1),x.get(4),x.get(5),x.get(6)};
			users.add(objs);
		}
	
	}
	
	public ArrayList<String[]> getUsers()
	{
		return users;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}

	public String getUserName() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String pw) {
		this.password = pw;
	}
	
	public String getDOB() {
		return DOB;
	}
	
	public void setDOB(String date) {
		DOB = date;
	}
	
	public String getDOE() {
		return DOE;
	}
	
	public void setDOE(String date) {
		DOE = date;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return lastName + " " + firstName + " " + username + " " + password + " " + DOB + " "
				+ DOE + " " + address;
	}

}

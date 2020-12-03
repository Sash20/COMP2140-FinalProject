package business;

import java.util.ArrayList;

public class Sales {
	ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	public Sales() {
		transactions.clear();
	}
	
	//  parameter to be changed to string
	public void addTransaction(Transaction t1) {
		transactions.add(t1);
	}
	
	// Searches for transaction with given receipt number and removes it if it is present
	public void removeTransaction(int receiptNo) {
		boolean didRemove = false;
		for (Transaction t1: transactions) {
			if (t1.getReceiptNo() == receiptNo) {
				didRemove = transactions.remove(t1);
	        }
		}
		if (didRemove) {
			System.out.print("Transaction Removed!");
		}
		else{
			System.out.print("Invalid Receipt No!");
		}
	}
	
	public ArrayList getSavedList(ArrayList<Transaction> tempList) {
		transactions = tempList;
		return tempList;
	}
	
	public ArrayList<Transaction> tempList() {
		return transactions;
	}
	
	public String toString() {
		String print="";
		print+=("Sales: \n");
		for (Transaction i1: transactions) {
			print+=(i1.toString());
		}
		return print;
	}
	
	
}

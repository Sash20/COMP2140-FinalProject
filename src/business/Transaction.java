package business;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3056662237486790583L;

	ArrayList<Item> item = new ArrayList<Item>();
	ArrayList<Item> InventoryList = new ArrayList<Item>();
	
	private double gct, subTotal, tax, total;
	private int quantity, receiptNo;
	private Refund refItem;
	private static int counter = 20482;
	
	public Transaction(ArrayList<Item> InventoryList) {
		this.InventoryList=InventoryList;
		receiptNo=counter;
		counter++;
	}
	
	// Construct of 2 decimal place format
	DecimalFormat df2 = new DecimalFormat ("##.00");
	
	
public void addItem(String Item, int quantity) {
		
		//calculateSubTotal(Item.getSubTotal());
		for (Item item : InventoryList) {
	        // Access properties of item
	        if (item.getCode().equals(Item)) {
	            // Found matching person
	            item.setQuantity(quantity);
	            items.add(item);
	            InventoryList.decreaseStockLevel(item.getName(), quantity);
	        }
	    }

	    // Traversed whole list but did not find a matching person
	}
	
	public void refundItme(Item i1) {
		refItem(i1);
		item.remove(i1);
		total -= refItem.refAmount();
	}

	
	public void calculateSubTotal(double subTotal) {
		// Unit-Price multiplied by quantity and added to sub-total for transaction
		this.subTotal += (quantity * subTotal);
	}

	public void calculateTax(double subTotal) {
		// GCT calculated as 8% of sub-total of cost of a type of item and added to total tax for transaction
		this.tax += (0.08 * subTotal);
	}

	public void calculateTotal(double total) {
		//Total calculated and rounded to 2 decimal places
		total = Double.parseDouble((df2.format(tax+subTotal)));
	}
	
	////////////////////////////////// ACCESSORS
	public double getSubTotal() {
		return subTotal;
	}

	public double getTax() {
		return tax;
	}

	public double getTotal() {
		return total;
	}
	
	public int getReceiptNo() {
		return receiptNo;
	}
	
	public ArrayList<Item> returnUpdatedStock() {
		return InventoryList;
	}
	
	public String toString() {
		String print;
		print+=("Reciept No. "+ getReceiptNo()+"\n");
		for (Item i1: item) {
			print+=("Name: "+i1.getName()+" Quantity: "+i1.getQuantity()+" Price: $"+df2.format(i1.getPrice())));
		}
		print+=("GCT: $"+ getTax()+"\n");
		print+=("Total: $"+ getTotal()+"\n\n");
		
		return print;
	}
	
	
}


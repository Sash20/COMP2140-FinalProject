package business;


/**
 * An Inventory management system dedicated to viewing, editing, adding and deleting products from an inventory.
 *
 * @author (Shevon Chisholm)
 * @version (1.0)
 */
import java.util.ArrayList;
public class Inventory
{
    
    // An array that represents an inventory of products
    private ArrayList<Item> products = new ArrayList<Item>();
    
    // Inventory constructor
    public Inventory() {
        this.products.add(new Item("IGL Gas", "756", "100 lb", 2500.00, 10, 5));
        this.products.add(new Item("Valve", "101", "valve for hose", 1900.00, 20, 3));
    }
    
    public void addItem(String name, String code, double price, int quantity)
	{
		Item item = new Item(name, code, price,quantity);
		products.add(item);
	}
    
    
    // Increasing the quantity of a particular product
    public void increaseQuantity(String productName, int quan) {
        for (Item product : this.products) {
            if (productName.equals(product.getName())) {
                product.add(quan);
            }
        }
    }
    // Decreasing the quantity of a particular product
    public void decreaseQuantity(String productName, int quan) {
        for (Item product : this.products) {
            if (productName.equals(product.getName())) {
                if (product.getQuantity()>=0) {
                    product.remove(quan);
                }
                return;
            }
        }
    }

    // Creating a new product
    public void createProduct(String name, String productCode, String description, double price, int quantity, int stockLevel) {
        this.products.add(new Item(name,productCode, description, price, quantity, stockLevel));
    }
    
    
    // Deleting an existing product.
    public void deleteProduct(String productName) {
         for (Item product : this.products) {
            if (productName.equals(product.getName())) {
                products.remove(product);
            }
        }
    }
    
    // Formatting the products of the inventory
    public String toString() {
        String s="";
        s+="Inventory contains:\n";
        for (Item product:this.products) {
            s+='\t'+product.toString();
        }
        return s;
    }

    // Printing a list of the products in the inventory.
    public ArrayList<Item> printInventory() {
    	return products;
    }
    
    public void editItem (String productCode, String attribute, String newValue) {
    	for (Item item: products){
    		if (item.getCode().equals(productCode)){
    			if (attribute.equalsIgnoreCase("name")) {
    				item.setName(newValue);
    			}
    			else if (attribute.equalsIgnoreCase("quantity")){
    				
    			}
    		}
    		
    	}
    }
    
    // Tester 
   /*  public static void main(String[] args) {
        Inventory inventory = new Inventory(); // creates an inventory
        inventory.printInventory(); // prints the products of the inventory
        inventory.increaseQuantity("IGL Gas"); // Increases the quantity of IGL Gas
        inventory.increaseQuantity("Valve"); // Increases the quantity of Valve
        inventory.printInventory(); // Prints the updated inventory
        inventory.decreaseQuantity("Valve"); // Decreases the quantity of Valve
        inventory.printInventory(); // Prints the updated inventory
        inventory.createProduct("Gas hose", "103", "Hose for gas", 2600.00); // Adds a new product to the inventory
        inventory.printInventory(); // Prints the updated inventory
        inventory.increaseQuantity("Gas Hose"); // Increases the quantity of Gas Hose
        inventory.printInventory(); // Prints the updated inventory
        inventory.deleteProduct("Valve"); // Deletes all the records of Valve from the inventory
        inventory.printInventory(); // Prints the updated inventory
    }*/


    
}

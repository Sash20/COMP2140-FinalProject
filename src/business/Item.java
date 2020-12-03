package business;


/**
 * This class is a child class of the Inventory class. It is responsible of creating instances of a product along with operations to be 
 * done on any specific product.
 * @author (Shevon Chisholm)
 * @version (1.0)
 */
public class Item
{
    // instance variables for a product
    private String name;
    private String productCode;
    private String description;
    private int quantity;
    private double price;
    private int stockLevel;
    
    public Item(String name, String productCode, String description, double price, int quantity, int stockLevel) {
    	this.name = name;
    	this.productCode = productCode;
    	this.description = description;
    	this.price = price;
    	this.quantity = quantity;
    	this.stockLevel = stockLevel;
    }
    
    public Item(String name, String code, double price, int quantity) {
    	this.name = name;
    	this.productCode = code;
    	this.price = price;
    	this.quantity = quantity;
    }

    // Retrieves the name of a product
    
    public String getName() {
        return name;
    }
    
    // Sets the name of a product
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
    	return productCode;
    }
    
    public void setCode(String code) {
    	this.productCode = code;
    }
    
    
    // Retrieves the quantity of a particular product
    public int getQuantity() {
        return quantity;
    }
    
    // Assigns the quantity to a particular product
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // Retrieves the price of a particular product
    public double getPrice() {
        return price;
    }
    
    // Assigns a price to a particular product
    public void setPrice(double price) {
        this.price = price;
    }
    
    // Retrieves the description of a particular product
    public String getDescription() {
        return description;
    }
    
    // Assigns a description to a particular product
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getStockLevel() {
    	return stockLevel;
    }
    
    public void setStockLevel(int stocklevel) {
    	stockLevel = stocklevel;
    }
    
    // Increases the quantity of a particular product
     public int add(int quan) {
        return (quantity+quan);
    }
     
    // Decreases the quantity of a particular product
    public int remove(int quan) {
        return (quantity-quan);
    }
    
    // Prints all the details of a product
     public String toString() {
        String s="";
        s+=" Product Name: "+this.name;
        s+=" , ProductCode: "+this.productCode;
        s+=" , Description: "+this.description;
        s+=" , Price: "+this.price;
        s+=" , Quantity: "+this.quantity;
        s+=" , Stock Level: " + this.stockLevel;
        
        return s;
    }
}


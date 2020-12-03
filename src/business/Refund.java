package business;


public class Refund {
	private Item i1;
	private double refundAmount;
	
	public Refund() {
	}
	
	public void refundItem(Item i1) {
		refundAmount=0.08 * i1.getPrice();
	}
	
	public double refAmount() {
		return refundAmount;
	}
	
	
}


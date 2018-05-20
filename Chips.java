package application;

public class Chips extends Snack {
	public Chips() {
		super.setName("Sun Chips");
		super.setBrand("Frito-Lays");
		super.setPrice(1.25);
	}
	public Chips(String name, String brand, double price,String productID) {
		super.setName(name);
		super.setBrand(brand);
		super.setPrice(price);
		super.setProductID(productID);
	}
	public Chips(Chips copyChips) {
		super.setName(copyChips.getName());
		super.setBrand(copyChips.getBrand());
		super.setPrice(copyChips.getPrice());
	}
	public String toString() {
		return "Chips " + super.toString() + "]";
	}
}

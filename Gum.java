package application;

public class Gum extends Snack {
	
	public Gum() {
		super.setName("Hubba Bubba");
		super.setBrand("Wrigley Co.");
		super.setPrice(.25);
	}
	public Gum(String name, String brand, double price, String productID) {
		super.setName(name);
		super.setBrand(brand);
		super.setPrice(price);
		super.setProductID(productID);
	}
	public Gum(Gum copyGum) {
		super.setName(copyGum.getName());
		super.setBrand(copyGum.getBrand());
		super.setPrice(copyGum.getPrice());
	}
	public String toString() {
		return "Gum" + super.toString() + "]";
	}

}

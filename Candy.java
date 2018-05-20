package application;

public class Candy extends Snack {
	public Candy() {
		super.setName("Snickers");
		super.setBrand("Mars INC");
		super.setPrice(1.00);
	}
	public Candy(String name, String brand, double price,String productID) {
		super.setName(name);
		super.setBrand(brand);
		super.setPrice(price);
		super.setProductID(productID);
	}
	public Candy(Candy copyCandy) {
		super.setName(copyCandy.getName());
		super.setBrand(copyCandy.getBrand());
		super.setPrice(copyCandy.getPrice());
	}
	public String toString() {
		return "Candy" + super.toString() + "]";
	}

}

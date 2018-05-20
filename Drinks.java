package application;
public class Drinks extends Product  {
	public Drinks() {
	super.setName("Dr. Pepper");
	super.setBrand("Coka-Cola");
	super.setPrice(.75);

	}
	public Drinks(String name, String brand, double price,String productID) {
		super.setName(name);
		super.setBrand(brand);
		super.setPrice(price);
		super.setProductID(productID);
		
	}
	public Drinks(Drinks copyDrinks) {
		super.setName(copyDrinks.getName());
		super.setBrand(copyDrinks.getBrand());
		super.setPrice(copyDrinks.getPrice());
	}
	public int compareTo(Product other) {
		if(getBrand().toUpperCase().compareTo(other.getBrand().toUpperCase())>0) {
			return 1;
		}
		else if(getBrand().toUpperCase().compareTo(other.getBrand().toUpperCase())<0) {
			return -1;
		}
		else if(getPrice() > other.getPrice()) {
			return 1;
		}
		else if (getPrice() < other.getPrice()) {
			return -1;
		}
		else return 0;
	}
	public String toString() {
		return "Drink [" +super.getName() + "Brand: " + getBrand()
		+ "Price: " + getPrice();
	}
}

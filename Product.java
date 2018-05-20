package application;
 public class Product implements Comparable <Product> {
	
	private String name;
	private String brand;
	private double price;
	String productID;
	int quantity;
	
	public Product() {
		name = "Doritos";
		brand = "Frito-Lay";
		price = 1.25;
		
	}
	
	public Product(String name, String brand, double price, String productID) {
		this.setName(name);
		this.setBrand(brand);
		this.setPrice(price);
		this.setProductID(productID);
	}
	public Product(Product copyProduct) {
		this.setName(copyProduct.getName());
		this.setBrand(copyProduct.getBrand());
		this.setPrice(copyProduct.getPrice());
		this.setProductID(copyProduct.getProductID());
	}
	public String getProductID() {
		return productID;
	}

	public String getName() {
		return this.name;
	}
	public String getBrand() {
		return this.brand;
	}
	public double getPrice() {
		return this.price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	 public void setQuantity(int quantity) {
	        this.quantity = quantity;
	 }
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String toString() {
		return "\n"
		+ getName()
		+"\nPrice; " + getPrice()
		+"\nBrand: " + getBrand();
		
	}

	public Object getQuantity() {
		// TODO Auto-generated method stub
		return this.quantity = quantity;
	}

	@Override
	public int compareTo(Product arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void changeQuantity(int quantity) {
		this.quantity = this.quantity + quantity;
		
	}

	
}

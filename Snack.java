package application;
abstract class Snack extends Product implements Comparable<Product> {
	@Override
	public int compareTo(Product o) {
		int result = this.getBrand().toUpperCase().compareTo(o.getBrand().toUpperCase());
		if(result == 0) {
			
			if(this.getPrice() > o.getPrice()) {
				result = 1;
			}
			else if(this.getPrice() < o.getPrice()) {
				result = -1;
			}
			else {
				result = 0;
			}
		}
		return result;
	}
	public Snack() {
		super.setName("Sun Chips");
		super.setBrand("Frito-lay");
		super.setPrice(1.25);
	}
	public Snack(String name, String brand, double price) {
		super.setName(name);
		super.setBrand(brand);
		super.setPrice(price);
	}
	public Snack(Snack copySnack) {
		super.setName(copySnack.getName());
		super.setBrand(copySnack.getBrand());
		super.setPrice(copySnack.getPrice());
	}
	
	public String toString() {
		return super.toString();
	}

}

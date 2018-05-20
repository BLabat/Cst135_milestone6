package application;

import java.util.ArrayList;

public class Inventory extends Dispenser {

	private ArrayList<Product> inventoryProducts;
	
	public Inventory(){
		inventoryProducts = new ArrayList<Product>();
		
	}
	
	public void addInventory(Product p){
		inventoryProducts.add(p);
	}
	
	public double getInventoryPrice() {
		double sum = 0;
		for(Product p : inventoryProducts){
			sum+=p.getPrice();
		}
		return sum;
	}
	
	public void printInventory(){
		double sum = 0;
		for(Product p : inventoryProducts){
			System.out.println(p.toString());
		}
	}

	public ArrayList<?> getDrinks() {
		// TODO Auto-generated method stub
		return null;
	}

}
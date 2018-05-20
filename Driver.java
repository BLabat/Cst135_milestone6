package application;

import java.util.ArrayList;

public class Driver {
public static void main(String[] args) {
		
		ArrayList productArray = new ArrayList();
		Dispenser dispenser = new Dispenser();
		
		System.out.println("Total Number of Products : " + dispenser.getNumberOfProducts());
		System.out.println("Total Number of Drinks : " + dispenser.getNumberOfDrinks());
		dispenser.removeProduct(1);
		System.out.println("Total Number of Candy : " + dispenser.getNumberOfCandy());
		System.out.println("Total Number of Chips : " + dispenser.getNumberOfChips());
		System.out.println("Total Number of Gum : " + dispenser.getNumberOfGum());
		System.out.println("Total Number of Products : " + dispenser.getNumberOfProducts());
		System.out.println("Total Number of Drinks : " + dispenser.getNumberOfDrinks());
		
		Inventory inv = new Inventory();
		inv.printInventory();
		System.out.println("The Total Price is :" + inv.getInventoryPrice());
	}
}
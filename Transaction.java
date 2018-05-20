package application;


import java.util.ArrayList;

public class Transaction extends Dispenser {

	private ArrayList<Product> transactionArray;
	
	public Transaction(){
		transactionArray = new ArrayList<Product>();
	}
	
	public int getNumberOfTransaction(){
		return transactionArray.size();
	}
	
	public void addTransaction(Product product){
		transactionArray.add(product);
	}
	
	public ArrayList getTransaction() {// Start of getProducts method
		return transactionArray;
	} // End of getProducts method
	
	public void removeTransaction(int index) {// Start of addProducts method
		transactionArray.remove(index);
	} // End of addProducts method
	
	public double getTransactionPrice() {
		double sum = 0;
		for(Product p : transactionArray){
			sum+=p.getPrice();
		}
		return sum;
	}
	
	public void printTransaction(){
		double sum = 0;
		for(Product p : transactionArray){
			System.out.println(p.toString());
		}
	}
}

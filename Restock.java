package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Restock {

    ObservableList<Product> localInventory = FXCollections.observableArrayList();
    private static Scanner sc;

    public void restockProducts(ObservableList<Product> inventory) {
        String csvFile = "Purchase Order.csv";

        try {
            sc = new Scanner(new File(csvFile));
            sc.useDelimiter("[,\n]");

            //skips header line
            String header = sc.nextLine();

            while (sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                String[] lineArray = nextLine.split(",");
                String name = lineArray[0];
                String strPrice = lineArray[1];
                double price = Double.parseDouble(strPrice);
                String strQuantity = lineArray[2];
                int quantity = Integer.parseInt(strQuantity);
                String productID = lineArray[3];

                //not used, but needs to be read from file for proper format
                String strProductTotal = lineArray[4];
                double productTotal = Double.parseDouble(strProductTotal);
                String strTransactionTotal = lineArray[5];
                double transactionTotal = Double.parseDouble(strTransactionTotal);

                Product product = new Product();
                localInventory.add(product);
            }

        } catch (Exception e) {
            Alert.display("", "ERROR");
            e.printStackTrace();
        }

        //compares productID in dispenser.inventory to productID of purchase order, and updates dispenser.inventory to match
        for (Product product : inventory) {
            for (Product purchaseProduct : localInventory) {
                if (product.productID.equals(purchaseProduct.getProductID()))
                    product.changeQuantity(purchaseProduct.quantity);
            }
        }
    }

    //purchase order for any product at or below 3 to get to 20
    public void purchaseLowProducts(ObservableList<Product> localInventory) {
        int i = 0;
        int qty;
        double productTotal;
        double transactionTotal = 0;

        //Delimiter used in CSV file
        final String COMMA_DELIMITER = ",";
        final String NEW_LINE_SEPARATOR = "\n";

        //write purchase order csv
        FileWriter fileWriter = null;

        //deletes existing inventory file before writing new contents
        try {
            File file = new File("Inventory.csv");
            file.delete();
        } catch (Exception e) {
            Alert.display("Error", "ERROR DELETING OLD PURCHASE ORDER");
        }

        try {
            fileWriter = new FileWriter("Purchase Order.csv");
        } catch (Exception e) {
            Alert.display("Error", "COULDN'T OPEN FILE");
        }

        //CSV file header
        final String FILE_HEADER = "Name,Price,Quantity,ProductID,Product Total,Running Total";

        try {
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
        }
        catch (Exception e) {
            Alert.display("Error", "ERROR WRITING TO FILE");
        }

        for (Product product : localInventory) {
            if (product.quantity <= 3) {
                qty = 20 - product.quantity;
                productTotal = qty * product.getPrice();
                transactionTotal = transactionTotal + productTotal;

                //Write a new product object list to the CSV file
                try {
                    fileWriter.append(String.valueOf(product.getName()));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(product.getPrice()));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(qty));
                    fileWriter.append(COMMA_DELIMITER);
               
                    fileWriter.append(String.valueOf(productTotal));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(transactionTotal));
                    fileWriter.append(NEW_LINE_SEPARATOR);
                } catch (Exception e) {
                    Alert.display("Error", "ERROR WRITING TO FILE");
                }
            }
            i++;
        }
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            Alert.display("Error", "ERROR FLUSHING/CLOSING FILE");
        }
    }
}

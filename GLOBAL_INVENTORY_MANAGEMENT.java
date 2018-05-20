package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GLOBAL_INVENTORY_MANAGEMENT  {

    ObservableList<Product> localInventory = FXCollections.observableArrayList();
    private static Scanner sc;
    QuickSort sorter = new QuickSort();

    public ObservableList<Product> GlobalInventoryManagement() {

        ObservableList<Product> globalInventoryList = FXCollections.observableArrayList();
        String csvFile = "globalInventoryList.csv";
        Product[] productArray;

        //this area is used to get number of products from inventory file to use for array size
        try {
            sc = new Scanner(new File(csvFile));
            sc.useDelimiter("[,\n]");

            //skips header line
            String header = sc.nextLine();

            int j = 0;
            while (sc.hasNextLine()) {
                sc.nextLine();
                j++;
            }
            sc.close();
            productArray = new Product[j];

            //open new scanner
            sc = new Scanner(new File(csvFile));
            sc.useDelimiter("[,\n]");

            //skips header line
            String header2 = sc.nextLine();

            int i = 0;
            while (sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                String[] lineArray = nextLine.split(",");
                String name = lineArray[0];
                String strPrice = lineArray[1];
                String strQuantity = lineArray[2];
                double price = Double.parseDouble(strPrice);
                int quantity = Integer.parseInt(strQuantity);
                String productID = lineArray[3];

                Product product = new Product();
                productArray[i] = product;
                i++;
            }
            //recursive sort productArray
            sorter.sort(productArray);
            globalInventoryList.addAll(productArray);
        } catch (Exception e) {
            Alert.display("", "ERROR");
            e.printStackTrace();
        }
        return globalInventoryList;
    }

    public ObservableList<Product> readCurrentInventory(ObservableList<Product> inventory) {
        String csvFile = "Inventory.csv";

        //stores observableList into temp Product[]
        Product[] temp = new Product[inventory.size()];
        int i = 0;
        for (Product productTemp : inventory) {
            temp[i] = productTemp;
            i++;
        }

        //recursive sorts temp Product[]
        sorter.sort(temp);

        //clears observableList
        inventory.clear();

        //writes observableList to match sorted temp Product[]
        for (Product productTemp : temp) {
            inventory.add(productTemp);
        }

        //reads inventory file to update observableList with current stock quantities
        try {
            sc = new Scanner(new File(csvFile));
            sc.useDelimiter("[,\n]");

            String header = sc.nextLine();

            while (sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                String[] lineArray = nextLine.split(",");
              
                String strPrice = lineArray[1];
                String strQuantity = lineArray[2];
                double price = Double.parseDouble(strPrice);
                int quantity = Integer.parseInt(strQuantity);
              ;

                Product product = new Product();
                localInventory.add(product);
            }

        } catch (Exception e) {
            Alert.display("", "ERROR");
            e.printStackTrace();
        }

        //compares productID in dispenser.inventory to productID of CSV localInventory, and updates dispenser.inventory to match
        i = 0;
        for (Product product : inventory) {
            for (Product product1 : localInventory)
                if (product1.getName().equals(product.getName())) {
                    product.setQuantity((int) product1.getQuantity());
                }
            i++;
        }
        return inventory;
    }
}

//class to recursive sort a Product[] by name
class QuickSort {

    Product[] globalProducts;
    int length;

    void sort(Product[] globalInventoryList) {
        if (globalInventoryList == null || globalInventoryList.length == 0) {
            return;
        }
        this.globalProducts = globalInventoryList;
        this.length = globalInventoryList.length;
        quickSort(0, length - 1);
    }

    void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.globalProducts[lowerIndex + (higherIndex - lowerIndex) / 2].getName();

        while (i <= j) {
            while (this.globalProducts[i].getName().compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (this.globalProducts[j].getName().compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(i, j);
                i++;
                j--;
            }
        }
        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    void exchangeNames(int i, int j) {
        Product temp = this.globalProducts[i];
        this.globalProducts[i] = this.globalProducts[j];
        this.globalProducts[j] = temp;
    }
}

class RecursiveSearch {

    public static int recursiveSearch(ObservableList<Product> list, String key) {
        int low = 0;
        int high = list.size() - 1;
        int mid;

        //stores observableList into temp Product[]
        Product[] temp = new Product[list.size()];
        int i = 0;
        for (Product productTemp : list) {
            temp[i] = productTemp;
            i++;
        }

        while (low <= high) {
            mid = (low + high) / 2;

            if (temp[mid].getName().compareToIgnoreCase(key) < 0) {
                low = mid + 1;
            } else if (temp[mid].getName().compareToIgnoreCase(key) > 0) {
                high = mid - 1;
            } else {
                writeCallStack(key);
                return mid;
            }
        }
        writeCallStack(key);
        return -1;
    }

    public static void writeCallStack(String key){

        //Stack trace file header
        final String FILE_HEADER = "Search Call Stack for keyword:  " + key + "\n\n";

        FileWriter fileWriter = null;

        try {

            //deletes existing inventory file before writing new contents
            try {
                File file = new File("Search Call Stack.txt");
                file.delete();
            } catch (Exception e) {
            }

            fileWriter = new FileWriter("Search Call Stack.txt");

            //Write the stack file header
            fileWriter.append(FILE_HEADER.toString());

            //Write a new product object list to the CSV file
                fileWriter.append(Arrays.toString(Thread.currentThread().getStackTrace()));
        } catch (Exception e) {
            Alert.display("Error", "ERROR WRITING SEARCH STACK TRACE FILE");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                Alert.display("Error", "ERROR FLUSHING/CLOSING SEARCH STACK TRACE");
            }
        }
    }

}
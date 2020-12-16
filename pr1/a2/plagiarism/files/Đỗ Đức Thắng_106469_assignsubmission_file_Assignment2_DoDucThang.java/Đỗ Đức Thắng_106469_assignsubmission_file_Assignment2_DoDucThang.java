package Assignment2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2_DoDucThang {
    static ArrayList<String> Name = new ArrayList<>();
    static ArrayList<Double> Price = new ArrayList<>();
    static ArrayList<Integer> Quantity = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static File f = new File("Product.bin");

    public static void main(String[] args) throws Exception{
        scanner = new Scanner(System.in);
        int n = 0;
        while (n != 9) {
            System.out.println("1: Add products");
            System.out.println("2: Display products");
            System.out.println("3: Edit a product");
            System.out.println("4: Delete a product");
            System.out.println("5: Search for products by name");
            System.out.println("6: Sort products by price");
            System.out.println("7: Save products to text/binary file");
            System.out.println("8: Load products from the saved file");
            System.out.println("9. Exit");
            System.out.println("Choose a feature: ");
            n = scanner.nextInt();
            switch (n) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    editProduct();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    System.out.println("Unable to show function!");
                    break;
                case 7:
                    saveFile();
                    break;
                case 8:
                	loadSavedTXT();
                    break;
                case 9:
                    System.out.println("See you again!");
                    break;
                default:
                    System.out.println("Please Input again, error occurs!");
                    break;
            }

        }

    }

    public static void addProduct() {
        String repeat = null;
        do {
            System.out.println("Input product name: ");
            scanner = new Scanner(System.in);
            Name.add(scanner.nextLine());

            try {
                scanner = new Scanner(System.in);
                System.out.println("Input the price of product: ");
                Price.add(scanner.nextDouble());
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                System.err.println("Please input a proper number type!");
                System.out.println("Input product price: ");
                Price.add(scanner.nextDouble());
            }
            try {
                scanner = new Scanner(System.in);
                System.out.println("Input the product quantity");
                Quantity.add(scanner.nextInt());

            } catch (Exception e) {
                scanner = new Scanner(System.in);
                System.err.println("Please input a proper number!");
                System.out.println("Input the product quantity");
                Quantity.add(scanner.nextInt());
            }
            System.out.println("Enter another product? yes/no");
            scanner = new Scanner(System.in);
            repeat = scanner.nextLine();

        } while (repeat.equalsIgnoreCase("yes"));

    }

    public static void displayProduct() {
        System.out.format("%-5s |%-20s | %20s | %8s | %n", "ID", "Name", "Price", "Quantity");
        for (int i = 0; i < Name.size(); i++) {
            System.out.format("%-5s |%-20s | %20s | %8s | %n", i, Name.get(i), Price.get(i), Quantity.get(i));

        }
    }
    
    public static void editProduct() {
        System.out.println("What product you want to edit?, please enter its ID: ");
        scanner = new Scanner(System.in);
        int productId = scanner.nextInt();
        System.out.println("Input new Product name: ");
        scanner = new Scanner(System.in);
        Name.set(productId, scanner.nextLine());

        System.out.println("Input new Product price: ");
        scanner = new Scanner(System.in);
        Price.set(productId, scanner.nextDouble());
        System.out.println("Input new Product quantity: ");
        scanner = new Scanner(System.in);
        Quantity.set(productId, scanner.nextInt());

    }
    
    public static void removeProduct() {
        System.out.println("Input the ID of product wanted to delete: ");
        scanner = new Scanner(System.in);
        int productId = scanner.nextInt();
        Name.remove(productId);
        Price.remove(productId);
        Quantity.remove(productId);
        System.out.println("Task is successfully done!");

    }


    public static void searchProduct() {
        System.out.println("Input a key product: ");
        scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        for (int i = 0; i < Name.size(); i++) {
            if (Name.get(i).contains(key)) {
                System.out.format("%-5s |%-20s | %20s | %8s | %n", i, Name.get(i), Price.get(i), Quantity.get(i));
            }

        }

    }

    public static void saveFile() throws Exception {
        if (!f.exists()) {
            f.createNewFile();
        }
        FileOutputStream fops = new FileOutputStream(f);
        ObjectOutputStream oops = new ObjectOutputStream(fops);
        oops.writeObject(Name);
        oops.writeObject(Price);
        oops.writeObject(Quantity);
        oops.close();
        System.out.println("File has been saved!");

    }

    public static void loadSavedTXT() throws Exception {
        FileInputStream fips = new FileInputStream(f);
        ObjectInputStream oips = new ObjectInputStream(fips);
        Name = (ArrayList<String>) oips.readObject();
        Price = (ArrayList<Double>) oips.readObject();
        Quantity = (ArrayList<Integer>) oips.readObject();
        System.out.format("%-5s |%-20s | %20s | %8s | %n", "ID", "Name", "Price", "Quantity");
        for (int i = 0; i < Name.size(); i++) {
            System.out.format("%-5s |%-20s | %20s | %8s | %n", i, Name.get(i), Price.get(i), Quantity.get(i));
        }
        oips.close();

    }
}



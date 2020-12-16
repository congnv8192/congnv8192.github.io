package assignment;

import com.sun.corba.se.impl.io.IIOPInputStream;
import com.sun.corba.se.impl.io.IIOPOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment {

    static ArrayList<String> Name = new ArrayList<>();
    static ArrayList<Double> Price = new ArrayList<>();
    static ArrayList<Integer> Quantity = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static File file = new File("Product.bin");

    public static void main(String[] args) throws Exception{
        sc = new Scanner(System.in);
        int a = 0;
        while (a != 9) {
            System.out.println("1: Add products");
            System.out.println("2: Display products");
            System.out.println("3: Delete a product");
            System.out.println("4: Edit a product");
            System.out.println("5: Search for products by name");
            System.out.println("6: Sort products by price");
            System.out.println("7: Save products to text/binary file");
            System.out.println("8: Load products from the saved file");
            System.out.println("9. Exit");
            System.out.println("Choose a feature: ");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    editProdct();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    System.out.println("Feature unavailable > v <");
                    break;
                case 7:
                    saveFile();
                    break;
                case 8:
                    loadFile();
                    break;
                case 9:
                    System.out.println("Goodbye :3!!!");
                    break;
                default:
                    System.out.println("Invalid input -_-");
                    break;
            }

        }

    }

    public static void addProduct() {
        String repeat = null;
        do {
            System.out.println("Enter name product: ");
            sc = new Scanner(System.in);
            Name.add(sc.nextLine());

            try {
                sc = new Scanner(System.in);
                System.out.println("Enter price product: ");
                Price.add(sc.nextDouble());
            } catch (Exception e) {
                sc = new Scanner(System.in);
                System.err.println("You shoud input number!");
                System.out.println("Enter price product: ");
                Price.add(sc.nextDouble());
            }
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter quantity product");
                Quantity.add(sc.nextInt());

            } catch (Exception e) {
                sc = new Scanner(System.in);
                System.err.println("You should input number!");
                System.out.println("Enter quantity product");
                Quantity.add(sc.nextInt());
            }
            System.out.println("Do you want to add another product? y/n ");
            sc = new Scanner(System.in);
            repeat = sc.nextLine();

        } while (repeat.equalsIgnoreCase("y"));

    }

    public static void displayProduct() {
        System.out.format("%-5s |%-20s | %20s | %8s | %n", "ID", "Name", "Price", "Quantity");
        for (int i = 0; i < Name.size(); i++) {
            System.out.format("%-5s |%-20s | %20s | %8s | %n", i, Name.get(i), Price.get(i), Quantity.get(i));

        }
    }

    public static void deleteProduct() {
        System.out.println("Enter the product ID to delete: ");
        sc = new Scanner(System.in);
        int id = sc.nextInt();
        Name.remove(id);
        Price.remove(id);
        Quantity.remove(id);
        System.out.println("Delete successfully!");

    }

    public static void editProdct() {
        System.out.println("Enter the product ID to edit: ");
        sc = new Scanner(System.in);
        int id = sc.nextInt();
        System.out.println("Enter new name: ");
        sc = new Scanner(System.in);
        Name.set(id, sc.nextLine());

        System.out.println("Enter new price: ");
        sc = new Scanner(System.in);
        Price.set(id, sc.nextDouble());
        System.out.println("Enter new quantity: ");
        sc = new Scanner(System.in);
        Quantity.set(id, sc.nextInt());

    }

    public static void searchProduct() {
        System.out.println("Enter a keyword: ");
        sc = new Scanner(System.in);
        String key = sc.nextLine();
        for (int i = 0; i < Name.size(); i++) {
            if (Name.get(i).contains(key)) {
                System.out.format("%-5s |%-20s | %20s | %8s | %n", i, Name.get(i), Price.get(i), Quantity.get(i));
            }

        }

    }

    public static void saveFile() throws Exception {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fops = new FileOutputStream(file);
        ObjectOutputStream oops = new ObjectOutputStream(fops);
        oops.writeObject(Name);
        oops.writeObject(Price);
        oops.writeObject(Quantity);
        oops.close();
        System.out.println("Save file successfully :>!");

    }

    public static void loadFile() throws Exception {
        FileInputStream fips = new FileInputStream(file);
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

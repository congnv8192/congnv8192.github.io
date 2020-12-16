/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mai;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class QuynhMai {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();
        boolean stop = false;
        while (!stop) {
            System.out.println("1. Add product");
            System.out.println("2. Open product");
            System.out.println("3. Remove product");
            System.out.println("4. Arrange product");
            System.out.println("5. Find product by name");
            System.out.println("6. Categorixe product by price");
            System.out.println("7. Save product under text/binary form");
            System.out.println("8. Load the products from saved file");
            System.out.println("9. Exit");
            System.out.print("Choose a feature: ");
            int n = sc.nextInt();
            switch (n) {
                case 1: 
                    System.out.print("The number of products: ");
                    int number = sc.nextInt();
                    for (int i = 1; i<= number;i++) {
                        System.out.print("Name: ");
                        sc.nextLine();
                        name.add(sc.nextLine());
                        System.out.print("Price: ");
                        price.add(sc.nextDouble());
                        System.out.print("Quantity: ");
                        quantity.add(sc.nextInt());
                    }
                    System.out.println("Product(s) added");
                    break;
                case 2:
                    try {
                        System.out.format("|%4s|%14s|%14s|%14s|%n", "ID", "Name", "Price", "Quantity");
                        for (int i = 0; i < name.size(); i++) {
                            System.out.println("-------------------------------------");
                            System.out.format("|%4s|%14s|%14.2f|%14d|%n", (i+1), name.get(i), price.get(i), quantity.get(i));
                        } 
                    } catch (Exception e) {
                        sc.nextLine();
                    } System.out.println();
                    break;
                case 3: 
                    if (name.size() <= 0) {
                        System.out.println("There are no product to remove.");
                    } else {
                        System.out.print("ID of the product you want to remove: ");
                        int remove = sc.nextInt();
                        name.remove(remove - 1);
                        price.remove(remove - 1);
                        quantity.remove(remove - 1);
                        System.out.println("Succeeded");
                    } break;
                case 4:
                    if (name.size()<= 0) {
                        System.out.println("There are no product to refactor.");
                    } else {
                        Scanner sc2 = new Scanner(System.in);
                        System.out.print("ID of the product you want to refactor: ");
                        int edit = sc.nextInt();
                        System.out.print("New name: ");
                        sc2.nextLine();
                        name.set(edit - 1, sc2.nextLine());
                        System.out.print("New price: ");
                        price.set(edit - 1, sc2.nextDouble());
                        System.out.print("New quantity: ");
                        quantity.set(edit - 1, sc.nextInt());
                        System.out.println("Succeeded");
                    } break;
                case 5:
                    System.out.println("Input keyword: ");
                    Scanner sc3 = new Scanner(System.in);
                    String keyword = sc3.nextLine();
                    System.out.format("|%4s|%14s|%14s|%14s|%n", "ID", "Name", "Price", "Quantity");
                    for (int i= 0; i<name.size(); i++) {
                        if ((name.get(i)).contains(keyword)) {
                            System.out.format("|%4s|%14s|%14.2f|%14d|%n", (i+1), name.get(i), price.get(i), quantity.get(i));
                        } else {
                            System.out.println("No products were found matching your selection.");
                            break;
                        }
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Not available at the moment");
                    break;
                case 7:
                    File f = new File("product.bin");
                    FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(name);
                    oos.writeObject(price);
                    oos.writeObject(quantity);
                    oos.close();
                    System.out.println("Succeeded");
                    break;
                case 8:
                    FileInputStream fis = new FileInputStream("product.bin");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    name = (ArrayList<String>) ois.readObject();
                    price = (ArrayList<Double>) ois.readObject();
                    quantity = (ArrayList<Integer>) ois.readObject();
                    ois.close();
                    System.out.println("Succeeded");
                    break;
                case 9: 
                    stop = true;
                    System.out.println("Bye!!");
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }
    
}

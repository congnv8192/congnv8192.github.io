/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
 
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class NguyenThiNinhThuan_1TĐ19_1901060047 {
    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> name = new ArrayList<>();
    ArrayList<Double> price = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    boolean stop = false;
    while (!stop) {
        System.out.println("1. Add product\n" + "2. Display products\n"
        + "3. Delete a product\n" + "4. Edit a product\n" + "5. Search for products by name\n"
        + "6. Sort a product by price\n" + "7. Save products to text/binary file\n"
        + "8. Load products from the saved file\n" + "9. Exit");
        System.out.println("Choose your option: ");
        int n = sc.nextInt();
    switch (n) {
        case 1: 
            System.out.println("The number of products you pick: ");
            int number = sc.nextInt();
            for (int i = 1; i <= number; i++) {
                System.out.print("Product name: ");
                sc.nextLine();
                name.add(sc.nextLine());
                System.out.print("Product price: ");
                price.add(sc.nextDouble());
                System.out.print("Product quantity: ");
                quantity.add(sc.nextInt());
            } System.out.println("Complete\n");
            break;
        case 2:
            try {
                System.out.format("| %5s | %14s | %14s | %14s | %n", "ID", "Name", "Price ($)", "Quantity");
                for (int i = 0; i < name.size(); i++) {
                    System.out.println("----------------------------------------------");
                    System.out.format("| %5s | %14s | %14.1f | %14d | %n", (i + 1), name.get(i), price.get(i),
                    quantity.get(i));            
              }                        
            } catch (Exception e) {
                sc.nextLine();
            } System.out.println();
            break;
        case 3:
            if (name.size() <= 0) {
                System.out.println("There is no product to delete at all!");
            } else {
                System.out.println("Enter ID product you want to delete: ");
                int delete = sc.nextInt();
                name.remove(delete - 1);
                price.remove(delete - 1);
                quantity.remove(delete - 1);
                System.out.println("Complete\n");
            }
           break;
        case 4: 
            if (name.size() <= 0) {
                System.out.println("There is no product to edit at all!");
            } else {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Enter ID product you want to edit: ");
                int edit = sc.nextInt();
                System.out.println("New name: ");
                name.set(edit - 1, sc1.nextLine());
                System.out.println("New price: ");
                price.set(edit - 1, sc1.nextDouble());
                System.out.println("New quantity; ");
                quantity.set(edit - 1, sc1.nextInt());
                System.out.println("Complete\n");
         } break;
        case 5: 
           System.out.print("Keyword of product's name you search: ");
           Scanner sc2 = new Scanner(System.in);
           String keyword = sc2.nextLine();
           System.out.format("| %5s | %14s | %14s | %14s | %n", "ID", "Name", "Price ($)", "Quantity");
           for (int i = 0; i < name.size(); i++) {
               if ((name.get(i)).contains(keyword)) {
                   System.out.format("| %5s | %14s | %14.1f | %14d | %n", (i + 1), name.get(i),
                           price.get(i), quantity.get(i));
               } else {
                   System.out.println("There is no product relating to this keyword!");
                   break;
               }
           } System.out.println();
            break;
        case 6:
            System.out.println("The menu will upgrade soon!\n");
            break;
        case 7:
            File f = new File("product.bin");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(name);
            oos.writeObject(price);
            oos.writeObject(quantity);
            oos.close();
            System.out.println("Complete\n");
            break;
        case 8:
            FileInputStream fis = new FileInputStream("product.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            name = (ArrayList<String>) ois.readObject();
            price = (ArrayList<Double>) ois.readObject();
            quantity = (ArrayList<Integer>) ois.readObject();
            ois.close();
            System.out.println("Complete\n");
            break;
        case 9:
            stop = true; // to stop while-loop//
            System.out.println("See you again!");
            break;
        default:
            System.out.println("Invalid option\n");
    }     
    }
    }  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class NguyenMinhHuyen_1TD19_1901060018 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();
        boolean stop = false;
        while (!stop) {
            System.out.println("1. Add product\n"
                    + "2. Display\n" + "3. Delete\n" + "4. Edit\n" + "5. Search\n" + "6. Exit");
            System.out.print("Choose a feature: ");
                int n = scan.nextInt();
            switch (n) {
            
                case 1:
                    System.out.println("Product quantity: ");
                    int pquantity = scan.nextInt();
                    for (int i = 1; i <= pquantity; i++) {
                        System.out.println("Name: ");
                        scan.nextLine();
                        name.add(scan.nextLine());
                        System.out.println("Price: ");
                        price.add(scan.nextDouble());
                        System.out.println("Quantity: ");
                        quantity.add(scan.nextInt());
                    }
                    System.out.println("Finished.");
                    break;
                    
                case 2:
                    try {
                        System.out.format("|%4s|%14s|%14s|%14s|%n", "ID", "Name", "Price", "Quantity");
                        for (int i = 0; i < name.size(); i++) {
                            System.out.println("_______________________________________");
                            System.out.format("| %4s | %14s | %14.2f | %14d |%n",(i+1), name.get(i), price.get(i), quantity.get(i));
                        }
                    } catch (Exception e) {
                        scan.nextLine();
                    }
                    System.out.println();
                    break;
                    
                case 3:
                    if (name.size() <= 0) {
                        System.out.println("No products!");
                    } else {
                        System.out.println("Enter the product ID to delete: ");
                        int del = scan.nextInt();
                        name.remove(del - 1);
                        price.remove(del -1);
                        quantity.remove(del - 1);
                        System.out.println("Finished!");
                    }
                    break;
                    
                case 4:
                    if (name.size() <=0) {
                        System.out.println("No products!");
                    } else {
                        Scanner scan1 = new Scanner(System.in);
                        System.out.print("Enter the product ID to edit: ");
                        int ed = scan1.nextInt();
                        System.out.println("Enter product name: ");
                        scan1.nextLine();
                        name.set(ed - 1, scan1.nextLine());
                        System.out.println("Enter product price: ");
                        price.set(ed - 1, scan1.nextDouble());
                        System.out.println("Enter quantity: ");
                        quantity.set(ed - 1, scan1.nextInt());
                        System.out.println("Finished.");
                    }
                    break;
                    
                case 5:
                    System.out.println("Enter keyword: ");
                    Scanner scan2 = new Scanner(System.in);
                    String word = scan2.nextLine();
                    System.out.format("|%4s|%14s|%14s|%14s|%n", "ID", "Name", "Price", "Quantity");
                    for (int i = 0; i < name.size(); i++) {
                        if ((name.get(i)).contains(word)) {
                            System.out.format("| %4s | %14s | %14.2f | %14d | %n", (i+1), name.get(i), price.get(i), quantity.get(i));
                        } else {
                            System.out.println("Not found!");
                        }
                        break;
                    }
                    System.out.println();
                    break;
                case 6: 
                        stop = true;
                        System.out.println("Bye!");
                        break;
                default: System.out.println("Invalid!");
            }
        }
    }
            
    
}

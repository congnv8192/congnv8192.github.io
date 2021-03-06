Nguyen Van Quan-1901040168

package assignment2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class ListProducts {

    Scanner in = new Scanner(System.in);
    ArrayList<Products> a = new ArrayList<>();

    /*Feature 1*/
    public void input(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print("\nProduct " + i );
            Products pro = new Products();
            pro.input();
            a.add(pro);
        }
    }

    /*Feature 2*/
    public void display() {
        System.out.format("%10s | %10s | %10s | %10s | %n", 
                "ID", "Name", "Price($)", "Quantity");
                 {a.get(i).display();
        }
    }

    /*Feature 3:(Find the location via ID)*/
    public int findLocation(int locate) {
        int i;
        boolean found = false;
        for (i = 0; i < a.size(); i++) {
            if (a.get(i).getID() == locate) {
                found = true;
                break;}
        }
        if (!found) {
            return -1;
        }
        return i;
    }

    /*Feature 5*/
    public void search() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter product's name: ");
        String s = input.nextLine();
        boolean found = false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getName().contains(s)) {
                System.out.format("%10s | %10s | %10s | %10s | %n", 
                        "ID", "Name", "Price($)", "Quantity");
                a.get(i).display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nProduct not found !!!");
        }
    }

    /*Feature 6*/
//  public void sort() {
//        Collections.sort(a, new Comparator<Products>() { 
//            @Override
//            public int compare(Products o1, Products o2) {
//                if (o1.getPrices() < o2.getPrices()) {
//                    return -1;
//                } else if (o1.getPrices() == o2.getPrices()) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//        });
//        System.out.format("%10s | %10s | %10s | %10s | %n", 
//                "ID", "Name", "Price($)", "Quantity");
//        for (int i = 0; i < a.size(); i++) {
//            a.get(i).display();
//        }
//    }
    
    /*Feature 7 */
    public void save() {
        try {
            File f = new File("database.txt");
            FileOutputStream fos = new FileOutputStream(f);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(a);
                oos.close();
            }
            System.out.println("\nFILE SAVED!");
        } catch (IOException e) {
            System.out.println("/nERROR: " + e);
        }
    }

    /*Feature 8*/
    public void load() throws ClassNotFoundException {
        try {
            File file = new File("database.txt");
            FileInputStream fis = new FileInputStream(file);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                a = (ArrayList<Products>) ois.readObject();
                System.out.println("\nFILE LOADED!");
                display();
                ois.close();
            }
        } catch (IOException e) {
            System.out.println("/nERROR: " + e);
        }
    }

    /*Menu*/
    public static void Menu() {
        System.out.println("\nManaging Laptop Products");
        System.out.println("\n[1] Add products");
        System.out.println("\n[2] Display products");
        System.out.println("\n[3] Delete a product");
        System.out.println("\n[4] Edit a product (Not finish)");
        System.out.println("\n[5] Search for products by name");
        System.out.println("\n[6] Sort products by price (Not Finish)");
        System.out.println("\n[7] Save products to text/binary file");
        System.out.println("\n[8] Load products from the saved file");
        System.out.println("\n[9] Quit");
        System.out.print("\n\n\nChoose an option: ");
    }

    public static void main(String[] args) throws Exception {

        ListProducts manages = new ListProducts();

        Scanner sc = new Scanner(System.in);
        int check = 0;
        while (check == 0) {
            Menu();
            int choose = sc.nextInt();
            System.out.print("\n\n");
            switch (choose) {
                
                case 1:
                    System.out.print("\nEnter the number of products you want to add: ");
                    int n = sc.nextInt();
                    manages.input(n);
                    System.out.println("\nUploaded!!");
                    break;
                    
                case 2:
                    manages.display();
                    break;
                    
                    
                case 3:
                    System.out.print("\nEnter ID: ");
                    int del = sc.nextInt();
                    int a = manages.findLocation(del);
                    if (a == -1) {
                        System.out.println("\nNot found !!!");
                    } else {
                        manages.a.remove(manages.a.get(a));
                        System.out.println("\nThe product with ID " + a + " is deleted.");
                        manages.display();
                    }
                    break;
                    
                    
                case 4:
//                    System.out.print("\nEnter ID: ");
//                    int edit = sc.nextInt();
//                    int b = manages.findLocate(edit);
//                    if (b == -1) {
//                        System.out.println("\nNot found !!");
//                    } else {
//                        System.out.println("\n>Edit: \"" 
//                                + manages.a.get(b).getNames() + "\"");
//                        System.out.print("Enter name: ");
//                        sc.nextLine();
//                        String reName = sc.nextLine();
//                        manages.a.get(b).setNames(reName);
//                        System.out.print("Enter price($): ");
//                        float rePrice = sc.nextFloat();
//                        manages.a.get(b).setPrices(rePrice);
//                        System.out.print("Enter quantities: ");
//                        int reQuantities = sc.nextInt();
//                        manages.a.get(b).setQuantities(reQuantities);
//                        System.out.println("\nProduct was updated!");
//                        manages.displayAll();
//                    }
                    break;
                    
                    
                case 5:
                    manages.search();
                    break;
                    
                    
                case 6:
//                  manages.sort();
                    break;
                    
                    
                case 7:
                    manages.save();
                    break;
                    
                    
                case 8:
                    manages.load();
                    break;
                    
                    
                case 9:
                    System.out.println("\nThanks you!");
                    check = 1;
                    break;
                    
                default:
                    System.out.println("\nInvalid choice!!!");
            }
        }
    }
}

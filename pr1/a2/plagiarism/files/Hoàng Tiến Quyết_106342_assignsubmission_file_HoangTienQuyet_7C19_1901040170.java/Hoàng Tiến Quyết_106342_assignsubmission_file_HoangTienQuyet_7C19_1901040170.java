/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**Hoang Tien Quyet 7C19
 * quyet1907@gmail.com
 * 1901040170
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HoangTienQuyet_7C19_1901040170 {
    //declare the array method
    public static ArrayList<Integer> id = new ArrayList<>();
    public static ArrayList<String> arrName = new ArrayList<>();
    public static ArrayList<Integer> arrPrice = new ArrayList<>();
    public static ArrayList<Integer> arrQuantity = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        boolean check_option = false;
        while(!check_option){
            try {
                System.out.println("1 - Add products");
                System.out.println("2 - Display the available products");
                System.out.println("3 - Edit an product");
                System.out.println("4 - Remove an product");
                System.out.println("5 - Search product by name");
                System.out.println("6 - Save to disk");
                System.out.println("7 - Load products from disk");
                System.out.println("8 - Exit");
                System.out.print("Enter your choice:");
                int option = sc.nextInt();
                sc.nextLine();
                //condition to take true option from user
                while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7 && option != 8){
                    System.out.println("Invalid option!!");
                    System.out.print("Please choose your option again \nEnter your choice:");
                    option = sc.nextInt();
                    sc.nextLine();
                    check_option =  true;
                }
                if (option == 1) {
                    add();
                } else if (option == 2) {
                    show();
                } else if (option == 3) {
                    edit();
                } else if (option == 4) {
                    remove();
                } else if (option == 5) {
                    search();
                } else if (option == 6) {
                    save();
                } else if (option == 7) {
                    load();
                } else {
                    sc.close();
                    return;
                }
                    confirm();
                break;
            } catch (Exception e){
                //ask the users to enter their choice again
                System.out.println("Invalid option!!");
                int option = sc.nextInt();
                sc.nextLine();
            }
        }
    }

    private static void confirm() throws IOException, ClassNotFoundException {
        //ask if the users want to exit
        boolean check_continue = false;
        while(!check_continue){
            try {
                System.out.println("Do you want to continue? 1 for yes, 2 for no");
                int a = sc.nextInt();
                
                while (a != 1 && a != 2){
                    System.out.println("Invalid choice!!");
                    System.out.println("Do you want to continue? 1 for yes, 2 for no");
                    a = sc.nextInt();                   
                    check_continue =  true;
                }
                if (a == 2) {
                    break;
                } else if (a == 1) {
                    main(null);
                } else {
                    System.out.println("Error");
                }
                break;
            } catch (Exception e){
                System.out.println("Invalid choice!!");
                int a = sc.nextInt();                
            }
        }
    }
    public static void add() {
        //add product into list array
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter price: ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        arrName.add(name);
        arrPrice.add(price);
        arrQuantity.add(quantity);
        id.add(arrName.size());
    }

    public static void show() {
        //show all the product were added before 
        for (int i = 0; i < id.size(); i++) {
            System.out.println(id.get(i) + "       |       " + arrName.get(i) + "       |       " + arrPrice.get(i) + "       |       " + arrQuantity.get(i));
        }
    }
    public static void edit() {
        //edit the chosen product
        System.out.println("Enter Id want to edit: ");
        int gainId = sc.nextInt();
        sc.nextLine();
        System.out.println("Edit name: ");
        String name = sc.nextLine();
                
        System.out.println("Enter price: ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        arrName.set(gainId, name);
        arrPrice.set(gainId, price);
        arrQuantity.set(gainId, quantity);
    }

    public static void remove() {
        //delete the chosen product
        System.out.println("Enter Id want to delete: ");
        int gainId = sc.nextInt();
        sc.nextLine();
        id.remove(gainId - 1);
        arrName.remove(gainId - 1);
        arrPrice.remove(gainId - 1);
        arrQuantity.remove(gainId - 1);
    }

    public static void search() {
        
        System.out.println("Enter name want to search: ");
        String tmp = sc.nextLine();
        for (int i = 0; i < arrName.size(); i++) {
            if (tmp.equalsIgnoreCase(arrName.get(i))) {
                System.out.println(id.get(i) + "       |       " + arrName.get(i) + "       |       " + arrPrice.get(i) + "       |       " + arrQuantity.get(i));
                break;
            }
            System.out.println("Not found!");
        }
    }

    public static void save() throws IOException {
        FileOutputStream fileId = new FileOutputStream("id.bin");
        ObjectOutputStream writeId = new ObjectOutputStream(fileId);
        writeId.writeObject(id);
        writeId.close();//save id

        FileOutputStream fileName = new FileOutputStream("name.bin");
        ObjectOutputStream writeName = new ObjectOutputStream(fileName);
        writeName.writeObject(arrName);
        writeName.close();//save name

        FileOutputStream filePrice = new FileOutputStream("price.bin");
        ObjectOutputStream writePrice = new ObjectOutputStream(filePrice);
        writePrice.writeObject(arrPrice);
        writePrice.close();//save price

        FileOutputStream fileQuantity = new FileOutputStream("quantity.bin");
        ObjectOutputStream writeQuantity = new ObjectOutputStream(fileQuantity);
        writeQuantity.writeObject(arrQuantity);
        writeQuantity.close();//save quantity
    }

    public static void load() throws IOException, ClassNotFoundException {
        //show all the product after being saved
        FileInputStream fileId = new FileInputStream("id.bin");
        ObjectInputStream readId = new ObjectInputStream(fileId);
        id = (ArrayList<Integer>) readId.readObject();
        readId.close();
        FileInputStream fileName = new FileInputStream("name.bin");
        ObjectInputStream readName = new ObjectInputStream(fileName);
        arrName = (ArrayList<String>) readName.readObject();
        readName.close();
        FileInputStream filePrice = new FileInputStream("price.bin");
        ObjectInputStream readPrice = new ObjectInputStream(filePrice);
        arrPrice = (ArrayList<Integer>) readPrice.readObject();
        readPrice.close();
        FileInputStream fileQuantity = new FileInputStream(new File("quantity.bin"));
        ObjectInputStream readQuantity = new ObjectInputStream(fileQuantity);
        arrQuantity = (ArrayList<Integer>) readQuantity.readObject();
        readQuantity.close();
    }
}


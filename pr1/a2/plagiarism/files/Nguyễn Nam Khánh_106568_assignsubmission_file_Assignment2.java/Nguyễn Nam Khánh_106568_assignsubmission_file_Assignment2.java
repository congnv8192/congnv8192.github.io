/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pr1.Assignment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NGUYEN NAM KHANH ID: 1901040112
 */
public class Assignment2 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int Choice;

        do { // To make loop menu-based 
            Products.Menu();
            Choice = input.nextInt();
            input.nextLine();
            

            switch (Choice) { // to split the option
                case 1:
                    Products.Option1();
                    break;
                case 2:
                    Products.Option2();
                    break;
                case 3:
                    Products.Option3();
                    break;
                case 4:
                    Products.Option4();
                    break;
                case 5:
                    Products.Option5();
                    break;
                case 6:
                    Products.Option6();
                    break;
                case 7:
                    Products.Option7();
                    break;
                
                default:
                    System.out.println("Invalid Option!! ");
                case 8:
                    System.out.println("Goodbye!!");
                    break;
            }
        }
        while (Choice != 8);
    }

    public static class Product {

        private String ID;
        private  String Name;
        private  double Price;
        private  int Quantity;

        
        public Product(String new_ID, String new_Name, double new_Price, int new_Quantity) {
            this.ID = new_ID;
            this.Name = new_Name;
            this.Price = new_Price;
            this.Quantity = new_Quantity;
        }

        public String getId() { // to bind the elements for latter use
            return ID;
        }

        
        public void ID(String new_ID) {
            this.ID = new_ID;
        }

        
        public String getName() {
            return Name;
        }

        
        public void Name(String new_Name) {
            this.Name = new_Name;
        }

        public double getPrice() {
            return Price;
        }

        
        public void Price(double new_Price) {
            this.Price = new_Price;
        }

        public int getQuantity() {
            return Quantity;
        }

        public void Quantity(int new_Quantity) {
            this.Quantity = new_Quantity;
        }
    }

    static class Products {

        static Scanner input = new Scanner(System.in);
        private static ArrayList<Product> List = new ArrayList<>();

        public static String GenerateID() { // for the auto ID
            String ID = "";
            String digits = "0123456789";
            for (int x = 0; x < 3; x++) {
                ID += digits.charAt((int) (Math.random() * digits.length()));
            }
            return ID;
        }

        public static void Menu() { //Display the menu

            System.out.println("1. Add products");
            System.out.println("2. Display products");
            System.out.println("3. Delete a product");
            System.out.println ("4. Edit a product");
            System.out.println ("5. Search for products by name");
            System.out.println ("6. Sort products by price");
            System.out.println ("7. Save products to text/binary file");
            System.out.println ("8. Load products from the saved file");
            System.out.println ("9. Exit");
            System.out.print("Choice: ");
            System.out.println();
        }

        private static void Option1() { 
            String Name;
            double Price;
            int Quantity;

            System.out.println("Number of products: "); // to know the number of products that customer want to put in
            int a = input.nextInt();
            input.nextLine();

            for (int b = 1; b <= a; b++) { 
                System.out.println("Product [" + b + "]");
                System.out.print("ProductName: ");
                Name = input.nextLine();
                
                System.out.print("ProductPrice: ");
                Price = input.nextDouble();
                input.nextLine();
                System.out.print("ProductQuantity: ");
                Quantity = input.nextInt();
                input.nextLine();
                System.out.println("Product added");
                System.out.println();
                
                Product v = new Product(GenerateID(), Name, Price, Quantity);
                List.add(v);
            }
        }

        

        private static void Option3() {
            System.out.print("Choose Id to remove: ");
            String removeID = input.nextLine();

            boolean IdValidation = false;  // to validate the ID
            Product Delete = null;
            for (Product v : List) {
                if (v.getId().equals(removeID)) { // to confirm the id 
                    IdValidation = true;
                    Delete = v;
                    break;
                }
            }
            if (IdValidation) { 
                List.remove(Delete);
                System.out.println("Product has been removed!!");
            } else {
                System.out.println("Invalid product ID!");
            }
        }
        private static void Option2() {
            
            System.out.printf("%-2s | %-7s | %-25s | %-10s | %s | %n", "Number", "ID", "Name", "Price", "Quantity"); //use to format the table
            System.out.println("-----------------------------------------------------------");

            
            int x = 1;
            for (Product v : List) {
                System.out.printf("%-3s | %-7s | %-25s | %-10.2f | %-10d | %n", x, v.getId(), v.getName(), v.getPrice(), v.getQuantity());
                x++;
            }
        }

        

        private static void Option5() {
            System.out.print("Keyword : ");
            String search = input.nextLine();
            ArrayList<Product> Search = new ArrayList<>(); // search a word from product name
            boolean word = false;
            for (Product v : List) { 
                if (v.getName().contains(search)) { 
                    Search.add(v);
                    word = true;
                }
                
                
                
            }
            int x = 0;
            if (word) {
                System.out.print("Search result: ");
                System.out.printf("%-2s | %-7s | %-25s | %-10s | %s | %n", "Number", "ID", "Name", "Price", "Quantity");
                System.out.println("-----------------------------------------------------------");
                for (Product v : Search) {
                    System.out.printf("%-3s | %-7s | %-25s | %-10.2f | %-10d | %n", x, v.getId(), v.getName(), v.getPrice(), v.getQuantity());
                    x++;
                }
            } else {
                System.out.println("Invalid keyword!");
            }
        }

        private static void Option6() {
            Product sort;
            ArrayList<Product> sortP = new ArrayList<>(List);
            for (int c = 0; c < sortP.size(); c++) { // bind c and d to the prodduct price
                for (int d = 0; d < sortP.size(); d++) {
                    if (sortP.get(c).getPrice() > sortP.get(d).getPrice()) { // compare c and d to sort
                        sort = sortP.get(c);
                        sortP.set(c, sortP.get(d));
                        sortP.set(d, sort);
                    }
                }
            }
            System.out.println("Result: ");
            System.out.printf("%-2s | %-7s | %-25s | %-10s | %s | %n", "Number", "ID", "Name", "Price", "Quantity");
            System.out.println("----------------------------------------------------------------------");
            int x = 1;
            for (Product v : sortP) {
                System.out.printf("%-3s | %-7s | %-25s | %-10.2f | %-10d | %n", x, v.getId(), v.getName(), v.getPrice(), v.getQuantity());
                x++;
            }
        }

        private static void Option7() throws FileNotFoundException, IOException {
             FileOutputStream fos = new FileOutputStream("src/NewClass/Products.txt");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(List);
                System.out.println("The file was written successfully");
            }
        }
        private static void Option4() {
            System.out.print("Product ID to edit: ");
            String editID = input.nextLine();

            boolean IDValidation = false;
            Product editP = null;
            for (Product v : List) {
                if (v.getId().equals(editID)) {
                    IDValidation = true;
                    editP = v;
                    break;
                }
            }
            if (IDValidation) {
                System.out.println("New name: ");
                String newName = input.nextLine();
                System.out.println("New price: ");
                double newPrice = Double.parseDouble(input.nextLine());
                System.out.println("New quantity: ");
                int newQuantity = Integer.parseInt(input.nextLine());

                List.get(List.indexOf(editP)).Name(newName);
                List.get(List.indexOf(editP)).Price(newPrice);
                List.get(List.indexOf(editP)).Quantity(newQuantity);
            } else {
                System.out.println("Invalid product ID!! Try again!!");
            }
        } 

        
        }
        }
           
        
    


        
        

        
        
        
            
            
      
            
            

        
       
            
        
            
        
        
        
        
        
        
        
        
        
        
    


            
        

        
    


    

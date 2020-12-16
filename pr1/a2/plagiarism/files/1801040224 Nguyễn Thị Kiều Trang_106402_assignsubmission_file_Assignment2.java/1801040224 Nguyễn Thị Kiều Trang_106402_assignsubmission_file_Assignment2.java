import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Product implements Serializable {
    int id, quantity;
    String name;
    double price;
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
       this.quantity = quantity;
    }
    public double getPrice() {
        return this.price;
    }
}

public class Assignment2 {
    private static void printMenu() {
        System.out.println("Available options: \n[1]. Add products\n[2]. Display all products\n[3]. Delete a product\n[4]. Edit a product");
        System.out.println("[5]. Search for products by name\n[6]. Sort products by price\n[7]. Save products into a file");
        System.out.println("[8]. Load products from saved file\n[9]. Exit\n");
    }
    private static int idStack = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> ProductList = new ArrayList<>();
        
        boolean inProgram = true;
        while (inProgram) {
            int option = -1;
            while (true) {
                printMenu();
                try {
                    System.out.print("Enter your option: ");
                    option = sc.nextInt();
                    if (option < 1 || option > 9) 
                        System.out.println("No such option available! Try again!\n");
                    else
                        break;
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an integer!\n");
                    sc.nextLine();
                }
            }
            
            switch (option) {
                case 1:
                    System.out.println("You chose option 1: Add products...");
                    
                    int addCount = -1;
                    while (true) {
                        try {
                            System.out.print("Enter the number of products you want to add: ");
                            addCount = sc.nextInt();
                            if (addCount < 0)
                                System.out.println("You can not add a negative number of products! Try again!\n");
                            else
                                break;
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter an integer!\n");
                            sc.nextLine();
                        }
                    }
                    
                    for (int a = 0; a < addCount; a++) {
                        System.out.println("Turn " + (a + 1) + ": ");
                        
                        sc.nextLine();
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        
                        double price = -1;
                        while (true) {
                            try {
                                System.out.print("Enter price: ");
                                price = sc.nextDouble();
                                if (price <= 0)
                                    System.out.println("The price must be higher than 0! Try again!\n");
                                else
                                    break;
                            }
                            catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter a floating point number!\n");
                                sc.nextLine();
                            }
                        }
                        
                        int quantity = 1;
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                quantity = sc.nextInt();
                                if (quantity < 0)
                                    System.out.println("A product can not have a negative quantity! Try again!\n");
                                else
                                    break;
                            }
                            catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter an integer!\n");
                                sc.nextLine();
                            }
                        }
                        
                        ProductList.add(new Product(++idStack, name, price, quantity));
                        System.out.println("Successfully added a product!\n");
                    }
                    break;
                case 2:
                    System.out.println("You chose option 2: Display all products...");
                    
                    if(ProductList.isEmpty())
                        System.out.println("Nothing to display!\n");
                    else {
                        System.out.printf(" %-4s | %-45s | %-12s | %-8s \n", "ID", "Name", "Price", "Quantity");
                        System.out.println("--------------------------------------------------------------------------------");
                        ProductList.forEach(p -> System.out.printf(" %-4d | %-45s | %-12.2f | %-8d \n", p.id, p.name, p.price, p.quantity));
                    }
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("You chose option 3: Delete a product...");
                    if (ProductList.isEmpty()) 
                        System.out.println("Nothing to delete!\n");
                    else {
                        int removeID = -1;
                        while (true) {
                            try {
                                System.out.print("Enter the ID of product you want to delete: ");
                                removeID = sc.nextInt();
                                break;
                            }
                            catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter an integer!\n");
                                sc.nextLine();
                            }
                        }

                        if (removeID <= 0)
                            System.out.println("No such ID exists!\n");
                        else {
                            boolean found = false;
                            for (Product p : ProductList) {
                                if (p.id == removeID) {
                                    ProductList.remove(ProductList.indexOf(p));
                                    found = true;
                                    break;
                                }
                            }
                            if (found)
                                System.out.println("Successfully deleted a product!\n");
                            else
                                System.out.println("No such ID found!\n");
                        }
                    }
                    break;
                case 4:
                    System.out.println("You chose option 4: Edit a product...");
                    if (ProductList.isEmpty())
                        System.out.println("Nothing to edit!\n");
                    else {
                        int editID = -1, editIndex = -1;
                        while (true) {
                            try {
                                System.out.print("Enter the ID of product you want to edit: ");
                                editID = sc.nextInt();
                                break;
                            }
                            catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter an integer!\n");
                                sc.nextLine();
                            }
                        }

                        if (editID <= 0)
                            System.out.println("No such ID exists!\n");
                        else {
                            for (Product p : ProductList) {
                                if (p.id == editID) {
                                    editIndex = ProductList.indexOf(p);
                                    break;
                                }
                            }

                            if (editIndex == -1) 
                                System.out.println("No such ID found!\n");
                            else {
                                sc.nextLine();
                                System.out.print("Enter the new name: ");
                                String newName = sc.nextLine();
                                
                                double newPrice = -1;
                                while (true) {
                                    try {
                                        System.out.print("Enter the new price: ");
                                        newPrice = sc.nextDouble();
                                        if (newPrice <= 0)
                                            System.out.println("The new price must be higher than 0! Try again!\n");
                                        else
                                            break;
                                    }
                                    catch (InputMismatchException e) {
                                        System.out.println("Invalid input! Please enter a floating point number!\n");
                                        sc.nextLine();
                                    }
                                }
                                
                                int newQuantity = -1;
                                while (true) {
                                    try {
                                        System.out.print("Enter the new quantity: ");
                                        newQuantity = sc.nextInt();
                                        if (newQuantity < 0)
                                            System.out.println("A product can not have a negative quantity! Try again!\n");
                                        else
                                            break;
                                    }
                                    catch (InputMismatchException e) {
                                        System.out.println("Invalid input! Please enter an integer!\n");
                                        sc.nextLine();
                                    }
                                }
                                
                                ProductList.get(editIndex).setName(newName);
                                ProductList.get(editIndex).setPrice(newPrice);
                                ProductList.get(editIndex).setQuantity(newQuantity);
                                System.out.println("Successfully edited a product!\n"); 
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("You chose option 5: Search for products by name...");
                    
                    if(ProductList.isEmpty())
                        System.out.println("Nothing to search for!\n");
                    else {
                        sc.nextLine();
                        System.out.print("Enter the searing name: ");
                        String searchName = sc.nextLine();
                        
                        boolean found = false;
                        System.out.printf(" %-4s | %-45s | %-12s | %-8s \n", "ID", "Name", "Price", "Quantity");
                        System.out.println("--------------------------------------------------------------------------------");
                        for (Product p : ProductList) {
                            if (p.name.toLowerCase().contains(searchName.trim().replaceAll("\\s{2,}", " ").toLowerCase())) {
                                System.out.printf(" %-4d | %-45s | %-12.2f | %-8d \n", p.id, p.name, p.price, p.quantity);
                                found = true;
                            }
                        }
                        if (!found)
                            System.out.println("There are no products which match your searching name!\n");
                    }
                    break;
                case 6:
                    System.out.println("You chose option 6: Sort products by price...");
                    
                    if(ProductList.isEmpty())
                        System.out.println("Nothing to sort!\n");
                    else {
                        System.out.printf(" %-4s | %-45s | %-12s | %-8s \n", "ID", "Name", "Price", "Quantity");
                        System.out.println("--------------------------------------------------------------------------------");
                        ProductList.stream().sorted(Comparator.comparing(Product::getPrice))
                                .forEach(p -> System.out.printf(" %-4d | %-45s | %-12.2f | %-8d \n", p.id, p.name, p.price, p.quantity));
                    }
                    break;
                case 7:
                    System.out.println("You chose option 7: Save products in a file...");
                    try (FileOutputStream fos = new FileOutputStream(new File("product_list.txt")); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                        oos.writeObject(ProductList);
                        oos.writeInt(idStack);
                        System.out.println("Successfully saved the product in a file!\n");
                    }
                    catch (FileNotFoundException e) {} //Most likely will never happen
                    catch (IOException e) {} //The same for this
                    break;
                case 8:
                    System.out.println("You chose option 8: Load products from saved file...");
                    try (FileInputStream fis = new FileInputStream(new File("product_list.txt")); ObjectInputStream ois = new ObjectInputStream(fis)) {
                        ProductList = (List<Product>) ois.readObject();
                        idStack = ois.readInt();
                        System.out.println("Successfully loaded the products from saved file!\n");
                    }
                    catch (FileNotFoundException e) {
                        System.out.println("File not found!\n");
                    }
                    catch (IOException | ClassNotFoundException e) {}
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    inProgram = false;    
            }
        }
    }
}
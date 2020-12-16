
package a2_pr1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Vector;

public class a2_1701040095 {

    static Scanner sc = new Scanner(System.in);
    static Vector<Product> products = new Vector<>();

    public static void main(String[] args) {
        for (;;) {
            System.out.println("1. Add products");
            System.out.println("2. Display products");
            System.out.println("3. Delete a product");
            System.out.println("4. Edit products");
            System.out.println("5. Search product by name");
            System.out.println("6. Sort products by price");
            System.out.println("7. Save products to text/binary file");
            System.out.println("8. Load products from the saved file");
            System.out.println("9. Quit");

            int option = 0;

            try {
                System.out.print("Choose an option: ");
                option = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                sc.nextLine();
            }

            if (option == 1) {
                addProduct();
            } else if (option == 2) {
                displayProduct();
            } else if (option == 3) {
                deleteProduct();
            } else if (option == 4) {
                editProduct();
            } else if (option == 5) {
                searchByName();
            } else if (option == 6) {
                sortByPrice();
            } else if (option == 7) {
                saveProduct();
            } else if (option == 8) {
                loadProduct();
            } else if (option == 9) {
                System.exit(0);
            }
        }
    }

    private static void addProduct() {
        System.out.println("----ADD PRODUCT----");

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        Product product = new Product(name, price, quantity);
        products.add(product);
    }

    private static void displayProduct() {
        System.out.println("----DISPLAY PRODUCT----");

        if (products.isEmpty()) {
            System.out.println("Nothing!");
        } else {
            for (Product p : products) {
                System.out.println(p.toString());
            }
        }
    }

    private static void deleteProduct() {
        System.out.println("----DELETE PRODUCT----");

        if (!products.isEmpty()) {
            System.out.print("Input product's id: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Product p : products) {
                if (p.getId() == id) {
                    products.remove(p);
                    System.out.println("Successfully!");
                    break;
                }
            }
        }
    }
    
    private static void editProduct() {
        System.out.println("----EDIT PRODUCT----");
        System.out.print("Enter the ID of the product u want to edit: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Product p : products) {
            if (p.getId() == id) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = Double.parseDouble(sc.nextLine());
                System.out.print("Quantity: ");
                int quantity = Integer.parseInt(sc.nextLine());

                p.setName(name);
                p.setPrice(price);
                p.setQuantity(quantity);
                System.out.println("Successfully!");
            }
        }
    }
    
    private static void searchByName() {
        System.out.println("----Search product by name----");
        System.out.print("Input name: ");
        String name = sc.nextLine();

        for (Product p : products) {
            if (p.getName().contains(name)) {
                System.out.println(p.toString());
            }
        }
    }
    
    private static void sortByPrice() {
        System.out.println("----Sort product by price----");

        //bubble sort
        for (int i = 0; i < products.size(); i++) {
            for (int j = i; j < products.size(); j++) {
                if (products.get(j).getPrice() > products.get(i).getPrice()) {
                    //swap element
                    Product temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }
    }

    private static void loadProduct() {
        System.out.println("----LOAD PRODUCT----");
        File f = new File("products.dat");
        if (f.exists()) {
            ObjectInputStream in = null;
            try {
                in = new ObjectInputStream(new FileInputStream(f));

                while (true) {

                    Object object = in.readObject();
                    if (object != null) {
                        products.add((Product) object);
                    }

                }
            } catch (EOFException e) {

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Load: " + products.size() + " products");
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private static void saveProduct() {
        System.out.println("----SAVE PRODUCT----");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("products.dat"));

            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                out.writeObject(product);
            }
            System.out.println("Save: " + products.size() + " products");
            out.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    static class Product implements Serializable {

        private int id;
        private String name;
        private double price;
        private int quantity;
        static int count = 0;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.id = generateId();
        }

        public int getId() {
            return id;
        }

        private int generateId() {
            count++;
            return count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "[Id: " + this.id + ", name: " + this.name + ", price: " + this.price + ", quantity: " + this.quantity + "]";
        }
    }
}

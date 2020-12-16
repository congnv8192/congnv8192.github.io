package nguyenlebaoanh_a02_7c18_1801040007_pr1_assignment2;

import java.io.*;

import java.util.*;

public class assignment2 {

    static ArrayList<String> qnameList = new ArrayList<>(); //create an array list to save product's name
    static ArrayList<Double> qpriceList = new ArrayList<>(); // create an array list to save products's price
    static ArrayList<Integer> qquantityList = new ArrayList<>(); // create an array list to save product's quantity


    public static void addProducts() {
        try {
            Scanner scAdd = new Scanner(System.in); 

            System.out.print("Enter number of products you want to add: ");
            int numProducts = scAdd.nextInt();
            scAdd.nextLine();

            for (int i = 0; i < numProducts; i++) {
                int id = qnameList.size() + 1; // ID was create automatically
                
                System.out.println("ID of product:" + id);
                System.out.print("Enter product's name: ");
                String name = scAdd.nextLine();
                System.out.print("Enter product's price: ");
                double price = scAdd.nextDouble();
                scAdd.nextLine();
                System.out.print("Enter product's quantity: ");
                int quantity = scAdd.nextInt();
                scAdd.nextLine();

                qnameList.add(name); // save input to arraylist
                qpriceList.add(price);
                qquantityList.add(quantity);
                
                System.out.println("Product is added successfully!");
            }
        } catch (Exception e) {
            System.err.println("Invalid input data!3");
        }
    }

    public static void displayProducts() {
        boolean checkExist = qnameList.isEmpty();
        if (checkExist == true) {
            System.out.println("There is no Products to display!");
        } else { // create a table 
            System.out.println("________________________________________________________");
            System.out.format("%10s || %20s || %10s || %10s || %n", "ID", "Name", " Price", "Quantity"); // create a table

            for (int i = 0; i < qnameList.size(); i++) {
                System.out.format("No.%7d || %20s || %10f || %10d || %n", i + 1, qnameList.get(i), qpriceList.get(i), qquantityList.get(i));// display data of products
            }
            System.out.println("________________________________________________________");
        }
    }

    public static void deleteProduct() {
        try {
            Scanner scDel = new Scanner(System.in);

            System.out.print("Enter the ID of product you want to delete: "); 
            int id = scDel.nextInt();

            qnameList.remove(id - 1); 
            qpriceList.remove(id - 1);// delete product in arraylist
            qquantityList.remove(id - 1);
            System.out.println( "Chosen product is Deleted!");

        } catch (Exception e) { 
            System.out.println("Invalid ID!");
        }
        displayProducts(); // display results remain after deleting
    }

    public static void editProduct() {
        try {
            Scanner scEdit = new Scanner(System.in);

            System.out.print("Enter the ID product you want to edit: ");
            int Id = scEdit.nextInt();
            scEdit.nextLine();

            System.out.print("Enter new name: ");
            String eName = scEdit.nextLine(); // get user input
            qnameList.set(Id - 1, eName); // change data in an array list 

            System.out.print("Enter new price: ");
            double ePrice = scEdit.nextDouble();
            qpriceList.set(Id - 1, ePrice);

            System.out.print("Enter new quantity: ");
            int eQuantity = scEdit.nextInt();
            qquantityList.set(Id - 1, eQuantity);

        } catch (Exception e) {
            System.err.println("Inavlid data!");
        }
        displayProducts(); // display result after edit
    }

    public static void searchProduct() {
        try {
            boolean checkExist = false; 
            Scanner scSearch = new Scanner(System.in);
            System.out.print("Enter the product name you want to search: ");
            String searchname = scSearch.nextLine();

            for (int i = 0; i < qnameList.size(); i++) {
                if (qnameList.get(i).contains(searchname)) {
                    System.out.println("____________________________________________________________");
                    System.out.format("%10s || %20s || %10s || %10s || %n", "ID", "Name", " Price", "Quantity");
                    System.out.format("No.%7d || %20s || %10f || %10d || %n", i + 1, qnameList.get(i), qpriceList.get(i), qquantityList.get(i));
                    System.out.println("_____________________________________________________________");
                    checkExist = true;
                }
            }
            if(checkExist == false) {
                System.err.println("No product has this name! ");
            }
        } catch (Exception e) {
            System.err.println("Invalid product's name!");
        }
    }

    public static void sortProducts() {
        int minPosi;
        String sName;
        double sPrice;
        int sQuantity;
        for (int i = 0; i < qnameList.size(); i++) { 
            minPosi = i;
            for (int j = i + 1; j < qnameList.size(); j++) { // find position of the minimum value in array list
                if (qpriceList.get(j) < qpriceList.get(i)) { //compare value in array list
                    minPosi = j; // create new minimun value
                }
            }
            sName = qnameList.get(i); // product name from the position of minimum value of price 
            qnameList.set(i, qnameList.get(minPosi));
            qnameList.set(minPosi, sName);

            sPrice = qpriceList.get(i);
            qpriceList.set(i, qpriceList.get(minPosi));
            qpriceList.set(minPosi, sPrice);

            sQuantity = qquantityList.get(i);
            qquantityList.set(i, qquantityList.get(minPosi));
            qquantityList.set(minPosi, sQuantity);
        }
        displayProducts();// display product after sorting
    }

    public static void saveProducts() {
        try {
            File productFile = new File("products.txt");
            FileOutputStream fos = new FileOutputStream(productFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(qnameList);
            oos.writeObject(qpriceList);
            oos.writeObject(qquantityList);

            oos.close();

            System.out.println("Products have been saved!");
        } catch (IOException e) {
            System.out.println("Something's Wrong!");
        }
    }

    public static void loadProducts() throws FileNotFoundException, IOException {
        try {
            File productFile = new File("products.txt");

            FileInputStream fis = new FileInputStream(productFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            qnameList = (ArrayList<String>) ois.readObject();
            qpriceList = (ArrayList<Double>) ois.readObject();
            qquantityList = (ArrayList<Integer>) ois.readObject();

            ois.close();

            System.out.println("Loading completed!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Something's Wrong!");
        }
    }

    public static void quitProgram() { // feature9
        System.out.println("________________Thank you,bye!________________");
    }

    public static void menuDisplay() { //display a menu
        System.out.println("------------------------------------------------------");
        System.out.println("Welcome to Product's manipulation _Assignment2_");
        System.out.println("----------------------------------------------------");
        System.out.println("Please choose an option:");
        System.out.println("[1]:Add products"
                + "\n[2]:Display products"
                + "\n[3]:Delete a product"
                + "\n[4]:Edit a product"
                + "\n[5]:Search for a product by name"
                + "\n[6]:Sort products by price"
                + "\n[7]:Save products to text/binary file"
                + "\n[8]:Load products from the saved file"
                + "\n[9]:Quit");
       
        
        System.out.println("______________________END_________________________");
    }

    public static void runProgram(int option) throws IOException {
        switch (option) {
            case 1:
                addProducts();
                break;
            case 2:
                displayProducts();
                break;
            case 3:
                deleteProduct();
                break;
            case 4:
                editProduct();
                break;
            case 5:
                searchProduct();
                break;
            case 6:
                sortProducts();
                break;
            case 7:
                saveProducts();
                break;
            case 8:
                loadProducts();
                break;
            case 9:
                quitProgram();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    public static void main(String[] args) throws Exception {
        int option = 0;
        boolean checkruncode = false;
        while (checkruncode == false) {
            try {
                while (option != 9) {
                    menuDisplay();
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter option: ");
                    option = sc.nextInt();
                    runProgram(option);
                }
                checkruncode = true;
            } catch (IOException e) {
                System.out.println("Invalid option!");
            }            
        }
    }
}

        
        
package assignment02;

import java.io.*;
import java.util.*;

class Products implements Serializable {

    private int ID;
    private String names;
    private float prices;
    private int quantities;

    public void addInfor() {

        Scanner sc = new Scanner(System.in);

        Random rd = new Random();
        ID = 100000 + rd.nextInt(900000);
        System.out.print("\nEnter product name: ");
        names = sc.nextLine();
        System.out.print("Enter product price($): ");
        prices = sc.nextFloat();
        System.out.print("Enter numbers of products: ");
        quantities = sc.nextInt();
    }

    public void display() {
        System.out.format("%20d | %20s | %10.2f | %10d | %n", ID, names, prices, quantities);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public float getPrices() {
        return prices;
    }

    public void setPrices(float prices) {
        this.prices = prices;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }
}

public class Assignment2MAU {

    Scanner in = new Scanner(System.in);
    List<Products> arr = new ArrayList<>();

    /*Add product*/
    void getInput(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.print("\n[Product " + i + "]");
            Products PD = new Products();
            PD.addInfor();
            arr.add(PD);
        }
    }

    /*Output screen*/
    void displayAllProducts() {
        System.out.format("%20s | %20s | %10s | %10s | %n", "PRODUCTS ID", "NAMES", "PRICES($)", "QUANTITIES");
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).display();
        }
    }

    /*Find location to manage*/
    int findPosition(int locate) {
        int i;
        boolean isFound = false;
        for (i = 0; i < arr.size(); i++) {
            if (arr.get(i).getID() == locate) {
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            return -1;
        }
        return i;
    }

    /*Search Method*/
    void searchProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter product's name: ");
        String s = input.nextLine();
        boolean isExisted = false;
        System.out.format("%20s | %20s | %10s | %10s | %n", "PRODUCTS ID", "NAMES", "PRICES($)", "QUANTITIES");
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getNames().contains(s)) {
                arr.get(i).display();
                isExisted = true;
            }
        }
        if (!isExisted) {
            System.out.println("\n>>>__________Product not found !!!__________<<<");
        }
    }

    /*Sort by prices*/
    void sortProducts() {
        Collections.sort(arr, new Comparator<Products>() { //Collections.sort() with Comparator
            @Override
            public int compare(Products o1, Products o2) {
                if (o1.getPrices() < o2.getPrices()) {
                    return -1;
                } else if (o1.getPrices() == o2.getPrices()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        System.out.format("%20s | %20s | %10s | %10s | %n", "PRODUCTS ID", "NAMES", "PRICES($)", "QUANTITIES");
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).display();
        }
    }

    /*Save data to file */
    void saveFile() {
        System.out.print("\nEnter file's name(.txt): ");
        String s = in.nextLine();
        try {
            File f = new File(s + ".txt");
            FileOutputStream fos = new FileOutputStream(f);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(arr);
                oos.close();
            }
            System.out.println("\n>>>__________FILE SAVED__________<<<");
        } catch (IOException e) {
            System.out.println("/n>>>__________ERROR: " + e + "__________<<<");
        }
    }

   
    void loadFile() throws ClassNotFoundException {
        System.out.print("\nEnter file's name you want to load-in: ");
        String s = in.nextLine();
        try {
           
            FileInputStream fis = new FileInputStream(new File(s + ".txt"));
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                arr = (ArrayList<Products>) ois.readObject();
                System.out.println("\n>>>__________FILE LOADED__________<<<");
                displayAllProducts();
                ois.close();
            }
        } catch (IOException e) {
            System.out.println("/n>>>__________ERROR: " + e + "__________<<<");
        }
    }

    /*Show list menu*/
    static void showMenu() {
        System.out.println("\n***********MENU***********");
        System.out.println("\n[1] Add products\n[2] Display products");
        System.out.println("[3] Delete a product\n[4] Edit a product");
        System.out.println("[5] Search for products by name\n[6] Sort products by price");
        System.out.println("[7] Save products to text/binary file\n[8] Load products from the saved file");
        System.out.print("[0] Quit\n\nChoose an option: ");
    }

    public static void main(String[] args) throws Exception {

        Assignment2MAU manages = new Assignment2MAU();

        Scanner sc = new Scanner(System.in);
        boolean checked = false;
        while (checked == false) {
            showMenu();
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("\nEnter numbers of products you want to add-in: ");
                    int n = sc.nextInt();
                    manages.getInput(n);
                    System.out.println("\n>>>__________Successful!__________<<<");
                    break;
                case 2:
                    manages.displayAllProducts();
                    break;
                case 3:
                    System.out.print("\nEnter product ID: ");
                    int id = sc.nextInt();
                    int a = manages.findPosition(id);
                    if (a == -1) {
                        System.out.println("\n>>>__________Product not found !!!__________<<<");
                    } else {
                        manages.arr.remove(manages.arr.get(a));//delete all data of a(th) product location
                        System.out.println("\nDeleted!");
                        manages.displayAllProducts();//show updated product's list
                    }
                    break;
                case 4:
                    System.out.print("\nEnter product's id: ");
                    int edit = sc.nextInt();
                    int b = manages.findPosition(edit);
                    if (b == -1) {
                        System.out.println("\nProduct not found !");
                    } else {
                        System.out.println("Updating product: " + manages.arr.get(b).getNames() + "\n");
                        System.out.print("New name: ");
                        sc.nextLine();// chống trôi dòng
                        String reName = sc.nextLine();
                        manages.arr.get(b).setNames(reName);
                        System.out.print("New price($): ");
                        float rePrice = sc.nextFloat();
                        manages.arr.get(b).setPrices(rePrice);
                        System.out.print("New quantities: ");
                        int reQuantities = sc.nextInt();
                        manages.arr.get(b).setQuantities(reQuantities);
                        System.out.println("\n>>>__________Products was edited!__________<<<");
                        manages.displayAllProducts();//show updated product's list
                    }
                    break;
                case 5:
                    manages.searchProduct();
                    break;
                case 6:
                    manages.sortProducts();
                    break;
                case 7:
                    manages.saveFile();
                    break;
                case 8:
                    manages.loadFile();
                    break;
                case 0:
                    System.out.println("__________End!__________");
                    checked = true;
                    break;

                default:
                    System.out.println("__________Invalid input!__________");
            }
        }
    }
}

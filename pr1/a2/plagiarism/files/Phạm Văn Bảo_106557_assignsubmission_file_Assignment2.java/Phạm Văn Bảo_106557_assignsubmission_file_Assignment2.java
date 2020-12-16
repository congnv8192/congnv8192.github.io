package Pham_Van_Bao_1901040030;

import java.io.*;
import java.util.*;

class Products implements Serializable {

    private int ID;
    private String names;
    private float prices;
    private int quantities;

    public void Add_Products() {

        Scanner sc = new Scanner(System.in);

        Random r = new Random();
        ID = 1 + r.nextInt(99);
        System.out.print("Enter name: \n");
        names = sc.nextLine();
        System.out.print("Enter price($): \n");
        prices = sc.nextFloat();
        System.out.print("Enter numbers of product: \n");
        quantities = sc.nextInt();
    }

    public void Display() {
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

public class Assignment2 {

    Scanner in = new Scanner(System.in);
    ArrayList<Products> arr = new ArrayList<>();

    /*Add product*/
    void InputData(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println("[Product " + i + "]");
            Products PD = new Products();
            PD.Add_Products();
            arr.add(PD);
        }
    }

    /*Output screen*/
    void DisplayAll() {
        System.out.format("%20s | %20s | %10s | %10s | %n", "PRODUCTS ID", "NAMES", "PRICES($)", "QUANTITIES");
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).Display();
        }
    }

    /*Find location to manage*/
    int FindLocate(int locate) {
        int i;
        boolean find = false;
        for (i = 0; i < arr.size(); i++) {
            if (arr.get(i).getID() == locate) {
                find = true;
                break;
            }
        }
        if (!find) {
            return -1;
        }
        return i;
    }

    /*Search Method*/
    void Search() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter product's name: \n");
        String S = input.nextLine();
        boolean found = false;
        System.out.format("%20s | %20s | %10s | %10s | %n", "PRODUCTS ID", "NAMES", "PRICES($)", "QUANTITIES");
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getNames().contains(S)) {
                arr.get(i).Display();
                found = true;
            }
        }
        if (!found) {
            System.out.println(">>>__________Product not found !!!__________<<< \n");
        }
    }

    /*Sort by prices*/
    void Sort() {
        Collections.sort(arr, new Comparator<Products>() { //Collections.Sort() with Comparator
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
            arr.get(i).Display();
        }
    }

    /* save */
    void Save() {
        System.out.print("Enter file's name(.txt): \n");
        String t = in.nextLine();
        try {
            File F = new File(t + ".txt");
            FileOutputStream fos = new FileOutputStream(F);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(arr);
                oos.close();
            }
            System.out.println(">>>__________FILE SAVED__________<<< \n");
        } catch (IOException e) {
            System.out.println(">>>__________ERROR: " + e + "__________<<<");
        }
    }

    /*Load data from file*/
    void Load() throws ClassNotFoundException {
        System.out.print("Enter file's name you want to load-in: \n");
        String s = in.nextLine();
        try {
            File file = new File(s + ".txt");
            FileInputStream fis = new FileInputStream(file);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                arr = (ArrayList<Products>) ois.readObject();
                System.out.println(">>>__________FILE LOADED__________<<<");
                DisplayAll();
                ois.close();
            }
        } catch (IOException e) {
            System.out.println(">>>__________ERROR: " + e + "__________<<<");
        }
    }

    /*Show list menu*/
    static void Menu() {
        System.out.println("[1] Add products\n"
                         + "[2] Display products\n"
                         + "[3] Delete a product\n"
                         + "[4] Edit a product\n"
                         + "[5] Search for products by name\n"
                         + "[6] Sort products by price\n"
                         + "[7] Save products to text/binary file\n"
                         + "[8] Load products from the saved file\n"
                         + "[0] Quit\n"
                         + "Choose an option: ");
    }

    public static void main(String[] args) throws Exception {

        Assignment2 manages = new Assignment2();

        Scanner sc = new Scanner(System.in);
        boolean check = false;
        while (check == false) {
            Menu();
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("Enter numbers of products you want to add-in: \n");
                    int n = sc.nextInt();
                    manages.InputData(n);
                    System.out.println(">>>__________Successful!__________<<<\n");
                    break;
                case 2:
                    manages.DisplayAll();
                    break;
                case 3:
                    System.out.print("Enter product ID: \n");
                    int del = sc.nextInt();
                    int a = manages.FindLocate(del);
                    if (a == -1) {
                        System.out.println(">>>__________Product not found !!!__________<<<\n");
                    } else {
                        manages.arr.remove(manages.arr.get(a));
                        System.out.println(">>>__________Deleted!__________<<<\n");
                        manages.DisplayAll();
                    }
                    break;
                case 4:
                    System.out.print("Enter product ID: \n");
                    int edit = sc.nextInt();
                    int b = manages.FindLocate(edit);
                    if (b == -1) {
                        System.out.println(">>>__________Product not found !!!__________<<<\n");
                    } else {
                        System.out.println("\n>>>__________Editing product: \"" + manages.arr.get(b).getNames() + "\"__________<<<");
                        System.out.print("New name: \n");
                        sc.nextLine();
                        String reName = sc.nextLine();
                        manages.arr.get(b).setNames(reName);
                        System.out.print("New price($): \n");
                        float rePrice = sc.nextFloat();
                        manages.arr.get(b).setPrices(rePrice);
                        System.out.print("New quantities: \n");
                        int reQuantities = sc.nextInt();
                        manages.arr.get(b).setQuantities(reQuantities);
                        System.out.println(">>>__________Product Data was updated!__________<<<\n");
                        manages.DisplayAll();
                    }
                    break;
                case 5:
                    manages.Search();
                    break;
                case 6:
                    manages.Sort();
                    break;
                case 7:
                    manages.Save();
                    break;
                case 8:
                    manages.Load();
                    break;
                case 0:
                    System.out.println("\n>>>__________Goodbye!__________<<<");
                    check = true;
                    break;

                default:
                    System.out.println("\n>>>_________Invalid choice!!!_________<<<");
            }
        }
    }
}

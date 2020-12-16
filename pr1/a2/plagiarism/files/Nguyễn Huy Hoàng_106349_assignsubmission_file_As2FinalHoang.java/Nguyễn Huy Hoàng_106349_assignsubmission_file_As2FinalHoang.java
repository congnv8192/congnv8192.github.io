package as2finalhoang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
class Products implements Serializable {
    private int id;
    private static int temp = 0;
    private String name;
    private double price;
    private int quantity;

    public Products(String name, double price, int quantity) {
        this.temp = this.temp + 1;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = this.temp;
    }
    public int getId() {
        return id;
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
    public String toString() {
        return this.id + " " + this.name + " " + this.price + " " + this.quantity;
    }
}

class Base implements Serializable {

    private ArrayList<Products> pro;
    public Base() {
        pro = new ArrayList<>();
    }
    public void add(Products p) {
        pro.add(p);
    }
    public void delete(Products p) {
        pro.remove(p);
    }
    public ArrayList get() {
        return pro;
    }
    public int size() {
        return pro.size();
    }
    public Products get(int i) {
        return pro.get(i);
    }
    public void set(int index, Products e) {
        pro.set(index, e);
    }
}

    
public class As2FinalHoang {
    public static void main(String[] args) throws IOException {
        Base hoanglist = new Base();
        int ft;
        Scanner sc = new Scanner(System.in);
        do {
            Menu();
            System.out.println("Enter Feature :");
            ft = Integer.parseInt(sc.nextLine());
            switch (ft) {
                case 1:
                    int n;
                    System.out.print("Enter number of products you want: ");
                    n = Integer.parseInt(sc.nextLine());
                    for (int i = 1; i <= n; i++) {
                        System.out.println("Product ID : " + i);
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter price: ");
                        double price = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter quantity: ");
                        int quantity = Integer.parseInt(sc.nextLine());
                        Products pd = new Products(name, price, quantity);
                        hoanglist.add(pd);
                    }
                    break;
                case 2:
                    for (int i = 0; i < hoanglist.size(); i++) {
                        System.out.println(hoanglist.get(i).toString());
                    }
                    break;
                case 3:
                    System.out.print("Enter id you want to delete: ");
                    int m = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < hoanglist.size(); i++) {
                        if (hoanglist.get(i).getId() == m) {
                            hoanglist.delete(hoanglist.get(i));
                        }
                    }
                    System.out.println("Deleted!");
                    break;
                case 4:
                    System.out.print("Enter id you want to edit: ");
                    int a = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new name: ");
                    String new_name = sc.nextLine();
                    System.out.print("Enter new price: ");
                    double new_price = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter new quatity: ");
                    int new_quantity = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < hoanglist.size(); i++) {
                        if (hoanglist.get(i).getId() == a) {
                            hoanglist.get(i).setName(new_name);
                            hoanglist.get(i).setPrice(new_price);
                            hoanglist.get(i).setQuantity(new_quantity);
                        }
                    }
                    System.out.println("Edited!");
                    break;
                case 5:
                    System.out.print("Enter keyword of the product name ");
                    String kw = sc.nextLine();
                    String[] name;
                    for (int i = 0; i < hoanglist.size(); i++) {
                        name = hoanglist.get(i).getName().split(" ");
                        for (int j = 0; j < name.length; j++) {
                            if (kw.equalsIgnoreCase(name[j])) {
                                System.out.println(hoanglist.get(i).toString());
                            }
                        }
                    }
                    break;
                case 6:
                    Products t;
                    for (int j = 0; j < hoanglist.size() - 1; j++) {
                        for (int i = 0; i < hoanglist.size() - 1; i++) {
                            if (hoanglist.get(i).getPrice() > hoanglist.get(i+1).getPrice()) {
                                t = hoanglist.get(i);
                                hoanglist.set(i, hoanglist.get(i + 1));
                                hoanglist.set(i + 1, t);
                            }
                        }
                    }
                    System.out.println("Sorted!");
                    break;
                case 7:
                    FileOutputStream out = null;
                    ObjectOutputStream oos = null;
                    try {
                        File f = new File("Menu.obj");
                        out = new FileOutputStream(f);
                        oos = new ObjectOutputStream(out);
                        oos.writeObject(hoanglist);
                    } 
                    catch (Exception e) {
                        System.out.println("File not found");
                    } 
                    finally {
                        if (out != null) {
                            out.close();
                        }
                        if (oos != null) {
                            oos.close();
                        }
                    }
                    System.out.println("Saved!");
                    break;
                case 8:
                    FileInputStream in = null;
                    ObjectInputStream ois = null;
                    try {
                        File f = new File("File.obj");
                        in = new FileInputStream(f);
                        ois = new ObjectInputStream(in);
                        hoanglist = (Base) ois.readObject();
                    }
                    catch (Exception e) {
                        System.out.println("File not found");
                    } 
                    finally {
                        if (in != null) {
                            in.close();
                        }
                        if (ois != null) {
                            ois.close();
                        }
                    }
                    System.out.println("Display: ");
                    for (int i = 0; i < hoanglist.size(); i++) {
                        System.out.println(hoanglist.get(i).toString());
                    }
                    break;

                case 9:
                    System.out.println("Still to finish the final exam!");
                    break;
                default:
                    System.err.println("Wrong!");
                    break;
            }

        } while (ft != 9);
    }
    static void Menu() {
        System.out.println("Program Features : ");
        System.out.println("1. Add products ");
        System.out.println("2. Display products ");
        System.out.println("3. Delete a product");
        System.out.println("4. Edit a product");
        System.out.println("5. Search for products by name");
        System.out.println("6. Sort products by price");
        System.out.println("7. Save products");
        System.out.println("8. Load products from saved file");
        System.out.println("9. Exit program");
    }
}

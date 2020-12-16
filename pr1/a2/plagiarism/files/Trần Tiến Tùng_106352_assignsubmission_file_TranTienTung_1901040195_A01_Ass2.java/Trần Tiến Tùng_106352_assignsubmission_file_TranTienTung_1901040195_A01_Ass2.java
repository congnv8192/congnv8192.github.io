/*
 * Student name: Tran Tien Tung
 * Class: 3CK19
 * Student ID: 1901040195
 * Email: hung2522001@gmail.com
 */
package trantientung_1901040195_a01_ass2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class Products implements Serializable {
    private int ID;
    private String names;
    private float prices;
    private int quantity;
public void addInfor() {
    Scanner sc = new Scanner(System.in);
    Random mylove = new Random();
    ID = 100000 + mylove.nextInt(900000);
    System.out.print("Enter product's name: ");
    names = sc.nextLine();
    System.out.print("Enter the cost price: ");
    prices = sc.nextFloat();
    System.out.print("Enter the number of products: ");
    quantity = sc.nextInt();
}
public void display(){
    System.out.format("%20d | %20s | %10.2f | %10d | %n", ID, names, prices, quantity);
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}


public class TranTienTung_1901040195_A01_Ass2 {
Scanner BTS = new Scanner(System.in);
ArrayList<Products> jungkook = new ArrayList<>();

/* Add product : THIS STEP AIM TO CREATE PRODUCT FROM ARRRAYLIST */
void inputData(int num){
    for (int i = 1; i <= num; i++){
        System.out.print("[Product " + i + "]");
        Products PD =new Products();
        PD.addInfor();
        jungkook.add(PD);
    }
}

/* DISPLAY TO SCREEN  */
void displayAll(){
    System.out.format("%20s | %20s | %10s | %10s | %n", "PRODUCTS ID", "NAMES", "PRICES(&)", "QUANTITY");
    for (int i = 0; i < jungkook.size(); i++){
        jungkook.get(i).display();
    }
}
    
/* Find SOMEWHERE THAT MAKES THE USER TO INPUT THE ID TO TAKE REQUIRE */
int findLocate(int locate){
    int i;
    boolean found = false;
     for (i = 0; i < jungkook.size(); i++){
        if(jungkook.get(i).getID() == locate){
            found = true;
            break;
        }
    }
    if(!found){
        return -1;
    }
    return i;
}

/* Search Method: YOU WANT TO MAKE METHOD */
void search(){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter product's name; ");
    String RM = input.nextLine();
    boolean found = false;
    System.out.format("%20s | %20s | %10s | %10s | %n", "PRODUCTS ID", "NAMES", "PRICES(&)", "QUANTITY");
    for (int i = 0; i < jungkook.size(); i++){
        if(jungkook.get(i).getNames().contains(RM)){
            jungkook.get(i).display();
            found = true;
        }
    }
    if(!found){
      System.out.println(">>>Product not found !!!<<<");  
    }
}

/* Sort by prices */
void sort(){
    Collections.sort(jungkook, (Products o1, Products o2) -> {
        if(o1.getPrices() < o2.getPrices()){
            return -1;
        } else if (o1.getPrices() == o2.getPrices()) {
            return 0;
        } else {
            return 1;
        }
    } 
    );
    System.out.format("%20s | %20s | %10s | %10s | %n", "PRODUCTS ID", "NAMES", "PRICES(&)", "QUANTITY");
    for(int i = 0; i < jungkook.size(); i++){
        jungkook.get(i).display();
    }
}

/* Save data to file */
void save(){
    System.out.print("Enter file's name: ");
    String s = BTS.nextLine();
    try {
        File f = new File(s + ".txt");
        FileOutputStream fos = new FileOutputStream(f);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos) ){
         oos.writeObject(jungkook);
         oos.close();
        }
        System.out.println(">>>File Saved<<<");
    } catch (IOException e) {
        System.out.println(">>>ERROR: " + e + "<<<");      
    }
}

/* Load data from file */
void load() throws ClassNotFoundException {
    System.out.print("Enter file's name");
    String s = BTS.nextLine();
    try {
        File file = new File(s + ".txt");
        FileInputStream fis = new FileInputStream(file);
        try (ObjectInputStream ois = new ObjectInputStream(fis)){
            jungkook = (ArrayList<Products>) ois.readObject();
            System.out.println(">>>FILE LOADED<<<");
            displayAll();
            ois.close();
        }
    } catch (IOException e){
        System.out.println(">>>ERROR: " + e + "<<<");       
    }
}

/* Show list menu */
static void  showMenu(){
    System.out.println("----------------MENU---------------");
    System.out.println("[1] Add products");
    System.out.println("[2] Display products");
    System.out.println("[3] Delete a product");
    System.out.println("[4] Edit a product");
    System.out.println("[5] Search for products by name");
    System.out.println("[6] Sort products by prices ");
    System.out.println("[7] Save products to text/binary file\n");        
    System.out.println("[8] Load products from the saved file");
    System.out.println("[0] Quit: Choose again an option");
}


    public static void main(String[] args) throws Exception {
        TranTienTung_1901040195_A01_Ass2 adjust = new TranTienTung_1901040195_A01_Ass2();
        
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        while (check == false){
            showMenu();
            int choose = sc.nextInt();
            switch(choose){
                case 1:
                    System.out.print("Enter numbers of products: ");
                    int n = sc.nextInt();
                    adjust.inputData(n);
                    System.out.println(">>>>SUCCESSFUL!!!<<<");
                    break;
                case 2:
                    adjust.displayAll();
                    break;
                case 3:
                    System.out.print("Enter product ID: ");
                    int del = sc.nextInt();
                    int a = adjust.findLocate(del);
                    if (a == -1) {
                        System.out.println(">>> PRODUCT NOT FOUND !!! <<<");
                    } else {
                        adjust.jungkook.remove(adjust.jungkook.get(a)); 
                        System.out.println(">>>Deleted!!!<<<");
                        adjust.displayAll();
                    }
                    break;
                case 4:
                    System.out.println("Enter product ID: ");
                    int edit = sc.nextInt();
                    int b = adjust.findLocate(edit);
                    if(b == -1){
                        System.out.println(">>>Product not found !!!<<<");
                    } else {
                        System.out.println(">>>Editing product : " + adjust.jungkook.get(b).getNames() + "<<<");
                        System.out.print("New Name: ");
                        sc.nextLine();
                        String reName = sc.nextLine();
                        adjust.jungkook.get(b).setNames(reName);
                        System.out.print("New price($): ");
                        float rePrice = sc.nextFloat();
                        adjust.jungkook.get(b).setPrices(rePrice);
                        System.out.println("New Quantity; ");
                        int reQuantity = sc.nextInt();
                        adjust.jungkook.get(b).setQuantity(reQuantity);
                        System.out.println(">>>Product Data was updated!!!<<<");
                        adjust.displayAll(); 
                    }
                    break;
                case 5:
                    adjust.search();
                    break;
                case 6:
                    adjust.sort();
                    break;
                case 7: 
                    adjust.save();
                    break;
                case 8:
                    adjust.load();
                    break;
                case 0:
                    System.out.println(">>>GOODBYE !!!<<<");
                    check = true;
                    break;
                    
                    
                default:
                    System.out.println(">>>Invalid choice!!!");
            }
        }
    }
    
}

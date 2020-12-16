/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenhoanganh1td19;

/*Name: Nguyen Hoang Anh
 *ID: 1901060002
 *Class: 1TD19
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NguyenHoangAnh1TD19 {
    private int ID;
    private String Name;
    private float Price;
    private int Quantity;
    
    public NguyenHoangAnh1TD19(BufferedReader in) throws IOException {
        System.out.println("Enter Product ID: ");
        this.ID = Integer.parseInt(in.readLine());
        System.out.println("Enter Product Name: ");
        this.Name = in.readLine();
        System.out.println("Enter Product Price: ");
        this.Price = Float.parseFloat(in.readLine());
        System.out.println("Enter Product Quantity: ");
        this.Quantity = Integer.parseInt(in.readLine());
    }

    public NguyenHoangAnh1TD19(String v) {
        String[] string = v.split(", ");
        this.ID = Integer.parseInt(string[0]);
        this.Name = string[1];
        this.Price = Float.parseFloat(string[2]);
        this.Quantity = Integer.parseInt(string[3]);
    }
    
    public int InputID() {
        return ID;
    }
    
    public String InputName() {
        return Name;
    }
    
    public float InputPrice() {
        return Price;
    }
    
    public int InputQuantity() {
        return Quantity;
    }
    
    public void View() {
        System.out.println(ID + "\t" + Name + "\t\t" + Price + "\t\t" + Quantity);
    }
    
    private static int readProductFile(NguyenHoangAnh1TD19[] productsArray, int list) {
        try {
            File file = new File("productsmenu.txt");
            if (file.exists()) {
                Scanner scan = new Scanner(file);
                int z = 0;
                while (scan.hasNextLine())
                    productsArray[z++] = new NguyenHoangAnh1TD19(scan.nextLine());
                list = z;
                System.out.println("Read Succesfully!");
                System.out.println();
                scan.close();
            } else
                System.out.println("File not found");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void SaveData(NguyenHoangAnh1TD19[] productsArray, int list) {
        try {
            BufferedWriter WriteFile = new BufferedWriter(new FileWriter("productsmenu.txt"));
            for (int z = 0; z < list; ++z)
                WriteFile.write(productsArray[z].InputID() + ", " + productsArray[z].InputName() + ", " + productsArray[z].InputPrice() + ", " + productsArray[z].InputQuantity() + "\n");
            WriteFile.close();
            System.out.println("Write Successfully!");
            System.out.println();
            WriteFile.close();
        } catch (IOException e) {
            System.out.println("INVALID!!!");
            e.printStackTrace();
        }
    }
    
    public static int AddProducts(NguyenHoangAnh1TD19[] AddProducts, BufferedReader input, int list) throws IOException {
        int prd;
        System.out.print("Total: ");
        prd = Integer.parseInt(input.readLine());
        for (int z = list; z < list + prd; ++z)
            AddProducts[z] = new NguyenHoangAnh1TD19(input);
        list += prd;
        return list;
    }
    
    private static void Check(NguyenHoangAnh1TD19[] SearchProducts, BufferedReader input, int list) throws IOException {
        System.out.print("Product Name: ");
        boolean check = false;
        String Name = input.readLine();
        for (int z = 0; z < list; ++z)
            if (SearchProducts[z].InputName().equals(Name)) {
                check = true;
                SearchProducts[z].View();
                break;
            }
        if (!check)
            System.out.println("Product Not Found!");
        System.out.println();
    }
    
    private static int Remove(NguyenHoangAnh1TD19 [] RemoveProducts, BufferedReader input, int list) throws IOException {
        System.out.print("Product ID: ");
        int ID;
        boolean result1 = false;
        ID = Integer.parseInt(input.readLine());
        for (int z = 0; z < list; ++z) {
            if (RemoveProducts[z].InputID() == ID) {
            --list;
            result1 = true;
            if (list - z >= 0)
                System.arraycopy(RemoveProducts, z + 1, RemoveProducts, z, list - 1);
            System.out.println("Removed Successfully");
            break;
        }
            }
            if (!result1)
            System.out.println("Not found!");
            System.out.println();
            return list;
    }
    
    private static void ShowAll(NguyenHoangAnh1TD19 [] allproducts, int list) {
        for (int z = 0; z < list; ++z)
            allproducts[z].View();
        System.out.println();
    }
    
    private static void EditList(NguyenHoangAnh1TD19 [] EditProducts, BufferedReader input, int list) throws IOException {
        System.out.println("Product ID: ");
        int ID = Integer.parseInt(input.readLine());
        for (int z = 0; z < list; ++z) {
            if (EditProducts[z].InputID() == ID) {
                EditProducts[z] = new NguyenHoangAnh1TD19(input);
                System.out.println("Changed Successfully");
                break;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        NguyenHoangAnh1TD19 [] productsArray = new NguyenHoangAnh1TD19 [30]; //limit of list
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        int menu = 0;
        do {
            System.out.println("***PRODUCT MENU***\n- Feature 1: Add Products\n- Feature 2: Display products\n- Feature 3: Delete a product\n"
                        + "- Feature 4: Edit a product\n- Feature 5: Search for products by name\n"
                        + "- Feature 6: Save products to text file\n"
                        + "- Feature 7: Load products from the saved file\n"
                        + "0. Exit\n"
                        + "My option is: ");
            try {
                menu = Integer.parseInt(input.readLine());
                System.out.println();
                switch (menu) {
                    case 0:
                        System.out.println("Exit");
                        System.exit(0);
                        break;
                    case 1:
                        total = AddProducts(productsArray, input, total);
                        break;
                    case 2:
                        ShowAll(productsArray, total);
                        break;
                    case 3:
                        total = Remove(productsArray, input, total);
                        break;
                    case 4:
                        EditList(productsArray, input, total);
                        break;
                    case 5:
                        Check(productsArray, input, total);
                        break;
                    case 6:
                        SaveData(productsArray, total);
                        break;
                    case 7:
                        total = readProductFile(productsArray, total);
                        break;
                    default: System.out.println("Invalid Value!");
                }
            } catch (InputMismatchException | NumberFormatException | IOException exc) {
                System.out.println("Invalid Input!");
                exc.printStackTrace();
            }
        } while (menu != 0);
        input.close();
    }
    
}    

    

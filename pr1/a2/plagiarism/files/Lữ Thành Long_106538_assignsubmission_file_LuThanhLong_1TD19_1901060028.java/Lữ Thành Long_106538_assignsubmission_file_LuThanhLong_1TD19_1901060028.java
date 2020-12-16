package luthanhlong_1td19_1901060028;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LuThanhLong_1TD19_1901060028 {

    final private int id;
    final private String name;
    final private double price;
    final private int quantity;

    LuThanhLong_1TD19_1901060028(BufferedReader in) throws IOException {
        System.out.println("Product ID: ");
        this.id = Integer.parseInt(in.readLine());//input product id
        System.out.println("Product name: ");
        this.name = in.readLine();//input product name
        System.out.println("Price: ");
        this.price = Double.parseDouble(in.readLine());//input product price
        System.out.println("Quantity: ");
        this.quantity = Integer.parseInt(in.readLine());//input product quantity
    }

    LuThanhLong_1TD19_1901060028(String s) {
        String[] str = s.split(", ");
        this.id = Integer.parseInt(str[0]);
        this.name = str[1];
        this.price = Double.parseDouble(str[2]);
        this.quantity = Integer.parseInt(str[3]);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void view() {
        System.out.println(id + "\t" + name + "\t\t" + price + "\t\t" + quantity);
    }

    private static int readFile(LuThanhLong_1TD19_1901060028[] productsArr, int total) {
        try {
            File file = new File("products.txt");
            if (file.exists()) {
                Scanner fileScan = new Scanner(file);
                int i = 0;
                while (fileScan.hasNextLine()) {
                    productsArr[i++] = new LuThanhLong_1TD19_1901060028(fileScan.nextLine());
                }
                total = i;
                System.out.println("Read successfull");
                System.out.println();
                fileScan.close();
            } else {
                System.out.println("File does not exist!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return total;
    }

    private static void writeFile(LuThanhLong_1TD19_1901060028[] productsArr, int total) throws IOException {
        try {
            BufferedWriter writeFile = new BufferedWriter(new FileWriter("products.txt"));
            for (int i = 0; i < total; ++i) {
                writeFile.write(productsArr[i].getId() + ", " + productsArr[i].getName() + ", " + productsArr[i].getPrice() + ", " + productsArr[i].getQuantity() + "\n");
            }
            writeFile.close();
            System.out.println("Write successful");
            System.out.println();
            writeFile.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    private static int input(LuThanhLong_1TD19_1901060028[] products, BufferedReader input, int total) {
        try {
            int newAdd;
            System.out.println("Total: ");
            newAdd = Integer.parseInt(input.readLine());
            for (int i = total; i < total + newAdd; ++i) {
                products[i] = new LuThanhLong_1TD19_1901060028(input);
            }
            total += newAdd;
        } catch (InputMismatchException | NumberFormatException | IOException ex) {
            System.out.println("Invalid input");
            ex.printStackTrace();
        }
        return total;
    }

    private static void search(LuThanhLong_1TD19_1901060028[] products, BufferedReader input, int totalProdcuts) throws IOException {
        System.out.println("Name: ");
        boolean check = false;
        String name = input.readLine();
        int totalProducts = 0;

        for (int i = 0; i < totalProducts; ++i) {
            if (products[i].getName().equals(name)) {
                check = true;
                products[i].view();
                break;
            }
        }
        if (!check) {
            System.out.println("Not found");
        }
        System.out.println();
    }

    private static int delete(LuThanhLong_1TD19_1901060028[] products, BufferedReader input, int total) throws IOException {
        System.out.println("Product ID: ");
        int id;
        boolean found = false;
        id = Integer.parseInt(input.readLine());
        for (int i = 0; i < total; ++i) {
            if (products[i].getId() == id) {
                --total;
                found = true;
                if (total - i >= 0) {
                    System.arraycopy(products, i + 1, products, i, total - i);
                }
                System.out.println("Has been deleted");
                break;
            }
        }
        if (!found) {
            System.out.println("Has not been found");
        }
        System.out.println();
        return total;
    }

    private static void showAll(LuThanhLong_1TD19_1901060028[] products, int total) {
        for (int i = 0; i < total; ++i) {
            products[i].view();
        }
        System.out.println();
    }

    private static void edit(LuThanhLong_1TD19_1901060028[] products, BufferedReader input, int total) throws IOException {
        System.out.println("Product ID: ");
        int id = Integer.parseInt(input.readLine());
        for (int i = 0; i < total; ++i) {
            if (products[i].getId() == id) {
                products[i] = new LuThanhLong_1TD19_1901060028(input);
                System.out.println("Has been edited");
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        LuThanhLong_1TD19_1901060028[] productsArr = new LuThanhLong_1TD19_1901060028[30];
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        int menu = 0;
        do {
            System.out.println("Menu\n1: Add products\n"
                    + "2: Display products\n3: Delete a product\n"
                    + "4: Edit a product\n5: Search for products by name\n"
                    + "6: Save products to text file\n"
                    + "7: Load prodcuts from the saved file\n"
                    + "Type 0 to exit\nYour option: ");
            try {
                menu = Integer.parseInt(input.readLine());
                System.out.println();
                switch (menu) {
                    case 1:
                        total = input(productsArr, input, total);
                        break;
                    case 2:
                        showAll(productsArr, total);
                        break;
                    case 3:
                        total = delete(productsArr, input, total);
                        break;
                    case 4:
                        edit(productsArr, input, total);
                        break;
                    case 5:
                        search(productsArr, input, total);
                        break;
                    case 6:
                        writeFile(productsArr, total);
                        break;
                    case 7:
                        total = readFile(productsArr, total);
                        break;
                    default:
                        System.out.println("Invalid inpuit");
                }
            } catch (InputMismatchException | NumberFormatException | IOException ex) {
                System.out.println("Invalid input.\n");
                ex.printStackTrace();
            }
        } while (menu != 0);
        input.close();
    }
}

package assignment_2;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Khanh Linh 3c19 1901040123
 */
public class Assignment_2 implements Serializable {
    private int id = 0;
    private String name;
    private double price;
    private int quantity;

    public  Assignment_2() {
    }

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setQuantity(int quantily) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Products{" + "id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product ID: ");
        this.id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter product name: ");
        this.name = sc.nextLine();
        System.out.print("Enter product price: ");
        this.price = sc.nextDouble();
        System.out.print("Enter product quantity: ");
        this.quantity = sc.nextInt();
    }
}
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author Taudio
 */
public class DataController {
    Scanner sc = new Scanner(System.in);
    List<Product> listPro = new ArrayList<>();
    FileController fileController = new FileController();
    
    public List<Product> Input(int n){
        for(int i = 0; i < n; i++){
            Product temp = new Product();
            temp.Input();
            listPro.add(temp);
        }
        return listPro;
    }
    
    public void Display(List<Product> list){
        list.forEach((i) -> {
            System.out.println(i);
        });
    }
    
    public void DeleteAProduct(List<Products> list){
        System.out.print("Enter the ID of product to delete: ");
        int id = sc.nextInt();
        boolean check = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                list.remove(i);
                check = true;
                break;
            }
        }
        if(!check){
            System.out.println("This product is not contain");
        }
    }
    
    public void Edit(List<Product> list){
        System.out.print("Enter the ID of product to edit: ");
        int id = sc.nextInt();
        boolean check = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                System.out.println("1. Edit new name");
                System.out.println("2. Edit new price");
                System.out.println("3. Edit new quantity");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1:
                        System.out.print("Enter new name: ");
                        list.get(i).setName(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Enter new price: ");
                        list.get(i).setPrice(sc.nextDouble());
                        break;
                    case 3:
                        System.out.print("Enter new quantily: ");
                        list.get(i).setQuantity(sc.nextInt());
                        break;
                    default:
                        System.out.println("your choice is not available");
                }
                check = true;
                break;
            }
        }
        if(!check){
            System.out.println("This product is not contain");
        }
    }
    
    public void SearchProductByName(List<Products> list){
        System.out.print("Enter name to find: ");
        String name = sc.nextLine();
        boolean check = false;
        
        for(Products i : list){
            if(i.getName().compareTo(name) == 0){
                check = true;
                break;
            }
        }
        
        if(check){
            list.forEach((i) -> {
                if(i.getName().compareTo(name) == 0)
                    System.out.println(i);
            });
        }else {
            System.out.println("Non-exsist product");
        }
    }
    
    public void SortProductsByPrice(List<Products> list){
        list.sort((o1, o2) -> {
            if(o1.getPrice() < o2.getPrice())
                return -1;
            else if(o1.getPrice() > o2.getPrice())
                return 1;
            else 
                return 0;
        });
    }
    
    public void WriteProductsToFile(List<Products> list, String fileName){
        fileController.WriteProductsToFile(list, fileName);
    }
    
    public void ReadProductsFromFile(String fileName){
        List<Products> list = fileController.ReadProductsFromFile(fileName);
        list.forEach((i) -> {
            System.out.println(i);
        });
    }

    List<Products> Input(int n) {
        throw new UnsupportedOperationException("Not yet supported."); 
    }

    void DeleteAProduct(List<Product> listPro) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void SearchProductByName(List<Product> listPro) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void SortProductsByPrice(List<Product> listPro) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void WriteProductsToFile(List<Product> listPro, String producTtxt) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class FileController {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    PrintWriter printWriter;
    Scanner scanner;
    
    public void OpenFileToWrite(String fileName){
        try {
            fileWriter = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException ex) {
        }
    }
    
    public void CloseFileAfterWrite(){
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        }catch(IOException ex){
        }
    }
    
    public void OpenFileToRead(String fileName){
        try {
            scanner = new Scanner(Paths.get(fileName));
        } catch (IOException ex) {
        }
    }
    
    public void CloseFileAfterRead(){
        scanner.close();
    }
    
    public void WriteProductsToFile(List<Products> list, String fileName){
        OpenFileToWrite(fileName);
        list.forEach((i) -> {
            printWriter.println(i.getId() + "|" + i.getName() + "|" + i.getPrice() + "|" + i.getQuantity());
        });
        CloseFileAfterWrite();
    }
    
    public Products CreateProductFromData(String data){
        String[] a = data.split("\\|");
        Products tmp = new Products(Integer.parseInt(a[0]), a[1], Double.parseDouble(a[2]), Integer.parseInt(a[3]));
        return tmp;
    }
    
    public List<Products> ReadProductsFromFile(String fileName){
        List<Products> list = new ArrayList<>();
        OpenFileToRead(fileName);
        while(scanner.hasNext()){
            list.add(CreateProductFromData(scanner.nextLine()));
        }
        return list;
    }
}
import java.util.*;

public class Run {
    
    static List<Product> listPro = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static DataController dataController = new DataController();
    
    public static void main(String[] args) {
        do {
            System.out.println("---------------------MENU-------------------");
            System.out.println("1. Add products");
            System.out.println("2. Display products");
            System.out.println("3. Delete a product");
            System.out.println("4. Edit a product");
            System.out.println("5. Search for products by name");
            System.out.println("6. Sort product by price");
            System.out.println("7. Save products to text/binary file");
            System.out.println("8. Load products from the saved file");
            System.out.println("0. Exit");
            System.out.println("=============================================");
            int choice = 0;
            System.out.print("Enter your choice(1 to 8): ");
            try {
                choice = sc.nextInt();
            }catch(Exception e){
                System.out.println("Choice is not a number");
            }

            switch(choice){
                case 1:
                    System.out.print("Enter the number n = ");
                    int n = sc.nextInt();
                    listPro = dataController.Input(n);
                    break;
                case 2:
                    dataController.Display(listPro);
                    break;
                case 3:
                    dataController.DeleteAProduct(listPro);
                    break;
                case 4:
                    dataController.Edit(listPro);
                    break;
                case 5:
                    dataController.SearchProductByName(listPro);
                    break;
                case 6:
                    dataController.SortProductsByPrice(listPro);
                    break;
                case 7:
                    dataController.WriteProductsToFile(listPro, "PRODUCT.txt");
                    break;
                case 8:
                    dataController.ReadProductsFromFile("PRODUCT.txt");
                    break;
                case 0:    
                    System.exit(0);
            }
        }while(true);
    }
}
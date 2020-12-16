/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


 public class Assignment2 
{
    public static void main(String[] args) throws IOException
   {
     Basic productslist = new Basic();
     int features;
     Scanner sc = new Scanner (System.in);
     do 
     {
        displayMenu();
         System.out.print("Enter feature: ");
        features = Integer.parseInt(sc.nextLine());
        switch (features) 
                {
                    case 1:   
                        int n;
                        System.out.print("Enter number of products you want: ");
                        n = Integer.parseInt(sc.nextLine());
                        
                       
                        for (int i=1;i<=n;i++)
                        {
                            System.out.println("Product "+i);
                            System.out.print("Enter name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter price: ");
                            double price = Double.parseDouble(sc.nextLine());
                            System.out.print("Enter quantity: ");
                            int quantity = Integer.parseInt(sc.nextLine());
                            Products prod = new Products(name, price, quantity); 
                            productslist.add(prod);
                        }
                        break;
                    case 2:
                        for (int i=0;i<productslist.size();i++)
                        {                          
                            System.out.println(productslist.get(i).toString());
                        }
                        break;                        
                    case 3:
                   
                        System.out.print("Enter id you want to delete: ");
                        int m = Integer.parseInt(sc.nextLine());
                        for (int i=0;i<productslist.size();i++)
                        {
                            if(productslist.get(i).getProductsID()== m) 
                                productslist.delete(productslist.get(i));
                        }
                        System.out.println("Delete successfully!");
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
                        for (int i=0;i<productslist.size();i++)
                        {
                            if(productslist.get(i).getProductsID()== a)
                            {
                               productslist.get(i).setProductsName(new_name);
                               productslist.get(i).setProductsPrice(new_price);
                               productslist.get(i).setProductsQuantity(new_quantity);
                            }
                        }
                        System.out.println("Edit successfully!");
                        break;
                    case 5:
                        System.out.print("Enter a keyword which name contains: ");
                        String keyword = sc.nextLine();
                        String[] name;
                        for (int i=0;i<productslist.size();i++)
                        {
                            name = productslist.get(i).getProductsName().split(" ");
                            for(int j=0;j<name.length;j++)
                            {
                                if(keyword.equalsIgnoreCase(name[j]))
                                {
                                    System.out.println(productslist.get(i).toString());
                                }
                            }
                        }                
                        break;
                    case 6:
                        Products tmp;
                        
                        for (int i=0;i<productslist.size()-1;i++)
                        {
                            if(productslist.get(i).getProductsPrice()>productslist.get(i+1).getProductsPrice())
                            {
                                tmp = productslist.get(i);
                                productslist.set(i,productslist.get(i+1));
                                productslist.set(i+1,tmp);    
                            }
                        }
                        break;
                    case 7:
                         
                         FileOutputStream out = null;
                         ObjectOutputStream oos = null;
                         try{
                             File f = new File("Menu.obj");
                             out = new FileOutputStream(f);
                             oos = new ObjectOutputStream(out);
                             oos.writeObject(productslist);
                         }
                         catch(Exception e){
                             System.out.println("File not found");
                         }
                         finally{
                             if (out!=null)
                             {
                                 out.close();
                             }
                             if (oos!=null)
                             {
                                 oos.close();
                             }
                         }
                        break;
                    case 8:
                        FileInputStream in = null;
                        ObjectInputStream ois = null;
                        try {
                            File f = new File("Menu.obj");
                           in = new FileInputStream(f);
                           ois = new ObjectInputStream(in);
                           productslist = (Basic) ois.readObject();
                        }
                        catch (Exception e) {
                            System.out.println("File not found");
                        }
                        finally {
                            if (in != null)
                            {
                                in.close();
                            }
                            if (ois != null)
                            {
                                ois.close();
                            }
                        }
                        System.out.println("display: ");
                        for (int i=0;i<productslist.size();i++)
                        {                          
                            System.out.println(productslist.get(i).toString());
                        }
                        break;
                    
                    case 9:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.err.println("Wrong!");
                        break;                   
                }
     }
     while (features !=9);
   }
      static void displayMenu() 
   {
        System.out.println("Here are 9 features of the program: ");
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
class Products implements Serializable {
    private  int id;
    private static int temp = 0;
    private String name;
    private double price;
    private int quantity;

    public Products( String name, double price, int quantity) {
        this.temp = this.temp +1;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = this.temp;
        
    }  

    public int getProductsID() {
        return id;
    }
    public String getProductsName() {
        return name;
    }

    public void setProductsName(String name) {
        this.name = name;
    }

    public double getProductsPrice() {
        return price;
    }

    public void setProductsPrice(double price) {
        this.price = price;
    }

    public int getProductsQuantity() {
        return quantity;
    }

    public void setProductsQuantity(int quantity) {
        this.quantity = quantity;
    }  
    public String toString(){
        return this.id+" "+ this.name+" "+ this.price+" "+this.quantity;
    }
}
class Basic implements Serializable{
    
     private ArrayList<Products> product;
     
     public Basic(){
         product = new ArrayList<>();
     }
     
     public void add(Products pro){
         product.add(pro);
     }
     public void delete(Products pro){
         product.remove(pro);
     }
     public ArrayList get(){
        return product;
     }
     public int size(){
         return product.size();
     }
     public Products get(int i){
         return product.get(i);
     }
     public void set(int index, Products e){
         product.set(index,e);
}
}

 


  
    
    


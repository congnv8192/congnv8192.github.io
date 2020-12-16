package assignment_2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class ass2 {
	
    
    static class Product{
        int ID;
        String name;
        float price;
        int quantity;
        
        public Product(int ID,String name,float price,int quantity){
            this.ID = ID;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
        
        public Product(){
        
        }
        
        void show(){
            System.out.printf("| %d | %7.2S | %8f | %6d | %n", ID,name,price,quantity);
        }
        
        void saveFile(Writer wr) {
        	try {
				wr.write("| "+ID+"|       "+name+" |     "+price +" |     "+quantity+" | "+"\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    static void deleteProduct(Scanner sc){
        System.out.println( "enter ID");
        int ID = sc.nextInt();
        int save = -1;
        for ( int i = 0 ; i < length ; i++ ){
           
            if(productList[i].ID == ID ){
                 save = i;
            } 
            
        }
        
        if(save == -1){
            System.out.println("not found");
            return;
        }
        
        for ( int i = save ; i<length -1 ; i ++ ){
            productList[i]  = productList[i +1]; 
        }
        length = length - 1;
        
    }
    static Product edit(int ID,Scanner sc){
        System.out.println("input the Name");
        String name = sc.next();
        System.out.println("input the Price");
        float price = sc.nextFloat();
        System.out.println("input the Quantity");
        int quantity = sc.nextInt();
        
        Product pro = new Product(ID,name,price,quantity);
        return pro;
    }
    
    static Product add(Scanner sc){
        System.out.println("input the ID");
        int ID = sc.nextInt();
        System.out.println("input the Name");
        String name = sc.next();
        System.out.println("input the Price");
        float price = sc.nextFloat();
        System.out.println("input the Quantity");
        int quantity = sc.nextInt();
        
        Product pro = new Product(ID,name,price,quantity);
        return pro;
    }
    static void editProduct(Scanner sc){
    	System.out.println( "input the ID");
        int ID = sc.nextInt();
        int save = -1;
        for ( int i = 0 ; i < length ; i++ ){
           
            if(productList[i].ID == ID ){
                 save = i;
            } 
            
        }
        
        if(save == -1){
            System.out.println("not found");
            return;
        }
        
        Product pro = edit(save,sc);
        productList[save] = pro;
    }
    static void searchProdcut(Scanner sc) {
    	System.out.println( "input the Name");
        String name = sc.next();
        int save = -1;
        for ( int i = 0 ; i < length ; i++ ){
           
            if(productList[i].name.equals(name)){
            	productList[i].show();
            } 
            
        }
    }
    
    
    static void saveProduct() {
    	Writer wr;
		try {
			wr = new FileWriter("A2.txt");
	    	for ( int i = 0 ; i < length ; i++ ){
	    		productList[i].saveFile(wr);
	        }
	    	wr.flush();
	    	wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("done");
    }
    
    static void loadProduct() {
    	FileReader fr;
		try {
			File file = new File("A2.txt");
            Scanner input = new Scanner(file);
            
            while (input.hasNextLine()) {
                String s = input.nextLine();
                String[] data = s.prolit("-");
                int ID = Integer.parseInt(data[0]);
                String name = data[1];
                float price = Float.parseFloat(data[2]);
                int quantity = Integer.parseInt(data[3]);
                Product pro = new Product(ID,name,price,quantity);
                productList[length] = pro;
                length = length + 1;
            }
            input.close();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("done");
    }
    
    
    
    static void sortProduct() {
    	for ( int i = 0 ; i < length ; i++ ){
    		for ( int j = i ; j < length ; j++ ){
	            if(productList[i].price > productList[j].price){
	            	Product tmp;
	            	tmp = productList[i];
	            	productList[i] = productList[j];
	            	productList[j] = tmp;
	            } 
    		}
        }
    	System.out.println("done");
    }
    
    static Product productList[] = new Product[100];
    static int length = 0;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while(true){      
            System.out.println("--------------Menu-----------");
            System.out.println("| 1. Add Product             |");
            System.out.println("| 2. Show All                |");
            System.out.println("| 3. Delete Product          |");
            System.out.println("| 4. Edit Product            |");
            System.out.println("| 5. Search Product          |");
            System.out.println("| 6. Sort Product            |");
            System.out.println("| 7. Save Product            |");
            System.out.println("| 8. Load Product            |");
            System.out.println("-----------------------------");
            int k = sc.nextInt();
          
            
            if(k == 1){
                Product pro = add(sc);
                productList[length] = pro;
                length = length + 1;
            }
            if(k==2){
                for(int i=0;i<length;i++){
                    productList[i].show();
                }
            }
            if(k==3){
                deleteProduct(sc);
            }
            if(k==4){
            	editProduct(sc);
            }
            if(k==5){
            	searchProdcut(sc);
            }
            if(k==6){
            	sortProduct();
            }
            if(k==7){
            	saveProduct();
            }
            if(k==8) {
            	loadProduct();
            }
            if(k==0){
                return;
            }
        }
        
    }
}

package Package;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Assignment2 {
    
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
            System.out.println(ID+" - "+name+" - "+price +" - "+quantity);
        }
        
        void saveFile(Writer wr) {
        	try {
				wr.write(ID+"-"+name+"-"+price +"-"+quantity+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    static void deleteProductById(Scanner sc){
        System.out.println( "Nhap ID");
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
    
    static Product nhapSP(Scanner sc){
        System.out.println("Nhap ID");
        int ID = sc.nextInt();
        System.out.println("Nhap Name");
        String name = sc.next();
        System.out.println("Nhap Price");
        float price = sc.nextFloat();
        System.out.println("Nhap Quantity");
        int quantity = sc.nextInt();
        
        Product sp = new Product(ID,name,price,quantity);
        return sp;
    }
    
    static Product editSP(int ID,Scanner sc){
        System.out.println("Nhap Name");
        String name = sc.next();
        System.out.println("Nhap Price");
        float price = sc.nextFloat();
        System.out.println("Nhap Quantity");
        int quantity = sc.nextInt();
        
        Product sp = new Product(ID,name,price,quantity);
        return sp;
    }
    
    static void saveProductToFile() {
    	Writer wr;
		try {
			wr = new FileWriter("Product.txt");
	    	for ( int i = 0 ; i < length ; i++ ){
	    		productList[i].saveFile(wr);
	        }
	    	wr.flush();
	    	wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    static void loadProductFromFile() {
    	FileReader fr;
		try {
			File file = new File("Product.txt");
            Scanner input = new Scanner(file);
            
            while (input.hasNextLine()) {
                String s = input.nextLine();
                String[] data = s.split("-");
                int ID = Integer.parseInt(data[0]);
                String name = data[1];
                float price = Float.parseFloat(data[2]);
                int quantity = Integer.parseInt(data[3]);
                Product sp = new Product(ID,name,price,quantity);
                productList[length] = sp;
                length = length + 1;
            }
            input.close();
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    static void editProduct(Scanner sc){
    	System.out.println( "Nhap ID");
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
        
        Product sp = editSP(save,sc);
        productList[save] = sp;
    }
    
    static void searchProdcutByName(Scanner sc) {
    	System.out.println( "Nhap Name");
        String name = sc.next();
        int save = -1;
        for ( int i = 0 ; i < length ; i++ ){
           
            if(productList[i].name.equals(name)){
            	productList[i].show();
            } 
            
        }
    }
    
    static void sortProductByPrice() {
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
    }
    
    static Product productList[] = new Product[100];
    static int length = 0;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while(true){      
            System.out.println("Menu");
            System.out.println("1. Add Product");
            System.out.println("2. Show All Product");
            System.out.println("3. Delete Product By ID");
            System.out.println("4. Edit Product By ID");
            System.out.println("5. Search Product By Name");
            System.out.println("6. Sort Product By Price");
            System.out.println("7. Save Product To File");
            System.out.println("8. Load Product From File");
            int k = sc.nextInt();
          
            
            //Product sp1 = new Product(1,"SP1",2.0f,5); 
            
//            switch(k){
//                case 0 : return; 
//                
//                case 1 : 
//                    productList[length] = sp1;
//                    length = length + 1;
//                    break;
//                    
//                case 2 :
//                    for(int i=0;i<length;i++){
//                        productList[i].show();
//                    }
//                    break;
//                
//            }
            if(k == 1){
                Product sp = nhapSP(sc);
                productList[length] = sp;
                length = length + 1;
            }
            if(k==2){
                for(int i=0;i<length;i++){
                    productList[i].show();
                }
            }
            if(k==3){
                deleteProductById(sc);
            }
            if(k==4){
            	editProduct(sc);
            }
            if(k==5){
            	searchProdcutByName(sc);
            }
            if(k==6){
            	sortProductByPrice();
            }
            if(k==7){
            	saveProductToFile();
            }
            if(k==8) {
            	loadProductFromFile();
            }
            if(k==0){
                return;
            }
        }
        
        
        //productList[6]
    }
}

﻿import java.util.*;
import java.util.*;
import java.io.*;
/** Full name: Dương Thế Công
 *  Class : 1C19
 *  Student ID: 1901040031
 */
public class DuongTheCong_1C19_1901040031 {
	public static void main(String[] args) {
		ProductManagement in4 = new ProductManagement();
		Scanner inf = new Scanner(System.in);
		do {
			System.out.println("1. Add products");
			System.out.println("2. Display products");
			System.out.println("3. Delete a product");
			System.out.println("4. Edit a product");
			System.out.println("5. Search for products by name");
			System.out.println("6. Sort products by price");
			System.out.println("7. Save products to text/binary file");
			System.out.println("8. Load products from the saved file");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");
			System.out.println("=========================");
			int choice = inf.nextInt();
			String a;
			switch (choice) {
			case 1: do {
				inf.nextLine();
				System.out.print("Enter name: ");
				String name = inf.nextLine();
				System.out.print("Enter price: ");
				double price = inf.nextDouble();
				System.out.print("Enter quantity: ");
				int quantity = inf.nextInt();
				in4.addProduct(new Product(in4.generateProductID(), name, price, quantity));
				System.out.println("Continue??? (y/n)?");
				a = inf.next();
			} while (a.equals("y"));
				break;
			case 2:
				in4.print();
				break;
			case 3:
				in4.print();
				System.out.println("Enter ID: ");
				a = inf.next();
				in4.deleteProduct(a);
				break;
			case 4:
				in4.print();
				System.out.println("Enter ID: ");
				a = inf.next();
				in4.editProduct(a, inf);
				break;
			case 5:
				System.out.print("Enter keywords: ");
				a = inf.nextLine();
				in4.find(s);
				break;
			case 6:
				in4.sortByPrice();
				in4.print();
				break;
			case 7:
				in4.saveToFile();
				break;
			case 8:
				in4.readFromFile();
				break;
			case 9:
				inf.close();
				return;
			}
		} while (true);
	}
}
public class Product implements Comparable<Product> {

	private String iD;
	private String nAme;
	private double pRice;
	private int qUantity;


	public Product() {
	}

	public Product(String iD, String nAme, double pRice, int qUantity) {
		this.nAme = nAme;
		this.iD = iD;
		this.pRice = pRice;
		this.qUantity = qUantity;
	}

	public String getName() {
		return nAme;
	}

	public void setName(String nAme) {
		this.nAme = nAme;
	}

	public String getID() {
		return iD;
	}

	public void setID(String iD) {
		this.iD = iD;
	}

	public double getPrice() {
		return pRice;
	}

	public void setPrice(double pRice) {
		this.pRice = pRice;
	}
	
	public int getQuantity() {
		return qUantity;
	}
	
	public void setQuantity(int qUantity) {
		this.qUantity = qUantity;
	}

	@Override
	public int compTo(Product p) {
		if (this.pRice < p.pRice) {
			return -1;
		} else if (this.pRice > p.pRice) {
			return 1;
		} else {
			return p;
		}
	}    
}


public class ProductManagement {

	List<Product> infoProductList = new ArrayList<>();

	public void addProduct(Product product) {
		if (infoProductList.size() < 30)
			infoProductList.add(product);
		else
			System.out.println("The List reached 30 products, can't add more!!!");
	}

	public boolean checkProductID(String iD) {
		for (int j = 0; j < infoProductList.size(); j++) {
			if (infoProductList.get(j).getID().equals(iD)) {
				return false;
			}
		}
		return true;
	}

	public String generateProductID() {
		String iD;
		String a = "QWERTYUIOPLKJHGFDSAZXCVBNM0987654321";
		do {
			Random r = new Random();
			iD = "____";
			for (int j = 0; j < 3; j++) {
				int l = r.nextInt(a.length());
				iD += a.charAt(l);
			}
			if (checkProductID(iD)) {
				return iD;
			}
		} while (true);
	}
	
	public void print() {
    	System.out.printf("........", "Product ID", "Name", "Price", "Quantity");
    	for (Product tem : infoProductList)
            System.out.printf("..........", tem.getID(), tem.getName(), tem.getPrice(), tem.getQuantity());
    	System.out.println();
    }
	
	public void deleteProduct(String iD) {
		for (int j = 0; j < infoProductList.size(); j++)
			if (infoProductList.get(j).getID().equals(iD)) {
				infoProductList.remove(j);
				return;
			}
		System.out.println("The ID is invalid!");	
	}
	
	public void editProduct(String iD, Scanner inf) {
		for (Product tem : infoProductList)
			if (tem.getID().equals(iD)) {
				System.out.println("Change the name??? (y/n)?");
				String a = inf.next();
				if (a.equals("y")) {
					System.out.println("Enter name: ");
					a = inf.nextLine();
					tem.setName(a);
				} else if (!a.equals("n")) {
					System.out.println("Wrong input!");
					return;
				}
				System.out.println("Change the price??? (y/n)?");
				a = inf.next();
				if (a.equals("y")) {
					System.out.println("Enter price: ");
					double pRice = inf.nextDouble();
					tem.setPrice(pRice);;
				} else if (!a.equals("n")) {
					System.out.println("Wrong input!");
					return;
				}
				System.out.println("Change the quantity??? (y/n)?");
				a = inf.next();
				if (a.equals("y")) {
					System.out.println("Enter quantity: ");
					int qUantity = inf.nextInt();
					tem.setQuantity(qUantity);
				} else if (!a.equals("n")) {
					System.out.println("Wrong input!");
				}
				return;
			}
		System.out.println("The ID is invalid!");
	}
	
	public void find(String a) {
		ProductManagement in4 = new ProductManagement();
		for (Product temp : infoProductList)
			if (tem.getName().indexOf(a) > -1)
				in4.addProduct(tem);
		in4.print();
	}
	
	public void sortByPrice() {
    	Collections.sort(infoProductList, new Comparator<Product>() {
			@Override
			public int compare(Product s1, Product s2) {
				return s1.compareTo(s2);
			}		
		)}};
    }
	
	public void saveToFile() {
		try {
			Formatter out = new Formatter(new File("D:/productText.txt"));
			out.format(".......", infoProductList.size());
			for (Product tem : infoProductList)
				out.format(".........", tem.getID(), tem.getName(), tem.getPrice(), tem.getQuantity());
			out.close();
		} catch (Exception e) {
			System.out.println("Can't save!" + e.getMessage());
		}
	}
	
	public void readFromFile() {
		try {
			Scanner inf = new Scanner(new File("D:/productText.txt"));
			int t = inf.nextInt();
			for (int j = 0; j < t; j++) {
				inf.nextLine();
				String iD = inf.next();
				String nAme = inf.next();
				double pRice = inf.nextDouble();
				int qUantity = inf.nextInt();
				infoProductList.add(new Product(iD, nAme, pRice, qUantity));
			}
		} catch (Exception e) {
			System.out.println("Can't read!" + e.getMessage());
		}
	}
}




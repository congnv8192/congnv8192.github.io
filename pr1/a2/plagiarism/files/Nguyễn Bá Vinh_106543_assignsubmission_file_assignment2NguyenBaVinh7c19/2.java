

import java.util.*;
import java.io.*;

public class ProductManagement {

	List<Product> infoProductList = new ArrayList<>();

	public void addProduct(Product product) {
		if (infoProductList.size() < 40)
			infoProductList.add(product);
		else
			System.out.println("Can't add product, the list is full");
	}

	public boolean checkProductID(String idnumber) {
		for (int i = 0; i < infoProductList.size(); i++) {
			if (infoProductList.get(i).getId().equals(idnumber)) {
				return false;
			}
		}
		return true;
	}

	public String generateProductID() {
		String idnumber;
		String s = "QWERTYUIOPLKJHGFDSAZXCVBNM0987654321";
		do {
			Random r = new Random();
			idnumber = "";
			for (int i = 0; i < 3; i++) {
				int k = r.nextInt(s.length());
				idnumber += s.charAt(k);
			}
			if (checkProductID(idnumber)) {
				return idnumber;
			}
		} while (true);
	}
	
	public void print() {
    	System.out.printf("%-15s%-15s%-15s%-15s\n", "Product ID", "Name", "Price", "Quantity");
    	for (Product temp : infoProductList)
            System.out.printf("%-15s%-15s%-15.2f%-15d\n", temp.getId(), temp.getName(), temp.getPrice(), temp.getQuantity());
    	System.out.println();
    }
	
	public void deleteProduct(String idnumber) {
		for (int i = 0; i < infoProductList.size(); i++)
			if (infoProductList.get(i).getId().equals(idnumber)) {
				infoProductList.remove(i);
				return;
			}
		System.out.println("The id number is invalid!");	
	}
	
	public void editProduct(String idnumber, Scanner in) {
		for (Product temp : infoProductList)
			if (temp.getId().equals(idnumber)) {
				System.out.println("Do u want to change the name? y/n");
				String s = in.next();
				if (s.equals("y")) {
					System.out.println("Enter the name: ");
					s = in.nextLine();
					temp.setName(s);
				} else if (!s.equals("n")) {
					System.out.println("Wrong input!");
					return;
				}
				System.out.println("Do u want to change the price? y/n");
				s = in.next();
				if (s.equals("y")) {
					System.out.println("Enter the price: ");
					double price = in.nextDouble();
					temp.setPrice(price);;
				} else if (!s.equals("n")) {
					System.out.println("Wrong input!");
					return;
				}
				System.out.println("Do u want to change the quantity? y/n");
				s = in.next();
				if (s.equals("y")) {
					System.out.println("Enter the quantity: ");
					int quantity = in.nextInt();
					temp.setQuantity(quantity);
				} else if (!s.equals("n")) {
					System.out.println("Wrong input!");
				}
				return;
			}
		System.out.println("The id is invalid!");
	}
	
	public void find(String s) {
		ProductManagement data = new ProductManagement();
		for (Product temp : infoProductList)
			if (temp.getName().indexOf(s) > -1)
				data.addProduct(temp);
		data.print();
	}
	
	public void sortByPrice() {
        // TODO
    	Collections.sort(infoProductList, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}		
		});
    }
	
	public void saveToFile() {
		try {
			Formatter out = new Formatter(new File("D:/productText.txt"));
			out.format("%d\n", infoProductList.size());
			for (Product temp : infoProductList)
				out.format("%-15s%-15s%-15.2f%-15d\n", temp.getId(), temp.getName(), temp.getPrice(), temp.getQuantity());
			out.close();
		} catch (Exception e) {
			System.out.println("Can't save!\n" + e.getMessage());
		}
	}
	
	public void readFromFile() {
		try {
			Scanner in = new Scanner(new File("D:/productText.txt"));
			int n = in.nextInt();
			for (int i = 0; i < n; i++) {
				in.nextLine();
				String idnumber = in.next();
				String name = in.next();
				double price = in.nextDouble();
				int quantity = in.nextInt();
				infoProductList.add(new Product(idnumber, name, price, quantity));
			}
		} catch (Exception e) {
			System.out.println("Can't read!\n" + e.getMessage());
		}
	}
}
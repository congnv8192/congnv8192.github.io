

import java.util.*;

public class Main {
	public static void main(String[] args) {
		ProductManagement data = new ProductManagement();
		Scanner sc = new Scanner(System.in);
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
			System.out.print("Select your choice: ");
			int choice = sc.nextInt();
			String con;
			switch (choice) {
			case 1: do {
				sc.nextLine();
				System.out.print("Enter name: ");
				String name = sc.nextLine();
				System.out.print("Enter price: ");
				double price = sc.nextDouble();
				System.out.print("Enter quantity: ");
				int quantity = sc.nextInt();
				data.addProduct(new Product(data.generateProductID(), name, price, quantity));
				System.out.println("Do u want to continue? y/n");
				con = sc.next();
			} while (con.equals("y"));
				break;
			case 2:
				data.print();
				break;
			case 3:
				data.print();
				System.out.println("Enter product ID: ");
				con = sc.next();
				data.deleteProduct(con);
				break;
			case 4:
				data.print();
				System.out.println("Enter product ID: ");
				con = sc.next();
				data.editProduct(con, sc);
				break;
			case 5:
				System.out.print("Enter the keyword: ");
				con = sc.nextLine();
				data.find(con);
				break;
			case 6:
				data.sortByPrice();
				data.print();
				break;
			case 7:
				data.saveToFile();
				break;
			case 8:
				data.readFromFile();
				break;
			case 9:
				sc.close();
				return;
			}
		} while (true);
	}
}

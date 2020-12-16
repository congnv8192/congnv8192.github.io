package Assignment2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class VuTienDat_7C18_1801040062_A2 {
	static Scanner sc = new Scanner(System.in);
	//Create array lists for each type of product's data
	static ArrayList<Integer> Product_ID = new ArrayList<Integer>();
	static ArrayList<String> Product_name = new ArrayList<String>();
	static ArrayList<Double> Product_Price = new ArrayList<Double>();
	static ArrayList<Integer> Quantity = new ArrayList<Integer>();
		@SuppressWarnings("unchecked")
		public static void main(String[] args) throws Exception {
			int choice = 0;
			// Repeating the Menu until the user enters the nineth option which is Quit!!!
			while (choice != 9) {
				int input_id, input_quan;
				double input_price;
				String input_name;
				//Creating a file to save the product's data
				File f = new File ("Product.txt");
				System.out.print("Menu:\r\n" + "1. Add products\r\n"
						+ "2. Display products\r\n"
						+ "3. Delete a product\r\n"
						+ "4. Edit a product\r\n"
						+ "5. Search for products by name\r\n"
						+ "6. Sort products by price\r\n"
						+ "7. Save products to text/binary file\r\n"
						+ "8. Load products from the saved file\r\n" +
						"9. Quit\r\n" +
						"Choose an option: ");
				choice = sc.nextInt();
				switch (choice) {
				//Add product: Input the product's data into the created ArrayList
				case 1:
						System.out.print("Enter Product's ID: ");
						input_id = sc.nextInt();
						Product_ID.add(input_id);
						
						System.out.print("Enter Product's name: ");
						input_name = sc.next();
						Product_name.add(input_name);
						
						System.out.print("Enter Product's price: ");
						input_price = sc.nextDouble();
						Product_Price.add(input_price);
						
						System.out.print("Enter Product's quantity: ");
						input_quan = sc.nextInt();
						Quantity.add(input_quan);
						
					System.out.println("The product information is input !!!");
					break;
				//Display product: Display a table-like product's data
				case 2:
					System.out.println(String.format("%10s %10s %20s %20s %10s %10s %10s", "ID", "|", "Name", "|", "Price", "|", "Quantity"));
					System.out.println(String.format("%s", "----------------------------------------------------------------------------------------------------------------"));
					for (int i = 0; i < Product_ID.size(); i++) {
						System.out.println(String.format("%10s %10s %20s %20s %10s %10s %10s", Product_ID.get(i), "|", Product_name.get(i), "|", Product_Price.get(i), "|", Quantity.get(i)));
					}
						break;
				//Delete product: since the ArrayList elements start from 0 so delete number has to be minused by 1
				case 3:
					System.out.print("Please enter the ID of the product you want to delete: ");
					int delete = sc.nextInt();
					Product_ID.remove(delete-1);
					Product_name.remove(delete-1);
					Product_Price.remove(delete-1);
					Quantity.remove(delete-1);
					System.out.println("The product is deleted!!!");
					break;
				//Edit product: since the ArrayList elements start from 0 so edit number has to be minused by 1
				case 4:
					System.out.print("Please enter the ID of the product you want to edit: ");
					int edit = sc.nextInt();
					Product_ID.set((edit-1), edit);
					
					System.out.print("Please enter a new name of the product: ");
					String editName = sc.next();
					Product_name.set((edit-1), editName);
					
					System.out.print("Please enter a new name of the product: ");
					double editPrice = sc.nextDouble();
					Product_Price.set((edit-1), editPrice);
					
					System.out.print("Please enter a new name of the product: ");
					int editQuantity = sc.nextInt();
					Quantity.set((edit-1), editQuantity);
					break;
				//Search product: compare the input name to the name in the ArrayList Product_name
				case 5:
					System.out.print("Please enter the name of the product you want to search: ");
					String search = sc.next();
					for (int i = 0; i < Product_name.size(); i++) {
						if (Product_name.get(i).contains(search)) {
							System.out.println(String.format("%10s %10s %20s %20s %10s %10s %10s", "ID", "|", "Name", "|", "Price", "|", "Quantity"));
							System.out.println(String.format("%s", "----------------------------------------------------------------------------------------------------------------"));
							System.out.println(String.format("%10s %10s %20s %20s %10s %10s %10s", Product_ID.get(i), "|", Product_name.get(i), "|", Product_Price.get(i), "|", Quantity.get(i)));
						}
					}
					break;
				case 6:
					break;
				//Save product: Save the information to the created file "Product.txt"
				case 7:
					FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(Product_ID);
                    oos.writeObject(Product_name);
                    oos.writeObject(Product_Price);
                    oos.writeObject(Quantity);
                    oos.close();
                    fos.close();
                    System.out.println("The file has been saved!");
					break;
				//Load product: load the information from the created file "Product.txt"
				case 8:
					FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Product_ID = (ArrayList<Integer>) ois.readObject();
                    Product_name = (ArrayList<String>) ois.readObject();
                    Product_Price = (ArrayList<Double>) ois.readObject();
                    Quantity = (ArrayList<Integer>) ois.readObject();
                    ois.close();
                    fis.close();
                    System.out.println("The file has been loaded!");
					break;
				//The case that user input the other number out of the range 1-9
				default:
					System.out.println("Invalid Input! Please input again!");
					break;
				}
			}
		}
}

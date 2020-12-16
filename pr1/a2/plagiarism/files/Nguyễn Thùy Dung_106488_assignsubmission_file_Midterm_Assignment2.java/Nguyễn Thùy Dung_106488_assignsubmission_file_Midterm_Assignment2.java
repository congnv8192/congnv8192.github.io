/*
 */
package Midterm;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* Nguyen Thuy Dung
 * Class: 1TD-19
 * ID: 1901060010
 */

public class Midterm_Assignment2 {
final private String name;
final private int ID;
final private double price;
final private int quantity;


Midterm_Assignment2(BufferedReader in) throws IOException {
System.out.print("Input the product ID: ");
this.ID = Integer.parseInt(in.readLine());
System.out.print("Input the product name: ");
this.name = in.readLine();
System.out.print("Input the product price: ");
this.price = Double.parseDouble(in.readLine());
System.out.print("Input the product quantity: ");
this.quantity = Integer.parseInt(in.readLine());
}


Midterm_Assignment2(String a) {
String[] string = a.split(", ");
this.name = string[1];
this.ID = Integer.parseInt(string[0]);
this.price = Double.parseDouble(string[2]);
this.quantity = Integer.parseInt(string[3]);
}


public String getname() {
    return name;
    }

public int getid() {
    return ID;
    }

public double getprice() {
    return price;
    }

public int getquantity() {
    return quantity;
    }


public void view() {
System.out.println(ID + "\t" + name + "\t\t" + price + "\t\t" + quantity);
}


public static int readfile(Midterm_Assignment2[] myproductArr, int total) {
try 
{
File f = new File("myproduct.txt");
if (f.exists()) 
{
Scanner filescan = new Scanner(f);
int x = 0;
while (filescan.hasNextLine()) 
{
myproductArr[x++] = new Midterm_Assignment2(filescan.nextLine());
}
total = x;
System.out.println("Read successfully!");
System.out.println();
filescan.close();
} 
else 
{
System.out.println("The file does not exist");
}
} 
catch (FileNotFoundException e) 
{
e.printStackTrace();
}
return total;
}


private static void writefile(Midterm_Assignment2[] myproductArr, int total) {
try 
{
BufferedWriter writefile = new BufferedWriter(new FileWriter("myproduct.txt"));
for (int x = 0; x < total; ++x) {
writefile.write(myproductArr[x].getid() 
        
    + ", " + myproductArr[x].getname() + ", " 
    
    + myproductArr[x].getprice() + ", " 
        
    + myproductArr[x].getquantity() + "\n");
}

writefile.close();
System.out.println("Write successfully!");
System.out.println();
writefile.close();
} catch (IOException e) {
System.out.println("Error!");
e.printStackTrace();
}
}


private static int input(Midterm_Assignment2[] myproduct, BufferedReader input, int total) throws IOException {
int newadd;
System.out.print("The total products is: ");
newadd = Integer.parseInt(input.readLine());
for (int x = total; x < total + newadd; ++x) {
myproduct[x] = new Midterm_Assignment2(input);
}
total += newadd;
return total;
}


private static void search(Midterm_Assignment2[] myproduct, BufferedReader input, int totalproduct) throws IOException {
System.out.print("Input product name: ");
boolean ck = false;
String Name = input.readLine();
for (int x = 0; x < totalproduct; ++x) 
{
if (myproduct[x].getname().equals(Name)) 
{
ck = true;
myproduct[x].view();
break;
}
if (!ck) 
{
System.out.println("Can not find the product");
}
System.out.println();
}
}


private static int delete(Midterm_Assignment2[] myproduct, BufferedReader input, int total) throws IOException {
System.out.print("Input product ID: ");
int ID;
boolean find = false;
ID = Integer.parseInt(input.readLine());
for (int x = 0; x < total; ++x) 
{
if (myproduct[x].getid() == ID) 
{
--total;
find = true;
if (total - x >= 0) 
{
System.arraycopy(myproduct, x + 1, myproduct, x, total - x);
}
System.out.println("The product has been deleted");
break;
}
}
if (!find) 
{
System.out.println("Can not find the product");
}
System.out.println();
return total;
}


private static void showall(Midterm_Assignment2[] myproduct, int total) {
for (int x = 0; x < total; ++x) 
{
myproduct[x].view();
}
System.out.println();
    }


private static void edit(Midterm_Assignment2[] myproduct, BufferedReader input, int total) throws IOException {
System.out.println("Input product ID: ");
int ID = Integer.parseInt(input.readLine());
for (int x = 0; x < total; ++x) 
{
if (myproduct[x].getid() == ID) 
{
myproduct[x] = new Midterm_Assignment2(input);
System.out.println("The product has been edited!");
break;
}
}
}


@SuppressWarnings("empty-statement")
public static void main(String[] args) throws IOException {
Midterm_Assignment2[] myproductArr = new Midterm_Assignment2[30];
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
int y = 0;
int total = 0;
do 
{
    System.out.println("[1] Add products");
    System.out.println("[2] Display products");
    System.out.println("[3] Delete a product");
    System.out.println("[4] Edit products by ID");
    System.out.println("[5] Search for products by name");
    System.out.println("[5] Save products to text/binary file");
    System.out.println("[6] Load products from the saved file");
    System.out.println("[7] Exit the program");
    System.out.print("Choose an option: ");
try 
{  
y = Integer.parseInt(input.readLine());
System.out.println();
switch (y) {
case 1:
total = input(myproductArr, input, total);
    break;
    
case 2:
showall(myproductArr, total);
    break;
    
case 3:
total = delete(myproductArr, input, total);
    break;
    
case 4:
edit(myproductArr, input, total);
    break;
    
case 5:
search(myproductArr, input, total);
    break;
    
case 6:
writefile(myproductArr, total);
    break;
    
case 7:
total = readfile(myproductArr, total);
    break;
    
default:
System.out.println("Invalid input");
System.out.println("Input again");
break;
}
} 
catch (InputMismatchException | NumberFormatException | IOException ex) {
System.out.println("Invalid input");
ex.printStackTrace();
}
} while (y != 7);
input.close();
}
}
 


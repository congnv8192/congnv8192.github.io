
import java.util.Scanner;


/**
 *
 * @author Do Duc Thang - 1701040169 - 4C17
 */
public class Assignment1_DoDucThang {
        public static void decimalToBinary() {
                Scanner nhap = new Scanner(System.in);
                System.out.println("Please enter an integer: ");
                int dec = nhap.nextInt();
                int binaryNumber [] = new int [1000];
                System.out.println("The binary number of " + dec + " is: ");
                int stt = 0;
                while (dec > 0) {
                binaryNumber[stt] = dec % 2;
                dec = dec / 2;
                stt++;
                }
        
                for (int lap = stt - 1; lap >= 0; lap--) {
                System.out.print(binaryNumber[lap]);
                }
                System.out.println();
        }
        
        public static void squareRoot() {
                Scanner nhap = new Scanner(System.in);
                System.out.println("Please enter an integer m: ");
                double input = nhap.nextDouble();
                double store = input;
                System.out.println("The times the square root is taken (From 1 to 5): ");
                int times = nhap.nextInt();
                int lan = 0;
                double resultSqrt = 0;
                
                while (times < 1 || times > 5) {
                    System.err.println("Not allowed! Please enter the times again: ");
                    times = nhap.nextInt();
                }
                   
                if (1 <= times && times <= 5) {
                    while (lan < times) {
                        resultSqrt = Math.sqrt(input);
                        input = store + resultSqrt;
                        lan++;
                    }
                    System.out.println("The result is: " + resultSqrt);
                }
        }
        
        public static void quadraticEquation() {
                Scanner nhap = new Scanner(System.in);
                System.out.println("Please insert a: ");
                double a = nhap.nextDouble();
                System.out.println("Please insert b: ");
                double b = nhap.nextDouble();
                System.out.println("Please insert c: ");
                double c = nhap.nextDouble();
                
                if (a == 0 && b == 0 && c == 0) {
                    System.out.println("There is noting to be solved!");
                }
                
                else if (a == 0 && b == 0 && c != 0) {
                    System.out.println("The equation has no root!");
                }
                
                else if (a == 0 && b != 0 && c != 0) {
                    double x = -c / b;
                    System.out.println("There is one root: x = " + x);
                }
                
                else {
                    double delta = b*b - 4*a*c;
                if (delta < 0) {
                    System.out.println("The equation has no real root!");
                }
                else {
                    double x1 = (-b + Math.sqrt(delta))/(2*a);
                    double x2 = (-b - Math.sqrt(delta))/(2*a);
                    System.out.println("There are two roots: ");
                    System.out.println("x1 = " + x1 + ", x2 = " + x2);
                }
                }
        }
                
        public static void triangleGivenSize() {
                Scanner nhap = new Scanner(System.in);
                System.out.println("Input an integer at range [1,5]: ");
                int level = nhap.nextInt();
                
                while (level < 1 || level > 5) {
                    System.err.println("Not allowed! Please input an integer between 1 and 5: ");
                    level = nhap.nextInt();
                }               
                
                if (level >= 1 && level <= 5) {
                    for (int k = 0; k < level; k++) {                           //Number of rows
                        for (int i = k; i < level-1; i++) {                     //Number of space each row
                            System.out.print(" ");
                        }
                        for (int j = 0; j < k * 2 + 1; j++) {                   //Number of star each row
                            System.out.print("*");
                        }
                            System.out.println();                               //Make a new line for each level
                        }
                    }
                }
        
        public static void main(String[] args) {
                Scanner nhap = new Scanner(System.in);
                int choose = 0;
                while (choose != 5) {
                try {
                System.out.println("Please choose your option: ");
                System.out.println("[1] - Convert a decimal (base 10) to binary (base 2)");
                System.out.println("[2] - Consecutive square root");
                System.out.println("[3] - Solve a quadric equation");
                System.out.println("[4] - Print a triangle given its size");
                System.out.println("[5] - Exit the program");
                choose = nhap.nextInt();
                
                while (!(choose >= 1 && choose <= 5)) {
                    Exception e = new Exception("Not allowed! ");
                    throw e;
                }
                } catch (Exception e) {               
                while (choose < 1 || choose > 5) {
                    System.err.println(e.getMessage() + "Please choose again: ");
                    choose = nhap.nextInt();
                }
                }
                switch (choose) {
                    case 1:
                       decimalToBinary();
                       break;  
                    case 2:
                       squareRoot();
                       break;  
                    case 3:
                       quadraticEquation(); 
                       break;                      
                    case 4:
                       triangleGivenSize(); 
                       break;                      
                    case 5:
                       System.out.println("Goodbye!");
                       System.exit(0);
                }
                }
                
    }
}


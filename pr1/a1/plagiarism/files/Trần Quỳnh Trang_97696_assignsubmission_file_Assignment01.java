/* Assignment 1
 * Name: Tran Quynh Trang
 * Student ID: 1901060054
 * Class: 1TD-19
 */
package pr1;

import java.util.Scanner;

public class Assignment01 {
    // [1] Convert a decimal integer to binary
    private static void convert(){
    	Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int a = sc.nextInt();
        int b;
        System.out.print("Binary equivalent: ");
        while (true){
        // calculate the binary value
          b = a % 2;
          a = (a-b)/2;
        // invalid input
          if (a < 2){
              System.out.println("The number must be greater than 2. Please input again.");
              break;
          }
          System.out.print(b);
        }
    }
    // [2] Compute a consecutive square root
    private static void consecutive(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an interger: ");
        int m = sc.nextInt();
        System.out.print("Enter the number of consecutive square root (from 1 to 5): ");
        int n = sc.nextInt();
        // calculation
        double k = Math.sqrt(m); // assign value square root m to k
        if (n>=1 && n<=5) { // select qualified input and start calculating + stop calculating if wrong input
           for (int u=1; u<n; u++) {
            k = Math.sqrt(m+k);
            }
            System.out.println("The answer is " + k);
        } else {
            System.out.println("Invalid input");
        }
    }
    // [3] Solve a quadratic equation
    private static void quadratic(){
        Scanner sc = new Scanner(System.in);
        System.out.println("a.x^2 + b.x + c = 0");
        System.out.println("Please enter the values:");
        System.out.print("a = ");
        int a = sc.nextInt();
        System.out.print("b = ");
        int b = sc.nextInt();
        System.out.print("c = ");
        int c = sc.nextInt();
        int delta = b*b-4*a*c; // define the equation to calculate the value delta
        // check the value of delta + calculate the solutions
        if ( delta < 0){
            System.out.println("No solution");
        } else if (a==0 && b==0 && c==0){
            System.out.println("Infinite solutions");
        } else if (delta ==0){
            System.out.println("x is "+(-b)/(2*a));
        } else { 
            double solution1 = (-b-Math.sqrt(delta))/(2*a);
            double solution2 = (-b+Math.sqrt(delta))/(2*a);
            System.out.println("x1 = " + solution1);
            System.out.println("x2 = " + solution2);
        }
    }
    // [4] Print a triangle given its size
    private static void triangle(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        int m = 2*n - 1;  
        //  place " " and "*"
        if (n >= 1 && n <= 5){ 
            for (int i = 0; i <= n; i++) {
                for (int x = 1; x <= (n-i); x++){
                     System.out.print(" ");
                }
                for (int y = (n-i+1); y <= (m-n+i); y++){
                     System.out.print("*");
                }
            System.out.println();
            }
        } else {
            System.out.println("Invalid input");
        }
    }
    // Listing the menu
    public static void main(String args[]) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        while (n != 4) {
        System.out.println("[1] Convert a decimal integer to binary");
        System.out.println("[2] Compute a consecutive square root");
        System.out.println("[3] Solve a quadratic equation");
        System.out.println("[4] Print a triangle given its size");
        System.out.print("Select a function: ");
        int scan = sc.nextInt();
        switch (scan){
            case 1:
                convert();
                break;
            case 2:
                consecutive();
                break;
            case 3:
                quadratic();
                break;
            case 4:
                triangle();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }   // ask the user if they want to continue or not 
            System.out.print("Do you want to continue another program ?(Y/N): ");
            sc.nextLine();
            if (sc.nextLine().equalsIgnoreCase("N")) {
                System.out.println("Goodbye");
                break;
            } else {}
            
    }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongquynhtrang_1td19_1901060050;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class DuongQuynhTrang_1TD19_1901060050 {
private static void convert(){
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer");
        int b = sc.nextInt();
        int c;
        System.out.println("Binary equivalent");
        while (true){
        // calculate the binary value
          c = b % 2;
          b = (b-c)/2;
        // invalid input
          if (b < 2){
              System.out.println("The number must be greater than 2. Please input again.");
              break;
          }
          System.out.print(c);
        }
    }
    private static void consecutive(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an interger");
        int m = sc.nextInt();
        System.out.println("Enter the number of consecutive square root (between 1 and 5)");
        int n = sc.nextInt();
        double k = Math.sqrt(m);
        if (n>=1 && n<=5){
           for (int u=1; u<n; u++){
            k = Math.sqrt(m+k);
            }
            System.out.println("Answer "+k);
        }else {
            System.out.println("Invalid input");
        }
    }
    private static void quadratic(){
        Scanner sc = new Scanner(System.in);
        System.out.println("a.x^2 + b.x + c = 0");
        System.out.println("Enter a b c");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int v = y*y-4*x*z;
        if (v<0){
            System.out.println("No solution");
        }else if (x==0 && y==0 && z==0){
            System.out.println("Infinite solutions");
        }else if (v==0){
            System.out.println("x is "+(-y)/(2*x));
        }else {
            double solution1 = (-y-Math.sqrt(v))/(2*x);
            double solution2 = (-y+Math.sqrt(v))/(2*x);
            System.out.println("x1 is "+ solution1);
            System.out.println("x2 is "+ solution2);
        }
    }
    private static void triangle(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int a = sc.nextInt();
        int b = 2 * a - 1;
        if (a>=1 && a<=5){
            for (int i=0; i<=a; i++){
            for (int m=1; m<=(a-i); m++){
                System.out.print(" ");
            }
            for (int n=(a-i+1); n<=(b-a+i); n++){
                System.out.print("*");
            }
            System.out.println();
            }
        }else {
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
          
            } // ask the user if they want to continue or not 
            System.out.print(" do u like to continue another program ?(ok/later): ");
            sc.nextLine();
            if (sc.nextLine().equalsIgnoreCase("later")) {
                System.out.println("Goodbye.See you again");
                break;
            } else {}
        }
    }
}
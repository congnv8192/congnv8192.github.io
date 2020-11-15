/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huathiquynhmai_1901060032;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class HuaThiQuynhMai_1901060032 {

    /**
     * @param args the command line arguments
     */
    private static void convert(){
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer");
        int a = sc.nextInt();
        int b;
        System.out.println("Binary equivalent");
        while (true){
          b = a % 2;
          a = (a-b)/2;
          if (a < 2) {
              System.out.println("The number must be greater than 2. Please input again.");
              break;
          }
          System.out.print(b);
        }
    }
    private static void consecutive() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an interger");
        int m = sc.nextInt();
        System.out.println("Enter the number of consecutive square root (between 1 and 5):");
        int n = sc.nextInt();
        double k = Math.sqrt(m);
        if (n>=1 && n<=5) {
           for (int u=1; u<n; u++){
            k = Math.sqrt(m+k);
            }
            System.out.println("Answer " + k);
        } else {
            System.out.println("Invalid input");
        }
    }
    private static void quadratic()  {
        Scanner sc = new Scanner(System.in);
        System.out.println("a.x^2 + b.x + c = 0");
        System.out.println("Enter value: a b c");
        System.out.print("a = ");
        int a = sc.nextInt();
        System.out.print("b = ");
        int b = sc.nextInt();
        System.out.print("c = ");
        int c = sc.nextInt();
        int delta = b*b-4*a*c;
        if (delta < 0) {
            System.out.println("No solution");
        }else if (a==0 && b==0 && c==0) {
            System.out.println("Infinite solutions");
        }else if (delta==0){
            System.out.println("x  is "+(-b)/(2*a));
        }else {
            double nghiem1 = (-b-Math.sqrt(delta))/(2*a);
            double nghiem2 = (-b+Math.sqrt(delta))/(2*a);
            System.out.println("x1 is "+nghiem1);
            System.out.println("x2 is "+nghiem2);
        }
    }
    private static void triangle(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int n  = sc.nextInt();
        int m = 2 * n - 1;
        if (n >= 1 && n <=5) {
            for (int i = 0; i <= n; i++) {
            for (int x = 1; x <= (n - i); x++) {
                System.out.print(" ");
            }
            for (int y = (n-i+1); y <= (m-n+i); y++) {
                System.out.print("*");
            }
            System.out.println();
            }
        } else {
            System.out.println("Invalid input");
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose one of the methods:");
        System.out.println("1.Convert to binary");
        System.out.println("2.Compute a consecutive square root");  
        System.out.println("3.Solve a quadratic equation");
        System.out.println("4.Print a star triangle");
        System.out.print("Select a function");
        int choose = sc.nextInt();
        switch (choose){
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
            }
            System.out.println("Do you want to continue another program ? (Y/N)");
            String output = sc.nextLine();
            for (int i=0; i<=output.length(); i++){
                 if (output.charAt(i)=='N'){     
                 System.out.println("Goodbye");
                 break;
                 }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm.assignment;

import java.util.Scanner;

/**
 *
 * @author Hello
 */
public class TranHaPhuong_2TD19_1901060042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer choice;
        do {
            System.out.println("\nThis is a menu-based program.");
            System.out.println("1. Convert a decimal (base 10) integer to binary (base 2).");
            System.out.println("2. Compute a consecutive square root.");
            System.out.println("3. Solve a quadratic equation.");
            System.out.println("4. Print a triangle given its size.");
            System.out.println("5. Exit the program.");
            System.out.println("Select Function : (1-5).");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter an integer: ");
                Integer input = sc.nextInt();
                System.out.println("Binary number of " + input + " is :" + Integer.toBinaryString(input));
            } else if (choice == 2) {
                System.out.print("Enter an integer m: ");
                Integer m = sc.nextInt();
                double result = 0;
                Integer n;
                do {
                    System.out.print("Enter an integer n: ");
                    n = sc.nextInt();
                    if (n > 0 && n < 6) {
                        for (int i = 1; i <= n; i++) {
                            result = Math.sqrt(m + result);
                        }
                        System.out.println(result);
                    } else if (n > 5 || n < 1) {
                        System.out.println("1<=n<=5");
                    }
                } while (n > 5 || n < 1);
            } else if (choice == 3) {
                System.out.print("Input a: ");
                double a = sc.nextInt();
                System.out.print("Input b: ");
                double b = sc.nextInt();
                System.out.print("Input c: ");
                double c = sc.nextInt();
                if (a == 0) {
                    if (b != 0) {
                        System.out.println("The equation has one solution: "
                                + "x = " + (-c / b));
                                } else {

                if (c != 0) {
                        
                System.out.println("The equation has no solution!");
                        } else {       
                            System.out.println("The equation has countless solutions");
                        }
                    }
                } else {
                    double x1;
                    double x2;
                    if (b * b - 4 * a * c > 0) {
                        x1 = (double) ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
                        x2 = (double) ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
                        System.out.println("The equation has two solutions: "
                                + "x1 = " + x1 + " và x2 = " + x2);
                    } else if (b * b - 4 * a * c == 0) {
                        x1 = (-b / (2 * a));
                        System.out.println("The equations has double solutions: "
                                + "x1 = x2 = " + x1);
                    } else {
                        System.out.println("The equation has no solution!");
                    }
                }

            } else if (choice == 4) {
                Integer n;
                do {
                    System.out.print("Enter the integer n: ");
                    n = sc.nextInt();
                    if (n >= 1 && n <= 5) {
                        for (int i = 1; i <= n; i++) {
                            for (int j = 1; j <= n - i; j++) {
                                System.out.print("  ");
                            }
                            for (int k = 1; k <= 2 * i - 1; k++) {
                                System.out.print("* ");
                            }
                            System.out.println("");
                        }
                    } else if (n > 5 || n < 1) {
                        System.out.println("1<=n<=5");
                    }
                } while (n > 5 || n < 1);
            } else if (choice == 5) {
                break;
            }
            if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                System.out.println("Enter incorrectly, please re-enter.");
            }
        } while (choice != 1 || choice != 2 || choice != 3 || choice != 4 || choice != 5);
       

    }
}

                
    
    


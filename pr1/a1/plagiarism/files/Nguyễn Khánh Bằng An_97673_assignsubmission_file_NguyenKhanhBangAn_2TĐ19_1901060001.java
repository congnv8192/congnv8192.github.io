/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm.assignment;

import java.util.Scanner;

/**
 *
 * @author Nguyen Khanh Bang An
 * Class: 2TĐ19
 * ID: 1901060001
 */
public class NguyenKhanhBangAn_2TĐ19_1901060001 {
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
            System.out.println("Select Function : [1-5].");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1) {
                //choice = 1 does exercise 1.
                System.out.print("Enter an integer: ");
                Integer input = sc.nextInt();
                System.out.println("Binary number of " + input + " is :" + Integer.toBinaryString(input));
                //usage of Interger.toBinaryString() changes integer into binary number base 2.
            } else if (choice == 2) {
                //choice = 2 does exercise 1.
                System.out.print("Enter the integer m: ");
                Integer m = sc.nextInt();
                double result = 0;
                Integer n;
                do {
                    System.out.print("Enter the integer n: ");
                    n = sc.nextInt();
                    if (n > 0 && n < 6) {
                        // n bigger than 0 and smaller than 6, starts go in for.
                        for (int i = 1; i <= n; i++) {
                            result = Math.sqrt(m + result);
                            // calculate sum.
                            //Math.squrt() calculates square root.
                        }
                        System.out.println(result);
                        //display result.
                    } else if (n > 5 || n < 1) {
                        //n bigger than 5 or smaller than 1 then it displays error.
                        System.out.println("1<=n<=5");
                    }
                } while (n > 5 || n < 1);
                // if n bigger than 5 or smaller than 1 then it displays error and continue the loop.
                // if n smaller than 5 or bigger than 1 then it displays result to end the loop.
            } else if (choice == 3) {
                //Choice = 3 does exercise 3. 
                System.out.print("Input a: ");
                double a = sc.nextInt();
                System.out.print("Input b: ");
                double b = sc.nextInt();
                System.out.print("Input c: ");
                double c = sc.nextInt();
                // There will be 2 cases a =0 and a!=0.
                if (a == 0) {
                    //case a= 0.
                    if (b != 0) {
                        //a=0,b!=0  the equation has 1 solution -c / b.
                        System.out.println("The equation has one solution: "
                                + "x = " + (-c / b));

                    } else {
                        //case a=0,b=0
                        if (c != 0) {
                            // case a=0,b=0,c!=0 the equation has no solution.    
                            System.out.println("The equation has no solution!");
                        } else {
                            // case a=0,b=0,c=0 the equation has countless solutions.        
                            System.out.println("The equation has countless solutions");
                        }
                    }
                } else {
                    //case a!=0.
                    double x1;
                    double x2;
                    if (b * b - 4 * a * c > 0) {
                        //calculate delta = b * b - 4 * a * c, delta >0 the equation has 2 solutions (-b + Math.sqrt(delta)) / (2 * a)và (-b - Math.sqrt(delta)) / (2 * a).
                        // Math.sqrt() calculates square root.
                        x1 = (double) ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
                        x2 = (double) ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
                        System.out.println("The equation has two solutions: "
                                + "x1 = " + x1 + " và x2 = " + x2);
                    } else if (b * b - 4 * a * c == 0) {
                        //delta = 0 the equation has double solutions -b / (2 * a).
                        x1 = (-b / (2 * a));
                        System.out.println("The equations has double solutions: "
                                + "x1 = x2 = " + x1);
                    } else {
                        //delta < 0 the equation has no solution.
                        System.out.println("The equation has no solution!");
                    }
                }

            } else if (choice == 4) {
                //Choice ==4 does exercise 4.
                Integer n;
                do {
                    System.out.print("Enter the integer n: ");
                    n = sc.nextInt();
                    if (n >= 1 && n <= 5) {
                        // if 1<=n<=5 then start running for.
                        for (int i = 1; i <= n; i++) {
                            for (int j = 1; j <= n - i; j++) {
                                System.out.print("  ");
                                //display the distance from left to right following k
                            }
                            for (int k = 1; k <= 2 * i - 1; k++) {
                                System.out.print("* ");
                                //display number * following k
                            }
                            System.out.println("");
                            //display line numbers following i.
                        }
                    } else if (n > 5 || n < 1) {
                        // if n bigger than 5 or smaller than 1 then it displays error.
                        System.out.println("1<=n<=5");
                    }
                } while (n > 5 || n < 1);
            } else if (choice == 5) {
                //Choice =5 ends the program.
                break;
            }
            if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                // if Choice != 1 , Choice != 2 , Choice != 3, Choice != 4 , Choice != 5 display error then please re-enter.
                System.out.println("Enter incorrectly, please re-enter.");
            }

        } while (choice != 1 || choice != 2 || choice != 3 || choice != 4 || choice != 5);
        // if Choice != 1 , Choice != 2 , Choice != 3, Choice != 4 then turn back the loop.

    }
    
}

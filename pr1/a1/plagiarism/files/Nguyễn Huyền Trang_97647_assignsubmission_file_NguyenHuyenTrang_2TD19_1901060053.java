/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Scanner;

/**
 *
 * @author 
 * Full name: Nguyen Huyen Trang
 * Student ID: 1901060053
 * Class: 2TD19
 */
public class NguyenHuyenTrang_2TD19_1901060053 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer Choice;
        do {
            System.out.println("\nThis is a menu-based program.");
            System.out.println("1. Convert a decimal (base 10) integer to binary (base 2).");
            System.out.println("2. Compute a consecutive square root.");
            System.out.println("3. Solve a quadratic equation.");
            System.out.println("4. Print a triangle given its size.");
            System.out.println("5. Exit the program");
            System.out.println("Select Function : [1- 5].");
            System.out.print("Choice :");
            Choice = sc.nextInt();
            if (Choice == 1) {
                //choice = 1 do the exercise 1.
                System.out.print("Enter the integer: ");
                Integer input = sc.nextInt();
                System.out.println("Binary number is :" + Integer.toBinaryString(input));
                //the function Integer.toBinaryString() convert integer into binary.
            } else if (Choice == 2) {
                //choice = 2 do the excercise 2.
                System.out.print("Enter the integer m: ");
                Integer m = sc.nextInt();
                double sqr = 0;
                Integer n;
                do {
                    System.out.print("Enter the integer n: ");
                    n = sc.nextInt();
                    if (n > 0 && n < 6) {
                        // n greater than 0 and less than 6, then start in round for.
                        for (int i = 1; i <= n; i++) {
                            sqr = Math.sqrt(m + sqr);
                            //calculate the total.
                            //function Math.sqrt() calculate the square root of 2.
                        }
                        System.out.println(sqr);
                        //show results.
                    } else if (n > 5 || n < 1) {
                        //n greater than 5 or less than 1 indicates an error.
                        System.out.println("1<=n<=5");
                    }
                } while (n > 5 || n < 1);
                // If n is greater than 5 or less than 1, then error message, continue the loop.
                //If n is less than 5 or greater than 1, print the end result of the loop.
            } else if (Choice == 3) {
                //Choice = 3 do the exercise 3.
                System.out.print("Input a: ");
                double a = sc.nextInt();
                System.out.print("Input b: ");
                double b = sc.nextInt();
                System.out.print("Input c: ");
                double c = sc.nextInt();
                // there will be 2 more cases than a = 0 and a! = 0.
                if (a == 0) {
                    //case: a= 0.
                    if (b != 0) {
                        //a=0,b!=0 the equation has 1 solution -c / b.
                        System.out.println("The equation has one solution: "
                                + "x = " + (-c / b));

                    } else {
                        //case: a=0,b=0
                        if (c != 0) {
                            // case: a=0,b=0,c!=0 The equation has no solution.    
                            System.out.println("The equation has no solution!");
                        } else {
                            // case: a=0,b=0,c=0 The equation has countless solution.        
                            System.out.println("The equation has countless solutions");
                        }
                    }
                } else {
                    //case: a!=0.
                    double x1;
                    double x2;
                    if (b * b - 4 * a * c > 0) {
                        //calculate delta = b * b - 4 * a * c, delta >0 the equation has 2 solutions (-b + Math.sqrt(delta)) / (2 * a) and (-b - Math.sqrt(delta)) / (2 * a).
                        //Function Math.sqrt() to calculate the square root of 2.
                        x1 = (double) ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
                        x2 = (double) ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
                        System.out.println("The equation has two solutions: "
                                + "x1 = " + x1 + " và x2 = " + x2);
                    } else if (b * b - 4 * a * c == 0) {
                        //delta = 0 the equation has double solutions: -b / (2 * a).
                        x1 = (-b / (2 * a));
                        System.out.println("The equation has double solutions: "
                                + "x1 = x2 = " + x1);
                    } else {
                        //delta < 0 he equation has no solution.
                        System.out.println("The equation has no solution!");
                    }
                }

            } else if (Choice == 4) {
                //Choice ==4 do the exercise 4.
                Integer n;
                do {
                    System.out.print("Enter the integer n: ");
                    n = sc.nextInt();
                    if (n >= 1 && n <= 5) {
                        //If n satisfies the condition of if 1<=n<=5 then starting running around for for.
                        for (int i = 1; i <= n; i++) {
                            for (int j = 1; j <= n - i; j++) {
                                System.out.print("  ");
                                //shows the distance from left to right in j.
                            }
                            for (int k = 1; k <= 2 * i - 1; k++) {
                                System.out.print("* ");
                                //show number * in k.
                            }
                            System.out.println("");
                            //shows line numbers according to i.
                        }
                    } else if (n > 5 || n < 1) {
                        //If n is greater than 5 or less than 1, the error will be reported.
                        System.out.println("1<=n<=5");
                    }
                } while (n > 5 || n < 1);
            } else if (Choice == 5) {
                //Choice =5 End the program.
                break;
            }
            if (Choice != 1 && Choice != 2 && Choice != 3 && Choice != 4 && Choice != 5) {
                // If Choice != 1 , Choice != 2 , Choice != 3, Choice != 4 , Choice != 5 report error and require user to re-enter.
                System.out.println("Enter incorrectly, please re-enter.");
            }

        } while (Choice != 1 || Choice != 2 || Choice != 3 || Choice != 4 || Choice != 5);
        // If Choice != 1 , Choice != 2 , Choice != 3, Choice != 4 back to the loop.
    }

}

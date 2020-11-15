/*
 * Student name: Vũ Đức Lộc
 * Student ID: 1901040129
 * Class: 2C19
 */
package MidtermPR1;

import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author Vu Duc Loc
 */
public class Assignment {

    /* Task 1: 1. Convert a decimal (base 10) integer to binary (base 2). */
    public String ConvertToBinary(int x) {
        String s = "";
        while (x != 0) {
            int mod = x % 2;
            x = x / 2;
            s = s + mod;
        }
        String s1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            s1 = s1 + s.charAt(i);
        }
        return s1;
    }

    /* Task 2: 2. Compute a consecutive square root. */
    public double ConsecutiveSquareRoot(double m, int n) {
        double Result = 0;
        if (n < 1 || n > 5) {
            System.out.println("Invalid input !");
        } else {
            for (int i = 0; i <= n; i++) {
                /* Use for loop to calculate the result of the square root by n times. */
                Result = Math.sqrt(m + Result);
            }
        }
        return Result;
    }

    /* Task 3: Solve a quadratic equation. */
    public void QuadaricEquation(double a, double b, double c) {
        if (a == 0) {
            /* Use if to find each case of the QuadaricEquation with given a,b,c. */
            if (b == 0 && c != 0) {
                System.out.println("The equation has no solution.");
            } else if (b == 0 && c == 0) {
                System.out.println("The equation has infinite solutions.");
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("The equation has no solution.");
            } else if (delta == 0) {
                double x = (-b) / (2 * a);
                System.out.println("The equation has 1 solution: " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("The equation has 2 solution: ");
                System.out.println("X1 = " + x1);
                System.out.println("X2 = " + x2);
            }
        }
    }

    /* Task 4: Print a triangle given its size. */
    public void PrintaTriangle(int n) {
        if (n < 1 || n > 5) {
            System.out.println("Invalid input !");
        } else {
            for (int i = 1; i <= n; i++) {
                for (int o = 1; o <= n - i; o++) {
                    System.out.print(" ");
                }
                for (int p = 1; p <= 2 * i - 1; p++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    /* Print the menu out. */
    public static void main(String[] args) {
        Assignment pr = new Assignment();
        Scanner scan = new Scanner(System.in);
        System.out.println("Menu: ");
        System.out.println("1. Convert a decimal (base 10) integer to binary (base 2).");
        System.out.println("2. Compute a consecutive square root.");
        System.out.println("3. Solve a quadratic equation.");
        System.out.println("4. Print a triangle given its size.");
        /* Use while loop and switch case to perform a particular function. */
        while (true) {
            System.out.println("Choose a function: ");
            boolean choose = true;

            switch (scan.nextInt()) {
                case 1:
                    System.out.println("Enter an integer: ");
                    System.out.println(pr.ConvertToBinary(scan.nextInt()));
                    break;
                case 2:
                    System.out.println("Input two intergers m and n (1 ≤ n ≤ 5): ");
                    int m = scan.nextInt();
                    int n = scan.nextInt();
                    System.out.println("Result = ");
                    System.out.println(pr.ConsecutiveSquareRoot(m, n));
                    break;
                case 3:
                    System.out.println("Input 3 coefficients a, b and c: ");
                    pr.QuadaricEquation(scan.nextDouble(), scan.nextDouble(), scan.nextDouble());
                    break;
                case 4:
                    System.out.println("Input an interger n(1 ≤ n ≤ 5)");
                    pr.PrintaTriangle(scan.nextInt());
                    break;
                default:
                    System.out.println("Please choose the function from 1 to 4.");
                    choose = false;
                    break;
            }
            if (choose == true) {
                System.out.println("Do you want to continue with another function ?");
                String again = scan.next();
                while (again.equals("Yes") == false) {
                    if (again.equals("No")) {
                        System.out.println("The program will stop immidiately !");
                        return;
                    } else {
                        System.out.println("Choose a function: ");
                        again = scan.next();
                    }
                }
            }
        }

    }
}

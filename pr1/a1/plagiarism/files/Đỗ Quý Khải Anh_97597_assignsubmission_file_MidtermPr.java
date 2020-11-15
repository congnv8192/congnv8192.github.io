/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Scanner;

/* Name: Đỗ Quý Khải Anh
Class: 4c19
ID: 1901040006
*/

public class MidtermPr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1: Demical to Binary     2: Consecutive square root     3: Quadratic equation     4: Triangle");
            System.out.print("Your choice is: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Choice 1: Convert a demical integer to binary.");
                    System.out.print("Enter a demical number: ");
                    int n = sc.nextInt();
                    int a;
                    int s = 0;
                    int i = 1;
                    while (n > 0) {
                        a = n % 2;
                        n = n / 2;
                        s = s + (a * i);
                        i = i * 10;
                    }
                    System.out.println("số nhị phân là: ");
                    break;

                case 2:
                    System.out.println("Choice 2: Compute a consecutive square root");
                    System.out.print("Enter m: ");
                    double m = sc.nextInt();
                    System.out.print("Enter n: ");
                    int n1 = sc.nextInt();
                    double a1 = 0,
                     b = m;
                    for (int i1 = 1; i1 < n1; i1++) {
                        a1 = Math.sqrt(m);
                        m = a1 + b;

                    }
                    System.out.println("Kết quả là: " + m);
                    break;
                case 3:
                    System.out.println(" Solve a quadratic equation");
                    double x1,
                     x2;
                    System.out.print("Enter a: ");
                    double a2 = sc.nextInt();
                    System.out.print("Enter b: ");
                    double b2 = sc.nextInt();
                    System.out.print("Enter c: ");
                    double c = sc.nextInt();
                    if (a2 == 0 && b2 == 0 && c == 0) {
                        System.out.println("There is nothing to solve");
                    } else if (a2 == 0 && b2 == 0 && c != 0) {
                        System.out.println("The equation has no root");

                    } else if (a2 == 0 && b2 != 0 && c != 0) {
                        System.out.println("There is one root: " + "x=" + -c / b2);
                    } else if ((Math.pow(b2, 2)) - 4 * a2 * c < 0) {
                        System.out.println("The equation has no root");
                    } else if ((Math.pow(b2, 2)) - 4 * a2 * c >= 0) {
                        x1 = (double) (-b2 + Math.sqrt(b2 * b2 - 4 * a2 * c)) / 2 * a2;
                        x2 = (double) (-b2 - Math.sqrt(b2 * b2 - 4 * a2 * c)) / 2 * a2;
                        System.out.println("There are two roots: " + "x1= " + x1 + " and x2=  " + x2);
                    }
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Print a triangle given its size");
                    System.out.println("Enter number of rows");
                    int a3 = sc.nextInt();
                    int b3 = 2 * a3 - 1;
                    if (a3 >= 1 && a3 <= 5) {
                        for (int i2 = 0; i2 <= a3; i2++) {
                            for (int m1 = 1; m1 <= (a3 - i2); m1++) {
                                System.out.print(" ");
                            }
                            for (int n2 = (a3 - i2 + 1); n2 <= (b3 - a3 + i2); n2++) {
                                System.out.print("*");
                            }
                            System.out.println("");
                        }
                    } else {
                        System.out.println("Invalid input");
                    }
                    break;
                    
            }
                     System.out.println("Do you want to continue with another choice?");
                     System.out.println("1. YES                               2, NO");
                     System.out.print("Plesase choose: ");
                     int ch2 = sc.nextInt();
                     if ( ch2==2){
                         System.out.println("GOODBYE! SEE YOU AGAIN.");
                      break;}
        } 
                    while (true);
    }}
            
        


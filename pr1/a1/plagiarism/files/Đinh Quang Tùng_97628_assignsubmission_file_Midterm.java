/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.util.Scanner;
public class Midterm {

    public static void main(String[] args) {
        boolean Continue = true;
        while (Continue) {
        System.out.println("1. Convert a decimal (base 10) integer to binary (base 2)");
        System.out.println("2. Compute a consecutive square root");
        System.out.println("3. Solve a quadratic equation");
        System.out.println("4. Print a triangle given its size");
        System.out.print("Choose the function that you want to perform: ");
        Scanner sc = new Scanner(System.in);
        int function = sc.nextInt();
            switch (function) {
                case 1:
                    int n ;
                    System.out.print("Enter the decimal number: ");
                    n = sc.nextInt();
                    int Dec ;
                    int Bin = 0;
                    int i = 1;
                    while (n > 0) {
                        Dec = n%2;
                        n = n/2;
                        Bin = Bin + (Dec*i);
                        i = i*10;
                    }
                    System.out.println(Bin);
                    break;
                case 2:
                    double m, x, root, x3;
                    System.out.print("Enter the number: ");
                    m = sc.nextDouble();
                    System.out.print("Enter the number of roots that you want (1-5): ");
                    x = sc.nextDouble();
                    root = 0;
                    boolean valid = false;
                    while ( x >= 1 && x <= 5) {
                        valid = true;
                        for ( int g = 1; g <= x; g++) {
                            root = Math.sqrt(m + root);
                        } System.out.println("A= " + root);
                        break;
                    }
                    while (!valid) {
                        System.out.println("Sorry, you must choose the number of roots from 1 to 5");
                        System.out.print("Enter the number of roots that you want (1-5):");
                        x3 = sc.nextDouble();
                        if ( x3 >= 1 && x3 <= 5) {
                        for ( int g = 1; g <= x3; g++) {
                            root = Math.sqrt(m + root);
                        } System.out.println("A = " + root);
                        break;
                        }
                    }
                    break;
                case 3:
                    double a,b,c,x1,x2;
                    System.out.println("Enter 3 number: ");
                    System.out.print("Enter a = ");
                    a = sc.nextInt();
                    System.out.print("Enter b = ");
                    b = sc.nextInt();
                    System.out.print("Enter c = ");
                    c = sc.nextInt();
                    if (a==0 && b==0 && c==0) {
                        System.out.println("There's nothing to be solved");
                    } else if (a==0 && b==0 && c!=0) {
                        System.out.println("The equation has no root");
                    } else if (a==0 && b!=0 && c!=0) {
                        System.out.println("There is one root x = " + -c/b);
                    } else if (b*b - 4*a*c < 0) {
                        System.out.println("The quation has no real root");
                    } else if (b*b - 4*a*c >0) {
                    x1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
                    x2 = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
                        System.out.println("There are two roots:");
                        System.out.println("x1 = " + x1);
                        System.out.println("x2 = " + x2);
                    }
                    break;
                case 4:
                int n1, z;
                System.out.print("Enter the size of triangle that you want (1-5): " + " n = ");
	            n1 = sc.nextInt();
	            while (n1 < 1 || n1 > 5) {
	            System.out.println("Sorry, but the size of triangle is from 1 to 5");
                    System.out.println("Enter the size of triangle that you want (1 <= n <= 5): " + " n = ");
	            n1 = sc.nextInt();
	            }
	            z = 0;
	            for (int j = n1; j > 0; j--) {
	                for (int k = 1; k < j; k++) {
		            System.out.printf("  ");
	                }
	            for (int k = 0; k <= z; k++) {
	            System.out.printf("*" + " ");
	            }
	            System.out.println();
	            z = z + 2;
	        }
                    break;
            } 
            if (function >= 1 && function <= 5) {
                System.out.println("Do you want to continue? (True/False)");
                Continue = sc.nextBoolean();
            } else if (function < 1 || function > 4) {
                System.out.println("Sorry, but you must choose the function from 1 to 4.");
                System.out.println("Do you want to continue? (True/False)");
                Continue = sc.nextBoolean();
            }
        } 
        System.out.println("Thank you!");
    }
}

/*
Student name:Ngo Quang Hieu
ID: 1901040077
Class: 2c19
Email:1901040077@s.hanu.edu.vn
*/
package ngoquanghieu_2c19_1901040077;
import java.util.Scanner;

public class ngoquanghieu {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("You chose 1");
                    Problem1();
                    break;
                case 2:
                    System.out.println("You chose 2");
                    Problem2();
                    break;
                case 3:
                    System.out.println("You chose  3");
                    Problem3();
                    break;
                case 4:
                    System.out.println("You chose 4");
                    Problem4();
                    break;
                case 0:
                    System.out.println("exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You should select from 0 to 4 only. ");
                    break;

            }
        }

    }

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     *
     * @author admin
     */
    public static void menu() {
        System.out.println("You can choose here :");
        System.out.println("1. Convert a decimal (base 10) integer to binary (base 2)");
        System.out.println("2. Compute a consecutive square root");
        System.out.println("3. Solve a quadratic equation");
        System.out.println("4. Print a triangle given its size");
        System.out.println("0. exit");

    }

    public static void Problem1() {
        System.out.println("Ask the user to enter an integer and print out its binary equivalent.");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int bin[] = new int[40];
        int index = 0;
        while (a > 0) {
            bin[index++] = a % 2;
            a = a / 2;
        }
        System.out.print("Binary "+a+ " is :");
        for (int i = index - 1; i >= 0; i--) {
            System.out.print( bin[i]);
            
        }
        System.out.println("\n");
    }

    public static void Problem2() {
        System.out.println("Ask the user to input two integers: m and n (1 ≤ n ≤ 5), then compute the"
                + "expression");
        System.out.println("Enter m");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n;
        do {
            System.out.println("Enter n");
            n = sc.nextInt();
        } while (n < 1 || n > 5);

        double result = 0;
        if (n == 1) {
            result = Math.sqrt(m);
        } else if (n == 2) {
            result = Math.sqrt(m + Math.sqrt(m));
        } else if (n == 3) {
            result = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m)));
        } else if (n == 4) {
            result = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m + Math.sqrt(m))));
        } else {
            result = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m + Math.sqrt(m) + Math.sqrt(m))));
        }
        System.out.println("Result : " + result);
    }

    public static void Problem3() {
        System.out.println("Ask the user to input 3 coefficients a, b and c, then solve the equation:");
        Scanner X = new Scanner(System.in);
        System.out.println("Enter a");
        double a = X.nextDouble();
        System.out.println("Enter b");
        double b = X.nextDouble();
        System.out.println("Enter c");
        double c = X.nextDouble();
        double sol1, sol2, sol3;
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("countless solutions");
                } else {
                    System.out.println("No solution");
                }
            } else {
                sol1 = -b / a;
                System.out.println("There's one solution which is" + sol1);
            }
        } else {
            sol3 = Math.pow(b, 2) - 4 * a * c;
            if (sol3 < 0) {
                System.out.println("No solution");
            } else if (sol3 == 0) {
                sol1 = -b / (2 * a);
                System.out.println("the Equation has double equations which is" + sol1);
            } else {
                sol1 = (-b + Math.sqrt(sol3)) / (2 * a);
                sol2 = (-b - Math.sqrt(sol3)) / (2 * a);
                System.out.println("The equation has two solutions which are different from each others");
                System.out.println(" + Solution 1 is " + sol1);
                System.out.println(" + Solution 2 is " + sol1);
            }
        }
    }

    public static void Problem4() {
         int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ask the user to input an integer n (1 ≤ n ≤ 5), then print the following\n"
                + "pattern:");
        do {
            System.out.print("Xin mời bạn nhập n:");
            n = sc.nextInt();
        } while (n < 1 || n > 5);
        for (int i = 1; i <= n; i++) {
            // phần 1
            for (int sp = n - i + 1; sp >= 1; sp--) {
                System.out.print(" ");
            }
            // phần 2
            for (int c = 1; c <= i; c++) {
                System.out.print("*");
            }
            // phần 3
            for (int c = i - 1; c >= 1; c--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }    
}

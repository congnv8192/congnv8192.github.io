/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.util.Scanner;

public class thienvan2c19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to my assignment work, below is the menu");
        String choice2 = "";
        do {
            System.out.println("Please choose one of the numbers that matches each excercise below (from 1 to 4 only):");
            System.out.println("1: Exercise 1");
            System.out.println("2: Exercise 2");
            System.out.println("3: Exercise 3");
            System.out.println("4: Exercise 4");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Exercise 1:");
                    System.out.print("Please enter an integer: ");
                    int j = sc.nextInt();
                    int n;
                    String s = "";
                    while (j > 0) {
                        n = (j % 2);
                        s = n + s;
                        j = (j / 2);
                    }
                    System.out.println("Binary equivalent: " + s);

                    System.out.println("Do you want to continue with the menu? Type Y for Yes or N for No");
                    choice2 = sc.nextLine();

                    break;

                case 2:
                    System.out.println("Exercise 2:");
                    System.out.print("Enter m: ");
                    int m = sc.nextInt();
                    System.out.print("Enter n (1 <= n <= 5): ");
                    int n1 = sc.nextInt();
                    double result;

                    if (n1 == 1) {
                        result = Math.sqrt(m);
                        System.out.println("A square root of " + m + " taken " + n1 + " times: " + result);
                    } else if (n1 == 2) {
                        result = Math.sqrt(m + Math.sqrt(m));
                        System.out.println("A square root of " + m + " taken " + n1 + " times: " + result);
                    } else if (n1 == 3) {
                        result = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m)));
                        System.out.println("A square root of " + m + " taken " + n1 + " times: " + result);
                    } else if (n1 == 4) {
                        result = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m + Math.sqrt(m))));
                        System.out.println("A square root of " + m + " taken " + n1 + " times: " + result);
                    } else if (n1 == 5) {
                        result = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m + Math.sqrt(m + Math.sqrt(m)))));
                        System.out.println("A square root of " + m + " taken " + n1 + " times: " + result);
                    } else {
                        System.out.println("Please enter n which follows condition.");
                    }

                    System.out.println("Do you want to continue with the menu? Type Y for Yes or N for No");
                    choice2 = sc.nextLine();
                    break;

                case 3:
                    System.out.println("Exercise 3:");

                    System.out.print("Enter coefficient a: ");
                    double a = sc.nextDouble();
                    System.out.print("Enter coefficient b: ");
                    double b = sc.nextDouble();
                    System.out.print("Enter coefficient c: ");
                    double c = sc.nextDouble();

                    if (a == 0 && b == 0 && c == 0) {
                        System.out.println("The equation has too many solutions.");
                    } else if (a == 0 && b == 0 && c != 0) {
                        System.out.println("The equation has no solution.");
                    } else if (a == 0 && b != 0 && c != 0) {
                        double x0 = -c / b;
                        System.out.println("The equation has one solution only: x = " + x0);
                    } else if (a != 0 && b != 0 && c != 0) {
                        if (b * b - 4 * a * c < 0) {
                            System.out.println("The equation has no solution.");
                        } else {
                            if (b * b - 4 * a * c > 0) {
                                double x1 = ((-b + Math.sqrt((b * b) - 4 * a * c)) / (2 * a));
                                double x2 = ((-b - Math.sqrt((b * b) - 4 * a * c)) / (2 * a));
                                System.out.println("The equation has two solutions: x1 = " + x1 + ", x2 = " + x2);
                            }
                        }
                    }
                    System.out.println("Do you want to continue with the menu? Type Y for Yes or N for No");
                    choice2 = sc.nextLine();
                    break;

                case 4:

                    System.out.println("Exercise 4:");
                    int rows,
                     col,
                     n2,
                     a2;
                    System.out.print("Enter integer n (1 <= n <= 5): ");
                    n2 = sc.nextInt();
                    a2 = n2;

                    for (rows = 1; rows <= n2; rows++) {
                        for (col = 1; col < a2; col++) {
                            System.out.print("  ");
                        }

                        a2--;

                        for (col = 1; col < 2 * rows; col++) {
                            System.out.print(" *");
                        }

                        System.out.println("");
                    }
                    System.out.println("Do you want to continue with the menu? Type Y for Yes or N for No");
                    choice2 = sc.nextLine();
                    break;

                default:
                    System.out.println("There are only four exercises.");
                    System.out.println("Do you want to continue with the menu? Type Y for Yes or N for No");
                    choice2 = sc.nextLine();
                    break;
            }
            System.out.print("~~> ");
            choice2 = sc.nextLine();
            if (choice2.equals("N") || choice2.equals("n")) {
                System.out.println("Goodbye!");
            }
        } 
        while (choice2.equals("Y") || choice2.equals("y"));
    }
}

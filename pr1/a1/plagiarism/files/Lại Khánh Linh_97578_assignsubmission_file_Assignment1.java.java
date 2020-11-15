/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentlinh;

import java.util.Scanner;

/**
 *
 * @author Lai Khanh Linh 1901040123
 */
public class AssignmentLinh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int a;
		while (true) {
			System.out.println("1. Convert a decimal (base 10) integer to binary (base 2).");
			System.out.println("2. Compute a consecutive square root.");
			System.out.println("3. Solve a quadratic equation.");
			System.out.println("4. Print a triangle given its size.");
			System.out.println("Choose one to do: ");
			Scanner sc = new Scanner(System.in);
			a = sc.nextInt();
			switch (a) {
                        case 1:
				int number, i = 0;
				int binary[] = new int[100];
				Scanner sc1 = new Scanner(System.in);
				System.out.print("Enter a decimal integer: ");
				number = sc1.nextInt();
				while (number != 0) {
					binary[i] = number % 2;
					number = number / 2;
					i++;
				}
				System.out.print("Binary value is : \n");
				for (int j = i - 1; j >= 0; j--) {
					System.out.print("" + binary[j]);
				}
				break;

			         
                        case 2:
				Scanner sc2 = new Scanner(System.in);
				int m, n;
				System.out.println(" Enter number m, n: ");
				m = sc2.nextInt();
				n = sc2.nextInt();
				double square = 0;
				for (int z = 1; z <= n; z++) {
					square = Math.sqrt(square + m);
				}
				System.out.println("Result: \n" + square);
				break;        
			case 3:
				Scanner sc3 = new Scanner(System.in);
				System.out.print("Input a: ");
				double d = sc3.nextDouble();
				System.out.print("Input b: ");
				double b = sc3.nextDouble();
				System.out.print("Input c: ");
				double c = sc3.nextDouble();
				double result = b * b - 4.0 * d * c;
				if (result > 0.0) {
					double r1 = (-b + Math.pow(result, 0.5)) / (2.0 * d);
					double r2 = (-b - Math.pow(result, 0.5)) / (2.0 * d);
					System.out.println("The roots are \n" + r1 + " and \n" + r2);
				} else if (result == 0.0) {
					double r1 = -b / (2.0 * d);
					System.out.println("The root is  \n" + r1);
				} else {
					System.out.println("The equation has no solution. \n");
				}

				break;

			case 4:
				int n1;
				Scanner sc4 = new Scanner(System.in);
				System.out.println("Please Enter a number");
				n1 = sc4.nextInt();
				if (n1 < 1 && n1 > 5) {
					System.out.println("Invalid number");
				} else {
					System.out.println("Triangle: ");
					int star = 1;
					int NumOfSpace = 4;
					for (int e = 1; e <= n1; e++) {
						for (int f = 1; f <= NumOfSpace; f++) {
							System.out.print(" ");
						}
						for (int g = 1; g <= star; g++) {
							System.out.print("*");
						}
						System.out.println();
						star = star + 2;
						NumOfSpace = NumOfSpace - 1;
					}
				}
				break;
                        default:
				System.out.println("Invalid number!");
			        }
			        System.out.println();
			        System.out.println(" Do you want to try another function? (Y/N)");

			        String answer = sc.next();
			        if (answer.equalsIgnoreCase("N")) {
				System.out.println("Thank you!");
                                }
				break;
			
			
			}
		}
	}
    
    


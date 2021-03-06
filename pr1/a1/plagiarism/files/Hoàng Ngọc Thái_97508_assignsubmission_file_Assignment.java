/*
 * Student: Hoàng Ngọc Thái
 * ID: 1901040197
 * MID-TERM PROJECT
 */

package Midterm;

import java.util.Scanner;
import java.io.*;
import static java.lang.Math.*;

public class Assignment {

	// Check input
	public static String Input(String message) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		int input_number = 0;
		while (!flag) {
			try {
				flag = true;
				System.out.print(message);
				String str = sc.nextLine();
				input_number = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out.println("Error: You must enter integer number not character.");
				Assignment obj = new Assignment();
				input_number = Integer.parseInt(obj.Input(message));
			}
		}
		return Integer.toString(input_number);
	}

	// EX1. Convert a decimal (base 10) integer to binary (base 2)
	public void convertBinary() {
		int binary_number[] = new int[100];
		Assignment obj = new Assignment();
		int decimal = Integer.parseInt(obj.Input("Ex1. Input a Decimal Number: "));
		int index = 0;

		while (decimal > 0) {
			binary_number[index++] = decimal % 2;
			decimal = decimal / 2;
		}
		String binary = "     Binary representation of decimal number is: ";
		for (int i = index - 1; i >= 0; i--) {
			binary = binary + Integer.toString(binary_number[i]);
		}
		System.out.println(binary);
	}

	// EX2. Compute a consecutive square root

	public static double square(int m, int n) {
		if (m == 0)
			return 0;
		if (n == 1)
			return (double) Math.sqrt(m);
		else
			return (double) Math.sqrt(m + square(m, n - 1));
	}

	public void ConsecutiveSquareRoot() {
		Scanner sc2 = new Scanner(System.in);
		Assignment obj = new Assignment();
		String str1, str2;
		int m, n;
		str1 = obj.Input("Ex2. Enter integer m: ");
		m = Integer.parseInt(str1);
		str2 = obj.Input("     Enter integer n (1 ≤ n ≤ 5): ");
		n = Integer.parseInt(str2);

		while (n >= 6 || n < 1) {
			str2 = obj.Input("Error: You must enter number n (1 <= n <= 5): ");
			n = Integer.parseInt(str2);
		}
		double sum = square(m, n);
		System.out.println("     Result: " + sum);
	}
     // Ex4
	public void triangle() {
		Scanner sc4 = new Scanner(System.in);
		Assignment obj4 = new Assignment();
		String str1;
		int HEIGHT;
		str1 = obj4.Input("Input an integer n(1 ≤ n ≤ 5): ");
		HEIGHT = Integer.parseInt(str1);
		System.out.println("The size of a triangle is: " + HEIGHT);
		String result = "";
		String space = "";
		String character = "";
		int line = 1;

		while (line <= HEIGHT) {
			space = "";
			character = "";
			for (int s = 1; s <= HEIGHT - line; s++)
				space += "  ";

			for (int c = 1; c <= 2 * line - 1; c++)
				character += "* ";

			result += space + character + "\n";
			line++;
		}
		System.out.println("Ex4. Result is: \n" + result + "\n");
	}

	// Main

	public static void main(String[] args) {
		int exercise = 0;
		Scanner sc = new Scanner(System.in);
		Assignment obj = new Assignment();

		while (exercise != 4) {
			try {
				System.out.println("[1] Convert a decimal (base 10) integer to binary (base 2)\r\n"
						+ "[2] Compute a consecutive square root\r\n" + "[3] Solve a quadratic equation\r\n"
						+ "[4] Print a triangle given its size\r\n" + "Choose an option to perform: ");
				exercise = (int) sc.nextInt();
			} catch (Exception e) {
				System.out.println("Error: You must enter number not character.");
				sc.nextLine();
			}

			switch (exercise) {
			case 1:
				obj.convertBinary();
				System.out.println("\n");
				break;
			case 2:
				obj.ConsecutiveSquareRoot();
				System.out.println("\n");
				break;
			case 3:
				// Ex3
				double a = 0, b = 0, c = 0;
				double root1, root2;
				Scanner sc3 = new Scanner(System.in);
				System.out.println("Ex3. Input a: ");
				a = sc3.nextDouble();
				System.out.println("Input b: ");
				b = sc3.nextDouble();
				System.out.println("Input c: ");
				c = sc3.nextDouble();
				
				double determinant = b * b - 4 * a * c;
				if (determinant > 0) {
					root1 = (-b + Math.sqrt(determinant)) / (2 * a);
					root2 = (-b - Math.sqrt(determinant)) / (2 * a);

					System.out.format("root1 = %.2f and root2 = %.2f \n", root1, root2);
				}
				else if (determinant == 0) {
					root1 = root2 = -b / (2 * a);

					System.out.format("root1 = root2 = %.2f; \n", root1);
				}
				else {
					double realPart = -b / (2 * a);
					double imaginaryPart = Math.sqrt(-determinant) / (2 * a);

					System.out.format("root1 = %.2f+%.2fi and root2 = %.2f-%.2fi \n", realPart, imaginaryPart, realPart,
							imaginaryPart);
				}
				break;
			case 4:
				obj.triangle();
				System.out.println("\n");
				break;
			default:
				System.out.println("Please! Enter a number in the list!!!\n");
				break;
			}
			char condition;
			System.out.println("Do you want to continue with another function? Enter:Y/N");
			condition = sc.next().charAt(0);
			sc.nextLine();

			if (condition == 'N' || condition == 'n') {
				System.out.println("Quit,goodbye!!!");
				break;
			} else if (condition == 'Y' || condition == 'y') {
				continue;
			} else {
				System.out.println("Please! Enter: Yes or No?");
				String answer = sc.nextLine();
				if (answer.equals("Yes") || answer.equals("yes") || answer.equals("Y") || answer.equals("y")) {
					continue;
				}
				if (answer.equals("No") || answer.equals("no") || answer.equals("n") || answer.equals("N")) {
					System.out.println("Goodbye!");
					break;
				}
			}
		}
	}
}

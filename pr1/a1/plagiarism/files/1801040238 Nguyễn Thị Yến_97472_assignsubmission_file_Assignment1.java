package a1;

import java.util.Scanner;

public class Assignment1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String repeat = null;
		int option;
		do {
			System.out.println("1: Convert a decimal integer to binary");
			System.out.println("2: Compute a consecutive square root");
			System.out.println("3: Solve quadratic equation");
			System.out.println("4: Print a triangle given it's size");
			System.out.println("Select a function you want: ");
			option = sc.nextInt();
			sc.nextLine();
			switch (option) { // Create a menu with switch/ case statement
			case 1:
				exercise1();
				break;
			case 2:
				exercise2();
				break;
			case 3:
				exercise3();
				break;
			case 4:
				exercise4();
				break;
			default:
				System.err.println("This function does not exist. Please select again.");
				break;
			}
			System.out.println("Do you want to continue with another function ? yes/ no");
			repeat = sc.nextLine();
		} while (repeat.equals("yes") == true);
	}

	// Convert a decimal (base 10) integer to binary (base 2)
	public static void exercise1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your number: ");
		int number = sc.nextInt();
		int a;
		String binaryNumber = "";
		while (number > 0) {
			a = number % 2;
			number = number / 2;
			binaryNumber = String.valueOf(a) + binaryNumber;
		}
		System.out.println("This number is written in binary form: " + binaryNumber);
	}

	// Compute a consecutive square root
	public static void exercise2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a number: ");
		double in = sc.nextInt();
		double st = in; // Stores the value of m into another variable
		System.out.println("How many times the square root is taken ?  (From 1 to 5)");
		int a = sc.nextInt();
		int x = 0;
		double result = 0;
		if (1 <= a && a <= 5) {
			while (x < a) {
				result = Math.sqrt(in);
				in = result + st;
				x++;
			}
			System.out.println("Result: " + result);
		} else {
			System.out.println("The number is not suitable to input");
		}
	}

	// Solve a quadratic equation
	public static void exercise3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter three coefficients");
		System.out.print("a = ");
		float a = sc.nextFloat();
		System.out.print("b = ");
		float b = sc.nextFloat();
		System.out.print("c = ");
		float c = sc.nextFloat();
		float delta = b * b - 4 * a * c;
		float x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
		float x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));

		if (a == 0 && b == 0 && c != 0 && delta < 0) {
			System.out.println("The equation has no solution ");
		} else if (a == 0 && b == 0 && c == 0) {
			System.out.println("The equation has infinitely many solutions");
		} else if (a == 0 && b != 0 && c != 0) {
			System.out.println("The equation has an unique solution x= " + -c / b);
		} else if (a != 0 && b != 0 && c != 0 && delta > 0) {
			System.out.println("The equation has two solutions: x1= " + x1 + "x2= " + x2);
		} else {
			System.out.println("The equation has double root: x = " + (-b) / (2 * a));
		}
	}

	// Print a triangle given its size
	public static void exercise4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Layer of trangular(An interge from 1 to 5)");
		int m, n, p, number;
		p = sc.nextInt();
		if (p >= 1 && p <= 5) {
			System.out.println("trangular: ");
			for (m = 0; m < p; m++) {
				for (n = 0; n <= 2 * p; n++) {
					if (n >= (p - 1 - m) && n <= (p - 1 + m)) {
						System.out.print(" * ");
					} else {

						System.out.print("   ");
					}
				}
				System.out.println("");
			}

		} else {
			System.out.println("The number is not suitable!");

		}
	}
}

package BuiThiHanh_1C18_1801040073_A1;

import java.util.Scanner;

/**
 *
 * @BùiTh?H?nh1C18
 */
public class BuiThiHanh_1C18_1801040073_A1 {

	/**
	 * @param args the command line arguments
	 */
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
			switch (option) {
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
				System.out.println("This function does not exist. Please select again.");
				break;
			}
			System.out.println("Do you want to continue with another function ? yes/ no");
			repeat = sc.nextLine();
		} while (repeat.equals("yes") == true);
	}

	public static void exercise1() {
		Scanner sc = new Scanner(System.in);
		int decimal, binary;
		System.out.println("Please enter a decimal number:");
		decimal = sc.nextInt();

		do {
			binary = decimal % 2;
			System.out.print(binary);
		} while ((decimal /= 2) != 0);// (decimal = decimal / 2) != 0
		System.out.println("");
	}

	public static void exercise2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a number: ");
		double in = sc.nextInt();
		double t = in;
		System.out.println("How many times the square root is taken ? (From 1 to 5)");
		int n = sc.nextInt();
		int x = 0;
		double result = 0;
		if (1 <= n && n <= 5) {
			while (x < n) {
				result = Math.sqrt(in);
				in = result + t;
				x++;
			}
			System.out.println("Result: " + result);

		} else {
			System.out.println("The number you input is not in range");
		}

	}

	public static void exercise3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter three coefficients");
		System.out.print("a = "); // Compute a quadratic equation.
		float a = sc.nextFloat();
		System.out.print("b = ");
		float b = sc.nextFloat();
		System.out.print("c = ");
		float c = sc.nextFloat();
		float delta = b * b - 4 * a * c;
		float x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
		float x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));

		if (a == 0 && b == 0 && c != 0 && delta < 0) {
			System.out.println("the equation has no solution ");
		} else if (a == 0 && b == 0 && c == 0) {
			System.out.println("the equation has infinitely many solution");
		} else if (a == 0 && b != 0 && c != 0) {
			System.out.println("the equation has an unique solution x=" + -c / b);
		} else if (a != 0 && b != 0 && c != 0 && delta > 0) {
			System.out.println("The equation has two solutions: x1= " + x1 + "x2= " + x2);
		} else {
			System.out.println("The equation has double root: x = " + (-b) / (2 * a));
		}
	}

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

		}

		else {
			System.out.println("The number is not suitable!");

		}
	}
}

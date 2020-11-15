package tut;

import java.util.Scanner;

public class assignmentmid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		while (true) { // loop menu
			System.out.println("[1] Task 1");
			System.out.println("[2] Task 2");
			System.out.println("[3] Task 3");
			System.out.println("[4] Task 4");
			System.out.println("Enter your choice");
			Scanner sc = new Scanner(System.in);
			a = sc.nextInt();
			// Receive user input
			;

			switch (a) {
			case 3:
				Scanner sc3 = new Scanner(System.in);
				System.out.print("Input a: ");
				double d = sc3.nextDouble();
				System.out.print("Input b: ");
				double b = sc3.nextDouble();
				System.out.print("Input c: ");
				double c = sc3.nextDouble();
				double result = b * b - 4.0 * d * c;// calculate
				if (result > 0.0) {// if there are 2 results
					double r1 = (-b + Math.pow(result, 0.5)) / (2.0 * d);
					double r2 = (-b - Math.pow(result, 0.5)) / (2.0 * d);
					System.out.println("The roots are \n" + r1 + " and \n" + r2);
				} else if (result == 0.0) { // 1 results
					double r1 = -b / (2.0 * d);
					System.out.println("The root is  \n" + r1);
				} else {// if there are no answer
					System.out.println("The equation has no real roots. \n");
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
					System.out.println("Pattern : ");
					int star = 1;// print the amount of star from the first row
					int NumOfSpace = 4;// the amount of space in the first row
					for (int e = 1; e <= n1; e++) {
						for (int f = 1; f <= NumOfSpace; f++) { // print the white backspace
							System.out.print(" ");
						}
						for (int g = 1; g <= star; g++) { // print the star and white background
							System.out.print("*");
						}
						System.out.println();
						star = star + 2;// the star + 2 by every single row
						NumOfSpace = NumOfSpace - 1; // the space get -1 by every single row
					}
				}
				break;
			case 2:
				Scanner sc2 = new Scanner(System.in);
				int m;
				System.out.println(" Enter your number m: ");
				m = sc2.nextInt();
				int n;
				System.out.println(" Enter your number n: ");
				n = sc2.nextInt();
				double square = 0;
				for (int i = 1; i <= n; i++) {
					square = Math.sqrt(square + m); // wrap square with m ( n times)
				}
				System.out.println("Result: \n" + square);
				break;
			case 1:
				int number, i = 0;
				int binary[] = new int[100];
				Scanner sc1 = new Scanner(System.in);
				System.out.print("Enter decimal number: ");
				number = sc1.nextInt();
				while (number != 0) {
					binary[i] = number % 2;// operation
					number = number / 2;
					i++;
				}
				System.out.print("Binary value is : \n");
				for (int j = i - 1; j >= 0; j--) {
					System.out.print("" + binary[j]);
				}
				break;

			default:
				System.out.println("Not a valid number");
			}
			System.out.println();
			System.out.println(" Do you want continue with another function? Y/N");// ask the user if they want to
																					// continue with another function

			String answer = sc.next();
			if (answer.equalsIgnoreCase("N")) { // allow the answer to be in upper or lower case
				System.out.println("Quitting");
				break;
			}
		}
	}
}

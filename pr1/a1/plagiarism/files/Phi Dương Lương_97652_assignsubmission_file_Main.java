package com.rain.assignmenthanu;

import java.util.Scanner;

/**
 * 
 * @author RainVN
 *
 */

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static Scanner sc2;

	// main method used to cast 2 sub-method
	public static void main(String[] args) {
		showSelectionMenu();
		gatheringInput();
	}

	private static void executeProgram1() {
		try {
			System.out.println("Enter your number for convert: ");
			int tempInt = sc.nextInt();
			String converted = "";
			if (tempInt <= 0)
				System.err.println("Only number > 0 !!");
			while (tempInt > 0) {
				converted = ((tempInt % 2) == 0 ? "0" : "1") + converted;
				tempInt = tempInt / 2;
			}
			System.out.println(converted);
		} catch (Exception InputMismatchException) {
			System.err.println("Out of integer memory!!");
		}
		showConfirmDialog();
	}

	private static void executeProgram2() {
		System.out.println("Enter number (m):");
		int m = sc.nextInt();
		if (m < 0) {
			System.err.println("Error with your input, m should be positive!");
			executeProgram2();
		}
		System.out.println("Enter loop times (n):");
		int n = sc.nextInt();
		if (!(n >= 1 && n <= 5)) {
			System.err.println("Invalid n, try again!");
			executeProgram2();
		}
		double rs = 0;
		for (int i = 1; i <= n; i++) {
			rs = Math.sqrt(m + rs);
		}
		System.out.println(rs);
		showConfirmDialog();
	}

	private static void executeProgram3() {
		System.out.print("Quadratic equation form: ax^2 + bx + c = 0 " + "\nEnter a: ");
		int a = sc.nextInt();
		System.out.print("Enter b: ");
		int b = sc.nextInt();
		System.out.print("Enter c: ");
		int c = sc.nextInt();

		if (a == 0 && b == 0 && c == 0) {
			System.out.println("The equation has many solutions");
		} else if (a == 0 && b != 0 && c != 0) {
			System.out.println("x=" + -c / b);
		} else if (a == 0 && b == 0 && c != 0) {
			System.out.println("The equation has no solution");
		}

		double delta = Math.pow(b, 2) - 4 * a * c;
		double r1 = (-b + Math.sqrt(delta)) / (2 * a);
		double r2 = (-b - Math.sqrt(delta)) / (2 * a);

		System.out.println(delta == 0 ? "x=" + r1
				: delta > 0 ? "The equation has 2 roots" + "\nroot 1 = " + r1 + " and " + "root 2 = " + r2
						: "The equation has no solution");
		showConfirmDialog();
	}

	private static void executeProgram4() {
		System.out.println("Enter row: ");
		int row = sc.nextInt();
		if (row > 20) {
			System.err.println("Becareful, the triangle will be too big to show in Console");
			executeProgram4();
		} else if (row <= 0) {
			System.err.println("Check your input again");
			executeProgram4();
		}
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= row - i; j++) {
				System.out.print("   ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*  ");
			}
			System.out.println("\n");
		}
		showConfirmDialog();
	}

	// Menu method
	private static void showSelectionMenu() {
		System.out.println(
				"\n=====================================\nChoose program to run: " + "\n[1] Convert int to binary "
						+ "\n[2] Compute consecutive square root" + "\n[3] Solve quadratic equation"
						+ "\n[4] Draw triangle" + "\n[5] Quit program" + "\n=====================================");
	}

	// Separate from menu to reuse for recursion
	// Try/catch used for catching exception in whole program
	private static void gatheringInput() {
		try {
			System.out.println("\nEnter your choice:");
			sc2 = new Scanner(System.in);
			int selection = sc2.nextInt();
			switch (selection) {
			case 1:
				executeProgram1();
			case 2:
				executeProgram2();
			case 3:
				executeProgram3();
			case 4:
				executeProgram4();
			case 5:
				System.out.println("Closed program!! Goodbye <3 ");
				System.exit(0);
			default:
				System.err.println("Wrong input, only int number 1,2,3 or 4");
				gatheringInput();
			}
		} catch (Exception e) {
			System.err.println("\nWrong input! Try again please");
			gatheringInput();
		}
	}

	// Show a confirm message in console, Y/N or y/n are acceptable
	private static void showConfirmDialog() {

		sc = new Scanner(System.in);
		System.out.println("Choose another function? Y/N");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("Y")) {
			showSelectionMenu();
			gatheringInput();
		} else if (choice.equalsIgnoreCase("N")) {
			System.out.println("Closed program!! Goodbye <3 ");
			System.exit(1);
			sc.close();
		} else {
			System.err.println("Wrong input, only Y or N!");
			showConfirmDialog();
		}
	}

}

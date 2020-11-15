package javaplayground1;

import java.util.Scanner;

public class Assignment1_MidTermProject {

	public static class Main {
		private static Scanner sc = new Scanner(System.in);
		private static Scanner sc2;

		// This main method will be used to cast 2 sub-method: Menu and Input
		public static void main(String[] args) {
			showSelectionMenu();
			gatherInput();
		}

		
		// Menu method
				private static void showSelectionMenu() {
					System.out.println(
							"\n**************************************\n"
							+ "Please choose program to run: " 
									+"\n[1] Convert decimal number to binary "
									+ "\n[2] Compute consecutive square root" 
									+ "\n[3] Solve quadratic equation"
									+ "\n[4] Draw triangle" 
									+ "\n[5] Quit program" 
									+ "\n**************************************");
				}

				
				
				
				
				private static void gatherInput() {
					try {               
						System.out.println("Please enter your choice:");
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
							System.out.println("Closed program! Goodbye and see you next time <3 ");
							System.exit(0);
						default:
							System.err.println("Wrong input, please only enter number 1, 2, 3 or 4");
							gatherInput();
						}
					} catch (Exception e) {
						System.err.println("\nWrong input! Try again please: ");
						gatherInput();
					}
				}

				// This method will show a confirm message in console, Y/N or y/n are acceptable
				private static void showConfirmDialog() {

					sc = new Scanner(System.in);
					System.out.println("Choose another function? Y/N");
					String choice = sc.nextLine();
					if (choice.equalsIgnoreCase("Y")) {
						showSelectionMenu();
						gatherInput();
					} else if (choice.equalsIgnoreCase("N")) {
						System.out.println("Program closed! Goodbye and see you next time <3 ");
						System.exit(1);
						sc.close();
					} else {
						System.err.println("Wrong input, please enter only Y or N!");
						showConfirmDialog();
					}
				}
		private static void executeProgram1() {
			try {
				System.out.println("Enter your decimal number for convert: ");
				int dec = sc.nextInt();
				String converted = "";
				if (dec <= 0)
					System.err.println("Please only choose positive number (> 0) !!");
				while (dec > 0) {
					converted = ((dec % 2) == 0 ? "0" : "1") + converted;
					dec = dec / 2;
				}
				System.out.println(converted);
			} catch (Exception InputMismatchException) {
				System.err.println("Out of integer memory!!");
			}
			showConfirmDialog();
		}

		private static void executeProgram2() {
			System.out.println("PLease enter number (m):");
			int m = sc.nextInt();
			if (m < 0) {
				System.err.println("Error with your input, m should be positive!");
				executeProgram2();
			}
			System.out.println("Please enter loop times (n):");
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
			System.out.print("Quadratic equation form: ax^2 + bx + c = 0 ") 
			System.out.println( "Enter a: ");
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
					: delta > 0 ? "The equation has 2 roots" 
					+ "\nroot 1 = " + r1 + " and " 
					+ "root 2 = " + r2
							: "The equation has no solution");
			showConfirmDialog();
		}

		private static void executeProgram4() {
			System.out.println("Please enter number of row(s): ");
			int row = sc.nextInt();
			if (row > 5) {
				System.err.println("Be careful, the triangle will be too big to show ");
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

		
	}
	}
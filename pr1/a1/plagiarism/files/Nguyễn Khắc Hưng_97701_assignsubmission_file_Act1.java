/* Nguyen Khac Hung-7c19
 * 
 * ID student: 1901040102*/
package midterm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Act1 {

	public static void main(String[] args) {
		boolean CONTINUE = true;
		Scanner sc = new Scanner(System.in);
		while (CONTINUE == true) {
			System.out.println("***********Menu***********");
			System.out.println("1. Convert decimal (base 10) integer to binary (base 2)");
			System.out.println("2. Compute a consecutive square root");
			System.out.println("3. Solve a quadratic equation");
			System.out.println("4. Print a triangle given its size");
			System.out.println(".......................................................");
			int option = 0;
			boolean ktra = false;
			while (ktra == false) {
				try {
					System.out.print("Please enter a function which you want to choose: ");
					option = sc.nextInt();
					ktra = true;
				} catch (Exception e) {
					System.err.println("You must enter a number!");
					sc.nextLine();
				}
			}
			switch (option) {
			case 1:
				int x = 0;
				boolean check = false;
				while (check == false) {
					try {
						System.out.print("Enter an integer: ");
						x = sc.nextInt();
						check = true;
					} catch (Exception e) {
						System.err.println("You must enter a integer!");
						sc.nextLine();
					}
				}
				System.out.print("Binary representation of " + x + " : ");
				System.out.println(Integer.toBinaryString(x));
				break;
			case 2:
				int n = 0, m = 0;
				boolean xem = false;
				while (xem == false) {
					try {
						System.out.print("Enter n (1 <= n <= 5): ");
						n = sc.nextInt();
						System.out.print("Enter m: ");
						m = sc.nextInt();
						xem = true;
					} catch (Exception e) {
						System.err.println("You must enter a integer!");
						sc.nextLine();
					}
				}
				double ket_qua = Math.sqrt(m);
				while (n < 1 || n > 5) {
					System.err.print("You have to enter n value in the range [1;5]: ");
					System.out.print("Enter n: ");
					n = sc.nextInt();
				}
				for (int i = 1; i <= n; i++) {
					ket_qua = Math.sqrt(ket_qua + m);
				}
				System.out.println(ket_qua);
				break;
			case 3:
				double a = 1, b = 2, c = 3;
				boolean CHECK = false;
				while (CHECK == false) {
					try {
						System.out.print("Enter a: ");
						a = sc.nextDouble();
						System.out.print("Enter b: ");
						b = sc.nextDouble();
						System.out.print("Enter c: ");
						c = sc.nextDouble();
						CHECK = true;
					} catch (Exception e) {
						System.err.println("You must enter a integer!");
						sc.nextLine();
					}
				}
				if (a == 0) {
					if (b == 0) {
						if (c == 0)
							System.out.println("There's nothing to be solved.");
						else
							System.out.println("No solution");
					} else {
						double H = -c / b;
						System.out.println("The equation has one root: x = " + H);
					}
				} else {
					double delta = Math.pow(b, 2) - 4 * a * c;
					if (delta < 0)
						System.out.println("No solution");
					else if (delta == 0) {
						double H = -b / (2 * a);
						System.out.println("The equation has one root: x = " + H);
					} else {
						double x1 = (-b + Math.sqrt(delta)) / (2 * a);
						double x2 = (-b - Math.sqrt(delta)) / (2 * a);
						System.out.println("The equation has two roots: x1 = " + x1 + " x2 = " + x2);
					}
				}
				break;
			case 4:
				int r = 0;
				boolean KQUA = false;
				while (KQUA == false) 
				{
					try 
					{
						System.out.print("Enter n (1 <= n <= 5): ");
						r = sc.nextInt();
						while (r < 1 || r > 5) {
							System.err.println("You have to enter n value in the range [1;5]: ");
							System.out.print("Enter n: ");
							r = sc.nextInt();
						}
						KQUA = true;
					} catch (Exception e) {
						System.err.println("You must enter a integer!");
						sc.nextLine();
					}
				}
				String q = "";
				String w = "*";
				String e = "";
				for (int i = 0; i < r; i++) {
					q = q + " ";
				}
				for (int i = 0; i < r; i++) 
				{
					q = q.substring(q.length() - r + 1) + w;
					System.out.println(q + e);
					e = e + w;
				}
				break;
			default:
				System.err.println("Invalid option! please retype!");
				continue;
			}
			System.out.println("Do you want to continue (yes or no) ?");
			String nkh = sc.next();
			boolean NKH = false;
			while (NKH == false) 
			{
				if (nkh.equalsIgnoreCase("yes")) {
					NKH = true;
				} else if (nkh.equalsIgnoreCase("no")) 
				{
					CONTINUE = false;
					System.out.println("Goodbye !");
					NKH = true;
				} else {

					System.err.println("Enter again!");
					System.out.println("Do you want to continue (yes or no) ?");
					nkh = sc.next();
				}
			}

		}
	}
}

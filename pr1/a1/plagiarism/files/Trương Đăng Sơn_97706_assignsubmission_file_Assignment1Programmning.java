import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment1Programmning {
	public static void main(String[] args) {
		boolean tiep_tuc = true;
		Scanner sc = new Scanner(System.in);
		while (tiep_tuc == true) 
		{
			System.out.println(">>>>>>>>>Menu<<<<<<<<<");
			System.out.println("1. Convert decimal (base 10) integer to binary (base 2)");
			System.out.println("2. Compute a consecutive square root");
			System.out.println("3. Solve a quadratic equation");
			System.out.println("4. Print a triangle given its size");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<");
			int option = 0;
			boolean j = false;
			while (j == false) 
			{
				try 
				{
					System.out.print("Please choose a function: ");
					option = sc.nextInt();
					j = true;
				} 
				catch (Exception e) 
				{
					System.err.println("You need enter a number");
					sc.nextLine();
				}
			}
			if (option == 1) 
			{
				int x = 0;
				boolean kiem_tra = false;
				while (kiem_tra == false) 
				{
					try 
					{
						System.out.print("Enter an integer:");
						x = sc.nextInt();
						kiem_tra = true;
					} 
					catch (Exception e) 
					{
						System.err.println("You need enter a integer");
						sc.nextLine();
					}
				}
				System.out.print("base 2 of " + x + " : ");
				System.out.println(Integer.toBinaryString(x));
				continue;
			}
			if (option == 2) 
			{
				int n = 0, m = 0;
				boolean xet = false;
				while (xet == false) 
				{
					try 
					{
						System.out.print("Enter n (n in [1;5]):");
						n = sc.nextInt();
						System.out.print("Enter m: ");
						m = sc.nextInt();
						xet = true;
					} 
					catch (Exception e) 
					{
						System.err.println("You need enter a integer!");
						sc.nextLine();
					}
				}
				double ket_qua = Math.sqrt(m);
				while (n < 1 || n > 5) 
				{
					System.err.print("You need enter n value in [1;5]:");
					System.out.print("Enter n:");
					n = sc.nextInt();
				}
				for (int i = 1; i <= n; i++) 
				{
					ket_qua = Math.sqrt(ket_qua + m);
				}
				System.out.println(ket_qua);
				continue;
			}
			if (option == 3) 
			{
				double a = 1, b = 2, c = 3;
				boolean abb = false;
				while (abb == false) 
				{
					try 
					{
						System.out.print("Enter a:");
						a = sc.nextDouble();
						System.out.print("Enter b:");
						b = sc.nextDouble();
						System.out.print("Enter c:");
						c = sc.nextDouble();
						abb = true;
					} 
					catch (Exception e) 
					{
						System.err.println("You need enter a integer!");
						sc.nextLine();
					}
				}
				if (a == 0) 
				{
					if (b == 0) 
					{
						if (c == 0)
							System.out.println("There's nothing to be solved.");
						else
							System.out.println("The equation has no solution!");
					} 
					else 
					{
						double s = -c / b;
						System.out.println("The equation has one solution: x = " + s);
					}
				} 
				else 
				{
					double delta = Math.pow(b, 2) - 4 * a * c;
					if (delta < 0)
						System.out.println("No solution");
					else if (delta == 0) 
					{
						double s = -b / (2 * a);
						System.out.println("The equation has one root: x = " + s);
					} 
					else 
					{
						double x1 = (-b + Math.sqrt(delta)) / (2 * a);
						double x2 = (-b - Math.sqrt(delta)) / (2 * a);
						System.out.println("The equation has two roots: x1 = " + x1 + " x2 = " + x2);
					}
				}
				continue;
			}
			if (option == 4) 
			{
				int son = 0;
				boolean psg = false;
				while (psg == false) 
				{
					try 
					{
						System.out.print("Enter n (n in [1;5]):");
						son = sc.nextInt();
						while (son < 1 || son > 5) 
						{
							System.err.println("You have to enter n value in the range [1;5]: ");
							System.out.print("Enter n: ");
							son = sc.nextInt();
						}
						psg = true;
					} 
					catch (Exception e) 
					{
						System.err.println("You need enter a integer");
						sc.nextLine();
					}
				}
				String a = "";
				String b = "*";
				String c = "";
				for (int i = 0; i < son; i++) 
				{
					a = a + " ";
				}
				for (int i = 0; i < son; i++) 
				{
					a = a.substring(a.length() - son + 1) + b;
					System.out.println(a + c);
					c = c + b;
				}
			}
			else 
			{
				System.err.println("dont have the option! try again!");
				continue;
			}
			System.out.println("choose yes/no to continue/end");
			String tds = sc.next();
			boolean srm = false;
			while (!srm) 
			{
				if (tds.equalsIgnoreCase("yes")) 
				{
					srm = true;
				} 
				else if (tds.equalsIgnoreCase("no")) 
				{
					tiep_tuc = false;
					System.out.println("End!");
					srm = true;
				}
				else 
				{

					System.err.println("Enter again!");
					System.out.println("choose yes/no to continue/end");
					tds = sc.next();
				}
			}
		}
		sc.close();
	}
}

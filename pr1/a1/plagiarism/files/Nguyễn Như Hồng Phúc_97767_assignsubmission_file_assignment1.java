package midtermproject;

/**
 *Author : Nguyen Nhu Hong Phuc 
 * Class: 7C19 Tut:  01.05
 * Student ID:1901040159
 * 
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class assignment1 {
    public static void main(String[] args) {
		
		   	boolean Continue = true;
		Scanner sc = new Scanner(System.in);
		while(Continue == true)
		{
			System.out.println("Please choose which function to perform:");
			System.out.println("__________________Menu_________________ ");
			System.out.println("1. Convert a decimal integer to binary");
			System.out.println("2. Compute a consecutive square root");
			System.out.println("3. Solve a quadratic equation");
			System.out.println("4. Print a triangle given its size");
			System.out.println("_______________________________________");
			int option = 0;
			boolean check= false;
			while(!check)
			{
				try
				{
					System.out.print("Function you want to choose: ");
					option = sc.nextInt();
					check= true;
				}
				catch(InputMismatchException e)
				{
					System.err.println("You have to enter the number!");
					
					sc.nextLine(); 
				}
			}
			if(option == 1)
			{
				task1();
				
			}
			else if(option == 2 )
			{
				task2();
				
			}
			else if(option == 3)
			{
				task3();
			}
			else if( option == 4)
			{
				task4();
			}
			else
			{
				 System.err.println("Invalid option! Retype!");
		            continue;
			}
			System.out.println("Do you want to continue(yes or no)?");
            String tmp = sc.next();
            boolean test = false;
            while(!test)
            {
	            if (tmp.equalsIgnoreCase("yes")) 
	            {
	            	test= true;
	            } 
	            else if (tmp.equalsIgnoreCase("no")) 
	            {
	                Continue = false;
	                System.out.println("Goodbye !");
	                test= true;
	            }
	            else 
	            {
	                
	                 System.err.println("Enter again!");
	                 System.out.print("Do you want to continue(yes or no)?");
	                 tmp = sc.next();         
	            } 
            }
			
		}
		sc.close();
	}
		public static void task1() 
		{
		System.out.println("1. Convert a decimal integer to binary");
		Scanner sc= new Scanner(System.in);
		int n =-1;
		boolean check = false;
		while(!check)
		{
			try
			{
				System.out.print("Enter Decimal Number: ");
				n = sc.nextInt();
				check= true;
			}
			catch(InputMismatchException e)
			{
				System.err.println("You have to enter the integer!");
				sc.nextLine();
			}
		}
		System.out.print(n+ " is represented in binary as: ");
		System.out.println(Integer.toBinaryString(n));
	}



	public static void task2() {
		System.out.println("2. Compute a consecutive square root");
		Scanner sc= new Scanner(System.in);
		int n = -1 , m = -1;
		boolean check= false;
		while( !check)
		{
			try
			{
				System.out.print("Enter m: ");
				m = sc.nextInt();
				System.out.println("Enter n, (1<= n <= 5): ");
				n= sc.nextInt();
				check = true;
			}
			catch(InputMismatchException e)
			{
				System.err.println("You have to enter the integer!");
				sc.nextLine(); 
			}
		}
		double s= Math.sqrt(m);
		while(n < 1 || n > 5)
		{
			System.err.println("You must enter n with 1<= n <=5.");
			System.out.print("  Enter n: ");
			n = sc.nextInt();
		}
		for( int i = 1; i < n ; i++)
		{
			s=Math.sqrt(m+s);
		}
		System.out.println(s);
	}
	public static void task3() {
			System.out.println("3. Solve a quadratic equation");
		Scanner sc = new Scanner(System.in);
		double a =-1,b=-1,c=-1;
		boolean check = false;
		while(!check)
		{
			try 
			{
				System.out.print("Enter a: ");
				a = sc.nextDouble();
				System.out.print("Enter b: ");
				b = sc.nextDouble();
				System.out.print("Enter c: ");
				c = sc.nextDouble();
				check= true;
			}
			catch ( InputMismatchException e)
			{
				System.err.println("You have to enter the number!");
				sc.nextLine();
			}
		}
		if(a==0)
		{
			if(b==0)
			{
				if(c==0)
				{
					System.out.println("There's nothing to be solved.");
				}
				else
				{
					System.out.println("The equation has no root.");
				}
			}
			else
			{
				System.out.println("There is one root: x= " + -c/b);
			}
		}
		else
		{
			double e= Math.pow(b, 2) - 4*a*c;
			if(e < 0)
			{
				System.out.println("The equation has no root.");
			}
			else
			{
				if(e==0)
				{
					System.out.println("The equation has a solution: x= " + -b/(2*a));
				}
				else
				{
					double x1 = (-b + Math.sqrt(e))/ (2*a);
					double x2 = (-b - Math.sqrt(e))/ (2*a);
					System.out.print("The equation has solution: x1= " + x1 + ", ");
					System.out.println("x2= " + x2);
				}
			}
				
		}
}
			
	public static void task4() {
		System.out.println("4. Print a triangle given its size");
		Scanner sc = new Scanner(System.in);
		int n=-1;
		boolean check = false;
		while(!check)
		{
			try
			{
				System.out.print("Enter n (1 <= n <= 5): ");
				n = sc.nextInt();
				while( n < 1 || n > 5)
				{
					System.err.println("You must enter n with 1<= n <=5.");
					System.out.print("  Enter n: ");
					n = sc.nextInt();
				}
				check = true;
			}
			catch(InputMismatchException e)
			{
				System.err.println("You must enter the integer!");
				sc.nextLine();
			}
		}
		String d = "";
		String e = "*";
		String f = "";
		for(int i = 0; i < n; i++)
		{
			d = d+ " ";
			
		}
		for( int i = 0; i < n ; i++ )
		{
			
			d = d.substring(d.length() - n + 1 ) + e ;
			System.out.println(d + f);
			f = f + "*"; 
		}
	}

}

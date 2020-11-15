import java.util.Scanner;

public class problem3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap a :");
		double a = sc.nextDouble();
		System.out.println("nhap b :");
		double b = sc.nextDouble();
		System.out.println("nhap c :");
		double c = sc.nextDouble();

		double d = b * b - 4 * a * c;

		double x1 = (-b + Math.sqrt(d)) / 2 * a;
		double x2 = (-b - Math.sqrt(d)) / 2 * a;
		if (a == 0) {
			double x = -c / b;
			System.out.println("x = " + x + "");
		}

		else if (d < 0) {
			System.out.println("equation has no solution");
		} else {
			System.out.println(" x1 = " + x1 + ",x2 = " + x2 + "");
		}

	}
}

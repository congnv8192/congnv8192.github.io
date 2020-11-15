
import java.util.Scanner;

/**
 *
 * @author Ngô Ánh Tuyết_8C19_1901040196_A1
 */
public class Assignment1 {

    public static void decimalToBinary() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input an integer: ");
        int dec = sc.nextInt();
        int binaryNum[] = new int[1000];
        System.out.println("The binary number of " + dec + " is: ");
        int stt = 0;
        while (dec != 0) {
            binaryNum[stt] = dec % 2;
            dec = dec / 2;
            stt++;
        }
        for (int lap = stt - 1; lap >= 0; lap--) {
            System.out.print(binaryNum[lap]);
        }
        System.out.println();
    }

    public static void squareRoot() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer m: ");
        double m = sc.nextDouble();
        double store = m;
        System.out.println("The times the square root is taken between 1 and 5: ");
        int n = sc.nextInt();
        int lan = 0;
        double resultSqrt = 0;

        while (n < 1 || n > 5) {
            System.err.println("Not allowed! Please re-enter the times: ");
            n = sc.nextInt();
        }

        if (1 <= n && n <= 5) {
            while (lan < n) {
                resultSqrt = Math.sqrt(m);
                m = store + resultSqrt;
                lan++;
            }
            System.out.println("The result is: " + resultSqrt);
        }
    }

    public static void quadraticEquation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a: ");
        double a = sc.nextDouble();
        System.out.println("Input b: ");
        double b = sc.nextDouble();
        System.out.println("Input c: ");
        double c = sc.nextDouble();

        if (a == 0 && b == 0 && c == 0) {
            System.out.println("There is noting to be solved!");
        } else if (a == 0 && b == 0 && c != 0) {
            System.out.println("The equation has no root!");
        } else if (a == 0 && b != 0 && c != 0) {
            double x = -c / b;
            System.out.println("There is one root: x = " + x);
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("The equation has no real root!");
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("There are two roots: ");
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }

    public static void triangleGivenSize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer in the range [1.5]: ");
        int n = sc.nextInt();

        while (n < 1 || n > 5) {
            System.err.println("Not allowed! Please enter an integer (From 1 to 5): ");
            n = sc.nextInt();
        }

        if (n >= 1 && n <= 5) {
            for (int k = 0; k < n; k++) {                               //Number of rows
                for (int i = k; i < n - 1; i++) {                         //Number of space each row
                    System.out.print(" ");
                }
                for (int j = 0; j < k * 2 + 1; j++) {                   //Number of star each row
                    System.out.print("*");
                }
                System.out.println();                               //Make a new line for each level
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        while (choose != 5) {
            try {
                System.out.println("Please choose your option: ");
                System.out.println("[1] - Convert a decimal (base 10) to binary (base 2)");
                System.out.println("[2] - Consecutive square root");
                System.out.println("[3] - Solve a quadric equation");
                System.out.println("[4] - Print a triangle given its size");
                System.out.println("[5] - Exit the program");
                choose = sc.nextInt();

                while (!(choose >= 1 && choose <= 5)) {
                    Exception e = new Exception("Not allowed! ");
                    throw e;
                }
            } catch (Exception e) {
                while (choose < 1 || choose > 5) {
                    System.err.println(e.getMessage() + "Please choose again: ");
                    choose = sc.nextInt();
                }
            }
            switch (choose) {
                case 1:
                    decimalToBinary();
                    break;
                case 2:
                    squareRoot();
                    break;
                case 3:
                    quadraticEquation();
                    break;
                case 4:
                    triangleGivenSize();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }

    }
}

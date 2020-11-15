/* NAME : PHAM VAN BAO
 * ID   : 1901040030
 * CLASS: 7C19
 */
package midterm.assignment;

import java.util.Scanner;

public class PhamVanBao_1901040030_7C19 {
    public static String input(String message) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int input_number = 0;
        while (!flag) {
            try {
                flag = true;
                System.out.println(message);
                String str = sc.nextLine();
                input_number = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Error: You only enter integer number.");
                input_number = Integer.parseInt(PhamVanBao_1901040030_7C19.input(message));
            }
        }
        return Integer.toString(input_number);
    }

    // EX1. Convert a decimal (base 10) integer to binary (base 2)
    public void convertBinary() {
        int binary_number[] = new int[100];
        System.out.println("Ex1: ");
        int decimal = Integer.parseInt(PhamVanBao_1901040030_7C19.input("-Input a Decimal Number: "));
        int index = 0;

        while (decimal > 0) {
            binary_number[index++] = decimal % 2;
            decimal = decimal / 2;
        }
        String binary = "-Binary representation of decimal number is: ";
        for (int i = index - 1; i >= 0; i--) {
            binary = binary + Integer.toString(binary_number[i]);
        }
        System.out.println(binary);
    }

    // EX2. Compute a consecutive square root
    public static double square(int m, int n) {
        if (m == 0)
            return 0;
        if (n == 1)
            return (double) Math.sqrt(m);
        else
            return (double) Math.sqrt(m + square(m, n - 1));
    }

    public void ConsecutiveSquareRoot() {
        String str1, str2;
        int m, n;
        str1 = PhamVanBao_1901040030_7C19.input("Ex2. Enter integer m: ");
        m = Integer.parseInt(str1);
        str2 = PhamVanBao_1901040030_7C19.input("Enter integer n (1 <= n <=  5): ");
        n = Integer.parseInt(str2);
        while (n >= 6 || n < 1) {
            str2 = PhamVanBao_1901040030_7C19.input("Error: You must enter number n (1 <= n <= 5): ");
            n = Integer.parseInt(str2);
        }
        double s = square(m, n);
        System.out.println("Result: " + s);
    }
    
    // Ex3: Solve a quadratic equation
    
    public void QuadraticEquation2() {
        double a = 0, b = 0, c = 0;
        double x1, x2;
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = sc3.nextDouble();
        System.out.println("Enter b: ");
        b = sc3.nextDouble();
        System.out.println("Enter c: ");
        c = sc3.nextDouble();
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);

            System.out.format("x1 = %.2f and x2 = %.2f \n", x1, x2);
        } else if (delta == 0) {
            x1 = x2 = -b / (2 * a);

            System.out.format("x1 = x2 = %.2f; \n", x1);
        }
        else {
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-delta) / (2 * a);

            System.out.format("x1 = %.2f+%.2fi and x2 = %.2f-%.2fi \n", real, imaginary, real,
                    imaginary);
        }        
    }
     
    // Ex4:  Print a triangle given its size
    public void triangle() {
        String str1;
        int h;
        str1 = PhamVanBao_1901040030_7C19.input("Input an integer n (1 <= n <= 5): ");
        h = Integer.parseInt(str1);
        System.out.println("The height: " + h);
        String space = "";
        String character = "";
        String result = "";
        int line = 1;

        while (line <= h) {
                space = "";
                character = "";
                for (int s = 1; s <= h - line; s++)
                        space += "  ";

                for (int c = 1; c <= 2 * line - 1; c++)
                        character += "* ";

                result += space + character + "\n";
                line++;
        }
        System.out.println("Result is: \n" + result + "\n");
    }
    public static void main(String[] args) {
        int exercise = 0;
        Scanner sc = new Scanner(System.in);
        PhamVanBao_1901040030_7C19 obj = new PhamVanBao_1901040030_7C19();

        while (exercise != 4) {
            try {
                System.out.println(
                         "[1] Convert a decimal (base 10) integer to binary (base 2)\r\n" 
                        + "[2] Compute a consecutive square root\r\n"
                        + "[3] Solve a quadratic equation\r\n"
                        + "[4] Print a triangle given its size\r\n"
                        +"Choose an option to perform: ");
                exercise = (int) sc.nextInt();
            } catch (Exception e) {
                System.out.println("Error: You only enter number");
                sc.nextLine();
            }
            switch (exercise) {
                case 1 : 
                    obj.convertBinary();
                    System.out.println("\n");
                    break;
                case 2 :
                    obj.ConsecutiveSquareRoot();
                    System.out.println("\n");
                    break;
                case 3 : 
                    obj.QuadraticEquation2();
                    break;
                case 4 : 
                    obj.triangle();
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Please! Enter a number in the list!!!\n");
                    break;
                }
                char condition;
                System.out.println("Do you want to continue with another function? Enter:Y/N");
                condition = sc.next().charAt(0);
                sc.nextLine();

                if (condition == 'N' || condition == 'n') {
                    System.out.println("Stop,goodbye! See you again.");
                    break;
                } else if (condition == 'Y' || condition == 'y') {
                    continue;
                } else {
                    System.out.println("Enter: Yes or No?");
                    String answer = sc.nextLine();
                    if (answer.equals("Yes") || answer.equals("yes") || answer.equals("Y") || answer.equals("y")) {
                            continue;
                    }
                    if (answer.equals("No") || answer.equals("no") || answer.equals("n") || answer.equals("N")) {
                            System.out.println("------Goodbye! See you again------");
                            break;
                    }
                }
            }
        }
    
}

/* 
 * Nguyen Thi Nga
 * 6C17
 * 1701040114
 */
package nguyenthinga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Nguyenthinga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            /*
     * Java main method is the entry point of any java program 
     */
        try {  
            boolean Continue = true;
            while (Continue) {            
                int option = showMenu();
                switch (option) {
                    case 1:
                        convertIntegerToBinary();
                        break;
                    case 2:
                        computeConsecutiveSquareRoot();
                        break;
                    case 3:
                        solveQuadraticEquation();
                        break;
                    case 4:
                        printTriangleWithSize();
                        break;
                    case 0:
                        System.out.println("Existing...");
                        return;
                    default:
                        System.out.println("Choose an option");
                        break;
                }
                System.out.println("Do you want to continue(true/false) ?");
                Scanner sc = new Scanner(System.in);
                Continue = sc.nextBoolean();
            }
            System.out.println("See you !");   
        } catch (Exception e) {
            System.out.println("An exception occured");
        }
    }
    private static Integer showMenu() {
        System.out.println(" MENU \n"
                         + "1. Convert a decimal (base 10) integer to binary (base 2)\n"
                         + "2. Compute a consecutive square root\n"
                         + "3. Solve a quadratic equation\n"
                         + "4. Print a triangle given its size\n"
                         + "0. Exit\n"
                         + "Choose an option: "
        );
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        return option;
    }
    /* 
     * The method is used to convert an integer to binary
     */
    private static void convertIntegerToBinary() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int integerInput = sc.nextInt();
        int divisor = integerInput;
        List<Integer> binaryList = new ArrayList<>();
        int resultOfDivisionByTwo = 1;
        while (resultOfDivisionByTwo != 0) {
            resultOfDivisionByTwo = divisor / 2;
            int remainder = divisor % 2;
            binaryList.add(remainder);
            divisor = resultOfDivisionByTwo;
        }
        System.out.printf("Binary equivalent of %d is: ", integerInput);
        if (integerInput >= 0) {
            for (int i = binaryList.size() - 1; i >= 0; i--) {
                System.out.print(binaryList.get(i));
            }
            System.out.println();
        } else {
            for (int i = binaryList.size() - 1; i >= 0; i--) {
                if (binaryList.get(i) == -1 & i < binaryList.size() - 1) {
                    binaryList.set(i, 1);
                }
                System.out.print(binaryList.get(i));
            }
            System.out.println();
        }
    }

    /* 
     * The method is used to compute consecutive square root of an integer
     */
    private static void computeConsecutiveSquareRoot() {
        // Print a message on the screen to request user input an integer which user want to compute consecutive square root
        System.out.println("Enter integer m which you want to compute square root: ");
        // Create a Scanner object to get user input
        Scanner sc = new Scanner(System.in);
        // Get user's input and assign it to a variable
        int integerInput = sc.nextInt();
        // Print a message on the screen to request user input an integer which is the times of squaring root
        System.out.println("Enter integer n (1 ≤ n ≤ 5) times to square root: ");
        // Get user's input and assign it to a variable
        int numberOfTime = sc.nextInt();
        // A block of code is used to compute consecutive square root of user's input and display the result
        if (integerInput < 0) {
            System.out.println("Can not compute square root of negative number");
        } else {
            if (numberOfTime < 1 || numberOfTime > 5) {
                System.out.println("Enter n in range between 1 and 5");
            } else {
                double sumInSqrt = 0;
                for (int i = 1; i <= numberOfTime; i++) {
                    sumInSqrt = integerInput + Math.sqrt(sumInSqrt);
                }
                double result = Math.sqrt(sumInSqrt);
                System.out.printf("When m is %d and n is %d: %.15f", integerInput, numberOfTime, result);
                System.out.println('\n');
            }
        }
    }

    /* 
     * The method is used to solve a quadratic equation
     */
    private static void solveQuadraticEquation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coefficient a: ");
        double a = sc.nextDouble();
        System.out.println("Enter coefficient b: ");
        double b = sc.nextDouble();
        System.out.println("Enter coefficient c: ");
        double c = sc.nextDouble();
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Infinite solutions");
                } else {
                    System.out.println("No solution");
                }
            } else {
                double root = -c / b;
                System.out.println("Root = " + root);
            }
        } else {
            double determinant = b * b - 4 * a * c;
            if (determinant > 0) {
                double root1 = (-b + Math.sqrt(determinant)) / (2 * a);
                double root2 = (-b - Math.sqrt(determinant)) / (2 * a);
                System.out.println("Root1 = " + root1);
                System.out.println("Root2 = " + root2);
            } else if (determinant == 0) {
                double root = -b / (2 * a);
                System.out.println("Root1 = Root2 = " + root);
            } else {
                System.out.println("No solution");
            }
        }
    }

    /* 
     * The method is used to print a triangle with user's size input
     */
    private static void printTriangleWithSize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input an integer n (1 ≤ n ≤ 5) as the number of rows"); 
        int rows = sc.nextInt();
        if (rows < 1 || rows > 5) {
            System.out.println("Enter from 1 to 5, please !");
        } else {
            for (int i = 1; i <= rows; i++) {
                for (int j = rows; j > i; j--) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= (2 * i) - 1; j++) {
                    System.out.print(" *");
                }
                System.out.println();
            }
        }
    }
}


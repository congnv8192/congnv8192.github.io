/*
 * Nguyen Quang Bang
 * 6C18
 * 1701 040 017
 */
package myassignment1;

// Import the ArrayList class
import java.util.ArrayList;
// Import the List class
import java.util.List;
// Import the Scanner class
import java.util.Scanner;

public class MyAssignment1 {
    
    /*
     * Java main method is the entry point of any java program 
     */
    public static void main(String[] args) {
        // Define a block of code to be tested for errors while it is being executed
        try {
            // A boolean variable that holds condition which determine whether the user want to use this program again  
            boolean isContinued = true;
            // Inside while-loop, display the menu and perform some tasks based on user's request
            // When the condition is true, it will execute the block code inside while-loop. Otherwise, it will ignore and execute the next statement
            while (isContinued) {
                // Call method to perform displaying menu and assign the return value of the method into integer variable
                int userOption = showMenu();
                // Use the switch statement to select one of many code blocks to be executed. 
                // Based on user's choice on the menu, it will excecute the task which user want to
                switch (userOption) {
                    // If user's input is 1. It will perform the task which is used to convert integer to binary
                    case 1:
                        // Call the method
                        convertIntegerToBinary();
                        // When reaching a break keyword, it breaks out of the switch block
                        break;
                    // If user's input is 2. It will perform the task which is used to compute consecutive square root of a number    
                    case 2:
                        // Call the method
                        computeConsecutiveSquareRoot();
                        // When reaching a break keyword, it breaks out of the switch block
                        break;
                    // If user's input is 3. It will perform the task which is used to solve a quadratic equation    
                    case 3:
                        // Call the method
                        solveQuadraticEquation();
                        // When reaching a break keyword, it breaks out of the switch block
                        break;
                    // If user's input is 4. It will perform the task which is used to print a triangle with input size    
                    case 4:
                        // Call the method
                        printTriangleWithSize();
                        // When reaching a break keyword, it breaks out of the switch block
                        break;
                    // If user's input is 0. It will print a message, then stop the program   
                    case 0:
                        // Print a message on the screen to sign that the program is existing
                        System.out.println("Existing...");
                        // Is used to end the method's execution
                        return;
                    // The default keyword specifies some code to run if there is no case match. 
                    // If the user's input don't match any case above, it will execute some code below
                    default:
                        // Print a message on the screen to tell user choose an option
                        System.out.println("Let's choose an option");
                        // When reaching a break keyword, it breaks out of the switch block
                        break;
                }
                // Print a message on the screen to determine whether user want to continue
                System.out.println("Do you want to continue(true/false) ?");
                // Create a Scanner object to get user input
                Scanner sc = new Scanner(System.in);
                // Get user's input value and assign it to the below variable to determine whether the user want to continue with this program.
                // If the value is true, it will execute the block of code inside while-loop again. Otherwise, it breaks out of the while-loop block
                isContinued = sc.nextBoolean();
            }
            // Print a message on the screen to say good bye
            System.out.println("See you !");
        // Define a block of code to be executed, if an error occurs in the try block    
        } catch (Exception e) {
            System.out.println("An exception occured");
        }
    }

    /* 
     * The method is used to print the menu on the screen
     */
    private static Integer showMenu() {
        // Display the content of the menu
        System.out.println("*** MENU ***\n"
                         + "1. Convert a decimal (base 10) integer to binary (base 2)\n"
                         + "2. Compute a consecutive square root\n"
                         + "3. Solve a quadratic equation\n"
                         + "4. Print a triangle given its size\n"
                         + "0. Exit\n"
                         + "Choose an option: "
        );
        // Create a Scanner object to get user input
        Scanner sc = new Scanner(System.in);
        // Get user's integer input and assign the value to a varible
        int userOption = sc.nextInt();
        // The method returns an integer value which is entered by user
        return userOption;
    }

    /* 
     * The method is used to convert an integer to binary
     */
    private static void convertIntegerToBinary() {
        // Create a Scanner object to get user input
        Scanner sc = new Scanner(System.in);
        // Print a message on the screen to request user input an integer
        System.out.println("Enter an integer: ");
        // Assign the user's input value to a variable
        int integerInput = sc.nextInt();
        int divisor = integerInput;
        // The ArrayList class is a resizable array. Creating an ArrayList object called "binaryList" that will store binary value
        List<Integer> binaryList = new ArrayList<>();
        // A block of code is used to get binary element from integer input and add to the ArrayList object
        int resultOfDivisionByTwo = 1;
        while (resultOfDivisionByTwo != 0) {
            resultOfDivisionByTwo = divisor / 2;
            int remainder = divisor % 2;
            binaryList.add(remainder);
            divisor = resultOfDivisionByTwo;
        }
        // Print a message on the screen to alert user the result
        System.out.printf("Binary equivalent of %d is: ", integerInput);
        // With user's input bigger or equal than 0, print binary list as requested
        if (integerInput >= 0) {
            for (int i = binaryList.size() - 1; i >= 0; i--) {
                System.out.print(binaryList.get(i));
            }
            // Print a blank line for looking easier
            System.out.println();
            // With user's input smaller than 0, print binary list as requested    
        } else {
            for (int i = binaryList.size() - 1; i >= 0; i--) {
                if (binaryList.get(i) == -1 & i < binaryList.size() - 1) {
                    binaryList.set(i, 1);
                }
                System.out.print(binaryList.get(i));
            }
            // Print a blank line for looking easier
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
        // Create a Scanner object to get user input
        Scanner sc = new Scanner(System.in);
        // Print a message on the screen to request user enter the first coefficient
        System.out.println("Enter coefficient a: ");
        // Get user's input and assign it into a variable
        double a = sc.nextDouble();
        // Print a message on the screen to request user enter the second coefficient
        System.out.println("Enter coefficient b: ");
        // Get user's input and assign it into a variable
        double b = sc.nextDouble();
        // Print a message on the screen to request user enter the third coefficient
        System.out.println("Enter coefficient c: ");
        // Get user's input and assign it into a variable
        double c = sc.nextDouble();
        // A block of code is used to solve the quadratic equation with user's input and print the result
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
        // Create a Scanner object to get user input
        Scanner sc = new Scanner(System.in);
        // Print a message on the screen to request user input the size of triangle 
        System.out.println("Input an integer n (1 ≤ n ≤ 5) as the number of rows");
        // Get user's input and assign it into a variable  
        int rows = sc.nextInt();
        // A block of code is used to print a triangle with user's size input
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

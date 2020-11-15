package com.company;
import java.util.Scanner;

public class problem4 {
    //Ex 1//
    public static void main(String[] args) {
        String answer;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please choose the function you want to do: ");
            System.out.println(" 1. Decimal to binary");
            System.out.println(" 2. Multiple square root");
            System.out.println(" 3. Solve quadratic equation");
            System.out.println(" 4. Print a triangle given its size");
            Integer function = sc.nextInt();
            //Function 1//
            switch(function){
			case 1:
                System.out.println("Please enter your number: ");
                Integer number = sc.nextInt();
                System.out.println("The number in binary is: " + Integer.toBinaryString(number));
				break;
            //Function 2//
			case 2:
                System.out.println("Please enter how many time do you want to repeat the square root (bigger or equal to 1 and smaller or equal to 5): ");
                int n = sc.nextInt();
                System.out.println("Please enter the number you want to add: ");
                double m = sc.nextDouble();
                double ketqua = 0;
                for (int i = 1; i <= n; i++) {
                    ketqua = Math.sqrt(ketqua + m);
                }
                System.out.println("Your result: " + ketqua);
				break;
            //Function 3//
			case 3:
                System.out.println("Please enter a: ");
                double a = sc.nextDouble();
                System.out.println("Please enter b: ");
                double b = sc.nextDouble();
                System.out.println("Please enter c: ");
                double c = sc.nextDouble();
                double delta = ((b * b) - (4 * a * c));
                if (delta < 0) {
                    System.out.println("There's no solution");
                }
                if (delta == 0) {
                    System.out.println("There's only one solution: x = " + -b / (2 * a));
                }
                if (delta > 0) {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    System.out.println("There are two solution: x1 = " + x1 + " and x2 = " + x2);
                }
				break;
            //Function 4//
			case 4:
                System.out.println("Please enter the height of your triangle: ");
                int h = sc.nextInt();
                for (int i = 1; i <= (h * 2); i += 2) {
                    for (int space = (h * 2); space >= i; space--) {
                        System.out.print(" ");
                    }
                    for (int star = 1; star <= i; star++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
				break;
            }
            answer = sc.nextLine();
            System.out.println("Do you want to use other functions? (Y/N)");
            answer = sc.nextLine();
        }
        while (answer.equals("Y") || answer.equals("y"));
    }
}


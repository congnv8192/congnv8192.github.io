/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenbatrungkien_1901040105_2c19;

import java.util.Scanner;

/**
 *
 * @author Nguyen Ba Trung Kien - 1901040105
 */
public class NguyenBaTrungKien_1901040105_2C19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String answer;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please choose the following function you want to perform: ");
            System.out.println(" 1. Convert a decimal (base 10) integer to binary (base 2)");
            System.out.println(" 2. Compute a consecutive square root");
            System.out.println(" 3. Solve a quadratic equation");
            System.out.println(" 4. Print a triangle given its size");
            Integer function = sc.nextInt();
            //Function 1//
            switch(function){
			case 1:
                System.out.println("Please enter your number: ");
                Integer number = sc.nextInt();
                System.out.println("The number converted to binary is: " + Integer.toBinaryString(number));
				break;
            //Function 2//
			case 2:
                System.out.println("Please enter the number of time that you want the square root to be repeated (bigger or equal to 1 and smaller or equal to 5): ");
                int n = sc.nextInt();
                while (n<1 || n>5){
                    System.out.println ("The number entered doesn't coordinate with the condition");
                }
                System.out.println("Please enter the number you want to add: ");
                double m = sc.nextDouble();
                double ketqua = 0;
                for (int i = 1; i <= n; i++) {
                    ketqua = Math.sqrt(ketqua + m);
                }
                System.out.println("The result is: " + ketqua);
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
                    System.out.println("There is no solution to this quadratic equation");
                }
                if (delta == 0) {
                    System.out.println("There is only one solution to this quadratic equation: x = " + -b / (2 * a));
                }
                if (delta > 0) {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    System.out.println("There are two solution to this quadratic equation: x1 = " + x1 + " and x2 = " + x2);
                }
				break;
            //Function 4//
			case 4:
                System.out.println("Please enter the desired height of your triangle: ");
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
            System.out.println("Do you want to continue with other functions? (Y/N)");
            answer = sc.nextLine();
        }
        while (answer.equals("Y") || answer.equals("y"));
    }
}


    
    


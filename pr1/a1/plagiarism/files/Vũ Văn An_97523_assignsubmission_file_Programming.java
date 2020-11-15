/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming;

import java.util.Scanner;

/**
 *
 * @author VuVanAn_2C19_1901040002_B3
 */
public class Programming {
    public String convertToBinary(int n) {
        String s = "";                              // we have "s" as an empty set.
        while(n != 0) {                             
            int mod = n % 2;                        // modular of an number equal the remainer of the division.
            n = n / 2;                             
            s = s + mod;                            // The empty set now accepts new elements of the modular number.
        }   
        String s1 = "";                             // Now we have new "s1" as another empty set.
        for (int i = s.length() - 1; i >= 0; i--) { // We have the loop "i" times, this loop will stand for the reverse of the set "s" before.
            s1 = s1 + s.charAt(i);                  // The new "s1" will get the reverse digits of s in ascending i.
        }
        return s1;                                  // In return, we have the complete new s1.
    }
    
    public double consecutiveSquareRoot(double m, int n) {
        double result = 0;
        if(n < 1 || n > 5){                         // This is the condition of n to make it available for the math.
            System.out.println("Input value 1 <= n <= 5");
        } else {
        for(int i = 0; i < n; i++) {                // "i" stands for the loop of how many times does the user want the square of m.
            result = Math.sqrt(m + result);         // With i equal 0, the math only have a square of m, then i will be less than n with increasing number of i.
        }                                           // The new result will contains the square of m, plus with another square of m in it, which equivalent to the number of "n".
    }
        return result;                              // In return, we have the complete new s1.
    }
    
    public void quadaricEquation( double a, double b, double c) {
        if(a == 0) {                                // With a equal 0, then there are 2 possibles which can happens that is all a, b and c equal 0, or  only a, b equal 0 but c is different to 0.
            if( b == 0 && c != 0) {
                System.out.println("The equation has no solution");
            } else if(b == 0 && c == 0) {
                System.out.println("The equation has infinite solutions");
            }
        } else {                                    // With a different to 0, we have delta, and from delta, we have 3 possibles which can happens that is delta smaller than 0 or equal 0 or bigger than 0.
            double delta = b * b - 4 * a * c;
            if( delta < 0) {
                System.out.println("The equation has no solution");
            } else if(delta == 0) {
                double x = -b / 2 * a;
                System.out.println("The equation has 1 solution: " + x);
            } else {
                double x1 = (-b - Math.sqrt(delta)) / (2 * a);
                double x2 = (-b + Math.sqrt(delta)) / (2 * a);
                System.out.println("The equation has 2 solution: ");
                System.out.println("X1 = " + x1);
                System.out.println("X2 = " + x2);
            }
        }
    }
    
    public void triangle(int n) {
        if(n < 1 || n > 5) {                         // This is the condition of n to make it available for the math.
            System.out.println("Invalid n");
        } else {
            for(int i = 1; i <= n; i++) {            // "i" stands for the rows of how many times does the user want the line in the triangle.
                for(int j = 1; j <= n - i; j++) {    // "j" stands for the number of space (" ") printed out, standing before "*", the distance increases, the more "*" decrease.
                    System.out.print(" ");           
                }
                for(int k = 1; k <= 2 * i - 1; k++) {// "k" stands for the number of "*", standing next to the space " ".
                    System.out.print("*");
                }
                System.out.println();                // This println() forms the triangle, it self-breaks and runs the second row after the first row qualifies and is output to the screen.
            }
        }
    }						     // For example, in the first line, with n equals 1, so there is only 1 row,
						     // so there is 1 "k", which means 1 "*", no "j", which means no space" ". But with
 						     // n equals 2, the first line will have 1 spcae " " standing before "*", then
						     // it self-breaks to the second lane, with no space " " and next to it is 3 "*".
    
    public static void main(String[] args) {
        Programming pr = new Programming();
        Scanner sc = new Scanner(System.in);
        System.out.println("MENU: ");
        System.out.println("1. Convert a decimal (base 10) integer to binary (base 2)");
        System.out.println("2. Compute a consecutive square root");
        System.out.println("3. Solve a quadratic equation");
        System.out.println("4. Print a triangle given its size");
        
        while(true){                                 // Use "while()" loop to let users enter as many times as they want.
            System.out.println("What do you want? ");
            boolean choose = true;
            
            switch (sc.nextInt()) {                  // Use "switch-case" to makes menu-based program.
                case 1:
                    System.out.println("Inter an interger: ");
                    System.out.println(pr.convertToBinary(sc.nextInt()));
                    break;
                    
                case 2:
                    System.out.println("Input two intergers m and n(1 ≤ n ≤ 5): ");
                    int m = sc.nextInt();
                    int n = sc.nextInt();
                    System.out.println("The result is: ");
                    System.out.println(pr.consecutiveSquareRoot(m, n));
                    break;
                    
                case 3:
                    System.out.println("Input 3 coefficients a, b and c");
                    pr.quadaricEquation(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                    break;
                    
                case 4:
                    System.out.println("Input an interger n(1 ≤ n ≤ 5)");
                    pr.triangle(sc.nextInt());
                    break;
                default:                             // Use "default" to restrict the users from only entering the four allowed functions.
                    System.out.println("Choose 1 or 2 or 3 or 4 only");
                    choose = false;
                    break;
            }
            if(choose == true) {                     // Part of the program to let users decide whether they want to stop or continue using program.
                System.out.println("Do you want to continue?");
                String again = sc.next();
                while(again.equals("Yes") == false) {
                    if(again.equals("No")) {         // This part aim to restricts the users from choosing only 2 option, which is "Yes"-Continue using program or "No"-Stop the program.
                        System.out.println("The program will stop immediately");
                        return;
                    } else {                         // This allows the user to re-enter their answer in case they enter a different answer "Yes" or "No".
                        System.out.println("Type again");
                        again = sc.next();
                    }
                }
            }
        } 
    }
}
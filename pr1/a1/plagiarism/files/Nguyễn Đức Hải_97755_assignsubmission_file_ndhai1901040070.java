/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermtest;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ndhai1901040070 {
    //EXE 3 IN ASSIGNMENT 1..

    public static void quadraticEquation() {
        Scanner var = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("Solving Quadratic Equation ( ax^2 + bx = c ) :");
        System.out.print("Enter a: ");
        double a = var.nextDouble();
        System.out.print("Enter b: ");
        double b = var.nextDouble();
        System.out.print("Enter c: ");
        double c = var.nextDouble();
        if (a != 0) {
            double delta = (b * b - 4 * a * c);
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);          //THE ONE THAT I COPIED FROM WHAT I HAD SUBMITTED ON FIT PORTABLE AS HOMEWORK
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);                  //MAYBE NO NEED TO EXPLAIN MORE ABOUT IT :P
                System.out.println("=> x1 = " + x1);
                System.out.println("  & x2 = " + x2);
            } else {
                if (delta == 0) {
                    double x = -b / (2 * a);
                    System.out.println("=> x = " + x);
                } else {           // delta < 0
                    System.out.println("There is no root.");
                }
            }
        } else {                   // a = 0
            if (b == 0) {
                if (c == 0) {
                    System.out.println("There are many roots");
                } else {
                    System.out.println("There is no root.");
                }
            } else {
                double x = -c / b;
                System.out.println("=> x = " + x);
            }
        }
    }
//EXE 2 IN ASSIGNMENT 1..

    public static void squareRoot() {
        Scanner in = new Scanner(System.in);
        System.out.println("----------------------------------------------");   //DEVIDER - BECAUSE I DUNNO HOW TO CLEAN SCREEN
        System.out.println("Computing Square Root: ");
        System.out.print("Enter a number that you want to compute:");
        double m = in.nextInt();
        System.out.print("Enter time to loop [1,5]: ");                         //MAYBE THE EASIEST ONE THAT TAKE A LIL TIME OF MINE
        int n = in.nextInt();
        double c = 0, a = m;   // a to hold the first value of m  
        for (int i = 0; i < n; i++) {
            c = Math.sqrt(m);  //compute square root of new m
            m = a + c;        //give m new value that its first value plus it square root
        }
        System.out.println("Result: " + c);
    }
//EXE 1 IN ASSIGNMENT 1.. 

    public static void decimalToBinary() {
        Scanner in = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("Convert Decimal number into Binary:");
        System.out.print("Enter an integer: ");
        int a = in.nextInt();
        String binary = "", binaryNew = "";                                         
        while (a / 2 != 0) {  // Im using Euclidean argothrism 
            binary = binary + (a % 2);  //record mod of a by 2                  //I DECIDE NOT TO USE '.toBinaryString()' 
            a = a / 2;    //give a new value that quotient
        }
        binary = binary + (a % 2);  //record the last mod of a by 2 because in while loop, it cannot be recorded when quotient equal to 0
        for (int i = binary.length() - 1; i >= 0; i--) {
            binaryNew = binaryNew + binary.charAt(i);   //change position of remainders to get binary number 
        }
        System.out.println("Result: "+binaryNew);
    }
//EXE 4 (MAYBE THE HARDEST ONE) IN ASSIGNMENT 1..

    public static void triangle() {
        Scanner in = new Scanner(System.in);
        System.out.println("----------------------------------------------");   //THIS EXE TOOK A LOT OF My TIME :((
        System.out.println("Drawing A Star Triangle: ");                        // BUT I LIKE IT <3
        System.out.print("Enter height of the triangle [1,5]: ");
        int n = in.nextInt();                                                   
        int space;
        String star = "*";      //give value for 1st line to be base of other line
        String[] starNew = new String[n];  //buitd an array have capabability as much as user want                                     
        if (n == 1) {                                                           
            System.out.println(star);  //if n=1 the code below maybe cannot run and bring an error
        } else {
            starNew[0] = star;  //set the first value of array is one star
            for (int i = 0; i < n - 1; i++) {
                star = "*" + star + "*";    //add 2 star in next line
                starNew[i + 1] = star;      //input this new line to array
            }
            for (int i = n - 2; i >= 0; i--) {
                while (starNew[i].length() != (starNew[n - 1].length())) {
                    space = (starNew[n - 1].length() - starNew[i].length()) / 2;
                    for (int j = 1; j <= space; j++) {                                  //add space to line to make sure all line has same length
                        starNew[i] = " " + starNew[i] + " ";
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.println(starNew[j]);                                          //print out 
        }
    }
//FUNCTION TO DECIDE THAT IF USER WANT TO CONTINUE OR NOT..

    public static boolean contFunction(boolean cont) {
        Scanner in = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.print("Do you want to contine (y/n): ");
        String inUser = in.nextLine();
        switch (inUser) {                                                       //I USED LOTS OF CASES TO COVER IF USER USE CAPSLOCK OR HOLDING SHIFT
            case "y":
                cont = true;
                break;
            case "Y":
                cont = true;
                break;
            case "n":
                System.out.println("");
                System.out.println("Thank You For Using My First 'Big' Java 'App' :>"); //MAYBE OUTTRO
                System.out.println("See You Next Time !!");
                cont = false;
                break;
            case "N":
                System.out.println("");
                System.out.println("Thank You For Using My First 'Big' Java 'App' :>");
                System.out.println("See You Next Time !!");
                cont = false;
                break;
            default:
                cont = false;
                break;
        }
        return cont;
    }
//MAIN BODY

    public static void main(String[] args) {
        Scanner select = new Scanner(System.in);
        System.out.println("Welcome to my first 'Big' java 'Application':");
        boolean cont = true;
        while (cont == true) {
            System.out.println("----------------------------------------------");
            System.out.println("Choose the funtion you want: ");
            System.out.println("1.Convert Decimal to Binary  |  2.Compute Square Root  |  3.Quadratic Equation  |  4.Draw Star Triangle  |  5.Exit");
            int input = select.nextInt();
            switch (input) {
                case (1):
                    decimalToBinary();
                    cont = contFunction(cont);
                    break;
                case (2):
                    squareRoot();
                    cont = contFunction(cont);
                    break;
                case (3):
                    quadraticEquation();
                    cont = contFunction(cont);
                    break;
                case (4):
                    triangle();
                    cont = contFunction(cont);
                    break;
                case (5):                                   //CASE THAT USER DOESNT WANT TO CONTINUE WHEN IN FUNCTION MENU
                    cont = contFunction(cont);
                default:
                    break;
            }
        }
    }
}
//160 lines (excepted some null lines)
//Nguyễn Đức Hải 4c19
//3 DAYS


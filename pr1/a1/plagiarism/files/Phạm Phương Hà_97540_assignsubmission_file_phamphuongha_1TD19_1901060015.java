
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pham Phuong ha
 * Class 1TD19
 */
public class phamphuongha1TD19 {
    // 1. Task 01: Convert a decimal (base 10) integer to binary (base 2)

    
    private static void Task01(){
        int[] binary = new int[32]; 
        /*Array to store binary number*/
         //declare variables
        int a, b=0;
        Scanner sc = new Scanner (System.in);
        System.out.print("Input an integer: "); 
        a = sc.nextInt();
        while (a!=0) 
        {
        // storing remainder in binary array
        binary[b] = a % 2;
        a= a/2;
        b++;
        }
        // printing binary array (reverse order) 
        System.out.print("Its binary equivalent is: ");
        //declare c
        for(int c=b-1; c>=0; c--) 
        {     
        System.out.print(binary[c]); 
        }
        }
    

// 2. Task02:  Compute a consecutive square root

    private static void Task02() {
        //declare variables
         int m, n;
         Scanner sc= new Scanner(System.in);
         System.out.print("Input m: ");
         m = sc.nextInt();
         System.out.print ("Input n: ");
         n = sc.nextInt(); 
         double result=0; //initialize total
         //condition for roots
         if (m<0) {
         System.out.println("Invalid m"); 
         }
         else if (1<n && n>5){
         System.out.println("Invalid n");
         }
         else
         for (int x = 0; x<n; x++){ //declare x 
         // compute the expression where the square root is taken n times
         result = Math.sqrt(m+result); 
         if (x==n-1){ 
         System.out.println("The result is: "+result);
         break;
         }
         }
         }


// 3. Task 03: Solve a quadratic equation


    private static void Task03() {
         Scanner input = new Scanner(System.in);
         //declare variables
         double a, b, c;
         System.out.print("Input a: ");
         a = input.nextDouble();
         System.out.print("Input b: ");
         b = input.nextDouble();
         System.out.print("Input c: ");
         c = input.nextDouble();           
         if (a == 0) {
         if (b == 0) {
         if (c == 0) {
        
         System.out.println("There's nothing to be solved.");
         
         } else {
         System.out.println("The equation has no root.");
         }
         //condition for 1 root: 
         } else {
         double x = -c / b;
         System.out.println("There is one root: x = " + x);
         }
         } else { 
         //condition for 2 roots:
         double Delta = b * b - 4 * a * c;
         //no real root
         if (Delta < 0) {
         System.out.println("The equation has no real root.");
        }
         // equal root
         else if (Delta == 0) {
         double x = -b / (2 * a);
         System.out.println("The root is x = " + x);
        }
         //2 different roots
         else {
         double x1 = (-b + Math.sqrt(Delta)) / (2 * a);
         double x2 = (-b - Math.sqrt(Delta)) / (2 * a);
         System.out.println("There are 2 roots: x1 = " + x1 + ", x2 = " + x2);
         }
         }
         }
 
        
        
// 4. Task 04: Print a triangle given its size

        private static void Task04() {
        Scanner input = new Scanner (System.in);
        //declare variables
        System.out.print("Enter number of rows: ");
        int x=input.nextInt();
        int y=2*x-1;
        //place " " and "*"
        if (x>=1 && x<=5){
        for (int z = 0; z<=x; z++){
        for (int a = 1; a<=(x-z); a++){
        System.out.print(" ");
        }
        for (int b = (x-z+1); b<=(y-x+z);b++){
        System.out.print("*");
        }
        System.out.println();
        }
        } else {
        }
        }

//Menu to let the user choose a function
        
public static void main(String[] args) {
int n = 0;
       Scanner sc = new Scanner (System.in);
        while ( n != 4 ) {
        System.out.println("[1] Convert a decimal integer to binary");
        System.out.println("[2] Compute a consecutive square root");
        System.out.println("[3] Solve a quadratic equation");
        System.out.println("[4] Print a triangle given its size");
        System.out.print("Select a function: ");
        int scan = sc.nextInt();
        switch (scan){
            case 1:
                Task01();
                break;
            case 2:
                Task02();
                break;
            case 3:
                Task03();
                break;
            case 4:
                Task04();
                break;
            default:
                System.out.println("Invalid input");
                break;
            }   
            // ask the user if they want to continue or not 
            System.out.print("Do you want to continue another function ?(Yes/No): ");
            sc.nextLine();
            if (sc.nextLine().equalsIgnoreCase("No")) {
                System.out.println("Goodbye. See you again!");
                break;
            } else {}
            }
            }
            }



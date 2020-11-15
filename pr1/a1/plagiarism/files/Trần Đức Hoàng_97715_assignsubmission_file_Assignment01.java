
import java.util.Scanner;

public class Assignment01 {
    
//EXE 3 IN ASSIGNMENT 1..
    public static void quadraticEquation() {
        Scanner var = new Scanner(System.in);
        System.out.println("----------------------------------------------");       //DEVIDER - BECAUSE I DUNNO HOW TO CLEAN SCREEN
        System.out.println("Solving Quadratic Equation ( ax^2 + bx = c ) :");
        
        //GET VALUE OF a,b,c FROM USER
        System.out.print("Enter a: ");
        double a = var.nextDouble();
        System.out.print("Enter b: ");
        double b = var.nextDouble();
        System.out.print("Enter c: ");
        double c = var.nextDouble();
        
        //CALCULATE QUADRATIC EQUATION
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
            
        // a = 0    
        } else {                   
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
        System.out.println("----------------------------------------------");   
        System.out.println("Computing Square Root: ");
        
        //GET NUMBER FROM USER
        System.out.print("Enter a number that you want to compute:");
        double m = in.nextInt();    
        System.out.print("Enter time to loop [1,5]: ");                         
        int n = in.nextInt();
        
        //CALCULATE SQUARE ROOT OF m
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
        
        //GET NUMBER FROM USER
        System.out.print("Enter an integer: ");
        int a = in.nextInt();
        
        //PREPARE NULL ARRAYS
        String binary = "", binaryNew = ""; 
        
        //
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
        System.out.println("Drawing A Star Triangle: ");                        //BUT I LIKE IT <3
                                                                                
        //GET THE HEIGHT OF THE TRIANGLE
        System.out.print("Enter height of the triangle [1,5]: ");
        int n = in.nextInt(), space;      
        
        //SETUP 
        String star = "*";      //give value for 1st line to be base of other line
        String[] starNew = new String[n];  //buitd an array have capabability as much as user want                                     
        
        //DRAWING THE TRIANGLE
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
        
        //PRINT TRIANGLE
        for (int j = 0; j < n; j++) {
            System.out.println(starNew[j]);                                          //print out 
        }
    }
    
//FUNCTION TO DECIDE THAT IF USER WANT TO CONTINUE OR NOT..
    public static boolean contFunction(boolean cont) {
        Scanner in = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        
        //GET USER'S OPTION
        System.out.print("Do you want to contine (y/n): ");
        String inUser = in.nextLine();
        
        //
        switch (inUser) {                                                       //I USED LOTS OF CASES TO COVER IF USER USE CAPSLOCK OR HOLDING SHIFT
            case "y":
            case "Y":
                cont = true;
                break;
            case "n":
            case "N":
                System.out.println("");
                System.out.println("Thank You For Using My First 'Big' Java 'App' :>");           //OUTTRO (?)
                System.out.println("Im Hoang, see you next time !!");
                cont = false;
                break;
            default:
                System.out.println("");
                System.out.println("Invalid input :(( Enter again plz !!!");          //De Quy Time :vv Maybe
                contFunction(cont);                                             // force user to answer correctly
                break;
        }
        return cont;
    }
    
//MAIN BODY
    public static void main(String[] args) {
        Scanner select = new Scanner(System.in);
        System.out.println("Welcome to my first 'Big' java 'Application':");
        boolean cont = true;
        
        //PRINT MENU
        while (cont == true) {
            System.out.println("----------------------------------------------");
            System.out.println("Choose the funtion you want: ");
            System.out.println("1.Convert Decimal to Binary  |  2.Compute Square Root  |  3.Quadratic Equation  |  4.Draw Star Triangle  |  5.Exit");
            
            //GET OPTION FROM USER
            System.out.print("Choose > ");
            String input = select.nextLine();                           /* a trick from my friend to avoid the program stoping 
                                                                        itself when user enter wrong type of input*/
            //
            switch (input) {
                case ("1"):
                    decimalToBinary();
                    break;
                case ("2"):
                    squareRoot();
                    break;
                case ("3"):
                    quadraticEquation();
                    break;
                case ("4"):
                    triangle();
                    break;
                case ("5"):                                   //CASE THAT USER DOESNT WANT TO CONTINUE WHEN IN FUNCTION MENU
                    break;
                default:
                    System.out.println("");
                    System.out.println("Invalid input :(( Enter again plz !!!");
                    break;
            }
            
            //ASK USER IF THEY WANT TO CONTINUE OR NOT
            cont = contFunction(cont);
        }
    }
}
//164 lines (excepted some null lines)
//Created by HoangTD.4C19.PR1-B02
//3 DAYS
//03.14AM - 31.10.20 _ FINISHED AND RUN SUCCESSFULLY 
//03.44AM - 31.10.20 _ Finished Format and gave comment
//yeee . happy HalLOweEn everyone !! have a good Saturday :)) I'll goto sleep.. zzz
//---------------------------------------------------------------------------------------------------------//
//160 LINES (EXECPTED NULL LINES)
//P.s: I have listened some amazing ideas from my friends so i decided to remake it again (>W<) !!!
//Copy right by Me - HoangTD.4C19-PR1-B02
//Before deadline 
//04.12PM - 08.11.20 _ FOMMATED AGAIN
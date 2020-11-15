package assigment;

import java.util.Scanner;
public class Assigment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice2 = "";
        do {
            System.out.println("Chọn bài tập (Từ 1 đến 4)");
            System.out.println("Exercise 1");
            System.out.println("Exercise 2");
            System.out.println("Exercise 3");
            System.out.println("Exercise 4");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Bài 1:");
                    System.out.println("Enter integer:");
                    int j = sc.nextInt();
                    int n;
                    String s = "";
                    while (j>0) {
                        n = (j%2);
                        s = n + s;
                        j = (j/2);
                    }
                    System.out.println("Binary equivalent:" +s);
                    System.out.println("Continue? Yes or No");
                    choice2 = sc.nextLine();
                    break;
               case 2: 
                System.out.println("Exercise 2:");
                System.out.print("Enter m: ");
                int m = sc.nextInt();
                System.out.print("Enter n (1 <= n <= 5): ");
                int n1 = sc.nextInt();
                double result;

                if (n1 == 1) {
                    result = Math.sqrt(m);
                    System.out.println("A square root of " + m + " taken " + n1 + " times: " + result);
                } else if (n1 == 2) {
                    result = Math.sqrt(m + Math.sqrt(m));
                    System.out.println("A square root of " + m + " taken " + n1 + " times: " + result);    
                } else if (n1 == 3) {
                    result = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m)));
                     System.out.println("A square root of " + m + " taken " + n1 + " times: " + result);
                } else if (n1 == 4) {
                    result = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m + Math.sqrt(m))));
                    System.out.println("A square root of " + m + " taken " + n1 + " times: " + result);
                } else if (n1 == 5) {
                    result = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m + Math.sqrt(m + Math.sqrt(m)))));
                    System.out.println("A square root of " + m + " taken " + n1 + " times: " + result);
                } else {
                    System.out.println("Please enter n that satisfies the given condition.");
                }
                
                System.out.println("Continue? Yes or No");
                choice2 = sc.nextLine(); 
                break;          
        
            case 3:
                System.out.println("Exercise 3:");

                System.out.print("Enter coefficient a: ");
                double a = sc.nextDouble();
                System.out.print("Enter coefficient b: ");
                double b = sc.nextDouble();
                System.out.print("Enter coefficient c: ");
                double c = sc.nextDouble();

                if (a==0 && b==0 && c==0) {
                    System.out.println("The equation has infinitely many solutions.");
                } else if (a==0 && b==0 && c!=0) {
                    System.out.println("The equation has no solution.");
                } else if (a==0 && b!=0 && c!=0) {
                    double x0 = -c/b;
                    System.out.println("The equation has only one solution: x = " + x0);
                } else if (a!=0 && b!=0 && c!=0) {
                    if (b*b - 4*a*c < 0) {
                        System.out.println("The equation has no solution.");
                    } else {
                        if (b*b - 4*a*c > 0) {
                            double x1 = ((-b + Math.sqrt((b*b) - 4*a*c))/(2*a));
                            double x2 = ((-b - Math.sqrt((b*b) - 4*a*c))/(2*a));
                            System.out.println("The equation has two solutions: x1 = " + x1 +", x2 = " + x2);
                        }
                    }
                }
                System.out.println("Continue? Yes or No");
                choice2 = sc.nextLine(); 
                break;
        
            case 4:
                
                System.out.println("Exercise 4:");
                int rows,col,n2,a2;
                System.out.print("Enter integer n (1 <= n <= 5): ");
                n2 = sc.nextInt();
                a2 = n2;

                for (rows = 1 ; rows <= n2 ; rows++) {
                    for (col = 1 ; col < a2 ; col++) 
                        System.out.print("  ");

                    a2--;

                    for (col = 1 ; col < 2*rows; col++)
                        System.out.print(" *");

                    System.out.println("");
                }
                System.out.println("Continue? Yes or No");
                choice2 = sc.nextLine(); 
                break;
        
            default: 
                System.out.println("There are no more than four exercises.");
                System.out.println("Continue? Yes or No");
                choice2 = sc.nextLine();   
                break;      
            }
            System.out.print("=> ");
          choice2 = sc.nextLine(); 
          if (choice2.equals("No") || choice2.equals("no")) {
              System.out.println("Thank you!");
        }               
    } while (choice2.equals("Yes") || choice2.equals("yes"));   
   }
}
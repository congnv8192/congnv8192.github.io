/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PR1;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class NguyenThiNgocNhi_2TD19_1901060039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer choice;
        do {
            System.out.println("\nThis is a menu-based program.");
            System.out.println("1. Convert a decimal (base 10) integer to binary (base 2).");
            System.out.println("2. Compute a consecutive square root.");
            System.out.println("3. Solve a quadratic equation.");
            System.out.println("4. Print a triangle given its size.");
            System.out.println("5. Exit the program.");
            System.out.println("Select Function : [1-5].");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1) {
                //choice = 1 thực hiện bài tập 1.
                System.out.print("Enter an integer: ");
                Integer input = sc.nextInt();
                System.out.println("Binary number of " + input + " is :" + Integer.toBinaryString(input));
                //tác dụng của hàm Integer.toBinaryString() chuyển số nguyên thành số nhị phân cơ số 2.
            } else if (choice == 2) {
                //choice = 2 thực hiện bài tập 1.
                System.out.print("Enter the integer m: ");
                Integer m = sc.nextInt();
                double result = 0;
                Integer n;
                do {
                    System.out.print("Enter the integer n: ");
                    n = sc.nextInt();
                    if (n > 0 && n < 6) {
                        // n lơn hơn 0 và nhỏ hơn 6 thì bắt đầu vào vòng for.
                        for (int i = 1; i <= n; i++) {
                            result = Math.sqrt(m + result);
                            //tính tổng.
                            //hàm Math.sqrt() tín căn bậc 2.
                        }
                        System.out.println(result);
                        //hiện kết quả.
                    } else if (n > 5 || n < 1) {
                        //n lớn hơn 5 hoặc nhỏ hơn 1 báo lỗi.
                        System.out.println("1<=n<=5");
                    }
                } while (n > 5 || n < 1);
                // nếu n lớn hơn 5 hoặc nhỏ hơn 1 thì báo lỗi,tiếp tục vòng lặp.
                //nếu n nhỏ hơn 5 hoặc lớn hơn 1 thì in ra kết quả kết thúc vòng lặp.
            } else if (choice == 3) {
                //Choice = 3 thực hiện bài tập 3.
                System.out.print("Input a: ");
                double a = sc.nextInt();
                System.out.print("Input b: ");
                double b = sc.nextInt();
                System.out.print("Input c: ");
                double c = sc.nextInt();
                // sẽ có 2 trường hơn a =0 và a!=0.
                if (a == 0) {
                    //trường hợp a= 0.
                    if (b != 0) {
                        //a=0,b!=0 phương trình có 1 nghiệm -c / b.
                        System.out.println("The equation has one solution: "
                                + "x = " + (-c / b));

                    } else {
                        //Trường hợp a=0,b=0
                        if (c != 0) {
                            // trường hợp a=0,b=0,c!=0 phương trình vô nghiệm.    
                            System.out.println("The equation has no solution!");
                        } else {
                            // trường hợp a=0,b=0,c=0 phương trình vô số nghiệm.        
                            System.out.println("The equation has countless solutions");
                        }
                    }
                } else {
                    //trường hợp a!=0.
                    double x1;
                    double x2;
                    if (b * b - 4 * a * c > 0) {
                        //tính delta = b * b - 4 * a * c, delta >0 phương trình có 2 nghiệm (-b + Math.sqrt(delta)) / (2 * a)và (-b - Math.sqrt(delta)) / (2 * a).
                        //hàm Math.sqrt() để tính căn bậc 2.
                        x1 = (double) ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
                        x2 = (double) ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
                        System.out.println("The equation has two solutions: "
                                + "x1 = " + x1 + " và x2 = " + x2);
                    } else if (b * b - 4 * a * c == 0) {
                        //delta = 0 phương trình có nghiệm kép -b / (2 * a).
                        x1 = (-b / (2 * a));
                        System.out.println("The equations has double solutions: "
                                + "x1 = x2 = " + x1);
                    } else {
                        //delta < 0 phương trình vô nghiệm.
                        System.out.println("The equation has no solution!");
                    }
                }

            } else if (choice == 4) {
                //Choice ==4 thực hiện bài tập 4.
                Integer n;
                do {
                    System.out.print("Enter the integer n: ");
                    n = sc.nextInt();
                    if (n >= 1 && n <= 5) {
                        //nếu n thỏa mãn điều kiên của if 1<=n<=5 thì bắt đầu chạy vòng for.
                        for (int i = 1; i <= n; i++) {
                            for (int j = 1; j <= n - i; j++) {
                                System.out.print("  ");
                                //hiện khoảng cách từ trái sang phải theo j
                            }
                            for (int k = 1; k <= 2 * i - 1; k++) {
                                System.out.print("* ");
                                //hiện số * theo k
                            }
                            System.out.println("");
                            //hiện số dòng theo i.
                        }
                    } else if (n > 5 || n < 1) {
                        //nếu n lớn hơn 5 hoặc nhỏ hơn 1 thì báo lỗi.
                        System.out.println("1<=n<=5");
                    }
                } while (n > 5 || n < 1);
            } else if (choice == 5) {
                //Choice =5 kết thúc chương trình.
                break;
            }
            if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                // nếu Choice != 1 , Choice != 2 , Choice != 3, Choice != 4 , Choice != 5 báo lỗi bắt người dùng nhập lại.
                System.out.println("Enter incorrectly, please re-enter.");
            }

        } while (choice != 1 || choice != 2 || choice != 3 || choice != 4 || choice != 5);
        // nếu Choice != 1 , Choice != 2 , Choice != 3, Choice != 4 quay lại vòng lặp.
    }
    
}

/*
* Student name: Mai Tien Dung
* Class: 7c19
* Student ID: 1901040042
* Email: maitiendung14072019@gmail.com
*/
package Assignment;

import java.util.Scanner;


public class maitiendung_1901040042_A01_7C19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner sc = new Scanner(System.in);
        while (true) {
            menu();
            int chon = sc.nextInt();
            switch (chon) {
                case 1:
                    System.out.println("Bạn đã chọn 1");
                    bai1();
                    break;
                case 2:
                    System.out.println("Bạn đã chọn 2");
                    bai2();
                    break;
                case 3:
                    System.out.println("Bạn đã chọn 3");
                    bai3();
                    break;
                case 4:
                    System.out.println("Bạn đã chọn 4");
                    bai4();
                    break;
                case 0:
                    System.out.println("exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn chỉ được chọn từ (0-4)");
                    break;

            }
        }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */


    public static void menu() {
        System.out.println("MENU(xin mời bạn chọn)");
        System.out.println("1. Convert a decimal (base 10) integer to binary (base 2)");
        System.out.println("2. Compute a consecutive square root");
        System.out.println("3. Solve a quadratic equation");
        System.out.println("4. Print a triangle given its size");
        System.out.println("0. exit");

    }

    public static void bai1() {
        System.out.println("Ask the user to enter an integer and print out its binary equivalent.");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int binary[] = new int[40];
        int index = 0;
        while (num > 0) {
            binary[index++] = num % 2;
            num = num / 2;
        }
        for (int i = index - 1; i >= 0; i--) {
            System.out.print("nhị phân của " + num + "là :" + binary[i] + "\n");
        }
    }

    public static void bai2() {
        System.out.println("Ask the user to input two integers: m and n (1 ≤ n ≤ 5), then compute the\n"
                + "expression:\n");
        System.out.println("Xin mời bạn nhập m");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n;
        do {
            System.out.println("Xin mời bạn nhập n");
            n = sc.nextInt();
        } while (n < 1 || n > 5);

        double resul = 0;
        if (n == 1) {
            resul = Math.sqrt(m);
        } else if (n == 2) {
            resul = Math.sqrt(m + Math.sqrt(m));
        } else if (n == 3) {
            resul = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m)));
        } else if (n == 4) {
            resul = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m + Math.sqrt(m))));
        } else {
            resul = Math.sqrt(m + Math.sqrt(m + Math.sqrt(m + Math.sqrt(m) + Math.sqrt(m))));
        }
        System.out.println("kết quả : " + resul);
    }

    public static void bai3() {
        System.out.println("Ask the user to input 3 coefficients a, b and c, then solve the equation:");
        Scanner nhap = new Scanner(System.in);
        System.out.println("xin mơi bạn nhập a");
        double a = nhap.nextDouble();
        System.out.println("xin mơi bạn nhập b");
        double b = nhap.nextDouble();
        System.out.println("xin mơi bạn nhập c");
        double c = nhap.nextDouble();
        double nghiem1, nghiem2, delta;
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("phương trình vô số nghiệm");
                } else {
                    System.out.println("phương trình vô nghiệm");
                }
            } else {
                nghiem1 = -b / a;
                System.out.println("có 1 nghiệm là" + nghiem1);
            }
        } else {
            delta = Math.pow(b, 2) - 4 * a * c;
            if (delta < 0) {
                System.out.println("phương trình vô nghiệm");
            } else if (delta == 0) {
                nghiem1 = -b / 2 * a;
                System.out.println("phương trình co nghiệm kép" + nghiem1);
            } else {
                nghiem1 = (-b + Math.sqrt(delta)) / 2 * a;
                nghiem2 = (-b - Math.sqrt(delta)) / 2 * a;
                System.out.println("phương trình có 2 nghiệm phân biệt");
                System.out.println("nghiệm 1:" + nghiem1);
                System.out.println("nghiệm 2:" + nghiem2);
            }
        }
    }

    public static void bai4() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ask the user to input an integer n (1 ≤ n ≤ 5), then print the following\n"
                + "pattern:\n");
        do {
            System.out.println("Xin mời bạn nhập n\n");
            n = sc.nextInt();
        } while (n < 1 || n > 5);
        for (int i = 1; i <= n; i++) {
            // phần 1
            for (int sp = n - i + 1; sp >= 1; sp--) {
                System.out.print(" ");
            }
            // phần 2
            for (int c = 1; c <= i; c++) {
                System.out.print("*");
            }
            // phần 3
            for (int c = i - 1; c >= 1; c--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}


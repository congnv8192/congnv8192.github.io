import java.util.Scanner;

public class Midterm {
    public static void main(String[] args) throws Exception {
        System.out.println("\nChoose your Function");
        
        int choose;
        Scanner sc = new Scanner(System.in);
        do {
            // show function
            System.out.println("1. Convert a decimal  integer to binary \n" + "2. Compute a consecutive square root\n" + "3. Solve a quadratic equation\n" + "4. Print a triangle given its size\n"+"5.Quit \n");

            System.out.print("Enter your choose : ");
            choose = sc.nextInt();
            System.out.println();
            switch(choose){
                case 1:
                convertToBinary();
                break;
                case 2:
                squareRooot(); 
                break;
                case 3:
                solveEquation();
                break;
                case 4:
                drawTriangle();
                break;
                case 5:
                System.out.println("Quit ....");
                break;
                default:
                System.out.println("Invalid choosen");
                break;

            }
        System.out.println();
            
        } while (choose != 5);
        sc.close();
    }
    // task1
    public static void convertToBinary() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a demical : ");
        int inputDemical = scanner.nextInt();
        int [] saveBinary = new int [100];
        int i = 0;
        while (inputDemical != 0) {
            saveBinary[i++] = inputDemical % 2;
            inputDemical = inputDemical / 2 ;
        }
        System.out.print("Binary = ");
        for (int j = i - 1; j >= 0 ; j--) {
            System.out.print(saveBinary[j]);
        }
  
    }
    //task2
    public static void squareRooot() {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter an integer : ");
        int valueSquare = scanner.nextInt();
        System.out.print("Enter times square : ");
        int timesSquare = scanner.nextInt();
        double sumLoops = 0;
        for(int i = 1; i <= timesSquare;i++){
            sumLoops += (double)valueSquare;
            sumLoops = Math.sqrt(sumLoops);
        }
        System.out.println("result = " + sumLoops);
    }
    //task3
    public static void solveEquation() {
        int a, b ,c;
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter value of a, b, c : "); 
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        double delta = (double)Math.pow(b, 2);
        
        if (a == 0 ){
            System.out.println("x = " + (double) -b / c);
        }
        else if (delta < 0){
            System.out.println("No solution");
        }
        else if(delta == 0){
            double x = (double)(-b / (2*a));
            System.out.println("x1 = x2 = " + x );
        }else{
            double x1 = (double)(-b + Math.sqrt(delta)/ (2 *a));
            double x2 = (double)(-b - Math.sqrt(delta)/(2 * a));
            System.out.println("x1 = " + x1  + "\n"  + "x2 = " + x2);
        }
        
    }
    // task4
    public static void drawTriangle() {
        Scanner scanner = new Scanner(System.in);
        int heightOfTrangile ;
        System.out.print("Enter height of trangile : ");
        heightOfTrangile = scanner.nextInt();
        for (int i = 1; i <= heightOfTrangile;i++ ){
            for (int j = i; j < heightOfTrangile; j++) {
                System.out.print(" ");
            }
            for (int k = 1 ; k < (i*2); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
       
    }
}

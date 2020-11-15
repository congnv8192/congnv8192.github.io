import java.util.Scanner;
import java.lang.Math; 
public class problem2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter integer M:  ");
		int m=sc.nextInt();
		System.out.println("Enter integer N (1 ≤ n ≤ 5) :  ");
		int n=sc.nextInt();
		double total=0;
		for (int i = 0 ;i <n ;i++) 
			
			total = Math.sqrt(total+m);
			
		System.out.println("result ="+total);
	}

}

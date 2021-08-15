package week2;

import java.util.Scanner;

public class Main_1057 {
	static int round;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		func(num1,num2);
		System.out.println(round);
	}
	public static void func(int target1, int target2) {
		
		round++;

		if(target1%2!=0) target1+=1;
		if(target2%2!=0) target2+=1;
		
		if(target2==target1) {
			return;
		}		
		func(target1/2,target2/2);
		
	}
}

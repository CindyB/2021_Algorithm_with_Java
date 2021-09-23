package week7;

import java.util.Scanner;

public class Main_boj_4948_베르트랑공준_방수영 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			int n = sc.nextInt();
			if(n==0)break;
			int cnt=0;
			for(int i=n+1; i<=2*n; i++) {
				if(getPrime(i))cnt++;
			}
			System.out.println(cnt);
		}
	}
	private static boolean getPrime(int n) {
		int cnt=0;
		
		if(n<2)return false;
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i==0)return false;
		}
		return true;
	}
}

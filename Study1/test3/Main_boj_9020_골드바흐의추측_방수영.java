package test3;

import java.util.Scanner;

public class Main_boj_9020_골드바흐의추측_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case<=T; test_case++) {
			
			int result1=0;
			int result2=0;
			
			int n = sc.nextInt();
			for(int i=2; i<=n/2; i++) {
				if(isPrime(i)&&isPrime(n-i)) {
					result1 = i;
					result2 = n-i;
				}
			}
			System.out.println(result1 +" "+result2);
		}
		
	}

	private static boolean isPrime(int num) {
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0)return false;
		}
		return true;
	}

}

package week8;

import java.util.Scanner;

public class Main_boj_2193_이친수_방수영 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n+1];
		
		if(n==1) {
			System.out.println(1);
		}else if(n==2) {
			System.out.println(1);
		}else {
			dp[1] = 1;
			dp[2] = 1;
			for(int i=3; i<=n; i++) {
				dp[i] = dp[i-2]+dp[i-1]; 
			}
			System.out.println(dp[n]);
		}
		
		
	}

}

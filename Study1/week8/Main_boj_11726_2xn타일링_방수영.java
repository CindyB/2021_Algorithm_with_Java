package week8;

import java.util.Scanner;

public class Main_boj_11726_2xn타일링_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==1) {
			System.out.println(1);
			return;
		}
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-2]+dp[i-1];
			dp[i]%=10007;
		}
		System.out.println(dp[n]);
	}

}

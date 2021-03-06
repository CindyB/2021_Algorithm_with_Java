package week7;

import java.util.Scanner;

public class Main_boj_1932_정수삼각형_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				arr[i][j] = sc.nextInt(); 
				if(i==n-1) {
					dp[i][j]=arr[i][j];
				}
			}
		}
		
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				dp[i][j]=Math.max(dp[i+1][j], dp[i+1][j+1])+arr[i][j];
			}
		}
		System.out.println(dp[0][0]);
	}

}

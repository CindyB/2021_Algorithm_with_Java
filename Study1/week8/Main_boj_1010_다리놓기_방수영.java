package week8;

import java.util.Scanner;

public class Main_boj_1010_다리놓기_방수영 {

	static int N, M;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[][] dp = new int[30][30];
		combi(dp);

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

			System.out.println(dp[M][N]);
		}
	}

	private static void combi(int[][] dp) {

		for (int i = 1; i < 30; i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}
		for (int n = 2; n < 30; n++) {
			for (int r = 1; r < 30; r++) {
				dp[n][r] = dp[n - 1][r - 1] + dp[n - 1][r];
			}
		}
	}

}

package week10;

import java.util.Scanner;

public class Main_boj_12865_평범한배낭_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] profit = new int[N + 1];
		int[] weight = new int[N + 1];
		int[] D = new int[K + 1];

		for (int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			profit[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			for (int w = K; w >= weight[i]; w--) {
				D[w] = Math.max(D[w], profit[i] + D[w - weight[i]]);
			}
		}
		System.out.println(D[K]);
	}

}

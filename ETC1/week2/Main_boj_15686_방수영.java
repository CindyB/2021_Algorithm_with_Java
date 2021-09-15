package com.ssafy.algo10;

import java.util.Arrays;
import java.util.Scanner;

public class Main_boj_15686_방수영 {

	static int N, M, cCnt, hCnt;
	static int city, result = Integer.MAX_VALUE;
	static int[][] home;
	static int[][] chicken;
	static int[] number;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
//		map = new int[N+1][N+1];
		home = new int[2 * N][2];
		chicken = new int[13][2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int tmp = sc.nextInt();
				if (tmp == 2) {
					chicken[cCnt][0] = i;
					chicken[cCnt++][1] = j;
				} else if (tmp == 1) {
					home[hCnt][0] = i;
					home[hCnt++][1] = j;
				}
			}
		}
		number = new int[cCnt];
		for(int i=1; i<=M; i++) {
			subset(0, 0, i);
		}
		System.out.println(result);
//		System.out.println(Arrays.toString(chicken));
//		System.out.println(Arrays.toString(home));
	}

	private static void subset(int cnt, int start, int R) {

		if (cnt == R) {
			city=0;
			for (int i = 0; i < hCnt; i++) {
				int min = Integer.MAX_VALUE;

				for (int j = 0; j < R; j++) {
					int d = Math.abs(chicken[number[j]][0] - home[i][0]) + Math.abs(chicken[number[j]][1] - home[i][1]);
					min = Math.min(min, d);
				}
				city += min;
			}
			result = Math.min(result, city);

//			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = start; i < cCnt; i++) {
			number[cnt] = i;
			subset(cnt + 1, i + 1,R);
		}
	}
}

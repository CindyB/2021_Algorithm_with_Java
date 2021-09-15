package com.ssafy.algo11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1074_방수영 {

	static int N, R, C, result;
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int tmp = N;
		System.out.println(func(R, C, tmp));
	}

	private static int func(int r, int c, int tmp) {

		if (tmp == 1) {
			if (r % 2 == 0 && c % 2 == 0)
				return 0;
			if (r % 2 == 0 && c % 2 == 1)
				return 1;
			if (r % 2 == 1 && c % 2 == 0)
				return 2;
			if (r % 2 == 1 && c % 2 == 1)
				return 3;

		}
		if (r < exp2(2, tmp - 1)) {
			if (c < exp2(2, tmp - 1)) {
				return func(r, c, tmp - 1);
			} else {
				return exp2(2, tmp - 1) * exp2(2, tmp - 1) + func(r, c - exp2(2, tmp - 1), tmp - 1);
			}
		} else {
			if (c < exp2(2, tmp - 1)) {
				return 2 * exp2(2, tmp - 1) * exp2(2, tmp - 1) + func(r - exp2(2, tmp - 1), c, tmp - 1);
			} else {
				return 3 * exp2(2, tmp - 1) * exp2(2, tmp - 1)
						+ func(r - exp2(2, tmp - 1), c - exp2(2, tmp - 1), tmp - 1);
			}
		}

	}

	static int exp2(int x, int y) {

		if (y == 1)
			return x;

		int r = exp2(x, y / 2);
		int result = r * r;

		if (y % 2 == 1)
			result *= x; // 홀수일때

		return result;
	}
}

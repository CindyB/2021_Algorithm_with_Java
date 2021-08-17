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
		System.out.println(func(R, C, N));
	}

	private static int func(int r, int c, int tmp) {
		

		if (tmp == 1) {
			if (r == 0 && c == 0)
				return 0;
			if (r == 0 && c == 1)
				return 1;
			if (r == 1 && c == 0)
				return 2;
			if (r == 1 && c == 1)
				return 3;
		}

		int nrCnt = r-exp2(2,tmp-1)>=0 ? r-exp2(2,tmp-1) : r;
		int ncCnt = c-exp2(2,tmp-1)>=0 ? c-exp2(2,tmp-1) : c;

		result += func(nrCnt, ncCnt, tmp-1);

		if (r > 1)
			result += exp2(2, tmp * 2 - 1);
		if (c > 1)
			result += exp2(2, (tmp - 1) * 2);

		return result;

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

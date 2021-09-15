package com.ssafy.algo14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3234_준환이의양팔저울_방수영 {

	static int N, total;
	static int[] arr;
	static int[] selectedNum;
	static boolean[] isSelected;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			isSelected = new boolean[N];
			selectedNum = new int[N];
			result = 0;
			perm(0);
			System.out.println("#" + test_case + " " + result);
		}
	}

	private static void perm(int cnt) {

		if (cnt == N) {
			check(0, 0, 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;

			isSelected[i] = true;
			selectedNum[cnt] = arr[i];
			perm(cnt + 1);

			isSelected[i] = false;

		}
	}

	private static void check(int cnt, int left, int right) {

		if (right > left)
			return;
		if (cnt == N) {
			result++;
			return;
		}

		check(cnt + 1, left + selectedNum[cnt], right);
		check(cnt + 1, left, right + selectedNum[cnt]);

	}
}


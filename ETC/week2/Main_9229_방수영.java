package com.ssafy.algo.hw06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9229_방수영 {

	static int[] arr;
	static int N, M;
	static int max = Integer.MIN_VALUE;
	static boolean check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			max = Integer.MIN_VALUE;
			check = false;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combi(0, 0, 0);
			int result = -1;
			if(check) result =max;
			else result = -1;
			
			System.out.println("#"+test_case+" "+result);
		}
	}

	private static void combi(int cnt, int start, int weight) {
		if (cnt == 2 && weight<=M) {
			max = Math.max(max, weight);
			check = true;
			return;
		}
		for (int i = start; i < N; i++) {
			if(arr[i]+weight >M)continue;
			combi(cnt + 1, i + 1, arr[i] + weight);
		}
	}

}

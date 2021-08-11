package com.ssafy.algo05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1861_방수영 {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			int startRoom =0 ;
			int maxCnt = Integer.MIN_VALUE;
			N = Integer.parseInt(in.readLine());
			int[][] arr = new int[N][N];

			// 입력받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int tmp = check(arr, r, c, 1);
					if(maxCnt<tmp) {
						maxCnt = tmp;
						startRoom = arr[r][c];
					}else if(maxCnt==tmp) {
						if(startRoom>arr[r][c]) {
							startRoom = arr[r][c];
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + startRoom + " " + maxCnt);
		}
	}

	private static int check(int[][] arr, int r, int c, int cnt) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N && (arr[nr][nc] - arr[r][c] == 1)) {
				cnt++;
				return check(arr, nr, nc, cnt);
			}
		}
		return cnt;

	}
}

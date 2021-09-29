package com.ssafy.algo22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_17144_미세먼지안녕_방수영 {

	static int R, C, T;
	static node[][] map;

	static class node {
		int data; // 기존의 확산
		int newdata; // 확산 후 상하좌우에서 얻은 먼지 + 남아있는 먼지

		public node(int data) {
			super();
			this.data = data;
		}

		private void changeMap() {
			this.data = this.newdata;
			this.newdata=0;
		}
	}

	public static void main(String[] args) throws IOException {

		int result = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new node[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = new node(Integer.parseInt(st.nextToken()));
			}
		}
		int[][] air = new int[2][2]; // 공기청정기 좌표
		int k = 0;
		
		for (int t = 0; t < T; t++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					
					if (map[r][c].data == -1 && t==0) {
						air[k][0] = r;
						air[k][1] = c;
						k++;
					} else if (map[r][c].data != 0 && map[r][c].data != -1) {
						int plus = map[r][c].data / 5;
						int cnt = dfs(r, c, plus);
						map[r][c].newdata += map[r][c].data - plus * cnt;
					}
				}
			}
			rotation(air[0][0], air[0][1]);
			rotation2(air[1][0], air[1][1]);
			map[air[0][0]][air[0][1]].newdata = -1;
			map[air[1][0]][air[1][1]].newdata = -1;
			
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					map[r][c].changeMap();
				}
			}
//			for (int r = 0; r < R; r++) {
//				for (int c = 0; c < C; c++) {
//					System.out.print(map[r][c].data+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				result += map[r][c].data;
			}
		}
		System.out.println(result + 2);
	}

	private static int dfs(int r, int c, int plus) {
		// 상하좌우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int cnt = 0;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc].data == -1)
				continue;
			map[nr][nc].newdata += plus;
			cnt++;
		}
		return cnt;
	}

	// 반시계
	private static void rotation(int r, int c) {

		// 우상좌하
		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { 1, 0, -1, 0 };

		int d = 0; // 방향
		int tmp1 = map[r][c].newdata;
		int tmp2 = 0;
		int endR = r;
		int startC = c;
		while (d < 4) {
			// 다음 위치
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr <= endR && nc >= startC && nc < C) {

				tmp2 = map[nr][nc].newdata;
				map[nr][nc].newdata = tmp1;
				tmp1 = tmp2;

				r = nr;
				c = nc;
			} else {
				d++;
			}
		}
	}

	// 시계
	private static void rotation2(int r, int c) {

		// 우하좌상
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int d = 0; // 방향
		int tmp1 = map[r][c].newdata;
		int tmp2 = 0;
		int startR = r;
		int startC = c;
		while (d < 4) {
			// 다음 위치
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= startR && nr < R && nc >= startC && nc < C) {

				tmp2 = map[nr][nc].newdata;
				map[nr][nc].newdata = tmp1;
				tmp1 = tmp2;

				r = nr;
				c = nc;
			} else {
				d++;
			}
		}
	}
}

package com.ssafy.algo21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_14502_연구소_방수영 {

	static int[][] map;
	static int N, M;
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int cnt) {

		if (cnt == 3) {
			// 바이러스 개수 검사
			bfs();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {

					map[i][j] = 1;
					dfs(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void bfs() {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int[][] newMap = copyMap();

		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newMap[i][j] == 2) {
					queue.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}		
		while (!queue.isEmpty()) {

			int[] tmp = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || newMap[nr][nc] == 1)
					continue;
				queue.add(new int[] { nr, nc });
				visited[nr][nc] = true;
				newMap[nr][nc] = 2;
			}
		}
		int result=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newMap[i][j] == 0) {
					result++;
				}
			}
		}
		max = Math.max(max, result);
	}

	private static int[][] copyMap() {

		int[][] newMap = new int[N][M];

		for (int r = 0; r < N; r++) {
			newMap[r] = map[r].clone();
		}
		return newMap;
	}

}

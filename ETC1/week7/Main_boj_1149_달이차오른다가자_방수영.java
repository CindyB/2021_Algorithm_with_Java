package com.ssafy.algo23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_1149_달이차오른다가자_방수영 {

	static int N, M;
	static char[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static node start;
	static Queue<node> queue;
	static boolean[][][] visited;

	static class node {
		int r, c;
		int key; // 소지 정보 , 64이면 모든 열쇠 소지

		public node(int r, int c, int key) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int r = 0; r < N; r++) {
			String tmp = in.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = tmp.charAt(c);
				// 시작 위치 정보
				if (map[r][c] == '0') {
					start = new node(r, c, 0);
				}
			}
		}
		// ------------bfs---------------
		visited = new boolean[N][M][64]; // [f][e][d][c][b][a] : 각 키(알파벳)의 유무를 비트로 표현
		queue = new LinkedList<node>();

		queue.add(start);
		visited[start.r][start.c][start.key] = true;

		int depth = 0;
		while (!queue.isEmpty()) {

			// depth 별 탐색
			int size = queue.size();

			while (size-- > 0) {
				node tmp = queue.poll();

				if (map[tmp.r][tmp.c] == '1') {
					System.out.println(depth);
					return;
				}

				for (int d = 0; d < 4; d++) {
					int nr = tmp.r + dr[d];
					int nc = tmp.c + dc[d];
					int key = tmp.key;	//열쇠 발견 시 열쇠 정보 변경하기 위해 변수 활용
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#' || visited[nr][nc][key])
						continue;

					int val = map[nr][nc];

					// 1) 열쇠인 경우
					if (isKey(val)) {
						key = key | 1 << (val - 'a'); // 키 add
					}
					// 2) 문인 경우
					else if (isDoor(val)) {
						// 맞는 열쇠가 없을 경우
						if ((key & 1 << (val - 'a')) == 0)continue;
					}
					// 3) 나머지 경우 & 공통
					visited[nr][nc][key] = true;
					queue.add(new node(nr, nc, key));

				}
			}
			depth++;
		}
		System.out.println(-1);
	}

	private static boolean isDoor(int val) {
		return val >= 'A' && val <= 'F';
	}

	private static boolean isKey(int val) {
		return val >= 'a' && val <= 'f';
	}

}

package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_1937_욕심쟁이판다_방수영 {

	static int N;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] DP;

	static class node {
		int r, c;
		int data; // 대나무의 양

		public node(int r, int c, int data) {
			super();
			this.r = r;
			this.c = c;
			this.data = data;
		}
//		@Override
//		public int compareTo(node o) {
//			return o.data- this.data;
//		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int result = 0;

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		DP = new int[N][N];

		// 대나무 숲 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
//				int len = BFS(i,j);
//				result = Math.max(result,len);
//				DFS(i, j);
			}
		}
		System.out.println(result);
	}

//	private static void DFS(int r, int c) {
//		for (int d = 0; d < 4; d++) {
//			int nr = r + dr[d];
//			int nc = c + dc[d];
//
//			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] <= tmp.data)
//				continue;
//
//		}
//	}

	private static int BFS(int r, int c) {
		boolean[][] visited = new boolean[N][N];

		Queue<node> queue = new LinkedList<>();
		queue.add(new node(r, c, map[r][c]));
		visited[r][c] = true;

		int length = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				node tmp = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nr = tmp.r + dr[d];
					int nc = tmp.c + dc[d];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] <= tmp.data)
						continue;
					queue.add(new node(nr, nc, map[nr][nc]));
					visited[nr][nc] = true;

				}
			}
			length++;
		}
		return length;
	}

}

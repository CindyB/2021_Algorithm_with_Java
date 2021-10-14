package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_boj_2580_스도쿠_방수영 {

	static final int N = 9;

	static class node {
		int r, c;

		public node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int[][] map;
	static ArrayList<node> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		arr = new ArrayList<>();
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					arr.add(new node(i, j));
				}
			}
		}
		dfs(0);
	}

	private static void dfs(int cnt) {
		if (cnt == arr.size()) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}			
			System.exit(0);
		}
		node tmp = arr.get(cnt);
		int r = tmp.r;
		int c = tmp.c;
		
		for(int i=1; i<=N; i++) {
			if(rowCheck(r, i) && colCheck(c, i) && squaredCheck(r, c, i)) {
				map[r][c]=i;
				dfs(cnt+1);
				map[r][c]=0;
			}
		}
		
	}

	// 가로 체크(해당 행을 기준으로 열 훑어봄)
	private static boolean rowCheck(int r, int num) {
		for (int i = 1; i <= N; i++) {
			if (map[r][i] == num)
				return false;
		}
		return true;
	}

	private static boolean colCheck(int c, int num) {
		for (int i = 1; i <= N; i++) {
			if (map[i][c] == num)
				return false;
		}
		return true;
	}

	private static boolean squaredCheck(int r, int c, int num) {

		for (int i = 3 * ((r - 1) / 3) + 1; i <= 3 * ((r - 1) / 3) + 3; i++) {
			for (int j = 3 * ((c - 1) / 3) + 1; j <= 3 * ((c - 1) / 3) + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}
		return true;
	}
}
/*
 *
0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0
*/

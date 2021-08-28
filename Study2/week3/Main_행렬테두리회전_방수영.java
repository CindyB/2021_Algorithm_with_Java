package week3;

import java.util.Scanner;

public class Main_행렬테두리회전_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][]q = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
//		int[][] q = { { 1, 1, 2, 2 }, { 1, 2, 2, 3 }, { 2, 1, 3, 2 }, { 2, 2, 3, 3 } };
//		int[][] q = {{1,1,100,97}};
		System.out.println(solution(r, c, q));
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = {};
		int[][] arr = new int[rows + 1][columns + 1];
		int cnt = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				arr[i][j] = cnt++;
			}
		}

//		print(rows, columns, arr);
		for (int i = 0; i < queries.length; i++) {
			System.out.println(calc(arr, queries[i]));
//			print(rows, columns, arr);
		}

		return answer;
	}

	private static void print(int rows, int columns, int[][] arr) {
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int calc(int[][] arr, int[] q) {

		int x1 = q[0];
		int y1 = q[1];
		int x2 = q[2];
		int y2 = q[3];

		// 우하좌상
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int d = 0;

		int sr = x1;
		int sc = y1;

		int tmp1 = arr[sr][sc];
		int tmp2 = 0;
		int min = Integer.MAX_VALUE;

		while (d < 4) {

			int nr = sr + dr[d];
			int nc = sc + dc[d];

			if (nr >= x1 && nr <= x2 && nc >= y1 && nc <= y2) {

				min = Math.min(min, tmp1);
				tmp2 = arr[nr][nc];
				arr[nr][nc] = tmp1;
				tmp1 = tmp2;

				sr = nr;
				sc = nc;
			} else {
				d++;
			}
		}
		return min;
	}
}

package week2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1051 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];

		// 구할 수 있는 가장 큰 정사각형 한 변
		int l = Math.min(N, M);
		int result = 0;
		// 수 입력받기
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		while (l > 0) {
			for (int r = 0; r < N - l + 1; r++) {
				for (int c = 0; c < M - l + 1; c++) {
					int[] num = new int[4];
					num[0] = map[r][c];
					num[1] = map[r][c + l - 1];
					num[2] = map[r + l - 1][c];
					num[3] = map[r + l - 1][c + l - 1];

					if (num[0] == num[1] && num[1] == num[2] && num[2] == num[3]) {
						result = l;
						System.out.println(result * result);
						return;
					}
				}
			}
			l--;
		}
		
	}

}

package week2;

import java.util.Scanner;

public class Main_1012 {

	static boolean[][] map;
	static int N,M,K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int result =0;
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();

			map = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				map[Y][X] = true;
			}		
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					
					if(map[r][c]) {
						result++;
						map[r][c]=false;
						dfs(r,c);
					}
				}
			}
			System.out.println(result);
		}
	}
	static void dfs(int r, int c) {
		//상하좌우
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]) {
				map[nr][nc]=false;
				dfs(nr,nc);
			}
		}
			
	}

}

package com.ssafy.algo08;

import java.util.Scanner;

public class Main_boj_16926_방수영 {
	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<R; i++) {
			rotation();
		}
		for(int i =0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void rotation() {
		// 하우상좌
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int group = Math.min(N, M) / 2;

		for (int g = 0; g < group; g++) {
			int r=g;
			int c=g;
			int d=0;	//방향
			int tmp1=arr[r][c];
			int tmp2=0;
			while(d<4) {
				//다음 위치
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr>=g && nr<N-g &&nc>=g &&nc<M-g) {
					
					tmp2 = arr[nr][nc];
					arr[nr][nc] = tmp1;
					tmp1=tmp2;
							
					r=nr;
					c=nc;
				}else {
					d++;
				}
				
				
			}

		}
	}

}

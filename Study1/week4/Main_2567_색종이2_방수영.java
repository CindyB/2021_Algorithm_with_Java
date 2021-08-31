package week4;

import java.util.Scanner;

public class Main_2567_색종이2_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[101][101];
		int N = sc.nextInt();
		int cnt=0;
		
		for(int i=0; i<N; i++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			
			for(int j=r; j<r+10; j++) {
				for(int k=c; k<c+10; k++) {
					map[j][k]=1;
				}
			}
		}
		//상하좌우
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int r=1; r<=100; r++) {
			for(int c=1; c<=100; c++) {
				if(map[r][c]==1) {
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];

						if(map[nr][nc]==0)cnt++;
					}
				}
				
			}
		}
		System.out.println(cnt);	
	}

}

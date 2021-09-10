package week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_2667_단지번호붙이기_방수영 {

	static int N;
	static int[][] map;
	static ArrayList<Integer> houseCnt;
	static int cnt=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		int areaCnt =0;
		houseCnt = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			String tmp = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j]=tmp.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]!=0) {
					areaCnt++;
					map[i][j]=0;
					cnt=1;
					dfs(i,j);
					houseCnt.add(cnt);
				}
			}
		}
		System.out.println(areaCnt);
		Collections.sort(houseCnt);
		for(int i=0; i<houseCnt.size(); i++) {
			System.out.println(houseCnt.get(i));
		}
	}

	private static void dfs(int r, int c) {

		//상하좌우
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]==0) continue;
			map[nr][nc]=0;
			cnt++;
			dfs(nr,nc);		
			
		}
	}
	

}

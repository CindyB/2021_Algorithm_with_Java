package com.ssafy.algo24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_SWEA_1249_보급로_방수영 {

	
	static class node implements Comparable<node>{
		int r, c;
		int cost;
		public node(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		@Override
		public int compareTo(node o) {
			return this.cost- o.cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int test_case=1; test_case<=T; test_case++) {
			
			int cost =0;
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				String tmp = in.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = tmp.charAt(c)-'0';
				}
			}
			boolean[][] visited = new boolean[N][N];
			PriorityQueue<node> queue = new PriorityQueue<node>();
			queue.add(new node(0,0,0));
			visited[0][0] = true;
			
			while(!queue.isEmpty()) {
				node tmp = queue.poll();
				
				if(tmp.r==N-1 && tmp.c==N-1) {
					cost = tmp.cost;
					break;
				}
				
				int[] dr = {-1, 1, 0, 0};
				int[] dc = {0, 0, -1, 1};
				for(int d=0; d<4; d++) {
					int nr = tmp.r+dr[d];
					int nc = tmp.c+dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
					queue.add(new node(nr,nc,tmp.cost+map[nr][nc]));
					visited[nr][nc] = true;
				}
			}
			
			
			
			System.out.println("#"+test_case+" "+cost);
		}
		
	}

}

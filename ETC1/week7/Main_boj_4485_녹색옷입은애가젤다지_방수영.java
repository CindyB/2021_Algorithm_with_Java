package com.ssafy.algo23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_boj_4485_녹색옷입은애가젤다지_방수영 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int min;
	
	static PriorityQueue<node> queue;
	
	static class node implements Comparable<node>{
		int r,c;
		int k;
		public node(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
		@Override
		public String toString() {
			return "node [r=" + r + ", c=" + c + ", k=" + k + "]";
		}

		@Override
		public int compareTo(node o) {
			return this.k - o.k;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for(int test_case=1; ;test_case++) {
			N = Integer.parseInt(in.readLine());
			if(N==0)break;

			min= Integer.MAX_VALUE;
			
			queue = new PriorityQueue<node>();
			map = new int[N][N];			
			visited = new boolean[N][N];
			
			//도둑 루피 크기를 각 원소로 하는 동굴(행렬)입력받기
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(in.readLine());					
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			queue.add(new node(0,0,map[0][0]));
			visited[0][0] = true;
			
			while(!queue.isEmpty()) {

//				for(node a : queue) {
//					System.out.print(a+" ");
//				}
//				System.out.println();
				node tmp = queue.poll();
				
				if(tmp.r==N-1 && tmp.c==N-1) {
					min = tmp.k;
					break;
				}
				
				int[] dr = {-1,1,0,0};
				int[] dc = {0,0,-1,1};
				
				for(int d=0; d<4; d++) {
					int nr = tmp.r + dr[d];
					int nc = tmp.c + dc[d];
					
					
					if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
					
					visited[nr][nc] = true;
					queue.add(new node(nr,nc,tmp.k+map[nr][nc]));
				}				
			}			
			System.out.println("Problem "+test_case+": "+min);
		}		
	}	
}

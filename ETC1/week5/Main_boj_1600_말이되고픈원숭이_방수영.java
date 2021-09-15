package com.ssafy.algo19;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_boj_1600_말이되고픈원숭이_방수영 {

	static class node{
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
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  =new Scanner(System.in);
		int K = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		
		int[][] map = new int[H][W];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//상하좌우		좌상의 위/옆, 우상의 위/옆, 좌하의 아래/옆, 우하의 아래/옆
		int[][] dr = {{-1, 1, 0, 0},{-2, -1, -2, -1, 2, 1, 2, 1 }};
		int[][] dc = {{0, 0, -1, 1},{-1, -2, 1, 2, -1, -2, 1, 2}};
		
		boolean[][][] visited = new boolean[H][W][K+1];
		Queue<node> queue = new LinkedList<>();
		queue.add(new node(0,0,0));
		int length =0;
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			for(node n : queue) {
				System.out.print(length+":  "+ n+"//");
			}
			System.out.println();
			while(--size >=0) {
				
				node tmp = queue.poll();
				if(tmp.r==H-1 && tmp.c==W-1) {
					System.out.println(length);
					return;
				}
				for(int i=0; i<2; i++) {
					
					if(i==1 && tmp.k>=K) continue; 
					
					for(int d=0; d<dr[i].length; d++) {
						int nr = tmp.r + dr[i][d];
						int nc = tmp.c + dc[i][d];
						
						if(nr<0 || nr>=H || nc<0 || nc>=W || map[nr][nc]==1)continue;
						
						map[nr][nc] = map[tmp.r][tmp.c]+1;
						if(i==0) {
							if(visited[nr][nc][tmp.k]) continue;
							queue.add(new node(nr,nc,tmp.k));
							visited[nr][nc][tmp.k] = true;
						}
						if(i==1) {
							if(visited[nr][nc][tmp.k+1]) continue;
							queue.add(new node(nr,nc,tmp.k+1));
							visited[nr][nc][tmp.k+1] = true;
						}
					}
				}
				
			}
			length++;
			
		}
		if(map[H-1][W-1]==0)System.out.println(-1);
	}

}

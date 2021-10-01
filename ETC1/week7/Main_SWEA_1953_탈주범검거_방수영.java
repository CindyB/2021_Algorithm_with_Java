package com.ssafy.algo.hw24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_SWEA_1953_탈주범검거_방수영 {

	static int[][][] typeDir = { { {} }, 
			{ { -1, 1, 0, 0 }, { 0, 0, -1, 1 } }, { { -1, 1 }, { 0, 0 } },{ { 0, 0 }, { -1, 1 } }, { { -1, 0 }, { 0, 1 } },
			{ { 1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, -1 } }, { { -1, 0 }, { 0, -1 } } };

	static class node {
		int r, c;
		int type;
		int typeSize;

		public node(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
			getTypeSize();
		}

		public void getTypeSize() {
			if (this.type == 1)
				this.typeSize = 4;
			else
				this.typeSize = 2;
		}

		@Override
		public String toString() {
			return "node [r=" + r + ", c=" + c + ", type=" + type + ", typeSize=" + typeSize + "]";
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(in.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(in.readLine());
				for (int c = 0; c < M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
		
			Queue<node> queue = new LinkedList<node>();
			boolean[][] visited = new boolean[N][M];

			queue.add(new node(R, C, map[R][C]));
			visited[R][C] = true;

			int depth =0;
			while (!queue.isEmpty()) {

				int size = queue.size();
//				System.out.print(depth +": ");
//				for(node a : queue) {
//					System.out.print(a);
//				}
//				System.out.println();
				
				while (size-- > 0) {
					node tmp = queue.poll();

					for (int d = 0; d < tmp.typeSize; d++) {
						int nr = tmp.r + typeDir[tmp.type][0][d];
						int nc = tmp.c + typeDir[tmp.type][1][d];

						if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 ||visited[nr][nc]) continue;
						if(!isConnected(d, tmp.type, map[nr][nc]))continue;
												
						queue.add(new node(nr, nc, map[nr][nc]));
						visited[nr][nc] = true;
					}
				}
				depth++;
				if(depth==L-1)break;
			}
			int result=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j])result++;
				}
			}
			if(L==1)result=1;
			System.out.println("#"+test_case+" "+result);
		}
	}

	private static boolean isConnected(int d, int now, int next) {		
		
		if(now==1) {
			if(d==0) {
				if(next==1 || next==2|| next==5|| next==6) return true;
			}
			else if(d==1) {
				if(next==1 || next==2|| next==4|| next==7) return true;
			}
			else if(d==2) {
				if(next==1 || next==3|| next==4|| next==5) return true;
			}
			else if(d==3) {
				if(next==1 || next==3|| next==6|| next==7) return true;
			}
		}
		if(now==2) {
			if(d==0) {//현재 상, 다음 파이프는 하
				if(next==1 || next==2|| next==5|| next==6) return true;
			}else if(d==1) {//현재 하, 다음 파이프는 상
				if(next==1 || next==2|| next==4|| next==7) return true;
			}
			
		}
		if(now==3) {
			if(d==0) {//현재 좌, 다음 파이프는 우
				if(next==1 || next==3|| next==4|| next==5) return true;
			}else if(d==1) {//현재 우, 다음 파이프는 좌
				if(next==1 || next==3|| next==6|| next==7) return true;
			}
			
		}
		if(now==4) {
			if(d==0) {//현재 상, 다음 파이프는 하
				if(next==1 || next==2|| next==5|| next==6) return true;
			}else if(d==1) {//현재 우, 다음 파이프는 좌
				if(next==1 || next==3|| next==6|| next==7) return true;
			}
			
		}
		if(now==5) {
			if(d==0) {//현재 하, 다음 파이프는 상
				if(next==1 || next==2|| next==4|| next==7) return true;
			}else if(d==1) {//현재 우, 다음 파이프는 좌
				if(next==1 || next==3|| next==6|| next==7) return true;
			}
			
		}
		if(now==6) {
			if(d==0) {//현재 하, 다음 파이프는 상
				if(next==1 || next==2|| next==4|| next==7) return true;
			}else if(d==1) {//현재 좌, 다음 파이프는 우
				if(next==1 || next==3|| next==4|| next==5) return true;
			}
			
		}
		if(now==7) {
			if(d==0) {//현재 상, 다음 파이프는 하
				if(next==1 || next==2|| next==5|| next==6) return true;
			}else if(d==1) {//현재 좌, 다음 파이프는 우
				if(next==1 || next==3|| next==4|| next==5) return true;
			}
			
		}	
		
		return false;
	}

}
//5
//5 6 2 2 6
//3 0 0 0 0 3
//2 0 0 0 0 6
//1 3 1 1 3 1
//2 0 2 0 0 2
//0 0 4 3 1 1
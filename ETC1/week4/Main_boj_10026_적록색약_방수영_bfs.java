package com.ssafy.algo.hw17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_boj_10026_적록색약_방수영_bfs {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int result;

	static Queue<Node> queue;
	static class Node{
		int r,c;
		char ch;
		public Node(int r, int c, char ch) {
			this.r = r;
			this.c = c;
			this.ch = ch;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			map[i] = tmp.toCharArray();
		}

		for (int k = 0; k < 2; k++) {
			result=0;
			visited = new boolean[N][N];
			queue = new LinkedList<Node>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
						result++;
					}
					if (map[i][j]=='G') map[i][j]='R';
				}
			}
			System.out.print(result+" ");		
		}
	}

	// #로 방문 표시
	private static void bfs(int r, int c) {
		
		visited[r][c]=true;			
		queue.offer(new Node(r,c,map[r][c]));
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = tmp.r + dr[d];
				int nc = tmp.c + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] ||tmp.ch!=map[nr][nc]) continue;
				queue.offer(new Node(nr,nc,map[nr][nc]));
				visited[nr][nc]=true;
			}
		}
		
	}

}

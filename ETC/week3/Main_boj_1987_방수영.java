package com.ssafy.algo.hw13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1987_방수영 {
	
	static int R,C;
	static char[][] board;
	static ArrayList<Character> list;
	static int max = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String tmp = in.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		list = new ArrayList<Character>();
		list.add(board[0][0]);

		calc(0,0);
		System.out.println(max);
	}
	private static void calc(int r, int c) {
		//상하좌우
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr>=0 && nr<R && nc>=0 && nc<C && isAvailable(nr,nc)) {
				list.add(board[nr][nc]);
				calc(nr,nc);
				max = Math.max(max, list.size());
				list.remove(list.indexOf(board[nr][nc]));
			}
		}
	}
	private static boolean isAvailable(int nr, int nc) {
		for(int i=0; i<list.size(); i++) {
			if(board[nr][nc]==list.get(i)) return false;
		}
		return true;
	}
}


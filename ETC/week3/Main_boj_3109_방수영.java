package com.ssafy.algo13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_3109_방수영 {

	static int R, C;
	static char[][] map;
	static int result;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = in.readLine();
			map[i] = tmp.toCharArray();
		}
		for (int r = 0; r < R; r++) {
			map[r][0] = 'x';
			calc(r, 0);
		}
		System.out.println(result);
//		System.out.println(Arrays.deepToString(map));
	
	}

	private static void calc(int r, int c) {
		// 우상, 우, 우하
		int[] dr = { -1, 0, 1 };
		int[] dc = { 1, 1, 1 };
		
		if(c==C-1) {
			result++;
			flag=true;
			return ;
		}
		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
				flag=false;
				map[nr][nc] = 'x';
				calc(nr,nc);
				if(flag) return;	//다 완성 했을 경우 나머지 경우 검사할 필요 없음
				
			}
		}
	}
	
}
/*
 * 
.xx.x.
..x.x.
....x.
...x..
...x..
*/

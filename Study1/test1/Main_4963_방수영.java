package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963_방수영 {

	private static int[][] map;
	private static int result;
	private static int w,h;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		
		while(true) {
			result =0;
			
			st = new StringTokenizer(in.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			map = new int[h][w];
			//지도 정보 입력 받기
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int r =0; r<h; r++) {
				for(int c=0; c<w; c++) {
					if(map[r][c]==1) {
						map[r][c]=0;
						dfs(r,c);
						result++;
					}
				}
			}
			System.out.println(result);
			
		}
	}
	private static void dfs(int r, int c) {
		//상 하 좌 우 좌상 우상 좌하 우하
		int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
		int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
		
		for(int d =0; d<8; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr>=0 && nr<h && nc>=0 && nc<w && map[nr][nc]==1) {
				map[nr][nc]=0;
				dfs(nr,nc);
			}
		}
	}

}

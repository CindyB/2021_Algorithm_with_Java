package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

	static int N, M;
	static int[][] map;
	static Queue<int[]> queue;
	static int[] dr = {-1,1,0,0};	//상하좌우
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		queue = new LinkedList<int[]>();
		map = new int[N][M];

		boolean check = true;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==1) queue.add(new int[] {r,c});
				if(map[r][c]==0) check=false;
			}
		}
		//처음부터 모든 토마토가 익어있는 상태 == 0이 없는 상태
		if(check) {
			System.out.println(0);
			return;
		}
		int length = -1;	//0부터하면 처음부터 1인 애들의 높이도 세어버림
		while(!queue.isEmpty()) {
			
			length++;
			int size = queue.size();
			while(--size >= 0 ) {
				int[] tmp = queue.poll();

				for(int d=0; d<4; d++) {
					int nr = tmp[0] + dr[d];
					int nc = tmp[1] + dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]!=0)continue;
					queue.add(new int[] {nr,nc});
					map[nr][nc]=1;
				}
			}			
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(length);
		
	}

}

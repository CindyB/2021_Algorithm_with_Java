package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_방수영 {

	static int N, M;
	static int[][] map;
	static Queue<int[]> queue;  
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i =0; i<N; i++) {
			st =new StringTokenizer(in.readLine());
			String tmp = st.nextToken();
			for(int j=0; j<M; j++) {
				map[i][j]=tmp.charAt(j)-'0';
			}
		}
		queue = new LinkedList<>();
		queue.offer(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			
			int[] tmp = queue.poll();
			miro(tmp[0],tmp[1]);
		}
		System.out.println(map[N-1][M-1]);
	}
	private static void miro(int r, int c) {
		//상 하 좌 우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for(int d=0; d<4; d++) {
			int nr = r +dr[d];
			int nc = c +dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==1) {
				queue.offer(new int[] {nr,nc});		
				map[nr][nc] = map[r][c]+1;
			}
		}
	}

}

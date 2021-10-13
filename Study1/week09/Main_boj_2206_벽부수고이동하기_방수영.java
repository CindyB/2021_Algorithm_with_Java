package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_2206_벽부수고이동하기_방수영 {

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class node implements Comparable<node>{
		int data;
		int r,c;
		int k;
		public node(int r, int c, int k, int data) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.data = data;
		}
		@Override
		public int compareTo(node o) {
			return this.data- o.data;
		}
	}
	public static void main(String[] args) throws IOException {
		int result = -1;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] visited = new int[N][M];
		for(int i = 0; i<N; i++) {
			String tmp = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j)-'0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<node> queue = new LinkedList<>();
		queue.offer(new node(0,0,0,1));
		visited[0][0] = 0;
		
		while(!queue.isEmpty()) {
			node tmp = queue.poll();
			int r = tmp.r;
			int c = tmp.c;
			
			if(r==N-1 && c ==M-1) {
				result = tmp.data;
				break;
			}
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr<0||nr>=N ||nc<0||nc>=M) continue;
				
				if(visited[nr][nc] <= tmp.k) continue;
				
				//벽일 경우 
				if(map[nr][nc]==1) {
					if(tmp.k==0) {
						visited[nr][nc] = tmp.k+1;
						queue.offer(new node(nr,nc,tmp.k+1,tmp.data+1));
					}
				}
				//벽이 아닐 경우
				else {
					visited[nr][nc] = tmp.k;
					queue.offer(new node(nr,nc,tmp.k,tmp.data+1));
				}
			}
		}
		System.out.println(result);
	}

}

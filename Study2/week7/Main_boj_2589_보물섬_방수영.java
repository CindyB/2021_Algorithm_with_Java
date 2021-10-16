package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_2589_보물섬_방수영 {

	static int R, C;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int max = Integer.MIN_VALUE;
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			String tmp = in.readLine();
			for (int c = 0; c < C; c++) {
				char ch = tmp.charAt(c);
				int data = (ch == 'W') ? 0 : 1;
				map[r][c] = data;
			}
		}
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]!=0) {
					max = Math.max(max, checkBfs(r,c));
				}
			}
		}
		System.out.println(max-1);

	}

	private static int checkBfs(int r, int c) {
		
		int max = Integer.MIN_VALUE;
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		int[][] newMap =copyMap();
		boolean[][] visited = new boolean[R][C];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r,c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			
			int[] tmp = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				
				if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc] || newMap[nr][nc]==0) continue;
				queue.add(new int[] {nr,nc});
				visited[nr][nc] = true;
				newMap[nr][nc] = newMap[tmp[0]][tmp[1]] +1;
				max = Math.max(max, newMap[nr][nc]);
			}
			
		}
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(newMap[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("===============================");
		return max;
		
		

	}

	private static int[][] copyMap() {
		
		int[][] newMap = new int[R][C];

		for (int r = 0; r < R; r++) {
			newMap[r] = map[r].clone();
		}
		return newMap;
	}
}

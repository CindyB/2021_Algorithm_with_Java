package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_14503_로봇청소기 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int cnt = 0;

	// 북,동,남,서
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		st = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(x, y, d);
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int d) {

		// 현재 위치를 청소한다.
		if (map[x][y] == 0) {
			map[x][y] = 2;
			cnt++;
		}

		boolean flag = false;
		int dir = d;
		//2번
		for (int i = 0; i < 4; i++) {
			int nd = (d + 3) % 4;
			int nr = x + dr[nd];
			int nc = y + dc[nd];
			
			
			//왼쪽에 아직 청소하지 않은 공간 존재
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
				dfs(nr, nc, nd); // 방향으로 회전 후 전진 및 1번
				flag = true;
				break;
			}
			d = nd; // 청소할 곳이 없다면 그 방향으로 회전 후 2번으로 돌아감
		}
		
		if (!flag) {	//이미 네 방향 모두 청소가 되어 있거나 벽인 경우 flag가 false 상태
			int nd = (dir + 2) % 4; // 후진후
			int nr = x + dr[nd];
			int nc = y + dc[nd];
			
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {
				dfs(nr, nc, dir); // 방향 유지, 1칸 후진
			}

		}

	}

}

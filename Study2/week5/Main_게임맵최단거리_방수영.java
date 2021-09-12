package week5;

import java.util.LinkedList;
import java.util.Queue;

public class Main_게임맵최단거리_방수영 {

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		solution(maps);
	}

	public static int solution(int[][] maps) {
		//상 하 좌 우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				
				if(nr>=0 && nr<maps.length && nc>=0 && nc<maps[0].length && maps[nr][nc]==1) {
					queue.offer(new int[] {nr,nc});	
					maps[nr][nc] = maps[tmp[0]][tmp[1]]+1;
				}
			}
		}
		int answer = maps[maps.length-1][maps[0].length-1];
		if(answer==1) {
			System.out.println(-1);
			answer=-1;
		}else {			
			System.out.println(answer);
		}
		return answer;
	}

	
}

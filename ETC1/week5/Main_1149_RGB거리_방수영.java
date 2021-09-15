package com.ssafy.algo.hw18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리_방수영 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] cost = new int[N+1][3];
		int[][] D = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			
			cost[i][0] = Integer.parseInt(st.nextToken());	//i번째 집의 빨간색 칠 비용
			cost[i][1] = Integer.parseInt(st.nextToken());	//i번째 집의 초록색 칠 비용
			cost[i][2] = Integer.parseInt(st.nextToken());	//i번째 집의 파란색 칠 비용
		}
		D[1][0] = cost[1][0];
		D[1][1] = cost[1][1];
		D[1][2] = cost[1][2];
		for(int i=2; i<=N; i++) {
			D[i][0] = Math.min(D[i-1][1], D[i-1][2])+ cost[i][0];		//i번째 집을 빨간색으로 칠할때의 최적 = i-1번째까지 집을 파란색 or 초록색으로 칠할 때 중 최소
			D[i][1] = Math.min(D[i-1][0], D[i-1][2])+ cost[i][1];
			D[i][2] = Math.min(D[i-1][0], D[i-1][1])+ cost[i][2];
			
		}
		System.out.println(Math.min(D[N][0], Math.min(D[N][1], D[N][2])));
	}

}

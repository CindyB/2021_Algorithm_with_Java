package com.ssafy.algo.hw22;

import java.util.Scanner;

public class Main_JO_1681_해밀턴순환회로_방수영 {

	static int minCost=Integer.MAX_VALUE;
	static int n;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visited = new boolean[n];
		
		visited[0]=true;	//회사 방문
		dfs(0,0,0);
		System.out.println(minCost);
	}
	private static void dfs(int r, int cnt, int sum) {
		
		if(cnt==n-1) {
			if(map[r][0]==0)return;
			sum+=map[r][0];
			minCost = Math.min(sum, minCost);
			return;
		}
		if(minCost<sum)return;
		for(int i=0; i<n; i++) {	
			
			if(visited[i] || map[r][i]==0)continue;
			visited[i] = true;
			dfs(i,cnt+1,sum+map[r][i]);
			visited[i] = false;
		}
	}

}


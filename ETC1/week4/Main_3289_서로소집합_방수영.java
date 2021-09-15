package com.ssafy.algo16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3289_서로소집합_방수영 {

	static int N, M;
	static int[] parents;
	
	private static void make() {
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	//대표자 찾기
	private static int find(int x) {
		if(x==parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);		
		if(aRoot== bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			make();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(command == 1) {
					if(find(a)==find(b))sb.append(1);
					else sb.append(0);
				}else if(command ==0) {
					union(a,b);
				}
			}
			System.out.println("#"+test_case+" "+sb.toString());
		}
	}

}

package com.ssafy.algo.hw16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_7465_창용마을무리의개수_방수영 {

	static int N,M;
	static int[] parents;
	
	private static void make() {
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return ;
		parents[bRoot] = aRoot;
		return ;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case<=T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			make();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);				
			}
//			System.out.println(Arrays.toString(parents));
			Set<Integer>set = new HashSet<Integer>();
			for(int i=1; i<=N; i++) {
				find(i);
			}
			for(int i=1; i<=N; i++) {
				set.add(parents[i]);
			}
			System.out.println("#"+test_case+" "+set.size());
		}
	}

}

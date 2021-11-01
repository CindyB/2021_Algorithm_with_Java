package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1717_집합의표현_방수영 {

	static int[] parents;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		make();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(command==0) {
				union(a, b);
			}else {
				System.out.println(check(a,b) ? "NO" : " YES");
			}
		}
	}
	private static boolean check(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot)return false;
		else return true;
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot)return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int x) {
		if(parents[x] == x) return x;
		
		return parents[x] = find(parents[x]);
	}

	private static void make() {
		parents = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	

}

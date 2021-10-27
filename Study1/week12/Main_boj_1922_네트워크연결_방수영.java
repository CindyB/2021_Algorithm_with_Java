package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1922_네트워크연결_방수영 {

	static int N;
	static int[] parent;
	static Edge[] edge;
	
	static class Edge implements Comparable<Edge>{
		int start,end,weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {			
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		edge = new Edge[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edge[i] = new Edge(start,end,weight);
		}
		Arrays.sort(edge);
		
		make();
		
		int cnt=0, result=0;
		for(int i=0; i<M; i++) {
			if(union(edge[i].start,edge[i].end)) {
				result += edge[i].weight;
				if(++cnt == N-1) break; 
			}
		}
		System.out.println(result);
		
	}

	private static void make() {
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
	}
	private static int find(int x) {
		if(x==parent[x])return x;
		
		return parent[x] = find(parent[x]);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot;
		return true;		
	}

}

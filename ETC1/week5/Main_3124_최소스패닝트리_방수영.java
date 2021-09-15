package com.ssafy.algo.hw19;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3124_최소스패닝트리_방수영 {

	
	static int V,E;
	static int[] parents;
	static node[] edgeList;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		for(int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			edgeList = new node[E];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				long w = Long.parseLong(st.nextToken());
				
				edgeList[i] = new node(s,e,w);
				
			}
			Arrays.sort(edgeList);
			make();
			
			int cnt =0;	//간선 개수 체크
			long result =0;	//비용 체크
			
			for(node n : edgeList) {
				if(union(n.start,n.end)) {
					result+=n.weight;
					if(++cnt == V-1)break;
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
	static class node implements Comparable<node>{	//간선 리스트
		int start, end;
		long weight;
		public node(int start, int end, long weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(node o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	private static void make() {
		parents = new int[V+1];
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if(a == parents[a] ) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		
		return true;
	}







}

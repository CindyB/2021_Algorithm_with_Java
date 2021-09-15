package com.ssafy.algo17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1251_하나로_방수영 {

	static int N;
	static node[] adjList;
	
	static class node{
		int to;
		long weight;
		node link;
		public node(int to, long weight, node link) {
			this.to = to;
			this.weight = weight;
			this.link = link;
		}
		@Override
		public String toString() {
			return "node [to=" + to + ", weight=" + weight + ", link=" + link + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(in.readLine());
			int[][] tmpXY = new int[N][N]; // tmpXY[0] : X좌표, tmpXY[1] : Y좌표

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					tmpXY[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			adjList = new node[N];
			boolean[] visited = new boolean[N];
			long[] minEdge = new long[N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==j)continue;
					adjList[i] = new node(j,getWeight(tmpXY[0][i],tmpXY[1][i],tmpXY[0][j],tmpXY[1][j]),adjList[i]);
				}
				minEdge[i]=Long.MAX_VALUE;
			}
			minEdge[0] = 0;
			long result=0;
			
			for(int i=0; i<N; i++) {
				long min =Long.MAX_VALUE;
				int minVertex = -1;
				
				for(int j=0; j<N; j++) {
					if(!visited[j] && min>minEdge[j]) {
						min = minEdge[j];
						minVertex = j;
					}
				}
				visited[minVertex] = true;
				result+=min;
				
				for(node p = adjList[minVertex]; p!=null ;p=p.link) {
					if(!visited[p.to] && minEdge[p.to] > p.weight ) {
						minEdge[p.to] = p.weight;
					}
				}
			}
			double E = Double.parseDouble(in.readLine()); 
			long answer =Math.round(result*E);
			System.out.println("#"+test_case+" "+answer);
		}
	}
	private static long getWeight(int x1, int y1, int x2, int y2) {
		long a =(long) Math.pow(x1-x2, 2);
		long b =(long) Math.pow(y1-y2, 2);
		return a+b;
	}
}

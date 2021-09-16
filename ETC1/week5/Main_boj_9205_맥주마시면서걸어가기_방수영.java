package com.ssafy.algo.hw20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_9205_맥주마시면서걸어가기_방수영 {

	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getDistance(Node o) {
			return (Math.abs(x-o.x)+Math.abs(y-o.y));
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//배낭 무게 20, 맥주병 ==가중치
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T =Integer.parseInt(in.readLine());
		for(int test_cast = 1; test_cast<=T; test_cast++) {
			
			int n = Integer.parseInt(in.readLine());
			
			Node[] node = new Node[n+2];
			//0번째는 집, n+1번쨰는 페스티벌 좌표
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				node[i] = new Node(x,y);
			}
			
			boolean[][] D = new boolean[n+2][n+2]; 
			
			for(int i=0; i<n+2; i++) {
				for(int j=i; j<n+2; j++) {
					if(i==j) D[i][j] = false;
					else {
						int tmp = node[i].getDistance(node[j]);
						if(tmp <= 50 * 20) {
							D[i][j] = true;
							D[j][i] = true;
						}
					}
				}
			}
			
			for(int k=0; k<n+2; k++) {				//경유지
				for(int i=0; i<n+2; i++) {			//출발지
					for(int j=0; j<n+2; j++) {		//도착지
						if(D[i][k] & D[k][j]) {
							D[i][j] = true;
						}
					}
				}
			}
			System.out.println(D[0][n+1] ? "happy" : "sad");
						
		}
	}

}

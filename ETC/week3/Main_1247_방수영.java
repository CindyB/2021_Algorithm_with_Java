package com.ssafy.algo13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1247_방수영 {

	static int N;
	static boolean[] isSelected;
	static int[] numbers;
	static int min;
	static Node office, home;
	static Node[] customers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			
			N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			office = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			home = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			customers = new Node[N];
			for(int i=0; i<N; i++) {
				customers[i] =new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			min =Integer.MAX_VALUE;
			
			isSelected = new boolean[N];
			numbers = new int[N];
			moveDistance(0);
			System.out.println("#"+test_case+" "+ min);
		}
	}
	private static void moveDistance(int cnt) {
		
		if(cnt==N) {
			int sum = customers[numbers[0]].getDistance(office);
			for(int i=0; i<N-1; i++) {
				sum+=customers[numbers[i]].getDistance(customers[numbers[i+1]]);
			}
			sum+= customers[numbers[N-1]].getDistance(home);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i])continue;
			
			isSelected[i] = true;
			numbers[cnt] = i;
			
			moveDistance(cnt+1);
			isSelected[i]= false;
		}
	}
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getDistance(Node o) {
			return Math.abs(this.x-o.x)+Math.abs(this.y-o.y);
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}

}

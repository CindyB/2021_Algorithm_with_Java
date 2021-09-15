package com.ssafy.algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_2961_방수영 {

	static boolean[] isSelected;
	static int N;
	static Food[] food;
	static long min=Long.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());

		food = new Food[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			food[i] = new Food(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
		}
		isSelected = new boolean[N];
		
		subset(0);
		System.out.println(min);
	}
	private static void subset(int cnt) {
		
		if(cnt == N) {
			boolean flag = false;
			long S=1,B=0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					flag = true;
					S*=food[i].s;
					B+=food[i].b;
				}
			}
			if(!flag)return;
			else {
				min = Math.min(min, S-B>0 ? S-B : B-S);
				return;
			}
		}
		isSelected[cnt]=true;
		subset(cnt+1);
		
		isSelected[cnt]=false;
		subset(cnt+1);
		
	}
	static class Food{
		long s,b;

		public Food(long s, long b) {
			super();
			this.s = s;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Food [s=" + s + ", b=" + b + "]";
		}
		
	}

}

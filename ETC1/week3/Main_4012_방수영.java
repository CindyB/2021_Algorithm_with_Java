package com.ssafy.algo12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4012_방수영 {

	static int N,min = Integer.MAX_VALUE;
	static int[][] foods;
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		for(int test_case =1; test_case<=T; test_case++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(in.readLine());
			foods = new int[N][N];
			
			for(int i =0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++) {
					foods[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			isSelected = new boolean[N];
			combi(0,0);
			System.out.println("#"+test_case+" "+min);
		}

	}
	private static void combi(int cnt, int start) {
		
		if(cnt==N/2) {
			cook();
			return;
		}
		for(int i=start; i<N; i++) {
			isSelected[i] = true;
			combi(cnt+1,i+1);
			isSelected[i] = false;
			
		}
	}
	private static void cook() {
		
		int dishA,dishB;
		dishA=dishB =0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(isSelected[i]&&isSelected[j]) {
					dishA+=foods[i][j];
				}else if(!isSelected[i]&&!isSelected[j]) {
					dishB+=foods[i][j];
				}
			}
		}
		min =Math.min(min, Math.abs(dishA-dishB));
	}

}

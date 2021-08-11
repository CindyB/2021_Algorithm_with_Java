package com.ssafy.algo06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5215_방수영 {

	static int calLimit ;
	static int N;
	static int[] scores; 
	static int[] cals; 
	static int max = Integer.MIN_VALUE;
	static boolean check; 
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case<=T; test_case++) {
			
            max = Integer.MIN_VALUE;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			calLimit = Integer.parseInt(st.nextToken());
			
			scores = new int[N];
			cals = new int[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				cals[i] = Integer.parseInt(st.nextToken());
			}
			test(0,0,0);
			System.out.println("#"+test_case+" "+ max);
		
		}
	}
	private static void test(int start, int calSum, int scoreSum) {
		if(calSum>calLimit) {
			check = true;			
			return;
		}else if(calSum == calLimit) {
			max = Math.max(scoreSum, max);
			return;
		}else {
			max = Math.max(scoreSum, max);
		}
		
		for(int i=start; i<N; i++) {
			
			test(i+1,calSum+cals[i],scoreSum+scores[i]);
			if(check) {
				max = Math.max(scoreSum, max);
				check = false;	
			}
		}
	}
}

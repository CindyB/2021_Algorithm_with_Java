package com.ssafy.algo20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_SWEA_3307_최장증가부분수열_방수영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T =Integer.parseInt(in.readLine());
		for(int test_cast = 1; test_cast<=T; test_cast++) {
			
			int N = Integer.parseInt(in.readLine());	//수열의 길이
			int[] arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] LIS = new int[N];
			int max =0;	//결과 -> 최대값
			for(int i=0; i<N; i++) {
				LIS[i] = 1;				
				for(int j=0; j<i; j++) {
					if(arr[j]<arr[i] && LIS[i] < LIS[j]+1) {
						LIS[i]=LIS[j]+1;
					}					
				}
				if(max<LIS[i])
					max =LIS[i];
			}
			System.out.println("#"+test_cast+" "+max);
		}
	}

}

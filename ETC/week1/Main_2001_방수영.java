package com.ssafy.algo.hw03;

import java.util.Scanner;
import java.io.FileInputStream;

public class Main_2001_방수영 {
	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("2001.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int max = Integer.MIN_VALUE;
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			int sum=0;
			int count = (1+N-M);
			
			for(int i=0; i<count; i++) {
				for(int j=0; j<count; j++) {
					
					for(int p=i; p<i+M; p++) {
						for(int q=j; q<j+M; q++) {
							sum+=arr[p][q];
						}
					}
					max = sum>max ? sum : max;
					sum=0;
				}
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
}
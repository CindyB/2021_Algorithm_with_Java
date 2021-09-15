package com.ssafy.algo.hw02;

import java.util.Scanner;
import java.io.FileInputStream;

public class Main_1954_방수영 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N=sc.nextInt();
			int[][] arr = new int[N][N];
			int count=1;

			System.out.println("#"+test_case);
			int r=0,c=-1;
			int change=1;
			int size=N;
			
			while(true) {
				for(int j=0; j<size; j++) {
					c+=change;
					arr[r][c]=count++;
				}
				size--;
				
				if(size<0)break;
				
				for(int j=0; j<size; j++) {
					r+=change;
					arr[r][c]=count++;
				}
				change *=-1;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
/*
 * 1  2  3  4
 * 12 13 14 5
 * 11 16 15 6
 * 10 9  8  7
*/
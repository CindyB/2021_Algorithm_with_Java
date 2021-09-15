package com.ssafy.algo.hw07;

import java.util.Scanner;

public class Main_boj_2563_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[100][100];
		
		int N= sc.nextInt();
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int r=y; r<y+10; r++) {
				for(int c=x; c<x+10; c++ ) {
					arr[r][c]=1;
				}
			}
		}
		int sum=0;
		for(int[] num : arr) {
			for(int number : num) {
				sum+=number;
			}
		}
		System.out.println(sum);
	}

}

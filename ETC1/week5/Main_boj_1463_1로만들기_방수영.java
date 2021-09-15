package com.ssafy.algo18;

import java.util.Scanner;

public class Main_boj_1463_1로만들기_방수영 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n+1];
		
		d[1] = 0;
		for(int i=2; i<=n; i++) {
			int min = Integer.MAX_VALUE;
			if(i%3==0) {
				min = Math.min(d[i/3]+1, min);
			}
			if(i%2==0) {
				min = Math.min(d[i/2]+1, min);
			}
			min = Math.min(d[i-1]+1, min);
			d[i] = min;
		}
		System.out.println(d[n]);
	}
}

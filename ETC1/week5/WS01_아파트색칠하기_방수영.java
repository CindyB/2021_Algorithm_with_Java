package com.ssafy.algo18;

import java.util.Scanner;

public class WS01_아파트색칠하기_방수영 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] d = new int[n+1][2];
		
		d[1][0]=1;	//1층 아파트를 노란색으로 칠한 경우
		d[1][1]=1;	//1층 아파트를 파란색으로 칠한 경우
		
		for(int i=2; i<=n; i++) {
			d[i][0] = d[i-1][0]+d[i-1][1];
			d[i][1] = d[i-1][0];
		}
		System.out.println(d[n][0]+d[n][1]);
	}
}
//f(8)=>55 f(6)=>169
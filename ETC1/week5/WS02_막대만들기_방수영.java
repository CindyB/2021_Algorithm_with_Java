package com.ssafy.algo18;

import java.util.Scanner;

public class WS02_막대만들기_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n+1];
		d[0] = 1;
		d[1] = 2;
		for(int i=3; i<=n; i++) {
			d[i] = d[i-1]*2 + d[i-2];	//빨간 막대의 경우 icm의 최적해는 i-2cm의 최적해를 더함
		}
		System.out.println(d[n]);
	}

}

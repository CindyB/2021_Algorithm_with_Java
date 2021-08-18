package com.ssafy.algo.hw12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1992_방수영 {
	static int N;
	static int[][] arr;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		//영상 입력 받기
		for(int i=0; i<N; i++) {
			String tmp = in.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = tmp.charAt(j)-'0';
			}
		}
		func(0,0,N);
		System.out.println(result.toString());
	}
	//같은 원소로 이루어져있는 지 판단
	public static boolean check(int r, int c, int n) {
		int now = arr[r][c]; // 
		
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(arr[i][j]!=now) return false;
			}
		}
		return true;
	}
	public static void func(int r, int c, int n) {
		
		if(check(r,c,n)) {
			result.append(arr[r][c]);
		}else {
			result.append("(");
			int size = n/2;
			
			func(r,c,size);
			func(r,c+size,size);
			func(r+size,c,size);
			func(r+size,c+size,size);
			
			result.append(")");
		}		
	}

}

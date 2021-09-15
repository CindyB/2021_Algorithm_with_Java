package com.ssafy.algo03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2805_방수영 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("2805.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case<=T; test_case++) {
			int sum=0;
			int N = sc.nextInt();
			int[][] map=new int[N][N];
			// 입력받음
			for(int i=0; i<N; i++) {
				String tmp = sc.next();
				for(int j=0; j<N; j++) {
					map[i][j]=tmp.charAt(j)-'0';
				}
			}

			int cnt=0;
			int mid = N/2;
			for(int i=0; i<N; i++) {
				
				int left=mid-cnt;
				int right=mid+cnt;
				for(int j=left; j<=right; j++) {
					sum+=map[i][j];
				}
				if(i<mid) {
					cnt++;
				}else {
					cnt--;
				}
			}
			System.out.println("#"+test_case+" "+sum);
			
		}
	}

}

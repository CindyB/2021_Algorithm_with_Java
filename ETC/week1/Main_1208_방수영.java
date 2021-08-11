package com.ssafy.algo02;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Main_1208_방수영 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("1208.txt"));

		Scanner sc = new Scanner(System.in);
		int T=10;

		for (int test_case = 1; test_case <= T; test_case++) {
			//덤프 횟수
			int count = sc.nextInt();
			//높이 입력
			int[] arr = new int[100];
			for(int i=0; i<arr.length; i++)
			{
				arr[i]=sc.nextInt();
			}
			Arrays.sort(arr);
			for(int i=0; i<count; i++) {
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
			}
			System.out.printf("#%d %d\n",test_case,arr[99]-arr[0]);
			
		}
	}
}
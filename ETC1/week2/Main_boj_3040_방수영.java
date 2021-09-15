package com.ssafy.algo.hw09;

import java.util.Arrays;
import java.util.Scanner;

public class Main_boj_3040_방수영 {
	
	static int[] num;
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = new int[9];
		numbers = new int[7];
		for(int i=0; i<9; i++) {
			num[i] = sc.nextInt();
		}
		
		combi(0,0);
	}
	private static void combi(int cnt, int start) {
		if(cnt == 7) {
			int sum=0;
			
			for(int i=0; i<7; i++) {
				sum+=numbers[i];
			}
			if(sum==100) {
				for(int i=0; i<7; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		for(int i=start; i<9; i++) {
			
			numbers[cnt] = num[i]; 
			combi(cnt+1,i+1);
		}
	}
}

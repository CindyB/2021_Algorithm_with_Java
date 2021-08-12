package com.ssafy.algo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6808_방수영 {

	static boolean[] isSelected;
	static int[] numbers;
	static int[] card2;
	static int[] card1;
	static int winCnt,loseCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case<=T; test_case++) {
			winCnt=0;
			loseCnt=0;
			st = new StringTokenizer(in.readLine());
			card1 = new int[9]; //규영
			card2 = new int[9];// 미영
			//9장 카드 정보 입력 받기 (규영)
			for(int i=0; i<9; i++) {
				card1[i] = Integer.parseInt(st.nextToken());
			}
			//미영이 카드 정보 찾기
			int cnt=0;
			boolean flag =false;
			for(int i=1; i<=18; i++) {
				for(int j=0; j<9; j++) {
					if(card1[j] == i) {
						flag= true;
					}
				}
				if(!flag) {
					card2[cnt++]=i;
				}
				flag=false;
			}
			//미영이 위치 경우 찾기
			isSelected = new boolean[9];
			numbers = new int[9];
			perm(0);
			System.out.println("#"+test_case+" "+winCnt+" "+loseCnt);
		}
	}
	private static void perm(int cnt) {
		if(cnt==9) {
			compare();
			return;
		}
		for(int i=0; i<9; i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt]=card2[i];
			isSelected[i] = true;
			perm(cnt+1);
			
			isSelected[i] = false;
		}
	}
	private static void compare() {
		int sum1=0, sum2=0;
		
		for(int i=0; i<9; i++) {
			int check =card1[i]-numbers[i];
			if(check>0) {
				sum1 += card1[i]+numbers[i];
			}else {
				sum2 += card1[i]+numbers[i];
			}
		}
		if(sum1>sum2) {
			winCnt++;
		}else {
			loseCnt++;			
		}
	}
}
/*

4
1 3 5 7 9 11 13 15 17
18 16 14 12 10 8 6 4 2
13 17 9 5 18 7 11 1 15
1 6 7 9 12 13 15 17 18	
*/


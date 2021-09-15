package com.ssafy.algo02;

import java.util.Scanner;
import java.io.FileInputStream;

class Main_1210_방수영 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("1210.txt"));

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int t = sc.nextInt();

			// 사다리 정보 입력
			int[][] ladder = new int[100][100];
			int x = 0, y=98;
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			//당첨 라인 찾아서 x에 넣기
			for (int i = 0; i < 100; i++) {
				if (ladder[99][i] == 2) {
					x=i;
					break;
				}
			}
			while(y>0) {
				//왼쪽에 1 존재 여부 확인후 쭉~~이동
				if(x>=1 && ladder[y][x-1]==1) {
					while(x>=1 && ladder[y][x-1]==1) {
						x--;
					}
				}
				else if(x<=98 && ladder[y][x+1]==1) {
					while(x<=98 && ladder[y][x+1]==1){
						x++;
					}
				}
				y--;				
			}
			System.out.printf("#%d %d\n", t, x);
		}
	}

}
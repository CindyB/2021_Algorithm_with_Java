package com.ssafy.algo.hw08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3_방수영 {

	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 연산 종류 한줄로 받기
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < R; i++) {
			int type = Integer.parseInt(st.nextToken());
			switch (type) {
			case 1:
				calc1();
//				print1();
				break;
			case 2:
				calc2();
//				print1();
				break;
			case 3:
				calc3();
//				print2();
				break;
			case 4:
				calc4();
//				print2();
				break;
			case 5:
				calc5();
//				print1();
				break;
			case 6:
				calc6();
//				print1();
				break;

			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void print1() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void print2() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void calc6() {
		int[][] copy = new int[arr.length][arr[0].length];
		int rMid = arr.length/2;
		int cMid = arr[0].length/2;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j< arr[0].length; j++) {
				//1번 그룹 -> 4번 그룹
				if(i<rMid && j<cMid ) {
					copy[i+rMid][j]=arr[i][j];
				}
				//2번 그룹 -> 1번 그룹
				if(i<rMid && j>=cMid ) {
					copy[i][j-cMid]=arr[i][j];
				}
				//3번 그룹 -> 2번 그룹
				if(i>=rMid && j>=cMid ) {
					copy[i-rMid][j]=arr[i][j];
				}
				//4번 그룹 -> 3번 그룹
				if(i>=rMid && j<cMid ) {
					copy[i][j+cMid]=arr[i][j];
				}
			}
		}
		arr = copy;
	}

	private static void calc5() {
		int[][] copy = new int[arr.length][arr[0].length];
		int rMid = arr.length/2;
		int cMid = arr[0].length/2;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				//1번 그룹 -> 2번 그룹
				if(i<rMid && j<cMid ) {
					copy[i][j+cMid]=arr[i][j];
				}
				//2번 그룹 -> 3번 그룹
				if(i<rMid && j>=cMid ) {
					copy[i+rMid][j]=arr[i][j];
				}
				//3번 그룹 -> 4번 그룹
				if(i>=rMid && j>=cMid ) {
					copy[i][j-cMid]=arr[i][j];
				}
				//4번 그룹 -> 1번 그룹
				if(i>=rMid && j<cMid ) {
					copy[i-rMid][j]=arr[i][j];
				}
			}
		}
		arr = copy;
	}

	private static void calc4() {
		int[][] copy = new int[arr[0].length][arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				copy[arr[0].length-1-j][i] = arr[i][j];
			}
		}
		arr = copy;
	}

	private static void calc3() {
		int[][] copy = new int[arr[0].length][arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				copy[j][arr.length - 1 - i] = arr[i][j];
			}
		}
		arr = copy;
	}

	private static void calc2() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length / 2; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[i][arr[0].length - 1 - j];
				arr[i][arr[0].length - 1 - j] = tmp;
			}
		}
	}

	private static void calc1() {
		for (int i = 0; i <arr.length / 2; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[arr.length - 1 - i][j];
				arr[arr.length - 1 - i][j] = tmp;
			}
		}
	}

}

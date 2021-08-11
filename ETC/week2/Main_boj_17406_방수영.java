package com.ssafy.algo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_boj_17406_방수영 {
	static int min = Integer.MAX_VALUE;
	static int N, M, K;
	static int[][] arr;
	static int [][] arr2;
	static boolean[] selected;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//배열 입력받기
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arr2 = new int[K][3];
		selected = new boolean[K];
		numbers = new int[K];
		//연산 입력 받기
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(in.readLine());
			arr2[i][0] = Integer.parseInt(st.nextToken());
			arr2[i][1]= Integer.parseInt(st.nextToken());
			arr2[i][2] = Integer.parseInt(st.nextToken());
		}

		perm(0);
		System.out.println(min);
//		for(int i =0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				sb.append(arr[i][j]).append(" ");
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb);
	}
	//순열
	private static void perm(int cnt) {
		if(cnt==K) {
			int[][] copy = new int[N][M];
			
			for(int i=0; i<arr.length; i++){
	            copy[i] = arr[i].clone();
	        }
			for(int i=0; i<K; i++) {
				rotation(arr2[numbers[i]][0],arr2[numbers[i]][1],arr2[numbers[i]][2],copy);
			}
			findMin(copy);
			
			return;
		}
		for(int i=0; i<K; i++) {
			if(selected[i]) continue;
			
			numbers[cnt]=i;
			selected[i]=true;
			
			perm(cnt+1);
			selected[i]=false;
		}
	}
	private static void findMin(int[][] map) {
		int sum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sum+=map[i][j];
			}
			min=Math.min(sum, min);
			sum=0;
		}
	}
	
	private static void rotation(int r, int c, int s,int[][] map) {
		// 우하좌상
		int[] dr = { 0,1,0,-1};
		int[] dc = { 1,0,-1,0 };
		int group = (2*s+1)/2;
		
		for (int g = 0; g < group; g++) {
			//시작 위치
			int sr=r-s-1+g;
			int sc=c-s-1+g;
			
			int d=0;	//방향
			
			int tmp1=map[sr][sc];
			int tmp2=0;
			
			while(d<4) {
				//다음 위치
				int nr = sr+dr[d];
				int nc = sc+dc[d];
				
				if(nr>=(r-s-1+g) && nr<(r+s-g) && nc>=(c-s-1+g) &&nc<(c+s-g)) {
					
					tmp2 = map[nr][nc];
					map[nr][nc] = tmp1;
					tmp1=tmp2;
							
					sr=nr;
					sc=nc;
				}else {
					d++;
				}				
			}

		}
	}

}

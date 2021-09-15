package com.ssafy.algo14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_boj_15683_감시_방수영 {

	static int min = Integer.MAX_VALUE;
	static int N, M;
	static int[][] arr;
	static ArrayList<Node> cctv;
	static int[] selectedTypeCase;	//해당 cctv에서 선택된 회전 정보
					  //우상좌하
	static int[] dr = {0,-1,0,1};
	static int[] dc = {1,0,-1,0};
	//typeCase[cctv Type][회전종류][우상좌하(dr/dc)중에 해당하는 index ]
	static int[][][] typeCase= {{},
								{{0},{1},{2},{3}},	
								{{0,2},{1,3}},		//우좌, 상하
								{{0,1},{1,2},{2,3},{0,3}},
								{{0,1,2},{1,2,3},{0,2,3},{0,1,3}},
								{{0,1,2,3}}
								};
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cctv = new ArrayList<Node>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] =  Integer.parseInt(st.nextToken());
				
				if(arr[i][j]!=0 && arr[i][j]!=6) {
					cctv.add(new Node(i,j,arr[i][j]));
				}
			}
		}
		selectedTypeCase = new int[cctv.size()];	//조합된 회전 경우 담을 예정
		combi(0);
		System.out.println(min);
	}
	static void combi(int cnt) {
		
		if(cnt == cctv.size()) {
			int[][] copyArr = copyArray(arr);
			watch(copyArr);
			int tmp = check(copyArr);
			min = Math.min(min, tmp);
			return;
		}
		for(int i=0; i<cctv.get(cnt).caseCnt; i++) {
			selectedTypeCase[cnt]=i;
			combi(cnt+1);
		}
	}
	static void watch(int[][] copyArr) {
		
		for(int i=0; i<cctv.size(); i++) {
			for(int d : typeCase[cctv.get(i).type][selectedTypeCase[i]]) {
				int r = cctv.get(i).r;
				int c = cctv.get(i).c;
				
				while(true) {
					r += dr[d];
					c += dc[d];
					
					if(r<0 || r>=N || c<0|| c>=M || copyArr[r][c] ==6)break;
					copyArr[r][c] = -1;	//cctv영역 마킹
				}
			}
			
		}
	}
	static int[][] copyArray(int[][] arr){
		int[][] copyArr = new int[N][M];
		for(int i=0; i<N; i++) {
			copyArr[i] = arr[i].clone();
		}
		return copyArr;
	}
	static int check(int[][] copyArr) {
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyArr[i][j]==0)cnt++;
			}
		}
		return cnt;
	}
	static class Node{
		int r,c;
		int type;
		int caseCnt;		///ccty 종류별 회전할 떄 나타날 수 있는 경우의 수
		public Node(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
			if(type==2)this.caseCnt=2;
			else if(type==5)this.caseCnt=1;
			else this.caseCnt=4;
		}
		
	}
}

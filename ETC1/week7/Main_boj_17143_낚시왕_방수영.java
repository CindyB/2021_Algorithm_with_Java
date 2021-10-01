package com.ssafy.algo25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_17143_낚시왕_방수영 {

	static class Shark {
		int r, c, s, d, z;
		int state; // 0:살아있음, 1: 낚아짐(map에서 제외), 2: 잡아먹힘(죽음->map에서 제외)

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

	static int[][] map;
	static Shark[] shark;
	static int R, C, M;

	// 상하우좌
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 1, -1 };
	static int[][] type = { { 0 }, { 1, 2 }, { 2, 1 }, { 3, 4 }, { 4, 3 } }; // type : 공백(0), 상(1),하(2),우(3),좌(4)

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[R + 1][C + 1];
		shark = new Shark[M + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark[i] = new Shark(r, c, s, d, z);
			map[r][c] = i; // map에 상어 위치를 상어 숫자로 저장
		}
//		view();		//초기상태
		for (int t = 1; t <= C; t++) {
//			System.out.println("=======================");
//			view();
			fishing(t);
			move();
			map = setting();
//			view();
		}
		int result=0;
		for(int i=1; i<=M; i++) {
			if(shark[i].state==1) result+=shark[i].z;
		}
		System.out.println(result);
	}

	private static void fishing(int t) {
		//행 탐색
		for (int r = 1; r <= R; r++) {
			if (map[r][t] != 0) { // 해당 열에서 가장 가까운 행의 상어 낚시!
				// fish
				shark[map[r][t]].state = 1; // 낚아진 상태로 변환
				map[r][t] = 0;
				return;
			}
		}		
	}

	private static int[][] setting() {
		int[][] newMap = new int[R + 1][C + 1];
		
		for (int i = 1; i <= M; i++) {
			if (shark[i].state == 0) {
				int r = shark[i].r;
				int c = shark[i].c;
				
				if(newMap[r][c]!=0) {
					int num = newMap[r][c];
					
					if(shark[num].z>shark[i].z) {
						shark[i].state = 2;	//새로 들어온 상어가 더 작아서 잡아먹힘
					}else {
						newMap[r][c] = i;
						shark[num].state=2;	//새로 들어온 상어가 더 커서 잡아먹힘
					}
				}else {
					newMap[r][c] = i; // map에 상어 위치를 상어 숫자로 저장
				}
				
			}
		}
		return newMap;
	}

	private static void view() {
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void move() {
		
		for (int i = 1; i <= M; i++) {
			
			if (shark[i].state == 0) {
				int r = shark[i].r;
				int c = shark[i].c;
				int s = shark[i].s;
				int dir = shark[i].d;
				
				int d=0;
				for(int si = 0; si<s; si++) {
										
					r = r+ dr[type[dir][d]];
					c = c+ dc[type[dir][d]];
					
					if(r<1|| r>R || c<1 || c>C) {
						if(d==0) d++;
						else if(d==1)d--;
						r = r+ dr[type[dir][d]];
						c = c+ dc[type[dir][d]];
						si--;
					}
				}
				shark[i].c = c;
				shark[i].r = r;				
				shark[i].d = type[dir][d]; 
			}
		}
	}
}

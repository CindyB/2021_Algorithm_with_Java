package com.ssafy.algo.hw26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_SWEA_4014_활주로건설_방수영 {

	static int N, X;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int result = 0;
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 행 check
			for (int r = 0; r < N; r++) {
				if (isPossible(r, true)) { // 경사 차이가 없으면 활주로 건설 ok
					result++;
				} else { // 경사 차이가 있을 경우 경사로 설치
					if (canInstall(r, true)) { // 설치할 수 있으면 설치 => 활주로 건설 ok
						result++;
					}
				}
			}
			// 열 check
			for (int c = 0; c < N; c++) {
				if (isPossible(c, false)) { // 경사 차이가 없으면 활주로 건설 ok
					result++;
				} else { // 경사 차이가 있을 경우 경사로 설치
					if (canInstall(c, false)) { // 설치할 수 있으면 설치 => 활주로 건설 ok
						result++;
					}
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

	private static boolean canInstall(int i, boolean flag) {
		
		boolean[] visited = new boolean[N];
		int cnt =0;	//설치 길이 카운팅
		
		// 행 탐색일 경우(행 고정, 열 움직)
		if (flag) {
			int before = map[i][0];
			for (int c = 0; c < N; c++) {
				int now = map[i][c];
				
				if (now == before) cnt++;
				else  {
					//한칸 높아질 경우
					if(now == before+1) {
						if(X<=cnt) {
							for(int k=c-X; k< c; k++) {
								if(visited[k])return false;	//경사로가 겹칠 경우
								visited[k] = true;
							}
							cnt=1;
						}else {	//범위를 벗어날 경우
							return false;
						}
					}
					//한칸 낮아질 경우
					else if(now == before -1) {
						if(c+X-1<N) {	//설치해도 범위를 벗어나지 않는다면
							for(int k=c; k< c+X; k++) {
								if(visited[k] || map[i][k] != now)return false;	//경사로가 겹칠 경우 or X길이 전에 경사가 달라질 경우
								visited[k] = true;
							}
							cnt=0;
							c=c+X-1;
						}else {	//범위를 벗어날 경우
							return false;
						}
					}
					else return false;
				}
				before= now;
			}		
			
			
		} else {// 열 탐색일 경우(열고정, 행 움직)
			int before = map[0][i];
			for (int r = 0; r < N; r++) {
				int now = map[r][i];
				
				if (now == before) cnt++;
				else  {
					//한칸 높아질 경우
					if(now == before+1) {
						if(X<=cnt) {
							for(int k=r-X; k< r; k++) {
								if(visited[k])return false;	//경사로가 겹칠 경우
								visited[k] = true;
							}
							cnt=1;
						}else {	//범위를 벗어날 경우
							return false;
						}
					}
					//한칸 낮아질 경우
					else if(now == before -1) {
						if(r+X-1<N) {	//설치해도 범위를 벗어나지 않는다면
							for(int k=r; k< r+X; k++) {
								if(visited[k] || map[k][i] != now)return false;	//경사로가 겹칠 경우
								visited[k] = true;
							}
							cnt=0;
							r=r+X-1;
						}else {	//범위를 벗어날 경우
							return false;
						}
					}
					else return false;
				}
				before= now;
			}		
		}
		return true;
	}

	private static boolean isPossible(int i, boolean flag) {

		// 행 탐색일 경우(행 고정, 열 움직)
		if (flag) {
			int tmp = map[i][0];
			for (int c = 1; c < N; c++) {
				if (map[i][c] != tmp)
					return false;
			}
		} else {// 열 탐색일 경우(열고정, 행 움직)
			int tmp = map[0][i];
			for (int r = 1; r < N; r++) {
				if (map[r][i] != tmp)
					return false;
			}
		}

		return true;
	}

}

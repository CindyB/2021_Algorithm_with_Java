package com.ssafy.algo03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1873_방수영 {
	

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("1873.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(in.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[H][W];
			int r=0;
			int c=0;
			for(int i=0; i<H; i++) {
				map[i] = in.readLine().toCharArray();
				for(int j=0; j<W; j++) {
					if(map[i][j]=='^'||map[i][j]=='v'||map[i][j]=='>'||map[i][j]=='<') {
						r=i;
						c=j;
					}
				}
			}
			int N = Integer.parseInt(in.readLine());
			char[] com = in.readLine().toCharArray();
			
			for(int i=0; i<N; i++) {
				switch(com[i]) {
				case 'U':
					if(r>=1 && map[r-1][c]=='.') {
						map[r][c]='.';
						r--;
					}
					map[r][c]='^';
					break;
				case 'D':
					if(r+1<H && map[r+1][c]=='.') {
						map[r][c]='.';
						r++;
					}
					map[r][c]='v';
					break;
				case 'L':
					if(c>=1 && map[r][c-1]=='.') {
						map[r][c]='.';
						c--;
					}
					map[r][c]='<';
					break;
				case 'R':
					if(c+1<W && map[r][c+1]=='.') {
						map[r][c]='.';
						c++;
					}
					map[r][c]='>';
					break;
				case 'S':
					if(map[r][c]=='^') {
						for(int s = r; s>=0 ;s-- ) {
							if(check(s,c,map)) break;
						}						
					}else if(map[r][c]=='v') {
						for(int s = r; s<H ;s++ ) {
							if(check(s,c,map)) break;
						}
						
					}else if(map[r][c]=='<') {
						for(int s = c; s>=0; s-- ) {
							if(check(r,s,map)) break;
						}
						
					}else if(map[r][c]=='>') {
						for(int s = c; s<W; s++ ) {
							if(check(r,s,map)) break;
						}
						
					}
					break;
				}			
			}		
			//끝남
			System.out.print("#"+test_case+" ");
			for(char[] ch : map) {
				for(char a : ch) {
					System.out.print(a);
				}
				System.out.println();
			}
		}
	}
	static boolean check(int s, int c, char[][] map) {
		
		if(map[s][c]=='*') {
			map[s][c]='.';
			return true;
		}else if(map[s][c]=='#') {
			return true;
		}
		return false;
	}

}

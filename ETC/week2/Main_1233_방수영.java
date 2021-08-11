package com.ssafy.algo07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1233_방수영 {

	private static char[] nodes;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("1233.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			check= false;
			N = Integer.parseInt(in.readLine());
			nodes = new char[N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine());
				Integer.parseInt(st.nextToken());
				nodes[i] = st.nextToken().charAt(0);
			}
			dfs(1);
			if (check)
				System.out.println("#" + test_case + " " + 0);
			else
				System.out.println("#" + test_case + " " + 1);
		}
	}

	private static boolean check;
	private static void dfs(int n) {
		if(check) return;
		if(nodes[n]=='+'||nodes[n]=='-'||nodes[n]=='*'||nodes[n]=='/') {
			//연산자 만났는데 자식이 없으면 오류
			if(n*2>N) {
				check = true;
			}			
		}else {
			//숫자를 만났는데 자식이 있으면 오류
			if(n*2<=N) check = true;
			return;
		}
		dfs(n*2);
		dfs(n*2+1);
	}
		
}



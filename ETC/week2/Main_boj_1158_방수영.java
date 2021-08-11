package com.ssafy.algo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_boj_1158_방수영 {

	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		sb.append('<');
		
		int idx = 0;
		while(!list.isEmpty()) {
			idx = (idx + K -1)%list.size();
			sb.append(list.remove(idx));
			sb.append(", ");
			
		}
		sb.setLength(sb.length()-2);
		sb.append('>');
		System.out.println(sb);
	}

}

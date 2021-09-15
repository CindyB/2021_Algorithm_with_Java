package com.ssafy.algo06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1228_방수영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("1228.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = 10;
		for(int test_case = 1; test_case<=T; test_case++) {
			int N = Integer.parseInt(in.readLine());
			LinkedList<Integer> origin = new LinkedList<Integer>(); 
			
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				origin.add(Integer.parseInt(st.nextToken()));
			}
			
			int S = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());

			for(int i=0; i<S; i++) {
				char command = st.nextToken().charAt(0);
				int index = Integer.parseInt(st.nextToken());
				int cnt =  Integer.parseInt(st.nextToken());
				for(int j =0; j<cnt; j++) {
					origin.add(index+j, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#"+test_case+" ");
			for(int i=0; i<10; i++) {
				System.out.print(origin.get(i)+" ");
			}
			System.out.println();
		}
	}

}

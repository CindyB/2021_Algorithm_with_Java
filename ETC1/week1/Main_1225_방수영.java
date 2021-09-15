package com.ssafy.algo04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1225_방수영 {

	public static void main(String[] args) throws Exception, IOException {
		System.setIn(new FileInputStream("1225.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = 10;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			int t = Integer.parseInt(in.readLine());
			
			st = new StringTokenizer(in.readLine());
			Queue<Integer> queue = new LinkedList<Integer>();
			
			while(st.hasMoreTokens()) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			boolean check = true;
			while (check) {
				for (int i = 1; i <= 5; i++) {
					int num = queue.poll();
					if(num-i<=0) {
						queue.offer(0);
						check = false;
						break;
					}else {
						queue.offer(num-i);
					}
				}
			}
			System.out.print("#"+test_case);
			while(!queue.isEmpty()) {
				System.out.print(" "+queue.poll());
			}
			System.out.println();
		}
	}

}

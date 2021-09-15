package com.ssafy.algo01;

import java.util.Scanner;
import java.io.FileInputStream;

public class Main_1289_방수영 {
	public static void main(String args[]) throws Exception {


		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int result=0;
			
			String origin=sc.next();
			char tmp= '0';
			
			for(int i =0; i<origin.length(); i++) {
				
				if(tmp != origin.charAt(i)) {
					result++;
					tmp=origin.charAt(i);
				}
			}
			System.out.printf("#%d %d\n", test_case,result);
		}
	}
}
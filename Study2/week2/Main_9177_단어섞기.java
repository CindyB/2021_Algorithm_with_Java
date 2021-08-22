package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_9177_단어섞기 {

	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			String w1 = sc.next();
			String w2 = sc.next();
			String target = sc.next();

			int[] list1 = new int[w1.length()];
			int[] list2 = new int[w2.length()];

			for (int i = 0; i < w1.length(); i++) {
				list1[i] = target.indexOf(w1.charAt(i));
			}
			System.out.println(Arrays.toString(list1));
//			for (int i = 0; i < w2.length(); i++) {
//				list2[i] = w2.charAt(i);
//			}
//
//			for (int i = 0; i < target.length(); i++) {
//				char tmp = target.charAt(i);
//			
//			}
//			String answer = "";
//			System.out.println("Data set " + test_case + ": " + answer);
		}

	}

	public static class Word {
		int order;
		char ch;
		boolean selected;
		
		public Word(int order, char ch) {
			super();
			this.order = order;
			this.ch = ch;
		}
	}

}

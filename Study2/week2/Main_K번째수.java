package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_K번째수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 7;
		int[] arr = new int[N];
		int[][] commands = new int[3][3];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				commands[i][j] = sc.nextInt();
			}
		}

		System.out.println(Arrays.toString(solution(arr, commands)));
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer;
		answer = new int[commands.length];

		// test_case
		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0] - 1;
			int end = commands[i][1];
			int k = commands[i][2]-1;
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j =start; j<end; j++) {
				list.add(array[j]);
			}
			Collections.sort(list);
			answer[i]=list.get(k);
		}
		return answer;
	}
}

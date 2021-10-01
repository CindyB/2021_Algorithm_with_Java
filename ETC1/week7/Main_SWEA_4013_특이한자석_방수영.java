package com.ssafy.algo25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_SWEA_4013_특이한자석_방수영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

//			Deque<Integer> deque = new LinkedList<>();
			ArrayList<LinkedList> arr = new ArrayList<>(); // 톱니바퀴 배열 0~4

			int K = Integer.parseInt(in.readLine());

			for (int i = 0; i < 4; i++) {
				LinkedList<Integer> deque = new LinkedList<>();
				arr.add(deque);

				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 8; j++) {
					arr.get(i).add(Integer.parseInt(st.nextToken()));
				}
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken()); // 1이면 시계, -1이면 반시계

				int[] isRotate = new int[4];
				
				int d = dir;
				isRotate[num] = dir; 
				for(int n = num; n<3; n++) {
					// 오른쪽 점검
					if (arr.get(n).get(2) != arr.get(n + 1).get(6)) {
						isRotate[n] = d;
						d*=-1;
						isRotate[n + 1] = d;
					}else {
						break;
					}
				}
				d = dir;
				for(int n = num; n>0; n--) {
					/// 왼쪽 점검
					if (arr.get(n).get(6) != arr.get(n - 1).get(2)) {
						isRotate[n] = dir;
						dir*=-1;
						isRotate[n - 1] = dir;
					}else {
						break;
					}
				}
				for(int j=0; j<4; j++) {
					LinkedList<Integer> tmp = arr.get(j);
//					System.out.print(isRotate[j]+" ");
					if(isRotate[j]==1) {
						int tmpNum = tmp.pollLast();
						tmp.addFirst(tmpNum);
					}else if(isRotate[j]==-1) {
						int tmpNum = tmp.pollFirst();
						tmp.addLast(tmpNum);
					}
				}
//				System.out.println();
			}
			int result=0;
			for(int i=0; i<4; i++) {
				LinkedList<Integer> tmp = arr.get(i);
				int target= tmp.getFirst();
				if(target == 1) {
					result += 1<<i;
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}

}

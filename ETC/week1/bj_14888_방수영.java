/* 문제 선정 이유
 * 재귀 파트를 잘 다루지 못하는 것같아
 * 조금 더 연습해보기 위해서
 * 그리고 해당 문제 비슷한 유형을 코테에서 본적있는데
 * 지금의 나는 풀 수 있나 해서 ㅎ
 * */

package com.ssafy.algo05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj_14888_방수영 {
	
	static int[] arr;
	static int[] op;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		op = new int[4];
		st = new StringTokenizer(in.readLine());
		//숫자 입력 받음
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//연산자 개수 입력 받음 
		// 0: +, 1: -, 2: *, 3: /
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		func(1,arr[0]); 
		System.out.println(max);
		System.out.println(min);
		
	}
	//cnt는 arr의 위치를 나타냄 => 숫자 순서 바꾸면 x(0~N-1)
	private static void func(int cnt,int sum) {
		if(cnt==N) {
			if(max<sum) {
				max=sum;
			}
			if(min>sum) {
				min=sum;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			
			if(op[i]!=0) {
				switch (i) {
				case 0:	
					op[i]--;	//사용했음
					func(cnt+1,sum+arr[cnt]);
					op[i]++;	//원상복귀
					break;
				case 1:
					op[i]--;	//사용했음
					func(cnt+1,sum-arr[cnt]);
					op[i]++;	//원상복귀
					break;
				case 2:
					op[i]--;	//사용했음
					func(cnt+1,sum*arr[cnt]);
					op[i]++;	//원상복귀
					break;
				case 3:
					op[i]--;	//사용했음
					func(cnt+1,sum/arr[cnt]);
					op[i]++;	//원상복귀
					break;
				}
			}
			
			
		}
	}
}

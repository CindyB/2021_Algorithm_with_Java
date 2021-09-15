package com.ssafy.algo.hw11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1828_방수영 {
	
	static class Temper implements Comparable<Temper>{
		int x,y;

		public Temper(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Temper o) {
			int value = this.x - o.x;		//시작온도로 정렬
			
			if(value==0) return this.y-o.y;
			
			return value;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		int cnt=0;
		
		Temper[] tempers = new Temper[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			tempers[i] = new Temper(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(tempers);	//최저보관온도로 오름차순 정렬
		
		cnt++;
		int min = tempers[0].y;
		for(int i=1, size = tempers.length; i<size; i++) {

			if(min>=tempers[i].x) {
				min = Math.min(min, tempers[i].y);
			}else {
				cnt++;
				min = tempers[i].y;
			}
		}
		System.out.println(cnt);
	}

}

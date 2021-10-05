package com.ssafy.algo.hw25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_2577_회전초밥_방수영 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] visited = new int[d+1];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		int cnt=0;
		for(int i=0; i<k; i++) {
			if(visited[arr[i]]==0)cnt++;	//방문한적이 없다면 ++
			visited[arr[i]]++;	//방문 표시 ++
		}
		int max = cnt;
		for(int i=1; i<N; i++) {
			if(max <=cnt) {
				if(visited[c]==0) max =cnt+1;
				else max =cnt;
			}
			//맨 앞쪽 제외
			visited[arr[i-1]]--;
			if(visited[arr[i-1]]==0)cnt--;
			
			//맨오른쪽에 하나 추가
			if(visited[arr[(i+k-1)%N]]==0)cnt++;
			visited[arr[(i+k-1)%N]]++;
		}
		
		System.out.println(max);
	}

}

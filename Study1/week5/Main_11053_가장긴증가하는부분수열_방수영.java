package week5;

import java.util.Scanner;

public class Main_11053_가장긴증가하는부분수열_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt=1;
		int max = Integer.MIN_VALUE;
		
		//수열 입력 받기
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			int tmp=arr[i];
			cnt=1;
			
			for(int j=i+1; j<N; j++) {
				if(tmp>=arr[j])continue;
				
				tmp = arr[j];
				cnt++;
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

}

package week10;

import java.util.Scanner;

public class Main_boj_N과M1_방수영 {

	static int N,M;
	static boolean[] isSelected;
	static int[] Numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		isSelected = new boolean[N+1];
		Numbers = new int[M];
		perm(0);
		
	}

	private static void perm(int cnt) {
		
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(Numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if(isSelected[i])continue;
			
			isSelected[i] = true;
			Numbers[cnt] = i;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}

}

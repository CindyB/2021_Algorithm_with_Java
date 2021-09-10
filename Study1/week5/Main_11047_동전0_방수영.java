package week5;

import java.util.Scanner;

public class Main_11047_동전0_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coins = new int[N];
		
		int cnt =0;
		
		for(int i=N-1; i>=0; i--) {
			coins[i] = sc.nextInt();
		}
		int i=0;
		int tmp = K;
		while(tmp>0) {
			if(coins[i]<=tmp) {
				cnt++;
				tmp-=coins[i];
			}else {
				i++;
			}
		}
		System.out.println(cnt);
	}

}

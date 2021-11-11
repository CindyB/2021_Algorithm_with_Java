package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_14501_퇴사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());

		int[] T = new int[N];
		int[] P = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		int[] DP = new int[N];
		int max = 0;
		for (int i = N - 1; i >= 0; i--) {
			
			if(T[i]+i>N) {
				DP[i] = 0;
			}
			else {
				max = Math.max(P[i]+DP[T[i]+i], DP[i]);
				for(int j=i; j>=0; j--) {
					
					DP[j] =max;
					
				}
			}
			
		}
		System.out.println(DP[0]);
	}

}

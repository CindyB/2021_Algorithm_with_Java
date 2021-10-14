package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_11404_플로이드_방수영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		int[][] D = new int[N+1][N+1];
		int INF = 1000000000;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				D[i][j]=INF;
			}
		}
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			D[start][end] = Math.min(D[start][end], weight);
		}
		for(int k = 1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				if(k==i)continue;
				for(int j=1; j<=N; j++) {
					if(j==k || j==i)continue;
					D[i][j] = Math.min(D[i][k]+D[k][j], D[i][j]);
				}
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(D[i][j] ==INF ? 0+" " : D[i][j]+ " ");
			}
			System.out.println();
		}
	}

}

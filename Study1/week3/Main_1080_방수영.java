package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1080_방수영 {

	static int[][] A;
	static int[][] B;
	static int n,m;
	static int cnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		A = new int[n][m];
		B = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String tmp = in.readLine();
			for(int j=0; j<m; j++) {
				A[i][j] = tmp.charAt(j)-'0';
			}
		}
		for(int i=0; i<n; i++) {
			String tmp = in.readLine();
			for(int j=0; j<m; j++) {
				B[i][j] = tmp.charAt(j)-'0';
			}
		}
		for(int i=0; i<=n-3; i++) {
			for(int j=0; j<=m-3; j++) {
				if(A[i][j]!=B[i][j]) {
					cnt++;
					reverse(i,j);
				}
			}
		}
		if(isSameMatrix()) System.out.println(cnt);
		else
			System.out.println(-1);
//		System.out.println(Arrays.deepToString(A));
//		System.out.println(Arrays.deepToString(B));
	}
	private static void reverse(int r, int c) {
		
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				A[i][j] = (A[i][j]==1) ? 0 : 1 ;
			}
		}
	}
	private static boolean isSameMatrix() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(A[i][j]!=B[i][j]) return false;
			}
		}
		return true;
	}

}
/*
 * 
 * 3*3 view에서 한번 연산 후에 바뀌지 않는 부분 즉 (0,0)과 같은 부분만 같은지 아닌지 검사 */

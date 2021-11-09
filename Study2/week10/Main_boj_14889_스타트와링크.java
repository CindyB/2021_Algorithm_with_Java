package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_14889_스타트와링크 {

	static int N;
	static int[][] team;	
	static boolean[] isSelected;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		team = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isSelected = new boolean[N];
		dfs(0,0);
		System.out.println(min);
	}
	//n개중 n/2개 선택	=>12를 선택하나 21을 선택하나 같음	=>순서 상관 x => 조합
	private static void dfs(int cnt, int start) {
		if(cnt==N/2) {
			int sum1=0, sum2=0;
			
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {	//1&2 검사했으면 2&1은 검사 안해도 됨
					if(isSelected[i] && isSelected[j]) {
						sum1+=team[i][j];
						sum1+=team[j][i];
					}else if(!isSelected[i] && !isSelected[j]) {
						sum2+=team[i][j];
						sum2+=team[j][i];
					}
				}
			}
			min = Math.min(Math.abs(sum1-sum2), min);
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			dfs(cnt+1, i+1);
			isSelected[i] = false;
		}
	}

}

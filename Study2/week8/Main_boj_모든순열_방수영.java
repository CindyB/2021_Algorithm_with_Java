package week8;
import java.util.Scanner;

public class Main_boj_모든순열_방수영 {
	static int N;
	static boolean[] visited;
	static int[] isSelected;
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N+1];
		isSelected = new int[N+1];
		
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt==N) {
			for(int i=0; i<N; i++) {				
				System.out.print(isSelected[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if(visited[i])continue;
			visited[i] = true;
			isSelected[cnt]=i;
			perm(cnt+1);
			visited[i] = false;
			
		}
	}

}

package week6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main_11724_연결요소의개수 {

	static int[] parents;
	static int N,M;
	private static void make() {
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a]= find(parents[a]);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		make();
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			union(a,b);
		}
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=1; i<=N; i++) {
			set.add(find(parents[i])); 	//방법 1) 
//			방법 2) if(i==find(i)) cnt++;
		}
		System.out.println(set.size());
	}
}

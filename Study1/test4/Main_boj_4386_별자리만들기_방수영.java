package test4;

import java.util.Arrays;
import java.util.Scanner;

public class Main_boj_4386_별자리만들기_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		double[][] matrix = new double[N][N];
		boolean[] visited = new boolean[N];
		double[] minEdge = new double[N];
		
		double[][] star = new double[N][2];	//0:x, 1:y 
		for(int i=0; i<N; i++) {
			star[i][0] = sc.nextDouble();
			star[i][1] = sc.nextDouble();
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) {
					matrix[i][j] = 0;
				}else {
					matrix[i][j] = Math.pow(Math.pow(star[i][0]-star[j][0], 2)+Math.pow(star[i][1]-star[j][1], 2), 0.5);
				}
			}
			minEdge[i] = Double.MAX_VALUE;
		}
		double result =0.0;
		minEdge[0] = 0.0;
		
		for(int i=0; i<N; i++) {
			
			double min = Double.MAX_VALUE;
			int minVertex = -1;
			for(int j=0; j<N; j++) {
				if(!visited[j]&&min>minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			visited[minVertex] = true;
			result+=min;
			
			for(int j=0; j<N; j++) {
				if(!visited[j] && matrix[minVertex][j]!=0 && minEdge[j]>matrix[minVertex][j]) {
					minEdge[j] = matrix[minVertex][j];
				}
			}
		}
		System.out.printf("%.2f",result);
	}

}

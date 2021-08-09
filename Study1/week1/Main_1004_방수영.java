package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1004_방수영 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int result =0;
			
			st = new StringTokenizer(in.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int destX = Integer.parseInt(st.nextToken());
			int destY = Integer.parseInt(st.nextToken());
			
			int N = Integer.parseInt(in.readLine());
			for(int i =0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				int c1 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				int d1 = distance(startX,startY,c1,c2);
				int d2 = distance(destX,destY,c1,c2);
				
				r = (int)Math.pow(r, 2);
				
				if((d1<r && d2>r )||(d1>r && d2<r) )result++;
			}
			System.out.println(result);
			
		}
	}
	private static int distance(int x1, int y1, int x2, int y2) {
		int a= (int)Math.pow(x2-x1, 2);
		int b= (int)Math.pow(y2-y1, 2);
		
		return a+b;
	}
	
}

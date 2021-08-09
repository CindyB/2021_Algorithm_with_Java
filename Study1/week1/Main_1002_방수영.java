package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1002_방수영 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case<=T; test_case++) {
			int result =0;
			
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			Double d = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
			
			if(d>r1+r2 || d < Math.abs(r2-r1)) result =0;
			else if(d == r1+r2 || d ==Math.abs(r2-r1)) result =1;
			else if(Math.abs(r2-r1) < d && d<r1+r2) result = 2;
			if(d==0 && r1==r2)result = -1;
			
			System.out.println(result);
		}
	}
}

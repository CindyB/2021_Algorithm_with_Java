package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_방수영 {

	static int[] zeroCnt;
	static int[] oneCnt;


	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(in.readLine());
			zeroCnt = new int[41];
			oneCnt = new int[41];
			
			zeroCnt[0]=1;
			oneCnt[1]=1;
			for(int i=2; i<=N; i++) {
				oneCnt[i] = oneCnt[i-1]+oneCnt[i-2];
				zeroCnt[i]=zeroCnt[i-1]+zeroCnt[i-2];
			}
			System.out.println(zeroCnt[N]+" "+oneCnt[N]);
		}
		
	}

}

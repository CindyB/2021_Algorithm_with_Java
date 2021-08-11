package week2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1041 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dice = new int[6];
		long[] mins = new long[3];
		long result =0;
		int N=sc.nextInt();		
		for(int i=0; i<6; i++) {
			dice[i]= sc.nextInt();
		}
		if(N==1) {
			Arrays.sort(dice);
			for(int num : dice) {
				result+=num;
			}
			result-=dice[5];
			System.out.println(result);
			return;
		}
		for(int i=0; i<3; i++) {
			mins[i] = Math.min(dice[5-i], dice[i]);
		}
		Arrays.sort(mins);
		
		//테두리
		result += (N*(mins[0]+mins[1])+mins[2]) *4; //각 모서리 기둥
		result += (N*mins[0]+mins[1])*(N-2)*4;//모서리 사이 기둥들
		//속 - 윗면만 덮으면 됨
		result += mins[0] *Math.pow(N-2,2);
		
		System.out.println(result);
		
	}

}

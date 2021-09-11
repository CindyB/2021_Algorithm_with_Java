package Kakao;

import java.util.Arrays;

public class Main_2022카카오문제4 {

	static int[] num;
	static int maxScore = Integer.MIN_VALUE;
	static int[] maxArray = new int[11];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] info = {0,0,0,0,0,0,0,0,0,0,2};
//		int[] info = {1,0,0,0,0,0,0,0,0,0,0};
		solution(2,info);

	}
	public static int[] solution(int n, int[] info) {
		int[] answer = {-1};

        num = new int[11];
        
        combi(n,0,0, info);
        
        System.out.println(Arrays.toString(maxArray)+"//score : "+ maxScore);
        
        if(maxScore<=0) return answer;
        else {
        	return maxArray;
        }
    }
	//중복조합
	private static void combi(int n, int cnt, int start, int[] info) {
		
		if(cnt == n) {
			int score = score(info, num);
//			System.out.println(Arrays.toString(num)+" // score : " + score);
			if(score>=maxScore) {
				
				for(int i=10; i>=0; i--) {
					if(num[i]== maxArray[i]) continue;
					if(num[i]>maxArray[i]) {
						maxArray = num.clone();
						break;
					}
				}				
				maxScore = score;
			}
			return;
		}
		//i는 과녁 점수 0부터~10점 / num의 원소값은 화살 개수
		for(int i=start; i<11; i++) {
			num[i]++;
			combi(n,cnt+1,i, info);
			num[i]--;
		}
	}
	private static int score(int[] info, int[] num) {
		
		int lionScroe =0;
		int apeachScore =0;
		
		for(int i=0; i<=10; i++) {
			if(info[i]==0&&num[i]==0) continue;
			if(info[i]<num[i]) {
				lionScroe+=10-i;
			}else if(info[i]>=num[i]) {
				apeachScore+=10-i;	
			}
		}
		return lionScroe - apeachScore ;
	}
}

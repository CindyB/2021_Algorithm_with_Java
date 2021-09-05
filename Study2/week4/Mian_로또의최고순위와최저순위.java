package week4;

import java.util.Arrays;

public class Mian_로또의최고순위와최저순위 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lottos = {1,2,3,4,5,6};
		int[] win_nums = {7,8,9,10,11,12};
		solution(lottos,win_nums);
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int xCnt=0;	//미지수 0의 개수
		int winCnt =0;	//당첨 개수
		
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		for(int i=0; i<6; i++) {
			if(lottos[i]==0) {
				xCnt++;
				continue;
			}
			for(int j=0; j<6; j++) {
				if(lottos[i]==win_nums[j]) {
					winCnt++;
				}
			}
		}
		//최고 순위 번호
		if(winCnt==0&&xCnt==0)answer[0]=6;
		else answer[0]=7-(winCnt+xCnt);
		//최저 순위번호
		if(winCnt==0)answer[1]=6;
		else answer[1]=7-winCnt;

		System.out.println(answer[0]+" "+answer[1]);
		return answer;
	}
}

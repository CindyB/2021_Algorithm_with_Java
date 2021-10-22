package week11;

import java.util.Scanner;

public class Main_boj_9663_NQueen_방수영 {
	
	static int N, result;
	static int col[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];	//1행부터 N행
		result=0;
		
		setQueens(1);	//1행부터 놓는 시도
		System.out.println(result);
		
	}private static void setQueens(int rowNo) {
		
		if(rowNo>N) {	//마지막행까지 다 둔 경우
			result++;
			return;
		}
		
		//현재 퀸 1열부터 N열까지 놓아보기
		//놓았으면 다음 퀸 놓으러 가기
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;	//i열에 놓아보기
			if(isAvailable(rowNo)) {	//가능하면 다음 퀸으로
				setQueens(rowNo+1);
			}
		}
	}
	private static boolean isAvailable(int rowNo) {	//rowNo : 현재 검사하려는 퀸

		for (int k = 1; k <rowNo; k++) {	//k는 이전퀸
			if(col[rowNo] == col[k] || Math.abs(col[rowNo] - col[k]) == (rowNo-k)) return false;	
			//같은 열, 대각선(행차이==열차이)
		}
		return true;
	}

}

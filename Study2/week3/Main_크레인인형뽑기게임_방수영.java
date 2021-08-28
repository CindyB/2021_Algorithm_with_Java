package week3;

import java.util.Stack;

public class Main_크레인인형뽑기게임_방수영 {

	static Stack<Integer>stack = new Stack<Integer>();
	public static void main(String[] args) {

		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		solution(board,moves);
	}
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        for(int i=0; i<moves.length; i++) {
        	answer+=move(board,moves[i]-1);
        }
        System.out.println(answer);
        return answer;
    }
	private static int move(int[][] board, int c) {
		
		int cnt=0;
		for(int r=0; r<board.length; r++) {
			if(board[r][c]!=0) {
				if(stack.isEmpty()) {
					stack.push(board[r][c]);
				}else if(stack.peek()==board[r][c]) {
					cnt+=2;
					stack.pop();
				}else {
					stack.push(board[r][c]);
				}
				board[r][c]=0;
				break;
			}			
		}
		return cnt;
	}
}

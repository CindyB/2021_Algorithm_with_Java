package week2;

import java.util.Scanner;

public class Main_타겟넘버 {

	static int N;
	static int result;
	static int[] numbers;
	static boolean[] isSelected;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = 5;
		numbers = new int[N];
		
		for(int i=0; i<N; i++) {
			numbers[i] = sc.nextInt();
		}
		int target = sc.nextInt();		
		solution(numbers,target);
	}
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        N = numbers.length;
        isSelected = new boolean[N];
        
        subset(0,target);
        System.out.println(result);
        return answer;
    }
	private static void subset(int cnt, int target) {
		if(cnt == N) {
			int total =0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					total+=numbers[i];
				}else {
					total-=numbers[i];
				}
			}
			if(target == total) {
				result++;
			}
			return;
		}
		isSelected[cnt] = true;
		subset(cnt+1, target);
		
		isSelected[cnt] = false;
		subset(cnt+1, target);
	}
}

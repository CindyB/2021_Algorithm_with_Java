package week1;
import java.util.Scanner;

public class Main_14888_방수영 {
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	static int size;
	static int[] arr;
	static int[] operator;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		size = sc.nextInt();
		arr = new int[size];
		// 숫자 입력 받기
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		// 연산자 입력 받기
		operator = new int[4];
		for (int i = 0; i < 4; i++) {
			operator[i] = sc.nextInt();
		}
		dfs(arr[0],1);
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int num, int index) {
		if(index == size) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
			
		}
		for (int i = 0; i < 4; i++) {
			
			if (operator[i] != 0) {
				operator[i]--;

				switch (i) {
				case 0: //+
					dfs(num+arr[index],index+1);
					break;
				case 1:// -
					dfs(num-arr[index],index+1);
					break;
				case 2:// *
					dfs(num*arr[index],index+1);
					break;
				case 3: // /나누기
					dfs(num/arr[index],index+1);
					break;
				}
				operator[i]++;
			}			
			
		}
	}

}

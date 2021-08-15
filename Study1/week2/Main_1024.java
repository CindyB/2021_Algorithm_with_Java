package week2;

import java.util.Scanner;

public class Main_1024 {

	static int N, L, k;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		int l; // 수열의 길이
		boolean flag = false; // 길이가 100이 넘거나 수열이 없을 경우 false
		for (l = L; l <= 100; l++) {
			if(N >= (((l - 1) * l) / 2)) {
				if ((N - (((l - 1) * l) / 2)) % l == 0) // 나눠떨어지면 해당 길이의 수열로 합 가능
				{
					k = (N - (((l - 1) * l) / 2)) / l; // 이때의 몫이 k값
					flag = true;
					break;
				}
			}			
		}
		if (flag) {
			for (int i = k; i < k + l; i++) {
				System.out.print(i + " ");
			}
		}else {
			System.out.println(-1);
		}
	}
}
/*
 * 길이 3의 수열이라고 했을 때 수열은 연속된 수니까 k, k+1, k+2 로 둘 수 있고 이때 k는 0보다 크거나 같은 수 3k+(1+2)
 * ==N 일때의 k부터 k+l-1까지 출력
 */

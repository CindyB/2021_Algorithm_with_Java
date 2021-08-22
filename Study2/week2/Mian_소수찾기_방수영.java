package week2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Mian_소수찾기_방수영 {

	static boolean[] isSelected;
	static char[] num;
	static Set<Integer> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tmp = sc.next();
		System.out.println(solution(tmp));

	}

	public static int solution(String numbers) {
		int answer = 0;

		num = numbers.toCharArray();
		isSelected = new boolean[num.length];
		set = new HashSet<Integer>();
		
		for (int i = 1; i <= numbers.length(); i++) {
			perm(0, "", i);
		}
		return set.size();
	}

	private static void perm(int cnt, String tmp, int r) {
		if (cnt == r) {
			int tmpNum = Integer.parseInt(tmp);
			if (check(tmpNum)) {
				if (tmp.length() != 0) 	set.add(tmpNum);
			}
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			perm(cnt + 1, tmp + num[i], r);
			isSelected[i] = false;
		}
	}

	private static boolean check(int n) {
		if(n<2)return false;
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i ==0)return false;
		}
		return true;
	}
}

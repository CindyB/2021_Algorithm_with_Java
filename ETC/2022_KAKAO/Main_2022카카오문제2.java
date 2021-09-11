package Kakao;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2022카카오문제2 {

	public static void main(String[] args) {
		System.out.println(solution(1000000,3));
//		solution(110011,10);
	}
	public static int solution(int n, int k) {
        String str = change(n,k);
        ArrayList<String> list = new ArrayList<String>();
        
        StringTokenizer st = new StringTokenizer(str,"0");
        while(st.hasMoreTokens()) {
        	String tmp = st.nextToken();
        	if(isPrimeNum(Long.parseLong(tmp))) {
        		System.out.println(tmp);
        		list.add(tmp);
        	}
//        	if(isPrimeNum(Integer.parseInt(tmp))) {
//        		System.out.println(tmp);
//        		list.add(tmp);
//        	}
        }
        return list.size();
    }
	//소수 확인 함수
	private static boolean isPrimeNum(long n) {
		if(n<2)return false;
		for(long i=2; i<=Math.sqrt(n); i++) {
			if(n%i ==0)return false;
		}
		return true;
	}
	
	//진수변환 함수
	private static String change(int n, int k) {
		StringBuilder sb = new StringBuilder();
		while(n>=1) {
			sb.insert(0, n%k);
			n/=k;
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}

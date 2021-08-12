package week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_문자열압축_방수영 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(solution(s));
	}
	public static int solution(String s) {
		
		int min = Integer.MAX_VALUE;
        int answer = 0;
        
        int mid = s.length()/2;
        int start=0, end=mid;
        
        if(s.length()==1) return 1;
        
        for(int i=1; i<=mid; i++) {
        	int tmp = cal(s,i);
        	min = Math.min(min, tmp);
        	
        }
        
        return min;
    }
	private static int cal(String s, int unit) {
		
		int cnt=1;
		int left =0;
		int right = unit;
		StringBuilder sb = new StringBuilder();
		String str2="";
		Queue<String> queue = new LinkedList<>();
		
		for(int i=0; i<s.length(); i+=unit) {
			if(i+unit>s.length()) {
				queue.offer(s.substring(i,s.length()));
			}else {
				queue.offer(s.substring(i,i+unit));
			}
		}
		while(!queue.isEmpty()) {
			String now = queue.poll();
			if(now.equals(queue.peek())) {
				cnt++;
			}else if(cnt<=1){
				sb.append(now);
			}else{
				sb.append(cnt);
				sb.append(now);
				cnt=1;
			}
		}
//		System.out.println(sb.toString());
		return sb.toString().length();
	}
}

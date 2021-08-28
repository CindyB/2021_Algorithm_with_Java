package week3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_영어끝말잇기_방수영 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		
		solution(n, words);
	}
	public static int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        ArrayList<String> list = new ArrayList<String>();
        
        char tmp=' ';
        for(int i=0; i<words.length; i++) {
        	if(!list.contains(words[i])) {
        		if(list.isEmpty()) {
        			list.add(words[i]);
        			tmp = words[i].charAt(words[i].length()-1);
        		}
        		else {
        			if(words[i].charAt(0)==tmp) {
        				list.add(words[i]);
        				tmp = words[i].charAt(words[i].length()-1);
        			}else {
        				answer[0]=i%n+1;
                		answer[1]=i/n+1;
                		break;
        			}
        			
        		}
        	}else {
        		answer[0]=i%n+1;
        		answer[1]=i/n+1;
        		break;
        	}
        	
        }
        System.out.println(answer[0] + " "+answer[1]);
        return answer;
    }
}

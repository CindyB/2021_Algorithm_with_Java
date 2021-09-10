package test2;

import java.util.ArrayList;

public class Main_압축_방수영 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "ABABABABABABABAB";
		solution(msg);
	}
	public static ArrayList<Integer> solution(String msg) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
        char[] msgArray = msg.toCharArray();
        
        ArrayList<String> dict = new ArrayList<String>();
        char ch ='A';
        
        for(int i=0; i<26; i++) {
        	dict.add(Character.toString(ch+i));
        }
        int cnt=0;
        for(int i=0; i<msg.length(); i=i+cnt) {
        	String tmp ="";
        	cnt =0;
        	while((i+cnt)<msg.length() && dict.contains(tmp+msgArray[i+cnt])) {
        		tmp = tmp+msgArray[i+cnt];
        		cnt++;
        	}
        	if(i+cnt<msg.length()) {
        	dict.add(tmp+msgArray[i+cnt]);
        	}else {
        		dict.add(tmp);
        	}
        	answer.add(dict.indexOf(tmp)+1);
        }
        for(int i=0; i<answer.size(); i++)System.out.println(answer.get(i));
        return answer;
    }
}

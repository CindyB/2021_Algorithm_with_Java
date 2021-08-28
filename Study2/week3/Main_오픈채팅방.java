package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_오픈채팅방 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}
	public static ArrayList<String> solution(String[] record) {
        ArrayList<String> list = new ArrayList<String>();
        Map<String,String> map = new HashMap<String, String>();
        
        StringTokenizer st = null;
        for(int i=0; i<record.length; i++) {
        	st = new StringTokenizer(record[i]);
        	String command = st.nextToken();
        	String userId = st.nextToken();
        	String nikName="";
        	if(st.hasMoreTokens()) {
        		nikName = st.nextToken();
        	}
        	if(command.equals("Enter")) {
        		map.put(userId, nikName);
        		
        	}else if(command.equals("Leave")) {
        		
        	}else if(command.equals("Change")) {
        		map.put(userId,nikName);
        		
        	}
        }
        for(int i=0; i<record.length; i++) {
        	st = new StringTokenizer(record[i]);
        	String command = st.nextToken();
        	String userId = st.nextToken();
        	
        	if(command.equals("Enter")) {
        		list.add(map.get(userId)+"님이 들어왔습니다.");
        		
        	}else if(command.equals("Leave")) {
        		list.add(map.get(userId)+"님이 나갔습니다.");
        	}
        }

        return list;
    }

}

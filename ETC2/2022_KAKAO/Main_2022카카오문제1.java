package Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_2022카카오문제1 {

	public static void main(String[] args) {

		String[] id_list = { "con", "ryan" };
		String[] report = { "ryan con", "ryan con", "ryan con", "ryan con" };
		int k = 2;
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}

	static class node{
		String id;
		int result;	//신고당한 개수
		ArrayList<String> reportUser;		//유저를 신고한 ID
		
		public node(String id, int result, ArrayList<String> reportUser) {
			super();
			this.id = id;
			this.result = result;
			this.reportUser = reportUser;
		}

		@Override
		public String toString() {
			return "node [id=" + id + ", result=" + result + ", reportUser=" + reportUser + "]";
		}
		
	}
	public static int[] solution(String[] id_list, String[] report, int k) {
        
		int[] answer= new int[id_list.length];
        StringTokenizer st = null;
        HashMap<String, node> list = new HashMap<String, node>();
        
        //초기화
        for(int i=0; i<id_list.length; i++) {
        	list.put(id_list[i], new node(id_list[i],0,new ArrayList<String>()));
        }
        for(int i=0; i<report.length; i++) {
        	st = new StringTokenizer(report[i]);
        	String user_id = st.nextToken();		//신고한 유저
        	String report_id = st.nextToken();		//신고 당한 유저
        	
        	if(!list.get(report_id).reportUser.contains(user_id)) {
        		list.get(report_id).reportUser.add(user_id);	//자신을 신고한 유저들 저장
        	}
        }
        for(int i=0; i<id_list.length; i++) {
        	node tmp = list.get(id_list[i]);
        	if(tmp.reportUser.size()>=k) {
        		for(int j=0; j<tmp.reportUser.size(); j++) {
        			list.get(tmp.reportUser.get(j)).result++;
        		}
        	}
        }
        
        for(int i=0; i<id_list.length; i++) {
        	System.out.println(list.get(id_list[i]));
        	answer[i]=list.get(id_list[i]).result;
        }
        return answer;
        
    }
}

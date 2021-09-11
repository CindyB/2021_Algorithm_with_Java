package Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_2022카카오문제3 {

	public static void main(String[] args) {

		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		solution(fees,records);
	}
	static class node{
		String num;
		ArrayList<String> timeRecord;
		int time =0;
		int fee =0;
		
		public node(String num, ArrayList<String> timeRecord) {
			super();
			this.num = num;
			this.timeRecord = timeRecord;
		}
		@Override
		public String toString() {
			return "node [num=" + num + ", timeRecord=" + timeRecord + "]";
		}		
		private void timeGap() {
			StringTokenizer st = null;
			
			int i=0;
			if(timeRecord.size()%2==0) {
				for(i=0; i<timeRecord.size(); i+=2) {
					st = new StringTokenizer(timeRecord.get(i),":");
					int inTime = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
					st = new StringTokenizer(timeRecord.get(i+1),":");
					int outTime = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
					time+=outTime-inTime;
				}
			}else { 
				for(i=0; i<timeRecord.size()-1; i+=2) {
					st = new StringTokenizer(timeRecord.get(i),":");
					int inTime = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
					st = new StringTokenizer(timeRecord.get(i+1),":");
					int outTime = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
					time+=outTime-inTime;
				}
				st = new StringTokenizer(timeRecord.get(i),":");
				int inTime = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
				int outTime = 23*60 + 59;
				time+=outTime-inTime;
			}
		}

	}
	public static int[] solution(int[] fees, String[] records) {
      
        StringTokenizer st = null;
        ArrayList<String> numList = new ArrayList<String>();	//차량 번호담을 배열
        HashMap<String, node> map = new HashMap<String, node>();
        
        for(int i=0; i<records.length; i++) {
        	st = new StringTokenizer(records[i]);
        	
        	String time = st.nextToken();	//시간
        	String num = st.nextToken();	//차량번호
        	String inout = st.nextToken();	//인인지 아웃인지
        	
        	if(!numList.contains(num)) {
        		numList.add(num);
        		map.put(num, new node(num,new ArrayList<String>()));        		
        	}
        	map.get(num).timeRecord.add(time);	//시간 추가(인아웃 번갈아 가며 나올 예정 인으로 끝날 경우 23:59까지로 처리)
        	
        }
        for(int i=0; i<numList.size(); i++) {
        	
        	map.get(numList.get(i)).timeGap();		//누적 시간 계산
        	int t =map.get(numList.get(i)).time;
        	
        	if(t==0) {
        		map.get(numList.get(i)).fee =0;
        	}else if(t<=fees[0]) {
        		map.get(numList.get(i)).fee = fees[1];
        	}else {
        		map.get(numList.get(i)).fee = fees[1] + (int)(Math.ceil((t-fees[0])/(double)fees[2]))*fees[3];
        	}
        	
        }
        
        int[] answer = new int[numList.size()];
        Collections.sort(numList);
        for(int i=0; i<numList.size(); i++) {
        	answer[i]= map.get(numList.get(i)).fee;
        }
        System.out.println(Arrays.toString(answer));
        
        
        return answer;
    }
	
	
}

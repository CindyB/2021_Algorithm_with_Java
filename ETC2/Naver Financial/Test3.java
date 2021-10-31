package NaverFinancial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Test3 {

	static class Node {
		String id;
		HashMap<Integer, Integer> map;// key : 문제 번호 value : 해당 점수

		public Node(String id, int pNum, int score) {
			super();
			this.id = id;
			this.map = new HashMap<>();  
			this.map.put(pNum, score);
		}
		@Override
		public String toString() {
			return "Node [id=" + id + ", map=" + map + "]";
		}
		public boolean check(Node o) {
			//1. 두 수험자가 푼 문제 수가 같다 단, 5개 미만인 경우는 제외(해당 조건 통과)
			if(this.map.size() == o.map.size() && this.map.size()>=5) {
				for(Integer key : this.map.keySet()) {
					//2. 푼 문제의 번호가 모두 같다 == 키가 모두 같다.
					if(!o.map.containsKey(key)) return false;	//같지 않은 키가 하나라도 있다면 부정행위자 x
					//3. 푼 문제의 점수가 모두 같다 = 값이 같다.
					if(this.map.get(key) != o.map.get(key)) return false;	//같지 않은 점수가 있다면 부정행위자 x
				}
			}else return false;
			//검문을 다 마쳤다면 부정행위자!
			return true;
		}
	}

	public static void main(String[] args) {
		String[] logs = { "0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90",
				"0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90" };
		StringTokenizer st = null;
		ArrayList<Node> student = new ArrayList<>();
		ArrayList<String> studentList = new ArrayList<>();	//전체 학생 목록
		HashSet<String> result = new HashSet<>();//부정행위자 목록

		for (int i = 0; i < logs.length; i++) {
			st = new StringTokenizer(logs[i]);
			String id = st.nextToken(); // 수험번호
			int pNum = Integer.parseInt(st.nextToken());// 문제 번호
			int score = Integer.parseInt(st.nextToken()); // 점수

			int idx = studentList.indexOf(id); // 학생 목록 중에 있는 지 찾기 없다면 -1 반환
			if (idx == -1) { // 없으면 학생 목록에 추가
				studentList.add(id);
				student.add(new Node(id,pNum,score));	//node 객체 생성
			} else {	//node 객체 생성된 학생이라면 문제와 점수만 세팅
				Node tmp = student.get(idx);
				tmp.map.put(pNum, score);
			}
		}
		//부정행위자 check
		for(int i=0; i<student.size()-1; i++) {
			for(int j=i+1; j<student.size(); j++) {
				if(student.get(i).check(student.get(j))) {
					result.add(student.get(i).id);
					result.add(student.get(j).id);
				}
			}
		}
		ArrayList resultList = new ArrayList(result);
		if(resultList.size()==0) {
			resultList.add("None");
		}else {
			Collections.sort(resultList);
		}
		System.out.println(resultList);
	}

}

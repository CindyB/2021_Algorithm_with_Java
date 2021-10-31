package NaverFinancial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Test1 {


	public static void main(String[] args) {
		String[] id_list = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
		int k =3;
		int result=0;
		StringTokenizer st = null;
		HashMap<String,Integer> map = new HashMap<>();
		ArrayList<String> visited = new ArrayList<>();
		
		for(int i=0; i<id_list.length; i++) {
			st = new StringTokenizer(id_list[i]);
			visited = new ArrayList<>();
			while(st.hasMoreTokens()) {
				String tmp = st.nextToken();
				if(visited.contains(tmp))continue;	//방문 했다면 하루 할당치 받음
				
				int cnt = map.get(tmp) ==null ? 0 : map.get(tmp);
				map.put(tmp, cnt+1);				
				visited.add(tmp);	//방문처리
			}
		}
		for(String key : map.keySet()) {
			System.out.println(key+" "+map.get(key));
			if(map.get(key)<=k) {
				result+=map.get(key);
			}else {
				result+=k;
			}
		}
		System.out.println(result);
	}

}

package forIM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7272_안경이없어_방수영 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case<=T; test_case++) {
			st = new StringTokenizer(in.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			if(isSame(str1,str2)) {
				System.out.println("#"+test_case+" SAME");
			}else {
				System.out.println("#"+test_case+" DIFF");
			}
		}
	}

	private static boolean isSame(String str1, String str2) {

		String tmp1 ="ADOPQR";
		String tmp2 = "CEFGHIJKLMNSTUVWXYZ";
		
		if(str1.length()!= str2.length()) return false;
		
		for(int i=0; i<str1.length(); i++) {
			char ch1 = str1.charAt(i);
			char ch2 = str2.charAt(i);
			if(ch1=='B'&&ch2=='B') {
				continue;
			}
			else if(tmp1.contains(Character.toString(ch1))&& tmp1.contains(Character.toString(ch2))) {
				continue;
			}else if(tmp2.contains(Character.toString(ch1))&& tmp2.contains(Character.toString(ch2))) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}

	

}

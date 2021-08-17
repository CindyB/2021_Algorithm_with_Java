package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2204 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(in.readLine());
			if(n==0)break;
			
			String now = in.readLine();
			String min=now;
			for(int i=1; i<n; i++) {
				
				String pre =now;
				now = in.readLine();
			
				if(pre.toLowerCase().compareTo(now.toLowerCase())<0) {
					if(pre.toLowerCase().compareTo(min.toLowerCase())<0) {
						min = pre;
					}					
				}else {
					if(now.toLowerCase().compareTo(min.toLowerCase())<0) {
						min = now;
					}
				}
			}
			System.out.println(min);
		}
	}

}

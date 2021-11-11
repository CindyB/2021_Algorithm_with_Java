package week11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main_boj_4358_생태학 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap<String,Integer> map = new TreeMap<>();
		
		int size =0;
		while(sc.hasNextLine()) {
			String tmp = sc.nextLine();
			map.put(tmp, map.getOrDefault(tmp, 0) +1);
			size++;
		}

		for(String k : map.keySet()) {
			double percent = ((double)map.get(k)/size)*100;
			System.out.printf("%s %.4f\n" ,k,percent);
			
		}
	}

}

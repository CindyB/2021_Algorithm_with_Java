package week1;

import java.awt.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main_1005_방수영 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Map<Integer,Integer> a = new HashMap<>();
		
		int[] p= new int[N];
		
		for(int i=0; i<N; i++) {
			a.put(i, sc.nextInt());
		}
		LinkedList<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(a.entrySet());
		entryList.sort(Map.Entry.comparingByValue());
		int i=0;
		for(Entry<Integer, Integer> entry : entryList){
			p[entry.getKey()] = i;
			i++;
//			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
		}
		for(int num : p) {
			System.out.print(num+" ");
		}
	}
}

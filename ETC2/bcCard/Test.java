package bcCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int n =4;
		int[] v = {3,2,3,1};	//2,3,1
		int[] map = new int[n];
		int k=0;
		int start = 0;
		
		for(int i=0; i<v.length; i++) {
			if(i==0) {
				map[i] = n-v[i];
				k++;
			}else {
				boolean flag = false;
				for(int j=start; j<k; j++) {
					if(map[j]==0)start = j;
					if(map[j]>=v[i]) {
						map[j] = map[j]-v[i];
						flag = true;
						break;
					}
				}
				if(!flag) {
					map[i] = n-v[i];
					k++;
				}
			}
		}
//		for(int i=0; i<k; i++) {
//			System.out.print(map[i]);
//		}
		System.out.println(k);
	}

}

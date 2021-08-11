package com.ssafy.algo.hw01;
import java.util.Arrays;
import java.util.Scanner;

public class Main_boj_1244_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		int n=sc.nextInt();
		for(int i=0; i<n; i++) {
			int gender = sc.nextInt();
			int number = sc.nextInt();
			
			switch(gender) {
			case 1:
				boy(arr,number);
				break;
			case 2:
				arr[number-1] = arr[number-1]==1 ? 0 : 1;
				girl(arr,number-2, number);
				break;
			}
		}
		for(int i=0; i<arr.length; i++) {
			if(i%20==0&&i!=0) {
				System.out.println();
			}
			System.out.print(arr[i]+" ");
		}
		
	}
	public static void girl(int[] arr, int left, int right) {
		
		if(left<0 || right>=arr.length || arr[left]!=arr[right]) return;
		
		else if(arr[left]==arr[right]) {
			arr[left] = arr[left]==1 ? 0 : 1;
			arr[right] = arr[right]==1 ? 0 : 1;
			girl(arr,left-1,right+1);
		}
	}
	public static void boy(int[] arr, int num) {
		for(int i=num-1; i<arr.length; i=i+num) {
			arr[i] = arr[i]==1 ? 0 : 1;
		}
	}
}

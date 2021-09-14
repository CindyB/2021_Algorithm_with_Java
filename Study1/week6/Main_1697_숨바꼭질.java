package week6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int target = sc.nextInt();
		
		boolean[] visited = new boolean[100001]; 

		Queue<Integer> queue = new LinkedList<Integer>();
		int length =-1;
		queue.add(x);	//초기 수빈이의 위치
		visited[x]=true;
		while(!queue.isEmpty()) {
			length++;
			int size = queue.size();
			while(--size>=0) {
				int tmp = queue.poll();
				visited[tmp]=true;
				if(tmp==target) {
					System.out.println(length);
					return;
				}
				queue.add(tmp*2);
				queue.add(tmp-1);
				queue.add(tmp+1);
			}
		}
	}

}

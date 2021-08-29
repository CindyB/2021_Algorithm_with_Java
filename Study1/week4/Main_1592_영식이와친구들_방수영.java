package week4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_1592_영식이와친구들_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		Deque<node> deque = new LinkedList<node>();
		//초기 세팅
		for(int i=0; i<N; i++) {
			deque.add(new node(i+1,0));
		}
		node tmp = deque.getFirst();
		tmp.cnt++;
		
		while(true) {
			if(tmp.cnt==M) {
				break;
			}
			if(tmp.cnt%2==0) {
				for(int i=0; i<L; i++) {
					deque.addFirst(deque.pollLast());
				}
				
			}else {
				for(int i=0; i<L; i++) {
					deque.addLast(deque.pollFirst());
				}
			}
			tmp = deque.getFirst();
			tmp.cnt++;
		}
		int sum=0;
		while(!deque.isEmpty()) {
			sum+=deque.poll().cnt;
		}
		System.out.println(--sum);
	}
	static class node{
		int num;
		int cnt=0;
		public node(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		
	}
}

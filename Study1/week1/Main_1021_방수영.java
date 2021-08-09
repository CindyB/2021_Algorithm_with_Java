package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1021_방수영{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result=0;
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		int[] target = new int[M];
		
		//뽑아낼 위치 저장
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<M; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		//1~N 세팅
		for(int i=1; i<=N; i++) {
			deque.offer(i);
		}
		for(int i=0; i<M; i++) {
			
			int mid = (deque.size()%2==0) ? deque.size()/2-1 : (deque.size()/2);

			if(deque.peek() == target[i]) {
				deque.pollFirst();
				continue;
			}
			
			else if(deque.indexOf(target[i])<=mid) {
				for(int j=0; j<deque.size(); j++) {
					if(deque.peek()==target[i])
					{
						deque.poll();
						break;
					}
					int tmp = deque.pollFirst();
					deque.offer(tmp);
					result++;
				}
			}else {
				for(int j=0; j<deque.size(); j++) {
					if(deque.peek()==target[i])
					{
						deque.poll();
						break;
					}
					int tmp = deque.pollLast();
					deque.offerFirst(tmp);
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}

//
//public class Main_1021_방수영 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int result=0;
//		
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int[] output = new int[M];
//		for(int i=0; i<M; i++) {
//			output[i] = sc.nextInt()-1;
//		}
//		int[] queue = new int[N+1];
//		for(int i=1; i<=N; i++) queue[i] = i;
//		
//		int mid = (N%2==0) ? N/2 : (N/2+1);
//		for(int i=0; i<M; i++ ) {
////			if(queue[0]==output[i])continue;
//			if(output[i] <=queue[mid]) {
//				while(queue[1]!=output[i]) {
//					int p=1;
//					int tmp = queue[1];
//					for(p=1; p<N; p++) {
//						queue[p] = queue[p+1];
//					}
//					queue[p]=tmp;
//				}
//				int p=1;
//				int tmp = queue[1];
//				for(p=1; p<N; p++) {
//					queue[p] = queue[p+1];
//				}
//				queue[p]=tmp;
//			}else {
//				while(queue[1]!=output[i]) {
//					int p=1;
//					int tmp = queue[N];
//					for(p=1; p<N; p++) {
//						queue[p+1] = queue[p];
//					}
//					queue[1]=tmp;
//					result++;
//				}
//				int p=1;
//				int tmp = queue[1];
//				for(p=1; p<N; p++) {
//					queue[p] = queue[p+1];
//				}
//				queue[p]=tmp;
//			}
//			
//		}
//	}
//
//}

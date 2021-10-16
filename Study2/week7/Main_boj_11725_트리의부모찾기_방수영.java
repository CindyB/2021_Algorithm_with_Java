package week7;

import java.util.Scanner;

public class Main_boj_11725_트리의부모찾기_방수영 {
	
	static int N;
	static int[] visited;
	
	static class Node{
		int data;		
		Node parents;
	}
	private static void findNode(Node node, int data) {
		Node newNode = new Node();
		
		//root일 경우
		if(node==null) {
			newNode.data = data;
		}else {
			if(node.left==null) {
				newNode.data = data;
				node.left = newNode;
			}else if(node.right==null) {
				
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		Node root = null; 
		
		for(int i=0; i<N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			add(root,a);
			add(root,b);
		}
//		for(int i=1; i<=N; i++) {
//		}

	}
}

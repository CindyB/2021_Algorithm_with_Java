package com.ssafy.algo15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1238_Contact_방수영 {

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	static int startNode, N = 100;
	static Node[] adjList;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("1238.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			adjList = new Node[N * N]; // 최대 100명
			st = new StringTokenizer(in.readLine());
			int C = Integer.parseInt(st.nextToken());
			startNode = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
			}
			bfs();
			System.out.println("#" + test_case + " " + max);
		}
	}

	private static void bfs() {

		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N*N];

		queue.offer(startNode);
		visited[startNode] = true;

		int size = 0, level = 0;
		while (!queue.isEmpty()) {

			size = queue.size();
			max = Integer.MIN_VALUE;
			while (--size >= 0) {
				int current = queue.poll();
				max = Math.max(max, current);
				for (Node tmp = adjList[current]; tmp != null; tmp = tmp.link) {
					if (!visited[tmp.vertex]) {
						queue.offer(tmp.vertex);
						visited[tmp.vertex] = true;
					}
				}
			}
			level++;
		}

	}

}

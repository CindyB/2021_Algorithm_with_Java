package com.ssafy.algo16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1753_최단경로_방수영 {

	static class Node {
		int vertex, weight;
		Node link;

		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", link=" + link + "]";
		}

	}

	static int V, E, startVertex;
	static Node[] adjList;
	static int[] distance;
	static boolean[] visited;
	final static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점 갯수
		E = Integer.parseInt(st.nextToken()); // 간선 갯수
		startVertex = Integer.parseInt(in.readLine()) - 1;

		adjList = new Node[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[start] = new Node(end, weight, adjList[start]);
		}

		dijkstra();

		for (int i = 0; i < V; i++) {
			if (distance[i] == INF)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}

	private static void dijkstra() {

		distance = new int[V];
		visited = new boolean[V];

		Arrays.fill(distance, INF);
		distance[startVertex] = 0;

		int min = 0, current = startVertex;

		for (int i = 0; i < V; i++) {
			min = INF;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;

			for (Node p = adjList[current]; p != null; p = p.link) {
				if (!visited[p.vertex] && distance[p.vertex] > min + p.weight) {
					distance[p.vertex] = min + p.weight;
				}
			}
		}

	}
}

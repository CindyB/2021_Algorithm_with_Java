package com.ssafy.algo10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_boj_17135_방수영 {

	static int N, M, D;
	static int[][] map;
	static ArrayList<Node> enemy;
	static ArrayList<Node> archer;
	static int killCnt, max = Integer.MIN_VALUE;
	static int[] number;
	
	static class Node implements Cloneable {

		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public int getDistance(Node n) {
			return Math.abs(this.r - n.r) + Math.abs(this.c - n.c);
		}
		@Override
		public Node clone() throws CloneNotSupportedException {
		return (Node) super.clone();
		}

	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();

		map = new int[N][M];
		enemy = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					enemy.add(new Node(i, j));
				}
			}
		}
		number = new int[M];
		
		combi(0, 0);
		System.out.println(max);
	}

	private static void combi(int cnt, int start) throws CloneNotSupportedException {
		if (cnt == 3) {
			
			killCnt = 0;
			archer = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				archer.add(new Node(N, number[i]));
			}

//			ArrayList<Node> copyOfEnemy = (ArrayList<Node>) enemy.clone();


			
			ArrayList<Node> copyOfEnemy = new ArrayList<Node>();
			for (Node f : enemy) {
				copyOfEnemy.add(f.clone());
			}

			attack(copyOfEnemy);
			max = Math.max(killCnt, max);
			return;
		}
		for (int i = start; i < M; i++) {
			number[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}	

	private static void attack(ArrayList<Node> copyOfEnemy) {
		
		while (!copyOfEnemy.isEmpty()) {

			for (int i = 0; i < 3; i++) {
				
				int minDis=Integer.MAX_VALUE;
				int minIdx=9999;
				for (int j = 0; j < copyOfEnemy.size(); j++) {

					int d = archer.get(i).getDistance(copyOfEnemy.get(j));
					if(d<minDis) {
						minDis=d;
						minIdx=j;
					}
				}
				if(minDis>=1 && minDis<=D) {
					killCnt++;
					copyOfEnemy.remove(minIdx);
				}				
			}

			//move
			for (int i = 0; i < copyOfEnemy.size(); i++) {
				copyOfEnemy.get(i).r++;
				if (copyOfEnemy.get(i).r >= N) {
					copyOfEnemy.remove(i);
				}
			}

		}

	}

}

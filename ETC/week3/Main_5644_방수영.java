package com.ssafy.algo12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5644_방수영 {

	static User[] users;
	static BC[] bcs;
	static int M, A;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("5644.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		for(int test_case =1; test_case<=T; test_case++) {
			result=0;
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			//사용자 객체 만들기
			users = new User[2];
			
			for(int i=0; i<2; i++) {
				//이동정보
				int[] tmp = new int[M+1];
				tmp[0]=0;		//제자리
				st = new StringTokenizer(in.readLine());
				for(int j=1; j<=M; j++) {
					tmp[j] = Integer.parseInt(st.nextToken());
				}
				if(i==0) users[i] = new User(1,1,tmp);
				if(i==1) users[i] = new User(10,10,tmp);
			}
			//BC 정보 입력
			bcs = new BC[A];
			
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcs[i] = new BC(x,y,c,p);
			}
			
			for(int i=0; i<=M; i++) {
				//이동 (처음엔 제자리)
				users[0].move(i);
				users[1].move(i);
				//현 위치에서 속하는 충전소 찾기
				addCharger();
				int max=0;
				if(users[0].charger.size()==0) {		//userA는 충전소 없음 -> userB만 따지면 됨
					for(int j=0; j<users[1].charger.size(); j++) {
						max = Math.max(max, bcs[users[1].charger.get(j)].p);
					}
				}else if(users[1].charger.size()==0) {	//userB는 충전소 없음 -> userA만 따지면 됨
					for(int j=0; j<users[0].charger.size(); j++) {
						max = Math.max(max, bcs[users[0].charger.get(j)].p);
					}
				}else {	//둘 다 충전소 있음 -> 합했을 때 더 큰거를 택
					for(int j=0; j<users[0].charger.size(); j++) {
						for(int k=0; k<users[1].charger.size(); k++) {
							if(users[0].charger.get(j) == users[1].charger.get(k)) {	//같으면
								max = Math.max(max,bcs[users[0].charger.get(j)].p);	//나누기 2인데 max는 총합이라 *2
								
							}else {	//다르면 두개 더하기
								max = Math.max(max,bcs[users[0].charger.get(j)].p+bcs[users[1].charger.get(k)].p );
							}
						}
					}
				}
				result+=max;
				users[0].charger.clear();
				users[1].charger.clear();
			}
			System.out.println("#"+test_case+" "+result);
			
		}
	}
	public static void addCharger() {
		// 범위에 속하는 충전소 넣기
		for(int i=0; i<A; i++) {			
			if(bcs[i].isRechargeable(users[0].x, users[0].y)) {
				users[0].charger.add(i);
			}
			if(bcs[i].isRechargeable(users[1].x, users[1].y)) {
				users[1].charger.add(i);
			}
		}
	}
	
	
	static class User{
		int x,y;
		int c;
		int[] moveInfo;
		ArrayList<Integer> charger = new ArrayList<Integer>();
		public User(int x, int y, int[] moveInfo) {
			super();
			this.x = x;
			this.y = y;
			this.moveInfo = moveInfo;
		}
		public void move(int t) {
			int command = moveInfo[t];
			switch(command) {
			case 0:
				break;
			case 1:
				this.y-=1;
				break;
			case 2:
				this.x+=1;
				break;
			case 3:
				this.y+=1;
				break;
			case 4:
				this.x-=1;
				break;
			}
		}
		
		@Override
		public String toString() {
			return "User [x=" + x + ", y=" + y + ", moveInfo=" + Arrays.toString(moveInfo) + "]";
		}				
	}
	static class BC{
		int x,y;
		int c;
		int p;
		public BC(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
		public boolean isRechargeable(int x, int y) {
			int d = Math.abs(this.x-x) + Math.abs(this.y - y);
			
			if(this.c>=d)return true;
			else return false;
		}
		@Override
		public String toString() {
			return "BC [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + "]";
		}
				
	}
}

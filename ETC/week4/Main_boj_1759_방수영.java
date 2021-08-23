package com.ssafy.algo.hw15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1759_방수영 {

	static char[] word;
	static char[] selectedWord;
	static int L,C;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		word = new char[C];
		selectedWord = new char[L];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<C; i++) {
			word[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(word);
		combi(0,0,"");
	}
	//정렬 후 순서없이 4개(L개)뽑으면 정렬 되어있음 또한 사전식으로 가능성 있는 경우는 한가지일뿐
	private static void combi(int cnt, int start, String tmp) {
		if(cnt == L) {
			int vol=0;
			for(int i=0; i<L; i++) {
				if(selectedWord[i]=='a'||selectedWord[i]=='u'||selectedWord[i]=='o'||selectedWord[i]=='i'||selectedWord[i]=='e')
					vol++;
			}
			if(vol>=1 && vol<=L-2)System.out.println(tmp);
			return;
		}
		for(int i=start; i<C; i++) {			
			selectedWord[cnt] = word[i];
			combi(cnt+1,i+1,tmp+word[i]);
		}
	}
	

}

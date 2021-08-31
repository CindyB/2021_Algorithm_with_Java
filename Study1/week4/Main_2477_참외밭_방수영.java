package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477_참외밭_방수영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int K = Integer.parseInt(in.readLine());
		int[] len = new int[6];
		
		int width=0;
		int height=0;
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(in.readLine());
			int dir = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
			
			//가장 긴 가로, 세로
			if(dir<3)width+=len[i];
			else height+=len[i];
		}
		width/=2;
		height/=2;
		
		//가장 긴 가로변의 인덱스, 긴 세로변의 인덱스 구하기
		int[] index = new int[2];
		int j=0;
		for(int i=0; i<6; i++) {
			if(len[i]==width || len[i]==height) {
				index[j++] = i;
			}			
		}
		if(index[1]==5&&index[0]==0)index[1]+=1;
		//두번째 인덱스의 +2,+3이 작은 직사각형의 가로 세로
		int smallS = len[(index[1]+2)%6] * len[(index[1]+3)%6];
		int bigS = width*height;
		
		int S = bigS - smallS;
		
//		System.out.println(width +" "+height);
//		System.out.println(index[0]+" "+index[1]);
		System.out.println(S*K);
	}
	
}
/*
 *case 2에서 틀림 => 예외처리 하긴 했는데 왠지는 모르겠음..
7
4 50
2 160
3 30
1 60
3 20
1 100

7
2 160
3 30
1 60
3 20
1 100
4 50

7
3 30
1 60
3 20
1 100
4 50
2 160

7
1 60
3 20
1 100
4 50
2 160
3 30

7
3 20
1 100
4 50
2 160
3 30
1 60

7
1 100
4 50
2 160
3 30
1 60
3 20
*/
 


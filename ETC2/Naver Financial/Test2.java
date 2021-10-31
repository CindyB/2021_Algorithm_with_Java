package NaverFinancial;

public class Test2 {

	static int[][] map;
	static int cnt=1;
	static int jumpFlag;
	static int jump;
	static int[] result;
	
	public static void main(String[] args) {
		int n = 4;
		jump = 1;
		map = new int[n][n];
		jumpFlag = jump;
		result = new int[2];
		
		while(cnt<=Math.pow(n, 2)) {
			snake(n);
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		result[0]++;
        result[1]++;
		System.out.println(result[0]+" "+result[1]);
	}

	private static void snake(int n) {
		int col = -1;
		int flag = 1, row = 0;
		
		for (int i = n; i > 0; i--) {
			for (int j = 0; j < n; j++) {
				col += flag;
				if(map[row][col]!=0)continue;
				
				if (jumpFlag == jump) {
					jumpFlag=1;
					map[row][col] = cnt++;
					result[0]=row;
					result[1]=col;
				}else {
					jumpFlag++;
				}
			}

			n--;

			for (int j = 0; j < n; j++) {
				row += flag;
				if(map[row][col]!=0)continue;
				if (jumpFlag == jump) {
					jumpFlag=1;
					map[row][col] = cnt++;
					result[0]=row;
					result[1]=col;
				}else {
					jumpFlag++;
				}
			}
			flag = flag * (-1);
		}		
	}

}

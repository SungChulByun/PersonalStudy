package Line_Online;

import java.util.*;
public class problem5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int tx = sc.nextInt();
		int ty = sc.nextInt();
		boolean avail=true;
		
		if(tx>n||ty>m) avail=false;
		int time = tx+ty;
		tx++;
		ty++;
		
		long[][] combination = new long[tx][ty];
		for(int i=0;i<ty;i++) {
			combination[0][i]=1;
		}
		for(int i=0;i<tx;i++) {
			combination[i][0]=1;
		}
		for(int i=1;i<tx;i++) {
			for(int j=1;j<ty;j++) {
				combination[i][j]=combination[i][j-1]+combination[i-1][j];
			}
		}
		if(avail) {
			System.out.println(time);
			System.out.println(combination[tx-1][ty-1]);
		}
		else {
			System.out.println("fail");
		}
	}
}

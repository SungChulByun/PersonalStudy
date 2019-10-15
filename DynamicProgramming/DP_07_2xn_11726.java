package DynamicProgramming;

import java.util.*;
public class DP_07_2xn_11726 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n+1];
		data[1]=1;
		
		if(n>=2) data[2]=2;
		if(n>=3) {
			for(int i=3;i<=n;i++) {
				data[i]=(data[i-1]+data[i-2])%10007;
			}
		}
		System.out.println(data[n]);
	}
}

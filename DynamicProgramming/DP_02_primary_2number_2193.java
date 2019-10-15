package DynamicProgramming;

import java.util.*;
public class DP_02_primary_2number_2193 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] data = new long[n+1];
		data[0]=0;
		data[1]=1;
		if(n>=2) data[2]=1;
		for(int i=3;i<=n;i++) {
			data[i]=data[i-1]+data[i-2];
		}
		System.out.println(data[n]);
	}
}

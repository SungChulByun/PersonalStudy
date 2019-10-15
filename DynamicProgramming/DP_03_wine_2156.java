package DynamicProgramming;

import java.util.*;
public class DP_03_wine_2156 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] g = new int[n];
		int[] zero = new int[n];
		int[] one = new int[n];
		int[] two = new int[n];
		for(int i=0;i<n;i++) {
			g[i]=sc.nextInt();
		}
		
		int answer=0;
		if(n==1) {
			answer=g[0];
		}
		else if(n==2) {
			answer=g[0]+g[1];
		}
		else {
			one[0]=g[0];
			for(int i=1;i<n;i++) {
				zero[i]=Math.max(zero[i-1], Math.max(one[i-1], two[i-1]));
				one[i] = zero[i-1]+g[i];
				two[i] = one[i-1]+g[i];
			}
			answer = Math.max(zero[n-1], Math.max(one[n-1], two[n-1]));
		}
		
		
//		for(int i=0;i<n;i++) {
//			System.out.print(g[i]+" ");
//		}
//		System.out.println();
//		for(int i=0;i<n;i++) {
//			System.out.print(zero[i]+" ");
//		}
//		System.out.println();
//		for(int i=0;i<n;i++) {
//			System.out.print(one[i]+" ");
//		}
//		System.out.println();
//		for(int i=0;i<n;i++) {
//			System.out.print(two[i]+" ");
//		}
//		System.out.println();
		System.out.println(answer);
	}
}

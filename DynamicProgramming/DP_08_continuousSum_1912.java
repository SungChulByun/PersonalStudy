package DynamicProgramming;

import java.util.*;
public class DP_08_continuousSum_1912 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		int sum=0;
		int max=0;
		int allminus=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			allminus=Math.max(allminus, data[i]);
			if(sum+data[i]<0) {
				sum=0;
			}
			else {
				sum+=data[i];
			}
			max=Math.max(max, sum);
		}
		if(allminus<=0) System.out.println(allminus);
		else System.out.println(max);
	}
}

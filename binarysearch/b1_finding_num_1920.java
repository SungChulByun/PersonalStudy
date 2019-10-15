package binarysearch;

import java.util.*;
public class b1_finding_num_1920 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			set.add(sc.nextInt());
		}
		int m = sc.nextInt();
		int[] ans = new int[m];
		for(int i=0;i<m;i++) {
			if(set.contains(sc.nextInt())) {
				ans[i]=1;
			}
		}
		for(int i=0;i<m;i++) {
			System.out.println(ans[i]);
		}
	}
}

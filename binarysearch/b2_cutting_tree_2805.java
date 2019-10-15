package binarysearch;

import java.util.*;
public class b2_cutting_tree_2805 {
	static long max, min, answer, tree[], m;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextLong();
		tree = new long[n];
		answer=0;
		long max=0;
		long min=0;
		for(int i=0;i<n;i++) {
			long tp = sc.nextInt();
			tree[i]=tp;
			max=Math.max(max, tp);
		}
		dfs(max, min);
		System.out.println(answer);
	}
	static void dfs(long top, long bot) {
		if(top-bot==1) {
			if(cutted(top)>=m) answer=top;
			else answer=bot;
			return;
		}
		else {
			long target=(top+bot)/2;
			long val = cutted(target);
			if(val==m) {
				answer=target;
				return;
			}
			else if(val>m) {
//				System.out.println("top : "+top+", target+1 : "+(target+1));
				dfs(top, target);
			}
			else {
				dfs(target, bot);
			}
		}
	}
	static long cutted(long x) {
		long sum=0;
		for(int i=0;i<n;i++) {
			if(tree[i]>x) sum+=(tree[i]-x);
		}
		return sum;
	}
}

package test;

import java.util.*;
public class generatingPermutation_repeat { // n개 데이터에서 임의로 m개를 고른 nPm개의 int[] 만들기
	static Queue<int[]> gqu = new LinkedList<int[]>();
	public static void main(String args[]) {
		int ct=0;
		permutation(12, 3);
		while(!gqu.isEmpty()) {
			int[] tp = gqu.poll();
			for(int i=0;i<tp.length;i++) {
				System.out.print(tp[i]+" ");
			}
			System.out.println();
			ct++;
		}
		System.out.println("ct : "+ct);
		
	}
	static void permutation(int x, int y) {
		make(new int[y], 0, 0, x);
	}
	static void make(int[] x, int loc, int cnt, int num) {
		if(loc==x.length) {
			gqu.add(x.clone());
		}
		else {
			for(int i=cnt;i<num;i++) {

				x[loc]=i;
				make(x, loc+1, 0, num);
			}
		}
	}
}

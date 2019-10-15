package test;

import java.util.*;
public class binarysearch {
	public static void main(String args[]) {
		int n = 100;
		int[] data = new int[n];
		for(int i=0;i<n;i++) {
			data[i]=i*i;
		}
		int loc = binarysearch(data, 100);
		System.out.println(loc);
	}
	static int binarysearch(int[] data, int target) {
		return bsearch(data, 0, data.length, target);
	}
	static int bsearch(int[] data, int s, int e, int target) {
		if(s==e) {
			if(data[s]==target) return s;
			else return -1;
		}
		else {
			int mid = (s+e)/2;
			int tp = data[mid];
			
			if(tp==target) return mid;
			else if(target<tp) return bsearch(data, s, mid, target);
			else return bsearch(data, mid+1, e, target);
		}
	}
}

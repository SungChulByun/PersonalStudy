package test;
import java.util.Scanner;
// import java.util.*;

public class MergeSort{
	static int n, data[];
	public static void main(String args[]) {
		int[] x = new int[] {38, 27, 43, 3, 9, 82, 10};

		
		mergesort(x);
		for(int i=0;i<x.length;i++) {
			System.out.print(x[i]+" ");
		}
	}
	private static void printarr(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	private static void mergesort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}
	private static void sort(int[] arr, int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			sort(arr, left, mid);
			sort(arr, mid+1, right);
			merge(arr, left, mid, right);

		}
	}
	private static void merge(int[] arr, int left, int mid, int right) {
//		System.out.println("left : "+left+", mid : "+mid+", right : "+right);
		int[] tp = new int[right-left+1];
		int lp=0;
		int rp=0;
		for(int i=0;i<tp.length;i++) {
			if(mid+1+rp>right) {
				tp[i]=arr[left+lp];
				lp++;
				//System.out.println("case1");
			}
			else if(left+lp>=mid+1) {
				tp[i]=arr[mid+1+rp];
				rp++;
//				System.out.println("case2");
			}
			else if(arr[left+lp]>arr[mid+1+rp]) {
				tp[i]=arr[mid+1+rp];
				rp++;
//				System.out.println("case3");
			}
			else {
				tp[i]=arr[left+lp];
				lp++;
//				System.out.println("case4");
			}
		}
		for(int i=0;i<tp.length;i++) {
			arr[left+i]=tp[i];
		}
	}
	
}
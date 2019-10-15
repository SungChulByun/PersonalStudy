package Line_Online;

import java.util.*;
public class problem3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] in = new int[n];
		int[] out= new int[n];
		for(int i=0;i<n;i++) {
			in[i]=sc.nextInt();
			out[i]=sc.nextInt();
		}
		int[] time = new int[151];
		for(int i=0;i<n;i++) {
			for(int j=in[i];j<out[i];j++) {
				time[j]++;
			}
		}
		int max = 0;
		for(int i=0;i<151;i++) {
			max=Math.max(max, time[i]);
		}
		System.out.println(max);
	}
}

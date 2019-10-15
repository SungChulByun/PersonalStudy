package binarysearch;

import java.util.*;
public class b4_number_card2_10816 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int tp = sc.nextInt();
			if(map.containsKey(tp)) {
				map.put(tp, map.get(tp)+1);
			}
			else {
				map.put(tp, 1);
			}
		}
		int m = sc.nextInt();
		int[] ans = new int[m];
		for(int i=0;i<m;i++) {
			int tp = sc.nextInt();
			if(map.containsKey(tp)) ans[i]=map.get(tp);
		}
		for(int i=0;i<m;i++) {
			System.out.print(ans[i]+" ");
		}
	}

}

package nhn;

import java.util.*;
public class nhn_problem2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int idx=1;
		int ct=0;
		String ans = "";
		int[] order = new int[101];
		int[] count = new int[101];
		for(int i=0;i<n;i++) {
			String next = sc.nextLine();
			if(next.indexOf("enqueue")==0) {
				int tar = Integer.parseInt(next.split(" ")[1]);
				if(order[tar]==0) {
					order[tar]=idx;
					idx++;
				}
				count[tar]++;
				ct++;
			}
			else {
				if(ct>0) {
					ct--;
					int max = 0;
					for(int j=0;j<101;j++) {
						max=Math.max(count[j], max);
					}
					pair[] cand = new pair[0];
					for(int j=0;j<101;j++) {
						if(count[j]==max) {
							cand = add(cand, new pair(j, order[j]));
						}
					}
					Arrays.sort(cand);
					int val = cand[0].val;
					count[val]--;
					if(count[val]==0) {
						order[val]=0;
					}
					ans = ans+" "+val;
				}
				else {
					ans = ans+" "+(-1);
				}
				
			}
		}
		ans = ans.substring(1);
		System.out.print(ans);
	}
	static pair[] add(pair[] ls, pair p) {
		pair[] tp = new pair[ls.length+1];
		for(int i=0;i<tp.length-1;i++) {
			tp[i]=ls[i];
		}
		tp[tp.length-1]=p;
		return tp;
	}
}
class pair implements Comparable<pair>{
	public int val;
	public int idx;
	public pair(int val, int idx) {
		this.val=val;
		this.idx=idx;
	}
	@Override
	public int compareTo(pair comp) {
		return this.idx-comp.idx;
	}
}
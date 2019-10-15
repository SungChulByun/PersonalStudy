package SWAcademy;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
public class SWD5_freight_7508 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] ans = new int[t];
		for(int tc=0;tc<t;tc++) {
			int n = sc.nextInt();
			int[] power = new int[n];
			for(int i=0;i<n;i++) {
				power[i]=sc.nextInt();
			}
			Arrays.sort(power);
			int powhere[] = new int[n];
			int[] powerForqu = norepeat(power);
			int ct=0;
			for(int i=0;i<n;i++) {
				if(power[i]==powerForqu[ct]) {
					ct++;
				}
				powhere[i]=ct-1;
			}
			int f = sc.nextInt();
			int[] w = new int[f];
			for(int i=0;i<f;i++) {
				w[i]=sc.nextInt();
			}
			if(power[n-1]<w[f-1]) {
				ans[tc]=-1;
			}
			else {
				PriorityQueue[] qulist = new PriorityQueue[powerForqu.length];
				for(int i=0;i<f;i++) {
					int wh = where(powerForqu, w[i]);
					if(qulist[wh]==null) {
						PriorityQueue<Integer> pqu = new PriorityQueue<Integer>(new intcomparator());
						qulist[wh]=pqu;
					}
					qulist[wh].add(w[i]);
				}
				int time=0;
				while(f>0) {
					for(int i=n-1;i>=0;i--) {
						if(powhere[i]==-1) continue;
						boolean down=true;
						while(down) {
							down=false;
							if(powhere[i]==-1) {
								down=false;
								
							}
							else if(qulist[powhere[i]]==null) {
								powhere[i]--;
								down=true;
							}
							else {
								if(qulist[powhere[i]].size()==0) {
									powhere[i]--;
									down=true;
								}
							}
						}
						if(powhere[i]>=0) {
							System.out.println(qulist[powhere[i]].poll());
							
							f--;
						}
						
					}
					time++;
				}
				ans[tc]=time;
			}
			
		}
		for(int i=0;i<t;i++) {
			System.out.println("#"+(i+1)+" "+ans[i]);
		}
	}
	static int[] norepeat(int[] x) {
		Queue<Integer> qu = new LinkedList<Integer>();
		for(int i=0;i<x.length;i++) {
			qu.add(x[i]);
		}
		int[] re = new int[qu.size()];
		int ct=0;
		while(!qu.isEmpty()) {
			re[ct]=qu.poll();
			ct++;
		}
		return re;
	}
	static int where(int[] list, int tar) {
		return where_pri(list, tar, 0, list.length-1);
	}
	static int where_pri(int[] list, int tar, int start, int end) {
		if(start==end) {
			return start;
		}
		else {
			int mid = (start+end)/2;
			if(list[mid]==tar) return mid;
			else if(list[mid]>tar) return where_pri(list, tar, start, mid);
			else return where_pri(list, tar, mid+1, end);
		}
	}
}
class intcomparator implements Comparator<Integer>{
	@Override
	public int compare(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return y-x;
	}
}